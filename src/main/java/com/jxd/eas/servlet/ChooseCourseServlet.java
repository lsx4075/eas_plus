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
 * @ClassName ChooseCourseServlet
 * @Description TODO
 * @Author 刘双喜
 * @Date 2026/8/27 8:25
 * @Version 1.0
 */
@WebServlet("/chooseCourse")
public class ChooseCourseServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int courseID = Integer.parseInt(req.getParameter("courseID"));
        int studentID = Integer.parseInt(req.getParameter("studentID"));

        ISelectedCourseService selectedCourseService = new SelectedCourseServiceImpl();
        // 判断该学生是否已选过该课程
        boolean flag = selectedCourseService.isExist(courseID, studentID);
        if (flag) {
            req.setAttribute("msg", "该课程已选，请勿重复选课");
            req.getRequestDispatcher("/getCoursesForStu").forward(req, resp);
        } else {
            selectedCourseService.insertOne(courseID, studentID);
            resp.sendRedirect("/getCoursesUncompleted");
        }
    }
}
