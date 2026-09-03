package com.jxd.eas.model;

/**
 * @ClassName course
 * @Description TODO
 * @Author 刘双喜
 * @Date 2026/8/24 10:29
 * @Version 1.0
 */
public class Course {
    private int id;
    private String courseName;
    private int teacherID;
    private String courseTime;
    private String classroom;
    private int classWeek;
    private String courseType;
    private int collegeID;
    private double score;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getTeacherID() {
        return teacherID;
    }

    public void setTeacherID(int teacherID) {
        this.teacherID = teacherID;
    }

    public String getCourseTime() {
        return courseTime;
    }

    public void setCourseTime(String courseTime) {
        this.courseTime = courseTime;
    }

    public String getClassroom() {
        return classroom;
    }

    public void setClassroom(String classroom) {
        this.classroom = classroom;
    }

    public int getClassWeek() {
        return classWeek;
    }

    public void setClassWeek(int classWeek) {
        this.classWeek = classWeek;
    }

    public String getCourseType() {
        return courseType;
    }

    public void setCourseType(String courseType) {
        this.courseType = courseType;
    }

    public int getCollegeID() {
        return collegeID;
    }

    public void setCollegeID(int collegeID) {
        this.collegeID = collegeID;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public Course() {
    }

    public Course(int id, String courseName, int teacherID, String courseTime, String classroom, int classWeek, String courseType, int collegeID, double score) {
        this.id = id;
        this.courseName = courseName;
        this.teacherID = teacherID;
        this.courseTime = courseTime;
        this.classroom = classroom;
        this.classWeek = classWeek;
        this.courseType = courseType;
        this.collegeID = collegeID;
        this.score = score;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", courseName='" + courseName + '\'' +
                ", teacherID=" + teacherID +
                ", courseTime='" + courseTime + '\'' +
                ", classroom='" + classroom + '\'' +
                ", classWeek=" + classWeek +
                ", courseType='" + courseType + '\'' +
                ", collegeID=" + collegeID +
                ", score=" + score +
                '}';
    }
}
