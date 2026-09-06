package com.jxd.eas.controller;

import com.jxd.eas.model.Course;
import com.jxd.eas.service.ICourseService;
import com.jxd.eas.service.ISelectedCourseService;
import com.jxd.eas.service.impl.CourseServiceImpl;
import com.jxd.eas.service.impl.SelectedCourseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

/**
 * @ClassName CourseController
 * @Description TODO
 * @Author 刘双喜
 * @Date 2026/9/6 14:14
 * @Version 1.0
 */
@Controller
public class CourseController {
    @Autowired
    private ICourseService courseService;
    @Autowired
    private ISelectedCourseService selectedCourseService;
    @GetMapping("/getCourses")
    public String getCourses(String courseName, Model m) {
        List<Map<String,Object>> list = courseService.getMaps(courseName);

        //获取所有课程信息，添加到请求体中
        m.addAttribute("courseList",list);
        if (courseName != null) {
            m.addAttribute("courseName",courseName);
        }
        return "CourseList";
    }

    @GetMapping("/toAddCourse")
    public String toAddCourse() {
        return "AddCourse";
    }

    @PostMapping("/addCourse")
    public String addCourse(Course course) {
        courseService.addCourse(course);
        return "redirect:/getCourses";
    }

    @GetMapping("/getOneCourse")
    public String getOneCourse(int id, Model m) {
        Course course = courseService.getOne(id);
        m.addAttribute("course",course);
        return "AddCourse";
    }

    @PostMapping("/editCourse")
    public String editCourse(Course course) {
        courseService.updateCourse(course);
        return "redirect:/getCourses";
    }

    @GetMapping("/delCourse")
    public String delCourse(int id,Model m) {
        int[] ids = {id};

        boolean isSelected = selectedCourseService.isSelected(id);
        if (isSelected) {
            m.addAttribute("msg","该课程已被选中，请先删除选课信息");
            return "forward:/getCourses";
        }

        courseService.removeBatch(ids);
        return "redirect:/getCourses";
    }

    @GetMapping("/getCoursesForStu")
    public String getCoursesForStu(String courseNameForStu,Model m) {
        List<Map<String,Object>> courseForStuList = courseService.getMaps(courseNameForStu);

        m.addAttribute("courseForStuList",courseForStuList);
        if (courseNameForStu != null) {
            m.addAttribute("courseNameForStu",courseNameForStu);
        }
        return "CourseForStu";
    }

    @GetMapping("/getCoursesUncompleted")
    public String getCoursesUncompleted(Model m, HttpSession session) {
        int studentID = Integer.parseInt((String) session.getAttribute("uname"));
        // 获取该学生未完成的课程列表
        List<Map<String, Object>> list = courseService.getCourseOfStudent(studentID, false);
        m.addAttribute("courseUncompletedList", list);
        return "CoursesChosen";
    }

    @GetMapping("/getCoursesFinished")
    public String getCoursesFinished(Model m, HttpSession session) {
        int studentID = Integer.parseInt((String) session.getAttribute("uname"));
        List<Map<String, Object>> list = courseService.getCourseOfStudent(studentID, true);
        list.forEach(map -> System.out.println(map.get("mark")));
        m.addAttribute("courseFinishedList", list);
        return "CourseFinished";
    }
}
