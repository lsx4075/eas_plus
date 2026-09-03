package com.jxd.eas.dao;

import com.jxd.eas.model.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface IStudentDao {
    int addOne(Student student);
    boolean deleteBatch(int[] ids);
    boolean updateOne(Student student);
    List<Map<String,Object>> selectStudentWithCollege(String name);
    Student selectOne(int id);
    List<Map<String ,Object>> selectByPage(@Param("name") String name, @Param("page") int page, @Param("limit") int limit);
}
