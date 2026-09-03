package com.jxd.eas.service;

import com.jxd.eas.model.UserLogin;

import java.util.List;

public interface IUserLoginService {
    UserLogin login(String uname,String pwd,int role);
    boolean addAccount(int id,int role);//添加登录信息
    boolean delAccount(int id);//删除登录信息
    boolean resetPwd(String[] userNames);//重置密码
    List<UserLogin> getAll(String userName);//获取所有登录信息
    List<UserLogin> getAccountsByPage(String userName,int page,int limit);//分页获取登录信息
    boolean changePwd(String userName,String newPwd,String oldPwd);//修改密码
}
