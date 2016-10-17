package com.example.administrator.studentsystem;

/**
 * Created by Administrator on 2016/8/17.
 */
public class StudentInfo {

    String name;
    String password;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public StudentInfo(String name, String password) {
        this.name = name;
        this.password = password;
    }
}
