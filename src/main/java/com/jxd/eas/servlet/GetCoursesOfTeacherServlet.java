package com.jxd.eas.servlet;

import com.jxd.eas.service.ICourseService;
import com.jxd.eas.service.impl.CourseServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * @ClassName GetCoursesOfTeacherServlet
 * @Description TODO
 * @Author 刘双喜
 * @Date 2026/8/26 22:41
 * @Version 1.0
 */
@WebServlet("/getCoursesOfTeacher")
public class GetCoursesOfTeacherServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String courseName = req.getParameter("courseName");
        HttpSession session = req.getSession();
        String userName = (String)session.getAttribute("uname");
        int teacherID = Integer.parseInt(userName);
        ICourseService courseService = new CourseServiceImpl();
        List<Map<String,Object>> list = courseService.getCourseByTeacherID(teacherID,courseName);
        req.setAttribute("coursesOfTeacherList",list);
        req.getRequestDispatcher("CoursesOfTeacher.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
