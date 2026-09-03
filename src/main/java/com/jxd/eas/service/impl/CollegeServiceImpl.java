package com.jxd.eas.service.impl;

import com.jxd.eas.dao.ICollegeDao;
import com.jxd.eas.model.College;
import com.jxd.eas.service.ICollegeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName CollegeServiceImpl
 * @Description TODO
 * @Author 刘双喜
 * @Date 2026/8/25 14:29
 * @Version 1.0
 */
@Service
public class CollegeServiceImpl implements ICollegeService {
    @Autowired
    private ICollegeDao collegeDao;
    @Override
    public List<College> getColleges() {
        return collegeDao.selectColleges();
    }
}
