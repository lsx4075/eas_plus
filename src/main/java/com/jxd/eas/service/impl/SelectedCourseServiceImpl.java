package com.jxd.eas.service.impl;

import com.jxd.eas.dao.ISelectedCourseDao;
import com.jxd.eas.model.SelectedCourse;
import com.jxd.eas.service.ISelectedCourseService;
import com.jxd.eas.util.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;
import java.util.Map;

/**
 * @ClassName SelectedCourseServiceImpl
 * @Description TODO
 * @Author 刘双喜
 * @Date 2026/8/26 23:36
 * @Version 1.0
 */
public class SelectedCourseServiceImpl implements ISelectedCourseService {
    private ISelectedCourseDao selectedCourseDao;
    @Override
    public List<Map<String, Object>> getStudentsByCourseID(int courseID) {
        SqlSession sqlSession = SqlSessionUtil.getSession();
        selectedCourseDao = sqlSession.getMapper(ISelectedCourseDao.class);

        return selectedCourseDao.selectStudentsByCourseID(courseID);
    }

    @Override
    public boolean mark(SelectedCourse selectedCourse) {
        SqlSession sqlSession = SqlSessionUtil.getSession();
        selectedCourseDao = sqlSession.getMapper(ISelectedCourseDao.class);

        return selectedCourseDao.updateMark(selectedCourse);
    }

    @Override
    public boolean insertOne(int courseID, int studentID) {
        SqlSession sqlSession = SqlSessionUtil.getSession();
        selectedCourseDao = sqlSession.getMapper(ISelectedCourseDao.class);

        return selectedCourseDao.addOne(courseID, studentID);
    }

    @Override
    public boolean isExist(int courseID, int studentID) {
        SqlSession sqlSession = SqlSessionUtil.getSession();
        selectedCourseDao = sqlSession.getMapper(ISelectedCourseDao.class);

        SelectedCourse selectedCourse = selectedCourseDao.selectOne(courseID, studentID);
        boolean flag = false;
        if (selectedCourse != null) {
            flag = true;
        }
        return flag;
    }

    @Override
    public boolean dropCourse(int courseID, int studentID) {
        SqlSession sqlSession = SqlSessionUtil.getSession();
        selectedCourseDao = sqlSession.getMapper(ISelectedCourseDao.class);

        return selectedCourseDao.deleteOne(courseID, studentID);
    }

    @Override
    public boolean isSelected(int courseID) {
        SqlSession sqlSession = SqlSessionUtil.getSession();
        selectedCourseDao = sqlSession.getMapper(ISelectedCourseDao.class);

        SelectedCourse selectedCourse = selectedCourseDao.selectOneByCourseID(courseID);
        boolean flag = false;
        if (selectedCourse != null) {
            flag = true;
        }
        return flag;
    }

    @Override
    public boolean dropByStudentID(int studentID) {
        SqlSession sqlSession = SqlSessionUtil.getSession();
        selectedCourseDao = sqlSession.getMapper(ISelectedCourseDao.class);

        return selectedCourseDao.deleteByStudentID(studentID);
    }
}
