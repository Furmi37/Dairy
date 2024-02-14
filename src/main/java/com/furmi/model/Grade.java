package com.furmi.model;

import jakarta.persistence.*;

@Entity
public class Grade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String subject;
    private int grade;
    private String addDate;
    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    public Grade() {
    }

    public Grade(int id, String subject, int grade, String addDate) {
        this.id = id;
        this.subject = subject;
        this.grade = grade;
        this.addDate = addDate;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public String getAddDate() {
        return addDate;
    }

    public void setAddDate(String add_date) {
        this.addDate = add_date;
    }


    @Override
    public String toString() {
        return "Grade{" +
                "subject='" + subject + '\'' +
                ", grade=" + grade +
                ", add_date='" + addDate + '\'' +
                '}';
    }
}
