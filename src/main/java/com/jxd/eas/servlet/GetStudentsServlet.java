package com.jxd.eas.servlet;

import com.jxd.eas.service.IStudentService;
import com.jxd.eas.service.impl.StudentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * @ClassName GetStudentsServlet
 * @Description TODO
 * @Author 刘双喜
 * @Date 2026/8/26 9:36
 * @Version 1.0
 */
@WebServlet("/getStudents")
public class GetStudentsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String stuName = req.getParameter("stuName");
        String pageStr = req.getParameter("page");
        String limitStr = req.getParameter("limit");
        int page = 1;
        int limit = 5;
        if (pageStr != null) {
            page = Integer.parseInt(pageStr);
        }
        if (limitStr != null) {
            limit = Integer.parseInt(limitStr);
        }

        IStudentService studentService = new StudentServiceImpl();
        List<Map<String,Object>> list = studentService.getMaps(stuName);

        List<Map<String,Object>> listPage = studentService.getMapsByPage(stuName,page,limit);

        //计算页码数
        int total = list.size();
        int pages = total % limit == 0 ? total / limit : total / limit + 1;

        req.setAttribute("stuList",listPage);
        req.setAttribute("pages",pages);
        req.setAttribute("limit",limit);
        if (stuName != null) {
            req.setAttribute("stuName",stuName);
        }
        req.getRequestDispatcher("StuList.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
