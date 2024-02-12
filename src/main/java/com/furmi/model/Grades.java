package com.furmi.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class Grades {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String subject;
    private int grade;
    private String add_date;
    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;


    public Grades() {
    }

    public Grades(int id, String subject, int grade, String add_date) {
        this.id = id;
        this.subject = subject;
        this.grade = grade;
        this.add_date = add_date;
    }

    public int getGrade_id() {
        return id;
    }

    public void setGrade_id(int grade_id) {
        this.id = grade_id;
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

    public String getAdd_date() {
        return add_date;
    }

    public void setAdd_date(String add_date) {
        this.add_date = add_date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Grades grades = (Grades) o;
        return id == grades.id && grade == grades.grade && Objects.equals(subject, grades.subject) && Objects.equals(add_date, grades.add_date) && Objects.equals(student, grades.student);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, subject, grade, add_date, student);
    }

    @Override
    public String toString() {
        return "Grades{" +
                "subject='" + subject + '\'' +
                ", grade=" + grade +
                ", add_date='" + add_date + '\'' +
                '}';
    }
}
