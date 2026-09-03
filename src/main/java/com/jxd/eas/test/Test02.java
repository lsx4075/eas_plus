package com.jxd.eas.test;

import com.jxd.eas.model.College;
import com.jxd.eas.model.UserLogin;
import com.jxd.eas.service.ICollegeService;
import com.jxd.eas.service.IUserLoginService;
import com.jxd.eas.service.impl.CollegeServiceImpl;
import com.jxd.eas.service.impl.UserLoginServiceImpl;

import java.util.List;

/**
 * @ClassName Test02
 * @Description TODO
 * @Author 刘双喜
 * @Date 2026/9/2 8:57
 * @Version 1.0
 */
public class Test02 {
    public static void main(String[] args) {
        IUserLoginService userLoginService = new UserLoginServiceImpl();

        /*UserLogin userLogin = userLoginService.login("admin", "123", 2);
        System.out.println(userLogin);*/

//        userLoginService.addAccount(1020);

//        userLoginService.delAccount(1020);

       /* List<UserLogin> list = userLoginService.getAll(null);
        list.stream().forEach(System.out::println);*/

        List<UserLogin> list1 = userLoginService.getAccountsByPage(null, 1, 15);
        list1.stream().forEach(System.out::println);

        /*userLoginService.changePwd("10001", "1234", "123");
        String[] userNames = {"10001", "1001","admin"};
        userLoginService.resetPwd(userNames);*/

        /*ICollegeService collegeService = new CollegeServiceImpl();
        List<College> collegeList = collegeService.getColleges();
        collegeList.stream().forEach(System.out::println);*/

    }
}
