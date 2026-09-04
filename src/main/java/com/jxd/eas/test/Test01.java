package com.jxd.eas.test;

import com.jxd.eas.model.Course;
import com.jxd.eas.service.ICourseService;
import com.jxd.eas.service.impl.CourseServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;
import java.util.Map;

/**
 * @ClassName Test01
 * @Description TODO
 * @Author 刘双喜
 * @Date 2026/9/1 19:32
 * @Version 1.0
 */
public class Test01 {
    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring_mybatis.xml");
        ICourseService courseService = (ICourseService) ac.getBean("courseServiceImpl");
        /*Course course = new Course(29,"高级口语",1018,"周一","X302",18,"必修",3,2);
        courseService.addCourse(course);
        course.setCourseTime("周二");
        course.setScore(1.5);
        courseService.updateCourse(course);*/

        List<Map<String, Object>> courses = courseService.getMaps(null);
        for (Map<String, Object> courseMap : courses) {
            System.out.println(courseMap);
        }

       /* Course course1 = courseService.getOne(29);
        System.out.println(course1);*/

        /*List<Map<String, Object>> list = courseService.getCourseByTeacherID(1001,null);
        for (Map<String, Object> map : list) {
            System.out.println(map);
        }*/

        /*List<Map<String, Object>> list1 = courseService.getCourseOfStudent(10001, false);
        for (Map<String, Object> map : list1) {
            System.out.println(map);
        }*/

        /*if (courseService.removeBatch(new int[]{29}))
            System.out.println("删除成功");
        else
            System.out.println("删除失败");*/
    }
}
