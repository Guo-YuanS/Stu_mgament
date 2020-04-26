package com.servlet;

import com.dao.UserDao;
import com.dao.UserDaoImplement;
import com.entity.MyUser;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class showAllServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        UserDao ud = new UserDaoImplement();
        List<MyUser> userAll = ud.getUserAll();
        req.setAttribute("all",userAll);
        req.getRequestDispatcher("showAll.jsp").forward(req,resp);
    }
}
