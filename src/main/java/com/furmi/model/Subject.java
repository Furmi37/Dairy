package com.furmi.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Subject {
    @Id
    private int subject_id;
    private String name;

    private int teacher;

//    @OneToMany(mappedBy = "subject")
//    List<Grades> grades;




    public Subject() {
    }


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

    public int getTeacher() {
        return teacher;
    }

    public void setTeacher(int teacher) {
        this.teacher = teacher;
    }
}
