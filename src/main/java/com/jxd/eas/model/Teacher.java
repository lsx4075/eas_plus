package com.jxd.eas.model;

/**
 * @ClassName teacher
 * @Description TODO
 * @Author 刘双喜
 * @Date 2026/8/24 10:30
 * @Version 1.0
 */
public class Teacher {
    private int id;
    private String name;
    private String sex;
    private String birthday;
    private String degree;
    private String title;
    private String grade;
    private int collegeID;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public int getCollegeID() {
        return collegeID;
    }

    public void setCollegeID(int collegeID) {
        this.collegeID = collegeID;
    }

    public Teacher() {
    }

    public Teacher(int id, String name, String sex, String birthday, String degree, String title, String grade, int collegeID) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.birthday = birthday;
        this.degree = degree;
        this.title = title;
        this.grade = grade;
        this.collegeID = collegeID;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", birthday='" + birthday + '\'' +
                ", degree='" + degree + '\'' +
                ", title='" + title + '\'' +
                ", grade='" + grade + '\'' +
                ", collegeID=" + collegeID +
                '}';
    }
}
