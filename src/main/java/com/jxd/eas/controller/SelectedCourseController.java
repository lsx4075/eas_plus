package com.jxd.eas.controller;

import com.jxd.eas.model.SelectedCourse;
import com.jxd.eas.service.ISelectedCourseService;
import com.jxd.eas.service.impl.SelectedCourseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

/**
 * @ClassName SelectedCourseController
 * @Description TODO
 * @Author 刘双喜
 * @Date 2026/9/6 17:09
 * @Version 1.0
 */
@Controller
public class SelectedCourseController {
    @Autowired
    private ISelectedCourseService selectedCourseService;

    @GetMapping("/chooseCourse")
    public String chooseCourse(@RequestParam("courseID") int courseID, int studentID, Model m) {
        // 判断该学生是否已选过该课程
        boolean flag = selectedCourseService.isExist(courseID, studentID);
        if (flag) {
            m.addAttribute("msg", "该课程已选，请勿重复选课");
            return "forward:/getCoursesForStu";
        } else {
            selectedCourseService.insertOne(courseID, studentID);
            return "redirect:/getCoursesUncompleted";
        }
    }
    @GetMapping("/dropCourse")
    public String dropCourse(int courseID, HttpSession session) {
        int studentID = Integer.parseInt((String) session.getAttribute("uname"));
        selectedCourseService.dropCourse(courseID, studentID);

        return "redirect:/getCoursesUncompleted";
    }

    @GetMapping("/getSelectedCourse")
    public String getSelectedCourse(Model m, int courseID) {
        List<Map<String,Object>> list = selectedCourseService.getStudentsByCourseID(courseID);

        m.addAttribute("studentsByCourseIDList", list);
        return "StudentsByCourseID";
    }

    @GetMapping("/toMark")
    public String toMark(String courseID, String studentName, String studentID, Model m) {
        m.addAttribute("studentID", studentID);
        m.addAttribute("studentName", studentName);
        m.addAttribute("courseID", courseID);
        return "Mark";
    }
    @PostMapping ("/mark")
    public String mark(SelectedCourse selectedCourse) {
        selectedCourseService.mark(selectedCourse);

        return "redirect:/getSelectedCourse?courseID=" + selectedCourse.getCourseID();
    }
}
