package com.jxd.eas.test;

import com.jxd.eas.model.SelectedCourse;
import com.jxd.eas.service.ISelectedCourseService;
import com.jxd.eas.service.impl.SelectedCourseServiceImpl;

import java.util.List;
import java.util.Map;

/**
 * @ClassName Test05
 * @Description TODO
 * @Author 刘双喜
 * @Date 2026/9/2 14:33
 * @Version 1.0
 */
public class Test05 {
    public static void main(String[] args) {
        ISelectedCourseService selectedCourseService = new SelectedCourseServiceImpl();
        /*List<Map<String, Object>> list = selectedCourseService.getStudentsByCourseID(1);
        list.stream().forEach(System.out::println);*/

        /*SelectedCourse selectedCourse = new SelectedCourse(27,10012,95);
        selectedCourseService.mark(selectedCourse);*/

//        selectedCourseService.insertOne(19, 10001);

       /* boolean isExist = selectedCourseService.isExist(11, 10015);
        System.out.println(isExist);*/

       /* boolean isSelected = selectedCourseService.isSelected(27);
        System.out.println(isSelected);*/

//        selectedCourseService.dropByStudentID(10012);
        selectedCourseService.dropCourse(10, 10015);
    }
}
