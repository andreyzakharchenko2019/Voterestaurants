package com.andreyzakharchenko.voterestaurants.web;

import com.andreyzakharchenko.voterestaurants.model.LaunchMenu;
import com.andreyzakharchenko.voterestaurants.web.launchmenu.LaunchMenuRestController;
import javafx.util.converter.LocalDateTimeStringConverter;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.format.datetime.joda.LocalDateParser;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Objects;

public class LaunchMenuServlet extends HttpServlet {

    private ConfigurableApplicationContext springContext;
    private LaunchMenuRestController launchMenuController;

    @Override
    public void init() {
        springContext = new ClassPathXmlApplicationContext("spring/spring-app.xml", "spring/spring-db.xml");
        launchMenuController = springContext.getBean(LaunchMenuRestController.class);
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
                        new LaunchMenu("", 100004, 0.0, LocalDate.now().plusDays(1)) :
                        launchMenuController.get(getId(request));
                request.setAttribute("launchMenu", launchMenu);
                request.getRequestDispatcher("/launch_menuForm.jsp").forward(request, response);
                System.out.println(launchMenu);
                break;
            case "all":
            default:
                request.setAttribute("launch_menus", launchMenuController.getAll());
                request.getRequestDispatcher("/launch_menu.jsp").forward(request, response);
        }


    }

    private int getId(HttpServletRequest request) {
        String paramId = Objects.requireNonNull(request.getParameter("id"));
        return Integer.parseInt(paramId);
    }

}
