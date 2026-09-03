package com.jxd.eas.servlet;

import com.jxd.eas.model.UserLogin;
import com.jxd.eas.service.IUserLoginService;
import com.jxd.eas.service.impl.UserLoginServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

/**
 * @ClassName LoginServlet
 * @Description TODO
 * @Author 刘双喜
 * @Date 2026/8/24 14:37
 * @Version 1.0
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uname = req.getParameter("uname");
        String pwd = req.getParameter("pwd");
        int role = Integer.parseInt(req.getParameter("user"));

        IUserLoginService userLoginService = new UserLoginServiceImpl();
        UserLogin userLogin = userLoginService.login(uname,pwd,role);
        if (userLogin != null) {
            // 记住密码
            String remember = req.getParameter("remember");
            if ("1".equals(remember)) {
                Cookie cUname = new Cookie("rememberUname", uname);
                Cookie cPwd = new Cookie("rememberPwd", pwd);
                Cookie cRole = new Cookie("rememberRole", String.valueOf(role));

                // 设置cookie存储时间，单位为s
                cUname.setMaxAge(3600 * 24 * 7);
                cPwd.setMaxAge(3600 * 24 * 7);
                cRole.setMaxAge(3600 * 24 * 7);
                // 将cookie加入响应
                resp.addCookie(cUname);
                resp.addCookie(cPwd);
                resp.addCookie(cRole);
            } else {
                // 未勾选则清除已有Cookie
                Cookie cUname = new Cookie("rememberUname", "");
                Cookie cPwd = new Cookie("rememberPwd", "");
                Cookie cRole = new Cookie("rememberRole", "");
                cUname.setMaxAge(0);
                cPwd.setMaxAge(0);
                cRole.setMaxAge(0);
                resp.addCookie(cUname);
                resp.addCookie(cPwd);
                resp.addCookie(cRole);
            }

            // 将数据存储到session对象中
            HttpSession session = req.getSession();
            session.setAttribute("uname",uname);

            //根据角色重定向到不同页面
            switch (role) {
                case 0:
                    resp.sendRedirect("Student.jsp");
                    break;
                case 1:
                    resp.sendRedirect("Teacher.jsp");
                    break;
                case 2:
                    resp.sendRedirect("Admin.jsp");
                    break;
            }
        } else {
            req.setAttribute("msg","用户名或密码错误");
            req.getRequestDispatcher("Login.jsp").forward(req,resp);
        }
    }
}
