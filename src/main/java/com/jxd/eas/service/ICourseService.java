package com.jxd.eas.service;

import com.jxd.eas.model.Course;

import java.util.List;
import java.util.Map;

public interface ICourseService {
    boolean addCourse(Course course);
    boolean removeBatch(int[] ids);
    boolean updateCourse(Course course);
    List<Map<String,Object>> getMaps(String courseName);//根据课程名查询课程
    Course getOne(int id);//根据id查询课程
    List<Map<String,Object>> getCourseByTeacherID(int teacherID,String courseName);//根据教师id和课程名查询课程
    List<Map<String,Object>> getCourseOfStudent(int studentID, boolean completed);//根据学生id查询未完成的课程
}
