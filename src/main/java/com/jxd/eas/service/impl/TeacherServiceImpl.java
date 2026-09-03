package com.jxd.eas.service.impl;

import com.jxd.eas.dao.ITeacherDao;
import com.jxd.eas.model.Teacher;
import com.jxd.eas.service.ITeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @ClassName TeacherServiceImpl
 * @Description TODO
 * @Author 刘双喜
 * @Date 2026/9/2 12:46
 * @Version 1.0
 */
@Service
public class TeacherServiceImpl implements ITeacherService {
    @Autowired
    private ITeacherDao teacherDao;
    @Override
    public int addTeacher(Teacher teacher) {
        return teacherDao.addOne(teacher);
    }

    @Override
    public boolean removeBatch(int[] ids) {
        return teacherDao.deleteBatch(ids);
    }

    @Override
    public boolean updateTeacher(Teacher teacher) {
        return teacherDao.updateOne(teacher);
    }

    @Override
    public List<Map<String, Object>> getMaps(String name) {
        return teacherDao.selectTeacherWithCollege(name);
    }

    @Override
    public List<Map<String, Object>> getMapsByPage(String name, int page, int limit) {
        return teacherDao.selectByPage(name, page, limit);
    }

    @Override
    public Teacher getOne(int id) {
        return teacherDao.selectOne(id);
    }

    @Override
    public List<Map<String, Object>> getTeachers(int collegeID) {
        return teacherDao.selectTeachers(collegeID);
    }
}
