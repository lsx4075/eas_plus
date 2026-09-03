package com.jxd.eas.servlet;

import com.jxd.eas.model.UserLogin;
import com.jxd.eas.service.IUserLoginService;
import com.jxd.eas.service.impl.UserLoginServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @ClassName GetUsersServlet
 * @Description TODO
 * @Author 刘双喜
 * @Date 2026/8/26 17:24
 * @Version 1.0
 */
@WebServlet("/getUsers")
public class GetUsersServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userName = req.getParameter("userName");
        String pageStr = req.getParameter("page");
        String limitStr = req.getParameter("limit");
        int page = 1;
        int limit = 10;
        if (pageStr != null) {
            page = Integer.parseInt(pageStr);
        }
        if (limitStr != null) {
            limit = Integer.parseInt(limitStr);
        }

        IUserLoginService userLoginService = new UserLoginServiceImpl();
        List<UserLogin> list = userLoginService.getAll(userName);

        List<UserLogin> listPage = userLoginService.getAccountsByPage(userName,page,limit);

        //计算页码数
        int total = list.size();
        int pages = total % limit == 0 ? total / limit : total / limit + 1;

        req.setAttribute("userList",listPage);
        req.setAttribute("pages",pages);
        req.setAttribute("limit",limit);
        if (userName != null) {
            req.setAttribute("userName",userName);
        }
        req.getRequestDispatcher("UserAccountList.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
