package com.jxd.eas.servlet;

import com.jxd.eas.model.College;
import com.jxd.eas.service.ICollegeService;
import com.jxd.eas.service.impl.CollegeServiceImpl;
import net.sf.json.JSONArray;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * @ClassName GetCollegeAjaxServlet
 * @Description TODO
 * @Author 刘双喜
 * @Date 2026/8/25 14:22
 * @Version 1.0
 */
@WebServlet("/getCollegeAjax")
public class GetCollegeAjaxServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ICollegeService collegeService = new CollegeServiceImpl();
        List<College> list = collegeService.getColleges();

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
