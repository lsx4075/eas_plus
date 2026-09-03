package com.jxd.eas.servlet;

import com.jxd.eas.service.IUserLoginService;
import com.jxd.eas.service.impl.UserLoginServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ClassName ChgPwdServlet
 * @Description TODO
 * @Author 刘双喜
 * @Date 2026/8/26 19:22
 * @Version 1.0
 */
@WebServlet("/chgPwd")
public class ChgPwdServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userName = req.getParameter("userName");
        String oldPwd = req.getParameter("oldPwd");
        String newPwd = req.getParameter("newPwd");

        IUserLoginService userLoginService = new UserLoginServiceImpl();
        boolean flag = userLoginService.changePwd(userName, newPwd, oldPwd);
        if (flag) {
            if ("admin".equals(userName)) {
                resp.sendRedirect("/getCourses");
            } else if (userName.length() == 4) {
                resp.sendRedirect("/getCoursesOfTeacher");
            } else {
                resp.sendRedirect("/getCoursesForStu");
            }
        } else {
            req.setAttribute("msg","原密码错误");
            req.getRequestDispatcher("ChangePwd.jsp").forward(req,resp);
        }
    }
}
