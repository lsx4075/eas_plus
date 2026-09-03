package com.jxd.eas.servlet;

import com.jxd.eas.model.Teacher;
import com.jxd.eas.service.ITeacherService;
import com.jxd.eas.service.impl.TeacherServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ClassName GetOneTeacherServlet
 * @Description TODO
 * @Author 刘双喜
 * @Date 2026/8/26 15:13
 * @Version 1.0
 */
@WebServlet("/getOneTeacher")
public class GetOneTeacherServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        ITeacherService teacherService = new TeacherServiceImpl();
        Teacher teacher = teacherService.getOne(id);

        req.setAttribute("teacher",teacher);
        req.getRequestDispatcher("AddTeacher.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
