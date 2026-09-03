package com.jxd.eas.servlet;

import com.jxd.eas.model.SelectedCourse;
import com.jxd.eas.service.ISelectedCourseService;
import com.jxd.eas.service.impl.SelectedCourseServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ClassName MarkServlet
 * @Description TODO
 * @Author 刘双喜
 * @Date 2026/8/27 6:09
 * @Version 1.0
 */
@WebServlet("/mark")
public class MarkServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int courseID = Integer.parseInt(req.getParameter("courseID"));
        int studentID = Integer.parseInt(req.getParameter("studentID"));
        double mark = Double.parseDouble(req.getParameter("mark"));
        SelectedCourse selectedCourse = new SelectedCourse(courseID,studentID,mark);

        ISelectedCourseService selectedCourseService = new SelectedCourseServiceImpl();
        selectedCourseService.mark(selectedCourse);

        resp.sendRedirect("/getSelectedCourse?CourseID=" + courseID);
    }
}
