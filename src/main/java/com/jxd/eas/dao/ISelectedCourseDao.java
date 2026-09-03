package com.jxd.eas.dao;

import com.jxd.eas.model.SelectedCourse;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface ISelectedCourseDao {
    List<Map<String,Object>> selectStudentsByCourseID(int courseID);
    boolean updateMark(SelectedCourse selectedCourse);//更新分数
    boolean addOne(@Param("courseID") int courseID, @Param("studentID") int studentID);//添加选课信息
    SelectedCourse selectOne(@Param("courseID") int courseID, @Param("studentID") int studentID);//获取指定选课信息
    boolean deleteOne(@Param("courseID") int courseID, @Param("studentID") int studentID);//删除选课信息
    SelectedCourse selectOneByCourseID(int courseID);//判断课程是否被选
    boolean deleteByStudentID(int studentID);//根据学生ID删除选课信息
}
