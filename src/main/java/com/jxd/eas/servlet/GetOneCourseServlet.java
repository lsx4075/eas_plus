package com.jxd.eas.servlet;

import com.jxd.eas.model.Course;
import com.jxd.eas.service.ICourseService;
import com.jxd.eas.service.impl.CourseServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ClassName GetOneCourseServlet
 * @Description TODO
 * @Author 刘双喜
 * @Date 2026/8/25 16:33
 * @Version 1.0
 */
@WebServlet("/getOneCourse")
public class GetOneCourseServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        ICourseService courseService = new CourseServiceImpl();
        Course course = courseService.getOne(id);

        req.setAttribute("course",course);
        req.getRequestDispatcher("AddCourse.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
