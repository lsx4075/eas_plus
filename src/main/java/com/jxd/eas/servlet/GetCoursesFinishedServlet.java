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
 * @ClassName GetCoursesFinishedServlet
 * @Description TODO
 * @Author 刘双喜
 * @Date 2026/8/27 10:31
 * @Version 1.0
 */
@WebServlet("/getCoursesFinished")
public class GetCoursesFinishedServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int studentID = Integer.parseInt((String) req.getSession().getAttribute("uname"));

        ICourseService courseService = new CourseServiceImpl();
        List<Map<String, Object>> list = courseService.getCourseOfStudent(studentID, true);
        list.forEach(map -> System.out.println(map.get("mark")));
        req.setAttribute("courseFinishedList", list);
        req.getRequestDispatcher("CourseFinished.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
