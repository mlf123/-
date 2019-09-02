package yndf.com.demo.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;


public class Users {
    private Integer usercode; //工号
    private String username;//姓名
    private String department;//部门
    private Date hiredate;//入职时间

    public Integer getUsercode() {
        return usercode;
    }

    public void setUsercode(Integer usercode) {
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

    public Date getHiredate() {
        return hiredate;
    }
    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
    public void setHiredate(Date hiredate) {
        this.hiredate = hiredate;
    }

    public Users(Integer usercode, String username, String department, Date hiredate) {
        this.usercode = usercode;
        this.username = username;
        this.department = department;
        this.hiredate = hiredate;
    }

    public Users() {
    }

    @Override
    public String toString() {
        return "Users{" +
                "usercode=" + usercode +
                ", username='" + username + '\'' +
                ", department='" + department + '\'' +
                ", hiredate=" + hiredate +
                '}';
    }
}
