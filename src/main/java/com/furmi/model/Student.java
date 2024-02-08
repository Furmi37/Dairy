package com.furmi.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Student {
    @Id
    private int sid;
    private String firstName;
    private String lastName;
    private String birth_day;
    private String class_name;

    public Student(int sid, String firstName, String lastName, String birth_day, String class_name) {
        this.sid = sid;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birth_day = birth_day;
        this.class_name = class_name;
    }

    public Student() {

    }

    public int getSid() {
        return sid;
    }

    public void setSid(int studentId) {
        this.sid = studentId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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
                "studentId=" + sid +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birth_day='" + birth_day + '\'' +
                ", class_name='" + class_name + '\'' +
                '}';
    }
}
