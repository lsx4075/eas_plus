package com.jxd.eas.servlet;

import com.jxd.eas.service.ISelectedCourseService;
import com.jxd.eas.service.impl.SelectedCourseServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * @ClassName GetSelectedCourseServlet
 * @Description TODO
 * @Author 刘双喜
 * @Date 2026/8/26 23:20
 * @Version 1.0
 */
@WebServlet("/getSelectedCourse")
public class GetSelectedCourseServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int courseID = Integer.parseInt(req.getParameter("CourseID"));

        ISelectedCourseService selectedCourseService = new SelectedCourseServiceImpl();
        List<Map<String,Object>> list = selectedCourseService.getStudentsByCourseID(courseID);

        req.setAttribute("studentsByCourseIDList", list);
        req.getRequestDispatcher("StudentsByCourseID.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
