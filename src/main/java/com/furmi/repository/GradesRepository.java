package com.furmi.repository;

import com.furmi.model.Grade;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class GradesRepository {
    private final EntityManager entityManager;

    public GradesRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public Grade findById(Long id) {
        return entityManager.find(Grade.class, id);
    }

    public void save(Grade grade) {
        entityManager.getTransaction().begin();
        entityManager.persist(grade);
        entityManager.getTransaction().commit();
    }

    public List<Grade> getAll() {
        TypedQuery<Grade> query = entityManager.createQuery("FROM Grade", Grade.class);
        return query.getResultList();
    }

    public void deleteAll() {
        entityManager.getTransaction().begin();
        Query query = entityManager.createQuery("DELETE FROM Grade");
        query.executeUpdate();
        entityManager.getTransaction().commit();
    }
}
