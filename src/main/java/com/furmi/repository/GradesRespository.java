package com.furmi.repository;

import com.furmi.model.Grades;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class GradesRespository {
    private final EntityManager entityManager;

    public GradesRespository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public Grades findById(Long id) {
        return entityManager.find(Grades.class, id);
    }

    public void save(Grades grades) {
        entityManager.getTransaction().begin();
        entityManager.persist(grades);
        entityManager.getTransaction().commit();
    }

    public List<Grades> getAll() {
        TypedQuery<Grades> query = entityManager.createQuery("FROM Grades", Grades.class);
        return query.getResultList();
    }

    public void deleteAll() {
        entityManager.getTransaction().begin();
        Query query = entityManager.createQuery("DELETE FROM Grades");
        query.executeUpdate();
        entityManager.getTransaction().commit();
    }
}
