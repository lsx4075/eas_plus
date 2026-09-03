package com.jxd.eas.service;

import com.jxd.eas.model.SelectedCourse;

import java.util.List;
import java.util.Map;

public interface ISelectedCourseService {
    List<Map<String,Object>> getStudentsByCourseID(int courseID);//根据课程ID获取选课信息
    boolean mark(SelectedCourse selectedCourse);//打分
    boolean insertOne(int courseID, int studentID);//插入选课信息
    boolean isExist(int courseID, int studentID);//判断选课信息是否存在
    boolean dropCourse(int courseID, int studentID);//删除选课信息
    boolean isSelected(int courseID);//判断课程是否被选
    boolean dropByStudentID(int studentID);//根据学生ID删除选课信息
}
