package com.jxd.eas.model;

/**
 * @ClassName selectedcourse
 * @Description TODO
 * @Author 刘双喜
 * @Date 2026/8/24 10:30
 * @Version 1.0
 */
public class SelectedCourse {
    private int courseID;
    private int studentID;
    private double mark;

    public int getCourseID() {
        return courseID;
    }

    public void setCourseID(int courseID) {
        this.courseID = courseID;
    }

    public int getStudentID() {
        return studentID;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    public double getMark() {
        return mark;
    }

    public void setMark(double mark) {
        this.mark = mark;
    }

    public SelectedCourse() {
    }

    public SelectedCourse(int courseID, int studentID, double mark) {
        this.courseID = courseID;
        this.studentID = studentID;
        this.mark = mark;
    }

    @Override
    public String toString() {
        return "SelectedCourse{" +
                "courseID=" + courseID +
                ", studentID=" + studentID +
                ", mark=" + mark +
                '}';
    }
}
