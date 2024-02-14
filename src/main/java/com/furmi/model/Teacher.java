package com.furmi.model;

import jakarta.persistence.*;

@Entity
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String firstName;
    private String lastName;
    private int salary;
    private String subject;
    private String academicDgr;
    private String emplDate;
//    @OneToOne
//    private Subject sub;


    public Teacher() {
    }

    public Teacher(String firstName, String lastName, int salary, String subject, String academicDgr, String emplDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
        this.subject = subject;
        this.academicDgr = academicDgr;
        this.emplDate = emplDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getAcademicDgr() {
        return academicDgr;
    }

    public void setAcademicDgr(String academicDgr) {
        this.academicDgr = academicDgr;
    }

    public String getEmplDate() {
        return emplDate;
    }

    public void setEmplDate(String emplDate) {
        this.emplDate = emplDate;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", salary=" + salary +
                ", subject='" + subject + '\'' +
                ", academicDgr='" + academicDgr + '\'' +
                ", emplDate='" + emplDate + '\'' +
                '}';
    }
}
