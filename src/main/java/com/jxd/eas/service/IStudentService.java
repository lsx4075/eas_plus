package com.jxd.eas.service;

import com.jxd.eas.model.Student;

import java.util.List;
import java.util.Map;

public interface IStudentService {
    int addStu(Student student);
    boolean removeBatch(int[] ids);
    boolean updateStu(Student student);
    List<Map<String,Object>> getMaps(String stuName);
    Student getOne(int id);
    List<Map<String ,Object>> getMapsByPage(String name,int page,int limit);
}
