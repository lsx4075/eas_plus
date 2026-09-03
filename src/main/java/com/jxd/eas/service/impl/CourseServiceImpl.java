package com.jxd.eas.service.impl;

import com.jxd.eas.dao.ICourseDao;
import com.jxd.eas.model.Course;
import com.jxd.eas.service.ICourseService;
import com.jxd.eas.util.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;
import java.util.Map;

/**
 * @ClassName CourseServiceImpl
 * @Description TODO
 * @Author 刘双喜
 * @Date 2026/9/1 18:24
 * @Version 1.0
 */
public class CourseServiceImpl implements ICourseService {
    private ICourseDao courseDao;
    @Override
    public boolean addCourse(Course course) {
        SqlSession sqlSession = SqlSessionUtil.getSession();
        courseDao = sqlSession.getMapper(ICourseDao.class);

        return courseDao.addOne(course);
    }

    @Override
    public boolean removeBatch(int[] ids) {
        SqlSession sqlSession = SqlSessionUtil.getSession();
        courseDao = sqlSession.getMapper(ICourseDao.class);

        return courseDao.deleteBatch(ids);
    }
    @Override
    public boolean updateCourse(Course course) {
        SqlSession sqlSession = SqlSessionUtil.getSession();
        courseDao = sqlSession.getMapper(ICourseDao.class);

        return courseDao.updateOne(course);
    }

    @Override
    public List<Map<String, Object>> getMaps(String courseName) {
        SqlSession sqlSession = SqlSessionUtil.getSession();
        courseDao = sqlSession.getMapper(ICourseDao.class);

        return courseDao.selectCourseWithCollege(courseName);
    }

    @Override
    public Course getOne(int id) {
        SqlSession sqlSession = SqlSessionUtil.getSession();
        courseDao = sqlSession.getMapper(ICourseDao.class);

        return courseDao.selectOne(id);
    }

    @Override
    public List<Map<String, Object>> getCourseByTeacherID(int teacherID, String courseName) {
        SqlSession sqlSession = SqlSessionUtil.getSession();
        courseDao = sqlSession.getMapper(ICourseDao.class);

        return courseDao.selectCourseByTeacherID(teacherID, courseName);
    }

    @Override
    public List<Map<String, Object>> getCourseOfStudent(int studentID, boolean completed) {
        SqlSession sqlSession = SqlSessionUtil.getSession();
        courseDao = sqlSession.getMapper(ICourseDao.class);

        return courseDao.selectCourseOfStudent(studentID, completed);
    }
}
