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
 * @ClassName GetCoursesUncompletedServlet
 * @Description TODO
 * @Author 刘双喜
 * @Date 2026/8/27 8:55
 * @Version 1.0
 */
@WebServlet("/getCoursesUncompleted")
public class GetCoursesUncompletedServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int studentID = Integer.parseInt((String) req.getSession().getAttribute("uname"));

        ICourseService courseService = new CourseServiceImpl();
        // 获取该学生未完成的课程列表
        List<Map<String, Object>> list = courseService.getCourseOfStudent(studentID, false);
        req.setAttribute("courseUncompletedList", list);
        req.getRequestDispatcher("CoursesChosen.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
