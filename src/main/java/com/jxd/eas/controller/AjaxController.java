package com.jxd.eas.controller;

import com.jxd.eas.model.College;
import com.jxd.eas.service.ICollegeService;
import com.jxd.eas.service.ITeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @ClassName AjaxController
 * @Description TODO
 * @Author 刘双喜
 * @Date 2026/9/6 14:44
 * @Version 1.0
 */
@RestController
public class AjaxController {
    @Autowired
    private ICollegeService collegeService;
    @Autowired
    private ITeacherService teacherService;
    @GetMapping("/getCollegeAjax")
    public List<College> getCollegeAjax() {
        List<College> list = collegeService.getColleges();

        return list;
    }

    @GetMapping("/getTeacherWithIDByCollegeID")
    public List<Map<String,Object>> getTeacherWithIDByCollegeID(int collegeID) {
        List<Map<String,Object>> list = teacherService.getTeachers(collegeID);

        return list;
    }

}
