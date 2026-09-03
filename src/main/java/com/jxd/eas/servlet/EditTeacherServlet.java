package com.jxd.eas.servlet;

import com.jxd.eas.model.Teacher;
import com.jxd.eas.service.ITeacherService;
import com.jxd.eas.service.impl.TeacherServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ClassName EditTeacherServlet
 * @Description TODO
 * @Author 刘双喜
 * @Date 2026/8/26 15:24
 * @Version 1.0
 */
@WebServlet("/editTeacher")
public class EditTeacherServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        String sex = req.getParameter("sex");
        String birthday = req.getParameter("birthday");
        String degree = req.getParameter("degree");
        String title = req.getParameter("title");
        String grade = req.getParameter("grade");
        int collegeID = Integer.parseInt(req.getParameter("collegeID"));

        ITeacherService teacherService = new TeacherServiceImpl();
        Teacher teacher = new Teacher(id,name,sex,birthday,degree,title,grade,collegeID);
        teacherService.updateTeacher(teacher);
        resp.sendRedirect("/getTeachers");
    }
}
