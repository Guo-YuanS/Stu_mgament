package com.servlet;

import com.dao.UserDao;
import com.dao.UserDaoImplement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class loginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String password = req.getParameter("password");

        UserDao ud = new UserDaoImplement();

        if(ud.login(name,password)){
            req.getRequestDispatcher("/success.jsp").forward(req,resp);
        }else{
            resp.sendRedirect("login.jsp");
        }
    }
}
