package com.jxd.eas.dao;

import com.jxd.eas.model.Teacher;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface ITeacherDao {
    int addOne(Teacher teacher);
    boolean deleteBatch(int[] ids);
    boolean updateOne(Teacher teacher);
    List<Map<String,Object>> selectTeacherWithCollege(String name);
    List<Map<String,Object>> selectTeachers(int collegeID);
    List<Map<String ,Object>> selectByPage(@Param("name") String name, @Param("page") int page, @Param("limit") int limit);
    Teacher selectOne(int id);
}
