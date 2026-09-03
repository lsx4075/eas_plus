package com.jxd.eas.servlet;

import com.jxd.eas.service.ICourseService;
import com.jxd.eas.service.impl.CourseServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * @ClassName GetCoursesSevlet
 * @Description TODO
 * @Author 刘双喜
 * @Date 2026/8/25 8:50
 * @Version 1.0
 */
@WebServlet("/getCourses")
public class GetCoursesServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String courseName = req.getParameter("courseName");
        ICourseService courseService = new CourseServiceImpl();
        List<Map<String,Object>> list = courseService.getMaps(courseName);

        //获取所有课程信息，添加到请求体中
        req.setAttribute("courseList",list);
        if (courseName != null) {
            req.setAttribute("courseName",courseName);
        }
        req.getRequestDispatcher("CourseList.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
