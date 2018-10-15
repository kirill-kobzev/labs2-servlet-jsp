package servlets.controllers;

import servlets.dao.UserDaoImpl;
import servlets.service.UserService;
import servlets.service.UserServiceImpl;
import servlets.service.utils.HashUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegisterServlet extends HttpServlet {

    UserService userService;

    @Override
    public void init() throws ServletException {
        userService = new UserServiceImpl(new UserDaoImpl());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("/register.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login  = HashUtil.stringToMD5(req.getParameter("login"));
        String password = req.getParameter("password");
        req.getSession().setAttribute("login",login);
        req.getSession().setAttribute("role", 0);
        userService.addUser(login, password);

        resp.sendRedirect("/inner/dashboard");
    }
}
