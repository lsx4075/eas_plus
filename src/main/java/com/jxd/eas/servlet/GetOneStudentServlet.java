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
 * @ClassName GetOneStudentServlet
 * @Description TODO
 * @Author 刘双喜
 * @Date 2026/8/26 11:08
 * @Version 1.0
 */
@WebServlet("/getOneStu")
public class GetOneStudentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        IStudentService studentService = new StudentServiceImpl();
        Student student = studentService.getOne(id);

        req.setAttribute("student",student);
        req.getRequestDispatcher("AddStu.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
