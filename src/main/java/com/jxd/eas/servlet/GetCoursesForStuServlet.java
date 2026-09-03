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
 * @ClassName GetCoursesForStuServlet
 * @Description TODO
 * @Author 刘双喜
 * @Date 2026/8/27 8:04
 * @Version 1.0
 */
@WebServlet("/getCoursesForStu")
public class GetCoursesForStuServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String courseNameForStu = req.getParameter("courseNameForStu");
        ICourseService courseService = new CourseServiceImpl();
        List<Map<String,Object>> courseForStuList = courseService.getMaps(courseNameForStu);

        req.setAttribute("courseForStuList",courseForStuList);
        if (courseNameForStu != null) {
            req.setAttribute("courseNameForStu",courseNameForStu);
        }
        req.getRequestDispatcher("CourseForStu.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
