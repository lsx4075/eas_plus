package com.jxd.eas.controller;

import com.jxd.eas.model.Student;
import com.jxd.eas.service.ISelectedCourseService;
import com.jxd.eas.service.IStudentService;
import com.jxd.eas.service.IUserLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

/**
 * @ClassName StudentController
 * @Description TODO
 * @Author 刘双喜
 * @Date 2026/9/6 16:23
 * @Version 1.0
 */
@Controller
public class StudentController {
    @Autowired
    private IStudentService studentService;
    @Autowired
    private IUserLoginService userLoginService;
    @Autowired
    private ISelectedCourseService selectedCourseService;

    @GetMapping("/getStudents")
    public String getStudents(String stuName,
                              @RequestParam(value = "page", defaultValue = "1") int page,
                              @RequestParam(value = "limit", defaultValue = "5") int limit,
                              Model m) {

        List<Map<String,Object>> list = studentService.getMaps(stuName);

        List<Map<String,Object>> listPage = studentService.getMapsByPage(stuName,page,limit);

        //计算页码数
        int total = list.size();
        int pages = total % limit == 0 ? total / limit : total / limit + 1;

        m.addAttribute("stuList",listPage);
        m.addAttribute("pages",pages);
        m.addAttribute("limit",limit);
        if (stuName != null) {
            m.addAttribute("stuName",stuName);
        }
        return "StuList";
    }
    @GetMapping("/toAddStu")
    public String toAddStu() {
        return "AddStu";
    }
    @PostMapping("/addStu")
    public String addStu(Student student) {
        studentService.addStu(student);
        userLoginService.addAccount(student.getId(),0);
        return "redirect:/getStudents";
    }
    @GetMapping("/getOneStu")
    public String getOneStu(int id, Model m) {
        Student student = studentService.getOne(id);
        m.addAttribute("student",student);
        return "AddStu";
    }
    @PostMapping("/editStu")
    public String editStu(Student student) {
        studentService.updateStu(student);
        return "redirect:/getStudents";
    }
    @GetMapping("/delStu")
    public String delStu(int id) {
        int[] ids = {id};
        studentService.removeBatch(ids);

        //删除登录表信息
        userLoginService.delAccount(id);

        //删除选课表信息
        selectedCourseService.dropByStudentID(id);

        return "redirect:/getStudents";
    }
}
