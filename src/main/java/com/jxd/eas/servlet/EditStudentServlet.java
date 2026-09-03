package com.jxd.eas.servlet;

import com.jxd.eas.model.Student;
import com.jxd.eas.service.IStudentService;
import com.jxd.eas.service.impl.StudentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ClassName EditStudentServlet
 * @Description TODO
 * @Author 刘双喜
 * @Date 2026/8/26 14:24
 * @Version 1.0
 */
@WebServlet("/editStu")
public class EditStudentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        String sex = req.getParameter("sex");
        String birthday = req.getParameter("birthday");
        String grade = req.getParameter("grade");
        int collegeID = Integer.parseInt(req.getParameter("collegeID"));

        IStudentService studentService = new StudentServiceImpl();
        Student student = new Student(id,name,sex,birthday,grade,collegeID);
        studentService.updateStu(student);
        resp.sendRedirect("/getStudents");
    }
}
