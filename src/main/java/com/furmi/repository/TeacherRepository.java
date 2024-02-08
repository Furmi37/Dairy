package com.furmi.repository;

import com.furmi.model.Student;
import com.furmi.model.Teacher;
import jakarta.persistence.EntityManager;

public class TeacherRepository {
    private final EntityManager entityManager;

    public TeacherRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void updateTeacher (Teacher teacher){

    }
    public void addStudent(Student student){

    }
    public void deleteStudent (Student student){

    }



}
