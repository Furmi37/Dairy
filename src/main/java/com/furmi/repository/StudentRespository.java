package com.furmi.repository;

import com.furmi.model.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class StudentRespository {
    private final EntityManager entityManager;

    public StudentRespository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    public Student findById(Long id){
        return entityManager.find(Student.class, id);
    }

    public void save(Student student){
        entityManager.getTransaction().begin();
        entityManager.persist(student);
        entityManager.getTransaction().commit();

    }
    public List<Student> getAllStudents (){
        entityManager.getTransaction().begin();
        TypedQuery<Student> query = entityManager.createQuery("FROM Student", Student.class);
    return query.getResultList();
    }
    public void deleteAllStudents(){
        entityManager.getTransaction().begin();
        Query query = entityManager.createQuery("DELETE FROM Student");
        query.executeUpdate();
        entityManager.getTransaction().commit();
    }
}
