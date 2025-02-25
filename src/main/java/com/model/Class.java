package com.model;

import java.util.Date;

public class Class {
    private int id;
    private int studentId;
    private Date classTime;

    public Class() {}

    public Class(int id, int studentId, Date classTime) {
        this.id = id;
        this.studentId = studentId;
        this.classTime = classTime;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getStudentId() { return studentId; }
    public void setStudentId(int studentId) { this.studentId = studentId; }

    public Date getClassTime() { return classTime; }
    public void setClassTime(Date classTime) { this.classTime = classTime; }
}

