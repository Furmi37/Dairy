package com.furmi.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Teacher {
    @Id
    private int tid;
    private String firstName;
    private String lastName;
    private int salary;
    private String subject;
    private String academic_dgr;
    private String emplDate;

    public Teacher(int tid, String firstName, String lastName, int salary, String subject, String academic_dgr, String emplDate) {
        this.tid = tid;
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
        this.subject = subject;
        this.academic_dgr = academic_dgr;
        this.emplDate = emplDate;
    }

    public Teacher() {
    }
    public int getTid() {
        return tid;
    }

    public void setTid(int tid) {
        this.tid = tid;
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

    public String getAcademic_dgr() {
        return academic_dgr;
    }

    public void setAcademic_dgr(String academic_dgr) {
        this.academic_dgr = academic_dgr;
    }

    public String getEmplDate() {
        return emplDate;
    }

    public void setEmplDate(String emplDate) {
        this.emplDate = emplDate;
    }
}
