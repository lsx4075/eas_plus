package com.jxd.eas.servlet;

import com.jxd.eas.model.Student;
import com.jxd.eas.service.IStudentService;
import com.jxd.eas.service.IUserLoginService;
import com.jxd.eas.service.impl.StudentServiceImpl;
import com.jxd.eas.service.impl.UserLoginServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ClassName AddStudentServlet
 * @Description TODO
 * @Author 刘双喜
 * @Date 2026/8/26 14:12
 * @Version 1.0
 */
@WebServlet("/addStu")
public class AddStudentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String sex = req.getParameter("sex");
        String birthday = req.getParameter("birthday");
        String grade = req.getParameter("grade");
        int collegeID = Integer.parseInt(req.getParameter("collegeID"));

        IStudentService studentService = new StudentServiceImpl();
        Student student = new Student(0,name,sex,birthday,grade,collegeID);

        //添加到登录表中
        studentService.addStu(student);
        IUserLoginService userLoginService = new UserLoginServiceImpl();
        userLoginService.addAccount(student.getId(),0);

        resp.sendRedirect("/getStudents");
    }
}
