package com.servlet;

import com.dao.UserDao;
import com.dao.UserDaoImplement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class updateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        String pass = req.getParameter("password");

        UserDao ud = new UserDaoImplement();

        if(ud.update(name,id)){
            req.getRequestDispatcher("/addUpdateDeleteSuccess.jsp").forward(req,resp);
        }else{
            resp.sendRedirect("addUpdateDeleteFail.jsp");
        }
    }
}
