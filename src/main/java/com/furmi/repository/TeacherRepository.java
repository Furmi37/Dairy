package com.furmi.repository;

import com.furmi.model.Student;
import com.furmi.model.Teacher;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class TeacherRepository {
    private final EntityManager entityManager;

    public TeacherRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void saveTeacher(Teacher teacher) {
        entityManager.getTransaction().begin();
        entityManager.persist(teacher);

        entityManager.getTransaction().commit();
    }

    public void saveStudent(Student student) {
        entityManager.getTransaction().begin();
        entityManager.persist(student);
        entityManager.getTransaction().commit();
    }

    public void deleteStudent(Student student) {
        entityManager.getTransaction().begin();
        entityManager.remove(student);
        entityManager.getTransaction().commit();
    }

    public List<Teacher> getAllTeachers() {
        entityManager.getTransaction().begin();
        TypedQuery<Teacher> query = entityManager.createQuery("FROM Teacher", Teacher.class);
        return query.getResultList();
    }

    public List getNumberOfStudentsInClass(String className) {
        entityManager.getTransaction().begin();
        return entityManager.createQuery(
                        "SELECT COUNT(id)  FROM Student WHERE className = :className")
                .setParameter("className", className).getResultList();
    }

}
