package com.jxd.eas.service.impl;

import com.jxd.eas.dao.IStudentDao;
import com.jxd.eas.model.Student;
import com.jxd.eas.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @ClassName StudentServiceImpl
 * @Description TODO
 * @Author 刘双喜
 * @Date 2026/8/26 9:42
 * @Version 1.0
 */
@Service
public class StudentServiceImpl implements IStudentService {
    @Autowired
    private IStudentDao studentDao;
    @Override
    public int addStu(Student student) {
        return studentDao.addOne(student);
    }

    @Override
    public boolean removeBatch(int[] ids) {
        return studentDao.deleteBatch(ids);
    }

    @Override
    public boolean updateStu(Student student) {
        return studentDao.updateOne(student);
    }

    @Override
    public List<Map<String, Object>> getMaps(String stuName) {
        return studentDao.selectStudentWithCollege(stuName);
    }

    @Override
    public Student getOne(int id) {
        return studentDao.selectOne(id);
    }

    @Override
    public List<Map<String, Object>> getMapsByPage(String name, int page, int limit) {
        return studentDao.selectByPage(name,page,limit);
    }
}
