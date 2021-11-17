package com.andreyzakharchenko.voterestaurants.web;

import com.andreyzakharchenko.voterestaurants.web.restaurant.LaunchMenuRestController;
import com.andreyzakharchenko.voterestaurants.web.restaurant.RestaurantRestController;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import java.io.IOException;

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
    public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
        request.setAttribute("launch_menus", launchMenuController.getAll());
        request.getRequestDispatcher("/launch_menu.jsp").forward(request, response);
    }
}
