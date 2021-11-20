package com.andreyzakharchenko.voterestaurants.web;

import com.andreyzakharchenko.voterestaurants.model.Restaurant;
import com.andreyzakharchenko.voterestaurants.web.restaurant.RestaurantRestController;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.util.StringUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class RestaurantServlet extends HttpServlet {

    private ConfigurableApplicationContext springContext;
    private RestaurantRestController restaurantController;

    @Override
    public void init() {
        System.out.println("init");
        springContext = new ClassPathXmlApplicationContext("spring/spring-app.xml", "spring/spring-db.xml");
        restaurantController = springContext.getBean(RestaurantRestController.class);
    }

    @Override
    public void destroy() {
        springContext.close();
        super.destroy();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("restaurantServlet");

        String action = request.getParameter("action");
        switch (action == null ? "all" : action) {
            case "delete":
                int id = getId(request);
                restaurantController.delete(id);
                response.sendRedirect("restaurants");
                break;
            case "create":
            case "update":
                final Restaurant restaurant = "create".equals(action) ?
                        new Restaurant("") :
                        restaurantController.get(getId(request));
                request.setAttribute("restaurant", restaurant);
                request.getRequestDispatcher("/restaurantForm.jsp").forward(request, response);
                break;
            case "all":
            default:
                request.setAttribute("restaurants", restaurantController.getAll());
                request.getRequestDispatcher("/restaurants.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("restaurantServlet doPost");
        request.setCharacterEncoding("UTF-8");
        Restaurant restaurant = new Restaurant(
                request.getParameter("name"));
        System.out.println(request.getParameter("name"));

        if (StringUtils.hasLength(request.getParameter("id"))) {
            restaurantController.update(restaurant, getId(request));
        } else {
            restaurantController.create(restaurant);
        }
        response.sendRedirect("restaurants");
    }

    private int getId(HttpServletRequest request) {
        String paramId = Objects.requireNonNull(request.getParameter("id"));
        return Integer.parseInt(paramId);
    }
}
