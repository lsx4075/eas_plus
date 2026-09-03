package com.jxd.eas.test;

import com.jxd.eas.model.Student;
import com.jxd.eas.service.IStudentService;
import com.jxd.eas.service.impl.StudentServiceImpl;

import java.util.List;
import java.util.Map;

/**
 * @ClassName Test04
 * @Description TODO
 * @Author 刘双喜
 * @Date 2026/9/2 13:50
 * @Version 1.0
 */
public class Test04 {
    public static void main(String[] args) {
        IStudentService studentService = new StudentServiceImpl();
        /*Student student = new Student(1, "小乐", "男", "2000-01-01", "2026-07-01", 3);
        studentService.addStu(student);
        System.out.println(student.getId());*/

//        studentService.removeBatch(new int[]{10012,10013});

        /*Student student = new Student(10008, "小亮", "男", "2000-01-01", "2026-08-20", 2);
        studentService.updateStu(student);*/

        /*List<Map<String,Object>> list = studentService.getMaps("米");
        list.forEach(System.out::println);*/

        /*List<Map<String,Object>> list1 = studentService.getMapsByPage("米",1,5);
        list1.forEach(System.out::println);*/

        Student student = studentService.getOne(10015);
        System.out.println(student);
    }
}
