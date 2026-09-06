package com.jxd.eas.controller;

import com.jxd.eas.model.UserLogin;
import com.jxd.eas.service.IUserLoginService;
import com.jxd.eas.service.impl.UserLoginServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @ClassName UserLoginController
 * @Description TODO
 * @Author 刘双喜
 * @Date 2026/9/6 16:39
 * @Version 1.0
 */
@Controller
public class UserLoginController {
    @Autowired
    private IUserLoginService userLoginService;

    @GetMapping("/getUsers")
    public String getUsers(String userName,
                           @RequestParam(value = "page", defaultValue = "1") int page,
                           @RequestParam(value = "limit", defaultValue = "5") int limit,
                           Model m) {
        List<UserLogin> list = userLoginService.getAll(userName);

        List<UserLogin> listPage = userLoginService.getAccountsByPage(userName,page,limit);

        //计算页码数
        int total = list.size();
        int pages = total % limit == 0 ? total / limit : total / limit + 1;

        m.addAttribute("userList",listPage);
        m.addAttribute("pages",pages);
        m.addAttribute("limit",limit);
        if (userName != null) {
            m.addAttribute("userName",userName);
        }
        return "UserAccountList";
    }
    @GetMapping("/resetPwd")
    public String resetPwd(String[] userName) {
        userLoginService.resetPwd(userName);

        return "redirect:/getUsers";
    }

    @GetMapping("toChangePwd")
    public String toChangePwd() {
        return "ChangePwd";
    }
    @PostMapping("/chgPwd")
    public String chgPwd(String userName, String newPwd, String oldPwd, Model m) {
        boolean flag = userLoginService.changePwd(userName, newPwd, oldPwd);
        if (flag) {
            if ("admin".equals(userName)) {
                return "redirect:/getCourses";
            } else if (userName.length() == 4) {
                return "redirect:/getCoursesOfTeacher";
            } else {
                return "redirect:/getCoursesForStu";
            }
        } else {
            m.addAttribute("msg","原密码错误");
            return "ChangePwd";
        }
    }
}
