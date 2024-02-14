package com.furmi.repository;

import com.furmi.model.Grade;
import com.furmi.model.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class StudentRepository {
    private final EntityManager entityManager;

    public StudentRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public Student findById(int id) {
        return entityManager.find(Student.class, id);
    }

    public Student findByEmail(String email) {
        return entityManager.createQuery(
                        "SELECT s from Student s WHERE s.email = :email", Student.class)
                .setParameter("email", email).getSingleResult();
    }

    public void saveStudentInfo(Student student) {
        entityManager.getTransaction().begin();
        entityManager.persist(student);
        entityManager.getTransaction().commit();

    }

    public List<Student> getAllStudentsInClass(String className) {
        TypedQuery<Student> query = entityManager.createQuery("FROM Student s  WHERE s.className = :className ", Student.class)
                .setParameter("className", className);
        return query.getResultList();
    }

    public List<Grade> getSubjectGrades(String email, String subject) {
        Student student = findByEmail(email);

        TypedQuery<Grade> query = entityManager.createQuery("FROM Grade s JOIN Student  ON  s.subject = :subject", Grade.class)
                .setParameter("subject", subject);
        return query.getResultList();
    }

    public void deleteAllStudents() {
        entityManager.getTransaction().begin();
        Query query = entityManager.createQuery("DELETE FROM Student");
        query.executeUpdate();
        entityManager.getTransaction().commit();
    }
}
