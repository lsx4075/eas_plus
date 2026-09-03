package com.jxd.eas.service.impl;

import com.jxd.eas.dao.ISelectedCourseDao;
import com.jxd.eas.model.SelectedCourse;
import com.jxd.eas.service.ISelectedCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @ClassName SelectedCourseServiceImpl
 * @Description TODO
 * @Author 刘双喜
 * @Date 2026/8/26 23:36
 * @Version 1.0
 */
@Service
public class SelectedCourseServiceImpl implements ISelectedCourseService {
    @Autowired
    private ISelectedCourseDao selectedCourseDao;
    @Override
    public List<Map<String, Object>> getStudentsByCourseID(int courseID) {
        return selectedCourseDao.selectStudentsByCourseID(courseID);
    }

    @Override
    public boolean mark(SelectedCourse selectedCourse) {
        return selectedCourseDao.updateMark(selectedCourse);
    }

    @Override
    public boolean insertOne(int courseID, int studentID) {
        return selectedCourseDao.addOne(courseID, studentID);
    }

    @Override
    public boolean isExist(int courseID, int studentID) {
        SelectedCourse selectedCourse = selectedCourseDao.selectOne(courseID, studentID);
        boolean flag = false;
        if (selectedCourse != null) {
            flag = true;
        }
        return flag;
    }

    @Override
    public boolean dropCourse(int courseID, int studentID) {
        return selectedCourseDao.deleteOne(courseID, studentID);
    }

    @Override
    public boolean isSelected(int courseID) {
        SelectedCourse selectedCourse = selectedCourseDao.selectOneByCourseID(courseID);
        boolean flag = false;
        if (selectedCourse != null) {
            flag = true;
        }
        return flag;
    }

    @Override
    public boolean dropByStudentID(int studentID) {
        return selectedCourseDao.deleteByStudentID(studentID);
    }
}
