package com.jxd.eas.service;

import com.jxd.eas.model.Teacher;

import java.util.List;
import java.util.Map;

public interface ITeacherService {
    int addTeacher(Teacher teacher);
    boolean removeBatch(int[] ids);
    boolean updateTeacher(Teacher teacher);
    List<Map<String,Object>> getMaps(String name);
    List<Map<String ,Object>> getMapsByPage(String name,int page,int limit);
    Teacher getOne(int id);
    List<Map<String,Object>> getTeachers(int collegeID);
}
