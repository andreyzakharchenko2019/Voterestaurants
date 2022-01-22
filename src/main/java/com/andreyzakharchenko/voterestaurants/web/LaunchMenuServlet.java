package com.andreyzakharchenko.voterestaurants.web;

import com.andreyzakharchenko.voterestaurants.Profiles;
import com.andreyzakharchenko.voterestaurants.model.LaunchMenu;
import com.andreyzakharchenko.voterestaurants.model.Restaurant;
import com.andreyzakharchenko.voterestaurants.model.VoteUser;
import com.andreyzakharchenko.voterestaurants.web.launchmenu.LaunchMenuRestController;
import com.andreyzakharchenko.voterestaurants.web.restaurant.RestaurantRestController;
import com.andreyzakharchenko.voterestaurants.web.voteuser.VoteUserRestController;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.format.datetime.joda.LocalDateParser;
import org.springframework.util.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

public class LaunchMenuServlet extends HttpServlet {

    private ClassPathXmlApplicationContext springContext;
    private LaunchMenuRestController launchMenuController;
    private RestaurantRestController restaurantRestController;
    private VoteUserRestController voteUserRestController;

    @Override
    public void init() {
        // Without profiles
        /*springContext = new ClassPathXmlApplicationContext("spring/spring-app.xml", "spring/spring-db.xml");
        launchMenuController = springContext.getBean(LaunchMenuRestController.class);
        restaurantRestController = springContext.getBean(RestaurantRestController.class);
        voteUserRestController = springContext.getBean(VoteUserRestController.class);*/
        //With profiles
        springContext = new ClassPathXmlApplicationContext(new String[]{"spring/spring-app.xml", "spring/spring-db.xml"}, false);
        //springContext.setConfigLocations("spring/spring-app.xml", "spring/spring-db.xml");
        springContext.getEnvironment().setActiveProfiles(Profiles.getActiveDbProfile(), Profiles.REPOSITORY_IMPLEMENTATION);
        springContext.refresh();
        launchMenuController = springContext.getBean(LaunchMenuRestController.class);
        restaurantRestController = springContext.getBean(RestaurantRestController.class);
        voteUserRestController = springContext.getBean(VoteUserRestController.class);
    }

    @Override
    public void destroy() {
        springContext.close();
        super.destroy();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        switch (action == null ? "all" : action) {
            case "delete":
                int id = getId(request);
                launchMenuController.delete(id);
                response.sendRedirect("launch_menu");
                break;
            case "create":
            case "update":
                final LaunchMenu launchMenu = "create".equals(action) ?
                        new LaunchMenu("", null, 1.0, LocalDate.now().plusDays(1)) :
                        launchMenuController.get(getId(request));
                request.setAttribute("launchMenu", launchMenu);
                request.setAttribute("restaurants", restaurantRestController.getAll());
                request.getRequestDispatcher("/launch_menuForm.jsp").forward(request, response);
                System.out.println(launchMenu);
                break;
            case "all":
                request.setAttribute("launch_menus", launchMenuController.getAll());
                request.getRequestDispatcher("/launch_menu.jsp").forward(request, response);
                break;
            case "vote":
                voteUserRestController.create(new VoteUser(LocalDate.parse(request.getParameter("datevote"))), Integer.parseInt(request.getParameter("id")));
                request.setAttribute("launch_menus", launchMenuController.getAll());
                request.getRequestDispatcher("/launch_menu.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        LaunchMenu restaurant = new LaunchMenu(
                request.getParameter("name"),
                new Restaurant(Integer.parseInt(request.getParameter("restaurant_id"))),
                Double.parseDouble(request.getParameter("price").replace(",", ".")),
                LocalDate.parse(request.getParameter("date")));

        if (StringUtils.hasLength(request.getParameter("id"))) {
            launchMenuController.update(restaurant, getId(request));
        } else {
            launchMenuController.create(restaurant);
        }
        response.sendRedirect("launch_menu");
    }

    private int getId(HttpServletRequest request) {
        String paramId = Objects.requireNonNull(request.getParameter("id"));
        return Integer.parseInt(paramId);
    }

}
