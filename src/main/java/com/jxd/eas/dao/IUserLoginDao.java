package com.jxd.eas.dao;

import com.jxd.eas.model.UserLogin;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IUserLoginDao {
    UserLogin selectByNameAndPwd(@Param("uname") String uname, @Param("pwd") String pwd, @Param("role") int role);
    boolean addOne(@Param("id") int id, @Param("role") int role);//设置教师或者学生的id作为账户名，id等于key值
    boolean delOne(int id);
    boolean resetPwd(String[] userNames);
    List<UserLogin> selectAll(String userName);
    List<UserLogin> selectByPage(@Param("userName") String userName,@Param("page") int page,@Param("limit") int limit);
    boolean updatePwd(@Param("userName") String userName,@Param("newPwd") String newPwd,@Param("oldPwd") String oldPwd);
}
