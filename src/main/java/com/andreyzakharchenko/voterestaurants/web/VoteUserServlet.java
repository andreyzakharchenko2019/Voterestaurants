package com.andreyzakharchenko.voterestaurants.web;

import com.andreyzakharchenko.voterestaurants.model.LaunchMenu;
import com.andreyzakharchenko.voterestaurants.web.launchmenu.LaunchMenuRestController;
import com.andreyzakharchenko.voterestaurants.web.voteuser.VoteUserRestController;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Objects;

public class VoteUserServlet extends HttpServlet {

    private ConfigurableApplicationContext springContext;
    private VoteUserRestController voteUserController;

    @Override
    public void init() {
        springContext = new ClassPathXmlApplicationContext("spring/spring-app.xml", "spring/spring-db.xml");
        voteUserController = springContext.getBean(VoteUserRestController.class);
    }

    @Override
    public void destroy() {
        springContext.close();
        super.destroy();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String action = request.getParameter("action");
        switch (action == null ? "all" : action) {
            case "delete":
                int id = getId(request);
                voteUserController.delete(id);
                response.sendRedirect("vote_user");
                break;
           /* case "create":
            case "update":
                final LaunchMenu launchMenu = "create".equals(action) ?
                        new LaunchMenu("", 100004, 0.0, LocalDate.now().plusDays(1)) :
                        launchMenuController.get(getId(request));
                request.setAttribute("launchMenu", launchMenu);
                request.getRequestDispatcher("/launch_menuForm.jsp").forward(request, response);
                System.out.println(launchMenu);
                break;*/
            case "all":
            default:
                request.setAttribute("voteUser", voteUserController.getAll());
                request.getRequestDispatcher("/vote_user.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {

    }

    private int getId(HttpServletRequest request) {
        String paramId = Objects.requireNonNull(request.getParameter("id"));
        return Integer.parseInt(paramId);
    }
}
