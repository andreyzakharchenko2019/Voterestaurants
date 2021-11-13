package com.andreyzakharchenko.voterestaurants.web;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class RestaurantServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/restaurants.jsp").forward(request, response);
        System.out.println("restaurantServlet");
    }
}
