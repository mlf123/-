package com.example.demo.entity;

public class People {
    private int usercode;
    private String username;
    private String department;

    public People() {
        
    }

    public int getUsercode() {
        return usercode;
    }

    public void setUsercode(int usercode) {
        this.usercode = usercode;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public People(int usercode, String username, String department) {
        this.usercode = usercode;
        this.username = username;
        this.department = department;
    }
}
