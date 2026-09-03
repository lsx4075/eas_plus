package com.jxd.eas.model;

/**
 * @ClassName student
 * @Description TODO
 * @Author 刘双喜
 * @Date 2026/8/24 10:30
 * @Version 1.0
 */
public class Student {
    private int id;
    private String name;
    private String sex;
    private String birthday;
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

    public Student() {
    }

    public Student(int id, String name, String sex, String birthday, String grade, int collegeID) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.birthday = birthday;
        this.grade = grade;
        this.collegeID = collegeID;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", birthday='" + birthday + '\'' +
                ", grade='" + grade + '\'' +
                ", collegeID=" + collegeID +
                '}';
    }
}
