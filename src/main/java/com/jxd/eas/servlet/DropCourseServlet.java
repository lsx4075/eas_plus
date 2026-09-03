package com.jxd.eas.servlet;

import com.jxd.eas.service.ISelectedCourseService;
import com.jxd.eas.service.impl.SelectedCourseServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ClassName DropCourseServlet
 * @Description TODO
 * @Author 刘双喜
 * @Date 2026/8/27 10:08
 * @Version 1.0
 */
@WebServlet("/dropCourse")
public class DropCourseServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int courseID = Integer.parseInt(req.getParameter("courseID"));
        int studentID = Integer.parseInt((String) req.getSession().getAttribute("uname"));

        ISelectedCourseService selectedCourseService = new SelectedCourseServiceImpl();
        selectedCourseService.dropCourse(courseID, studentID);
        resp.sendRedirect("/getCoursesUncompleted");
    }
}
