package com.jxd.eas.service.impl;

import com.jxd.eas.dao.IUserLoginDao;
import com.jxd.eas.model.UserLogin;
import com.jxd.eas.service.IUserLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName UserLoginServiceImpl
 * @Description TODO
 * @Author 刘双喜
 * @Date 2026/9/2 8:54
 * @Version 1.0
 */
@Service
public class UserLoginServiceImpl implements IUserLoginService {
    @Autowired
    private IUserLoginDao userLoginDao;
    @Override
    public UserLogin login(String uname, String pwd, int role) {
        return userLoginDao.selectByNameAndPwd(uname, pwd, role);
    }

    @Override
    public boolean addAccount(int id,int role) {
        return userLoginDao.addOne(id,role);
    }

    @Override
    public boolean delAccount(int id) {
        return userLoginDao.delOne(id);
    }

    @Override
    public boolean resetPwd(String[] userNames) {
        return userLoginDao.resetPwd(userNames);
    }

    @Override
    public List<UserLogin> getAll(String userName) {
        return userLoginDao.selectAll(userName);
    }

    @Override
    public List<UserLogin> getAccountsByPage(String userName, int page, int limit) {
        return userLoginDao.selectByPage(userName, page, limit);
    }

    @Override
    public boolean changePwd(String userName, String newPwd, String oldPwd) {
        return userLoginDao.updatePwd(userName, newPwd, oldPwd);
    }
}
