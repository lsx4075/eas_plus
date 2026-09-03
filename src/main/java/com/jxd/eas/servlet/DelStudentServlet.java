package com.jxd.eas.servlet;

import com.jxd.eas.service.ISelectedCourseService;
import com.jxd.eas.service.IStudentService;
import com.jxd.eas.service.IUserLoginService;
import com.jxd.eas.service.impl.SelectedCourseServiceImpl;
import com.jxd.eas.service.impl.StudentServiceImpl;
import com.jxd.eas.service.impl.UserLoginServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ClassName DelStudentServlet
 * @Description TODO
 * @Author 刘双喜
 * @Date 2026/8/26 14:29
 * @Version 1.0
 */
@WebServlet("/delStu")
public class DelStudentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        int[] ids = {id};
        IStudentService studentService = new StudentServiceImpl();
        studentService.removeBatch(ids);

        //删除登录表信息
        IUserLoginService userLoginService = new UserLoginServiceImpl();
        userLoginService.delAccount(id);

        //删除选课表信息
        ISelectedCourseService selectedCourseService = new SelectedCourseServiceImpl();
        selectedCourseService.dropByStudentID(id);

        resp.sendRedirect("/getStudents");
    }
}
