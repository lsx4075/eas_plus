package com.jxd.eas.dao;

import com.jxd.eas.model.Course;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface ICourseDao {
    boolean addOne(Course course);
    boolean deleteBatch(int[] ids);
    boolean updateOne(Course course);
    List<Map<String,Object>> selectCourseWithCollege(String courseName);//查询所有课程及所属院系名
    Course selectOne(int id);
    List<Map<String,Object>> selectCourseByTeacherID(@Param("teacherID") int teacherID, @Param("courseName") String courseName);//查询教师所教课程

    //查询学生课程，completed为true则查询已选课程，为false则查询未选课程
    List<Map<String,Object>> selectCourseOfStudent(@Param("studentID") int studentID, @Param("completed") boolean completed);
}
