package com.jxd.eas.servlet;

import com.jxd.eas.model.Teacher;
import com.jxd.eas.service.ITeacherService;
import com.jxd.eas.service.IUserLoginService;
import com.jxd.eas.service.impl.TeacherServiceImpl;
import com.jxd.eas.service.impl.UserLoginServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ClassName AddTeacherServlet
 * @Description TODO
 * @Author 刘双喜
 * @Date 2026/8/26 15:09
 * @Version 1.0
 */
@WebServlet("/addTeacher")
public class AddTeacherServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String sex = req.getParameter("sex");
        String birthday = req.getParameter("birthday");
        String degree = req.getParameter("degree");
        String title = req.getParameter("title");
        String grade = req.getParameter("grade");
        int collegeID = Integer.parseInt(req.getParameter("collegeID"));

        ITeacherService teacherService = new TeacherServiceImpl();
        Teacher teacher = new Teacher(0,name,sex,birthday,degree,title,grade,collegeID);

        //添加到登录表中
        teacherService.addTeacher(teacher);
        IUserLoginService userLoginService = new UserLoginServiceImpl();
        userLoginService.addAccount(teacher.getId(),1);

        resp.sendRedirect("/getTeachers");
    }
}
