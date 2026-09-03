package com.jxd.eas.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @ClassName LogOutServlet
 * @Description TODO
 * @Author 刘双喜
 * @Date 2026/8/24 16:07
 * @Version 1.0
 */
@WebServlet("/logOut")
public class LogOutServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //session 销毁
        HttpSession session = req.getSession();
        //session对象被回收
        session.invalidate();

        resp.sendRedirect("Login.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
