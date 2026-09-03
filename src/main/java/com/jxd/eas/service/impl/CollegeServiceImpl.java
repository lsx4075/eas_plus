package com.jxd.eas.service.impl;

import com.jxd.eas.dao.ICollegeDao;
import com.jxd.eas.model.College;
import com.jxd.eas.service.ICollegeService;
import com.jxd.eas.util.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * @ClassName CollegeServiceImpl
 * @Description TODO
 * @Author 刘双喜
 * @Date 2026/8/25 14:29
 * @Version 1.0
 */
public class CollegeServiceImpl implements ICollegeService {
    private ICollegeDao collegeDao;
    @Override
    public List<College> getColleges() {
        SqlSession sqlSession = SqlSessionUtil.getSession();
        collegeDao = sqlSession.getMapper(ICollegeDao.class);

        return collegeDao.selectColleges();
    }
}
