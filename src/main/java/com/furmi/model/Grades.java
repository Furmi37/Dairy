package com.furmi.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Grades {
    @Id
    private int grade_id;
    @OneToOne
    private Subject subject;
    @OneToOne
    private Student student;
    private int grade;
    private String add_date;



    public Grades() {

    }

    public int getGrade_id() {
        return grade_id;
    }

    public void setGrade_id(int grade_id) {
        this.grade_id = grade_id;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public String getAdd_date() {
        return add_date;
    }

    public void setAdd_date(String add_date) {
        this.add_date = add_date;
    }

    @Override
    public String toString() {
        return "Grades{" +
                "grade_id=" + grade_id +
                ", subject=" + subject +
                ", student=" + student +
                ", grade=" + grade +
                ", add_date='" + add_date + '\'' +
                '}';
    }
}
