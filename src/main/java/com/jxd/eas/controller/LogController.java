package com.jxd.eas.controller;

import com.jxd.eas.model.UserLogin;
import com.jxd.eas.service.IUserLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @ClassName LogController
 * @Description TODO
 * @Author 刘双喜
 * @Date 2026/9/4 15:57
 * @Version 1.0
 */
@Controller
@SessionAttributes({"uname"})
public class LogController {
    @Autowired
    private IUserLoginService userLoginService;

    @GetMapping({"/", "/toLogin"})
    public String toLogin() {
        return "Login";
    }

    @PostMapping("/login")
    public String login(String uname, String pwd, @RequestParam("user") int role, String remember, Model m, HttpServletResponse resp) {
        UserLogin userLogin = userLoginService.login(uname, pwd, role);

        if (userLogin != null) {
            // 记住密码
            if ("1".equals(remember)) {
                Cookie cUname = new Cookie("rememberUname", uname);
                Cookie cPwd = new Cookie("rememberPwd", pwd);
                Cookie cRole = new Cookie("rememberRole", String.valueOf(role));

                // 设置cookie存储时间，单位为s
                cUname.setMaxAge(3600 * 24 * 7);
                cPwd.setMaxAge(3600 * 24 * 7);
                cRole.setMaxAge(3600 * 24 * 7);
                // 将cookie加入响应
                resp.addCookie(cUname);
                resp.addCookie(cPwd);
                resp.addCookie(cRole);

            } else {
                // 未勾选则清除已有Cookie
                Cookie cUname = new Cookie("rememberUname", "");
                Cookie cPwd = new Cookie("rememberPwd", "");
                Cookie cRole = new Cookie("rememberRole", "");
                cUname.setMaxAge(0);
                cPwd.setMaxAge(0);
                cRole.setMaxAge(0);
                resp.addCookie(cUname);
                resp.addCookie(cPwd);
                resp.addCookie(cRole);
            }

            // 将数据存储到session对象中
            m.addAttribute("uname",uname);

            //根据角色重定向到不同页面
            switch (role) {
                case 0:
                    return "Student";
                case 1:
                    return "Teacher";
                case 2:
                    return "Admin";
            }
        }

        m.addAttribute("msg", "用户名或密码错误");
        return "Login";
    }

    @GetMapping("/logOut")
    public String logOut(HttpSession session) {
        //session 销毁
        //session对象被回收
        session.invalidate();
        return "Login";
    }
}
