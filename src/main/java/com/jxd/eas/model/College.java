package com.jxd.eas.model;

/**
 * @ClassName college
 * @Description TODO
 * @Author 刘双喜
 * @Date 2026/8/24 10:29
 * @Version 1.0
 */
public class College {
    private int collegeID;
    private String collegeName;

    public int getCollegeID() {
        return collegeID;
    }

    public void setCollegeID(int collegeID) {
        this.collegeID = collegeID;
    }

    public String getCollegeName() {
        return collegeName;
    }

    public void setCollegeName(String collegeName) {
        this.collegeName = collegeName;
    }

    public College() {
    }

    public College(int collegeID, String collegeName) {
        this.collegeID = collegeID;
        this.collegeName = collegeName;
    }

    @Override
    public String toString() {
        return "College{" +
                "collegeID=" + collegeID +
                ", collegeName='" + collegeName + '\'' +
                '}';
    }
}
