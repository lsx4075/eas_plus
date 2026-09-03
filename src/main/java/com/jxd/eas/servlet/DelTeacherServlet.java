package com.jxd.eas.servlet;

import com.jxd.eas.service.ICourseService;
import com.jxd.eas.service.ITeacherService;
import com.jxd.eas.service.IUserLoginService;
import com.jxd.eas.service.impl.CourseServiceImpl;
import com.jxd.eas.service.impl.TeacherServiceImpl;
import com.jxd.eas.service.impl.UserLoginServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * @ClassName DelTeacherServlet
 * @Description TODO
 * @Author 刘双喜
 * @Date 2026/8/26 15:27
 * @Version 1.0
 */
@WebServlet("/delTeacher")
public class DelTeacherServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        int[] ids = {id};

        ICourseService courseService = new CourseServiceImpl();
        List<Map<String, Object>> courseList = courseService.getCourseByTeacherID(id, null);
        if (courseList.size() > 0) {
            req.setAttribute("msg", "该教师下有课程，无法删除");
            req.getRequestDispatcher("/getTeachers").forward(req, resp);
        } else {
            // 删除教师信息
            ITeacherService teacherService = new TeacherServiceImpl();
            teacherService.removeBatch(ids);

            // 删除登录表信息
            IUserLoginService userLoginService = new UserLoginServiceImpl();
            userLoginService.delAccount(id);

            resp.sendRedirect("/getTeachers");
        }
    }
}
