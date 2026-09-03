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
 * @ClassName ResetPwdServlet
 * @Description TODO
 * @Author 刘双喜
 * @Date 2026/8/26 17:53
 * @Version 1.0
 */
@WebServlet("/resetPwd")
public class ResetPwdServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String[] userNames = req.getParameterValues("userName");

        IUserLoginService userLoginService = new UserLoginServiceImpl();
        userLoginService.resetPwd(userNames);

        resp.sendRedirect("/getUsers");
    }
}
