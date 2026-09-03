package com.jxd.eas.test;

import com.jxd.eas.model.Teacher;
import com.jxd.eas.service.ITeacherService;
import com.jxd.eas.service.impl.TeacherServiceImpl;

import java.util.List;
import java.util.Map;

/**
 * @ClassName Test03
 * @Description TODO
 * @Author 刘双喜
 * @Date 2026/9/2 12:49
 * @Version 1.0
 */
public class Test03 {
    public static void main(String[] args) {
        ITeacherService teacherService = new TeacherServiceImpl();
       /* Teacher teacher = new Teacher(1, "王五", "男", "1990-01-01", "博士", "教授", "2026-01-01", 1);
        teacherService.addTeacher(teacher);
        System.out.println(teacher.getId());*/

        /*List<Map<String, Object>> list = teacherService.getMaps(null);
        list.stream().forEach(System.out::println);*/

        List<Map<String,Object>> list1 = teacherService.getMapsByPage(null,1,5);
        list1.stream().forEach(System.out::println);

        /*List<Map<String,Object>> list2 = teacherService.getTeachers(1);
        list2.stream().forEach(System.out::println);*/

        /*Teacher teacher = new Teacher(1019, "王五", "男", "1990-01-01", "博士", "副教授", "2026-01-01", 2);
        teacherService.updateTeacher(teacher);*/

        /*Teacher teacher = teacherService.getOne(1019);
        System.out.println(teacher);*/


        /*if (teacherService.removeBatch(new int[]{1016,1019}))
            System.out.println("删除成功");
        else
            System.out.println("删除失败");*/

    }
}
