package com.furmi.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Teacher {
    @Id
    private int teacher_id;
    private String first_name;
    private String last_name;
    private int salary;
    private String academic_dgr;
    private String empl_date;
    @OneToOne
    private Subject subject;

    public Teacher(int teacher_id, String first_name, String last_name, int salary, String academic_dgr, String empl_date, Subject subject) {
        this.teacher_id = teacher_id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.salary = salary;
        this.academic_dgr = academic_dgr;
        this.empl_date = empl_date;
        this.subject = subject;
    }

    public Teacher() {
    }
    public int getTeacher_id() {
        return teacher_id;
    }

    public void setTeacher_id(int tid) {
        this.teacher_id = tid;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String firstName) {
        this.first_name = firstName;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String lastName) {
        this.last_name = lastName;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public String getAcademic_dgr() {
        return academic_dgr;
    }

    public void setAcademic_dgr(String academic_dgr) {
        this.academic_dgr = academic_dgr;
    }

    public String getEmpl_date() {
        return empl_date;
    }

    public void setEmpl_date(String emplDate) {
        this.empl_date = emplDate;
    }
}
