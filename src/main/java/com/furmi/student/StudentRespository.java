package com.furmi.student;

import jakarta.persistence.EntityManager;

public class StudentRespository {
    private final EntityManager entityManager;

    public StudentRespository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
}
