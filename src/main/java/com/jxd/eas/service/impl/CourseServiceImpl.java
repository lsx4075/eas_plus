package com.jxd.eas.service.impl;

import com.jxd.eas.dao.ICourseDao;
import com.jxd.eas.model.Course;
import com.jxd.eas.service.ICourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @ClassName CourseServiceImpl
 * @Description TODO
 * @Author 刘双喜
 * @Date 2026/9/1 18:24
 * @Version 1.0
 */
@Service
public class CourseServiceImpl implements ICourseService {
    @Autowired
    private ICourseDao courseDao;
    @Override
    public boolean addCourse(Course course) {
        return courseDao.addOne(course);
    }

    @Override
    public boolean removeBatch(int[] ids) {
        return courseDao.deleteBatch(ids);
    }
    @Override
    public boolean updateCourse(Course course) {
        return courseDao.updateOne(course);
    }

    @Override
    public List<Map<String, Object>> getMaps(String courseName) {
        return courseDao.selectCourseWithCollege(courseName);
    }

    @Override
    public Course getOne(int id) {
        return courseDao.selectOne(id);
    }

    @Override
    public List<Map<String, Object>> getCourseByTeacherID(int teacherID, String courseName) {
        return courseDao.selectCourseByTeacherID(teacherID, courseName);
    }

    @Override
    public List<Map<String, Object>> getCourseOfStudent(int studentID, boolean completed) {
        return courseDao.selectCourseOfStudent(studentID, completed);
    }
}
