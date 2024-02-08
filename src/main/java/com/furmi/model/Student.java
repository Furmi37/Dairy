package com.furmi.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Student {
    @Id
    private int student_id;
    private String first_name;
    private String last_name;
    private String birth_day;
    private String class_name;

    public Student(int student_id, String first_name, String last_name, String birth_day, String class_name) {
        this.student_id = student_id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.birth_day = birth_day;
        this.class_name = class_name;
    }

    public Student() {

    }

    public int getStudent_id() {
        return student_id;
    }

    public void setStudent_id(int sid) {
        this.student_id = sid;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getBirth_day() {
        return birth_day;
    }

    public void setBirth_day(String birth_day) {
        this.birth_day = birth_day;
    }

    public String getClass_name() {
        return class_name;
    }

    public void setClass_name(String class_name) {
        this.class_name = class_name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "sid=" + student_id +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", birth_day='" + birth_day + '\'' +
                ", class_name='" + class_name + '\'' +
                '}';
    }
}
