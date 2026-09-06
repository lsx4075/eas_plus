package com.jxd.eas.controller;

import com.jxd.eas.model.Teacher;
import com.jxd.eas.service.ICourseService;
import com.jxd.eas.service.ITeacherService;
import com.jxd.eas.service.IUserLoginService;
import com.jxd.eas.service.impl.CourseServiceImpl;
import com.jxd.eas.service.impl.TeacherServiceImpl;
import com.jxd.eas.service.impl.UserLoginServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

/**
 * @ClassName TeacherController
 * @Description TODO
 * @Author 刘双喜
 * @Date 2026/9/6 15:48
 * @Version 1.0
 */
@Controller
public class TeacherController {
    @Autowired
    private ITeacherService teacherService;
    @Autowired
    private ICourseService courseService;
    @Autowired
    private IUserLoginService userLoginService;

    @GetMapping("/getTeachers")
    public String getTeachers(String teacherName,
                              @RequestParam(value = "page", defaultValue = "1") int page,
                              @RequestParam(value = "limit", defaultValue = "5") int limit,
                              Model m) {

        List<Map<String,Object>> list = teacherService.getMaps(teacherName);

        List<Map<String,Object>> listPage = teacherService.getMapsByPage(teacherName,page,limit);

        //计算页码数
        int total = list.size();
        int pages = total % limit == 0 ? total / limit : total / limit + 1;

        m.addAttribute("teacherList",listPage);
        m.addAttribute("pages",pages);
        m.addAttribute("limit",limit);
        if (teacherName != null) {
            m.addAttribute("teacherName",teacherName);
        }
        return "TeacherList";
    }

    @GetMapping("/toAddTeacher")
    public String toAddTeacher() {
        return "AddTeacher";
    }

    @PostMapping("/addTeacher")
    public String addTeacher(Teacher teacher) {
        teacherService.addTeacher(teacher);
        return "redirect:/getTeachers";
    }

    @GetMapping("/getOneTeacher")
    public String getOneTeacher(int id, Model m) {
        Teacher teacher = teacherService.getOne(id);
        m.addAttribute("teacher",teacher);
        return "AddTeacher";
    }

    @PostMapping("/editTeacher")
    public String editTeacher(Teacher teacher) {
        teacherService.updateTeacher(teacher);
        return "redirect:/getTeachers";
    }

    @GetMapping("/delTeacher")
    public String delTeacher(int id,Model m) {
        int[] ids = {id};

        List<Map<String, Object>> courseList = courseService.getCourseByTeacherID(id, null);
        if (courseList.size() > 0) {
            m.addAttribute("msg", "该教师下有课程，无法删除");
            return "forward:/getTeachers";
        } else {
            // 删除教师信息
            teacherService.removeBatch(ids);

            // 删除登录表信息
            userLoginService.delAccount(id);

           return "redirect:/getTeachers";
        }
    }
}
