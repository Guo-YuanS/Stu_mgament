package com.servlet;

import com.dao.UserDao;
import com.dao.UserDaoImplement;
import com.entity.MyUser;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class registerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        String pass = req.getParameter("password");

        MyUser user = new MyUser();
        user.setId(id);
        user.setName(name);
        user.setPassword(pass);

        UserDao ud = new UserDaoImplement();

        if(ud.register(user)){
            req.setAttribute("id",id);
            req.getRequestDispatcher("/login.jsp").forward(req,resp);
        }else{
            resp.sendRedirect("register.jsp");
        }
    }
}
