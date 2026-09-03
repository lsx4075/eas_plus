package com.jxd.eas.service.impl;

import com.jxd.eas.dao.ITeacherDao;
import com.jxd.eas.model.Teacher;
import com.jxd.eas.service.ITeacherService;
import com.jxd.eas.util.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;
import java.util.Map;

/**
 * @ClassName TeacherServiceImpl
 * @Description TODO
 * @Author 刘双喜
 * @Date 2026/9/2 12:46
 * @Version 1.0
 */
public class TeacherServiceImpl implements ITeacherService {
    private ITeacherDao teacherDao;
    @Override
    public int addTeacher(Teacher teacher) {
        SqlSession sqlSession = SqlSessionUtil.getSession();
        teacherDao = sqlSession.getMapper(ITeacherDao.class);

        return teacherDao.addOne(teacher);
    }

    @Override
    public boolean removeBatch(int[] ids) {
        SqlSession sqlSession = SqlSessionUtil.getSession();
        teacherDao = sqlSession.getMapper(ITeacherDao.class);

        return teacherDao.deleteBatch(ids);
    }

    @Override
    public boolean updateTeacher(Teacher teacher) {
        SqlSession sqlSession = SqlSessionUtil.getSession();
        teacherDao = sqlSession.getMapper(ITeacherDao.class);

        return teacherDao.updateOne(teacher);
    }

    @Override
    public List<Map<String, Object>> getMaps(String name) {
        SqlSession sqlSession = SqlSessionUtil.getSession();
        teacherDao = sqlSession.getMapper(ITeacherDao.class);

        return teacherDao.selectTeacherWithCollege(name);
    }

    @Override
    public List<Map<String, Object>> getMapsByPage(String name, int page, int limit) {
        SqlSession sqlSession = SqlSessionUtil.getSession();
        teacherDao = sqlSession.getMapper(ITeacherDao.class);

        return teacherDao.selectByPage(name, page, limit);
    }

    @Override
    public Teacher getOne(int id) {
        SqlSession sqlSession = SqlSessionUtil.getSession();
        teacherDao = sqlSession.getMapper(ITeacherDao.class);

        return teacherDao.selectOne(id);
    }

    @Override
    public List<Map<String, Object>> getTeachers(int collegeID) {
        SqlSession sqlSession = SqlSessionUtil.getSession();
        teacherDao = sqlSession.getMapper(ITeacherDao.class);

        return teacherDao.selectTeachers(collegeID);
    }
}
