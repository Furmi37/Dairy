package com.furmi.model;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class Student {
    @Id

    private int id;
    private String first_name;
    private String last_name;
    private String email;
    private String birth_day;
    private String class_name;
    @OneToMany(mappedBy = "student", cascade = CascadeType.MERGE, orphanRemoval = true)
    private Set<Grades> grades = new HashSet<>();

    public Student() {
    }

    public Student(int id, String first_name, String last_name, String email, String birth_day, String class_name) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.birth_day = birth_day;
        this.class_name = class_name;
    }

    public int getStudent_id() {
        return id;
    }

    public void setStudent_id(int sid) {
        this.id = sid;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<Grades> getGrades() {
        return grades;
    }

    public void setGrades(Set<Grades> addresses) {
        this.grades = addresses;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", email='" + email + '\'' +
                ", birth_day='" + birth_day + '\'' +
                ", class_name='" + class_name + '\'' +
                '}';
    }
}
