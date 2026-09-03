package com.jxd.eas.model;

/**
 * @ClassName userLogin
 * @Description TODO
 * @Author 刘双喜
 * @Date 2026/8/24 10:30
 * @Version 1.0
 */
public class UserLogin {
    private String userName;
    private String password;
    private int role;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public UserLogin() {
    }

    public UserLogin(String userName, String password, int role) {
        this.userName = userName;
        this.password = password;
        this.role = role;
    }

    @Override
    public String toString() {
        return "UserLogin{" +
                "userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                '}';
    }
}
