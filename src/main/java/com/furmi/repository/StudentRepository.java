package com.furmi.repository;

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


    public void updateInfo(Student student) {
        entityManager.getTransaction().begin();
        entityManager.persist(student);
        entityManager.getTransaction().commit();
    }

    public List<Student> getAllStudents() {
        entityManager.getTransaction().begin();
        TypedQuery<Student> query = entityManager.createQuery("FROM Student", Student.class);
        return query.getResultList();
    }

    public void deleteAllStudents() {
        entityManager.getTransaction().begin();
        Query query = entityManager.createQuery("DELETE FROM Student");
        query.executeUpdate();
        entityManager.getTransaction().commit();
    }
}
