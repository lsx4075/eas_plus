package com.jxd.eas.servlet;

import com.jxd.eas.service.ICourseService;
import com.jxd.eas.service.ISelectedCourseService;
import com.jxd.eas.service.impl.CourseServiceImpl;
import com.jxd.eas.service.impl.SelectedCourseServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ClassName DelCourseServlet
 * @Description TODO
 * @Author 刘双喜
 * @Date 2026/8/26 9:11
 * @Version 1.0
 */
@WebServlet("/delCourse")
public class DelCourseServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        int[] ids = {id};

        ISelectedCourseService selectedCourseService = new SelectedCourseServiceImpl();
        boolean isSelected = selectedCourseService.isSelected(id);
        if (isSelected) {
            req.setAttribute("msg","该课程已被选中，请先删除选课信息");
            req.getRequestDispatcher("/getCourses").forward(req, resp);
            return;
        }
        ICourseService courseService = new CourseServiceImpl();
        courseService.removeBatch(ids);

        resp.sendRedirect("/getCourses");
    }
}
