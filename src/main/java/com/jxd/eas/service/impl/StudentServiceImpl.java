package com.jxd.eas.service.impl;

import com.jxd.eas.dao.IStudentDao;
import com.jxd.eas.model.Student;
import com.jxd.eas.service.IStudentService;
import com.jxd.eas.util.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;
import java.util.Map;

/**
 * @ClassName StudentServiceImpl
 * @Description TODO
 * @Author 刘双喜
 * @Date 2026/8/26 9:42
 * @Version 1.0
 */
public class StudentServiceImpl implements IStudentService {
    private IStudentDao studentDao;
    @Override
    public int addStu(Student student) {
        SqlSession sqlSession = SqlSessionUtil.getSession();
        studentDao = sqlSession.getMapper(IStudentDao.class);

        return studentDao.addOne(student);
    }

    @Override
    public boolean removeBatch(int[] ids) {
        SqlSession sqlSession = SqlSessionUtil.getSession();
        studentDao = sqlSession.getMapper(IStudentDao.class);

        return studentDao.deleteBatch(ids);
    }

    @Override
    public boolean updateStu(Student student) {
        SqlSession sqlSession = SqlSessionUtil.getSession();
        studentDao = sqlSession.getMapper(IStudentDao.class);

        return studentDao.updateOne(student);
    }

    @Override
    public List<Map<String, Object>> getMaps(String stuName) {
        SqlSession sqlSession = SqlSessionUtil.getSession();
        studentDao = sqlSession.getMapper(IStudentDao.class);

        return studentDao.selectStudentWithCollege(stuName);
    }

    @Override
    public Student getOne(int id) {
        SqlSession sqlSession = SqlSessionUtil.getSession();
        studentDao = sqlSession.getMapper(IStudentDao.class);

        return studentDao.selectOne(id);
    }

    @Override
    public List<Map<String, Object>> getMapsByPage(String name, int page, int limit) {
        SqlSession sqlSession = SqlSessionUtil.getSession();
        studentDao = sqlSession.getMapper(IStudentDao.class);

        return studentDao.selectByPage(name,page,limit);
    }
}
