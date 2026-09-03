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
 * @ClassName EditCourseServlet
 * @Description TODO
 * @Author 刘双喜
 * @Date 2026/8/26 9:02
 * @Version 1.0
 */
@WebServlet("/editCourse")
public class EditCourseServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        String courseName = req.getParameter("courseName");
        int teacherID = Integer.parseInt(req.getParameter("teacherID"));
        String courseTime = req.getParameter("courseTime");
        String classroom = req.getParameter("classroom");
        int classWeek = Integer.parseInt(req.getParameter("classWeek"));
        String courseType = req.getParameter("courseType");
        double score = Double.parseDouble(req.getParameter("score"));
        int collegeID = Integer.parseInt(req.getParameter("collegeID"));

        ICourseService courseService = new CourseServiceImpl();
        Course course = new Course(id,courseName,teacherID,courseTime,classroom,classWeek,courseType,collegeID,score);
        courseService.updateCourse(course);
        resp.sendRedirect("/getCourses");
    }
}
