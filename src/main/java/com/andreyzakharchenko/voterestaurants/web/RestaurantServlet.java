package com.andreyzakharchenko.voterestaurants.web;

import com.andreyzakharchenko.voterestaurants.model.Restaurant;
import com.andreyzakharchenko.voterestaurants.web.restaurant.RestaurantRestController;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("restaurantServlet");

        //request.setAttribute("restaurants", new ArrayList<>(Arrays.asList(new Restaurant(10446, "cev"), new Restaurant(1015416, "feeg"))));
        request.setAttribute("restaurants", restaurantController.getAll());
        request.getRequestDispatcher("/restaurants.jsp").forward(request, response);

    }
}
