package com.oneclasswork.pojo;

public class Staff {
    private Integer staffid;
    private String staffname;
    private Integer staffage;
    private String staffposition;

    @Override
    public String toString() {
        return "Staff{" +
                "staffdid=" + staffid +
                ", staffname='" + staffname + '\'' +
                ", staffage=" + staffage +
                ", staffposition='" + staffposition + '\'' +
                '}';
    }

    public Integer getStaffdid() {
        return staffid;
    }

    public void setStaffdid(Integer staffdid) {
        this.staffid = staffdid;
    }

    public String getStaffname() {
        return staffname;
    }

    public void setStaffname(String staffname) {
        this.staffname = staffname;
    }

    public Integer getStaffage() {
        return staffage;
    }

    public void setStaffage(Integer staffage) {
        this.staffage = staffage;
    }

    public String getStaffposition() {
        return staffposition;
    }

    public void setStaffposition(String staffposition) {
        this.staffposition = staffposition;
    }
}
