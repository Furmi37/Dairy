package com.furmi;

import com.furmi.model.Grades;
import com.furmi.model.Student;
import com.furmi.model.Subject;
import com.furmi.model.Teacher;
import com.furmi.repository.StudentRespository;
import com.furmi.service.StudentService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class App {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("persistenceUnit");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        StudentRespository studentRespository = new StudentRespository(entityManager);
        StudentService service = new StudentService(studentRespository);


        Student student1 = new Student(208,"Susan","Wright","2015-04-01","2A");

        service.createStudent(student1);








    }
}
