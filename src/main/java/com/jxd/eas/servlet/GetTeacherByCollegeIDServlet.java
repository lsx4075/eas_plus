package com.jxd.eas.servlet;

import com.jxd.eas.service.ITeacherService;
import com.jxd.eas.service.impl.TeacherServiceImpl;
import net.sf.json.JSONArray;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

/**
 * @ClassName GetTeacherByCollegeIDServlet
 * @Description TODO
 * @Author 刘双喜
 * @Date 2026/8/25 18:08
 * @Version 1.0
 */
@WebServlet("/getTeacherWithIDByCollegeID")
public class GetTeacherByCollegeIDServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int collegeID = Integer.parseInt(req.getParameter("collegeID"));
        ITeacherService teacherService = new TeacherServiceImpl();
        List<Map<String,Object>> list = teacherService.getTeachers(collegeID);

        resp.setContentType("text/html;charset=utf-8");
        PrintWriter pw = resp.getWriter();

        JSONArray jsonArray = JSONArray.fromObject(list);
        pw.write(jsonArray.toString());
        pw.flush();
        pw.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
