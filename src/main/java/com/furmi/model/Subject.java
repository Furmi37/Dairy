package com.furmi.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Subject {
    @Id
    private int subject_id;
    private String name;
    @OneToOne
    private Teacher teacher;



    public int getSubject_id() {
        return subject_id;
    }

    public void setSubject_id(int sid) {
        this.subject_id = sid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }
    @Override
    public String toString() {
        return "Subject{" +
                "sid=" + subject_id +
                ", name='" + name + '\'' +
                ", teacher=" + teacher.getTeacher_id() +
                '}';
    }

}
