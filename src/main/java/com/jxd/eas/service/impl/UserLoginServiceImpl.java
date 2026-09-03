package com.jxd.eas.service.impl;

import com.jxd.eas.dao.IUserLoginDao;
import com.jxd.eas.model.UserLogin;
import com.jxd.eas.service.IUserLoginService;
import com.jxd.eas.util.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * @ClassName UserLoginServiceImpl
 * @Description TODO
 * @Author 刘双喜
 * @Date 2026/9/2 8:54
 * @Version 1.0
 */
public class UserLoginServiceImpl implements IUserLoginService {
    private IUserLoginDao userLoginDao;
    @Override
    public UserLogin login(String uname, String pwd, int role) {
        SqlSession sqlSession = SqlSessionUtil.getSession();
        userLoginDao = sqlSession.getMapper(IUserLoginDao.class);

        return userLoginDao.selectByNameAndPwd(uname, pwd, role);
    }

    @Override
    public boolean addAccount(int id,int role) {
        SqlSession sqlSession = SqlSessionUtil.getSession();
        userLoginDao = sqlSession.getMapper(IUserLoginDao.class);

        return userLoginDao.addOne(id,role);
    }

    @Override
    public boolean delAccount(int id) {
        SqlSession sqlSession = SqlSessionUtil.getSession();
        userLoginDao = sqlSession.getMapper(IUserLoginDao.class);

        return userLoginDao.delOne(id);
    }

    @Override
    public boolean resetPwd(String[] userNames) {
        SqlSession sqlSession = SqlSessionUtil.getSession();
        userLoginDao = sqlSession.getMapper(IUserLoginDao.class);

        return userLoginDao.resetPwd(userNames);
    }

    @Override
    public List<UserLogin> getAll(String userName) {
        SqlSession sqlSession = SqlSessionUtil.getSession();
        userLoginDao = sqlSession.getMapper(IUserLoginDao.class);

        return userLoginDao.selectAll(userName);
    }

    @Override
    public List<UserLogin> getAccountsByPage(String userName, int page, int limit) {
        SqlSession sqlSession = SqlSessionUtil.getSession();
        userLoginDao = sqlSession.getMapper(IUserLoginDao.class);

        return userLoginDao.selectByPage(userName, page, limit);
    }

    @Override
    public boolean changePwd(String userName, String newPwd, String oldPwd) {
        SqlSession sqlSession = SqlSessionUtil.getSession();
        userLoginDao = sqlSession.getMapper(IUserLoginDao.class);

        return userLoginDao.updatePwd(userName, newPwd, oldPwd);
    }
}
