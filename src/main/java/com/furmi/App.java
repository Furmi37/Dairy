package com.furmi;

import com.furmi.model.Student;
import com.furmi.model.Teacher;
import com.furmi.repository.GradesRepository;
import com.furmi.repository.StudentRepository;
import com.furmi.repository.TeacherRepository;
import com.furmi.service.StudentService;
import com.furmi.service.TeacherService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class App {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("persistenceUnit");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        StudentRepository studentRepository = new StudentRepository(entityManager);
        StudentInterface studentInterface = new StudentInterface();
        StudentService studentService = new StudentService(studentRepository);
        GradesRepository gradesRepository = new GradesRepository(entityManager);

        TeacherRepository teacherRepository = new TeacherRepository(entityManager);
        TeacherService teacherService = new TeacherService(teacherRepository,
                studentRepository, gradesRepository);

        //starting an app
//        studentInterface.loop(teacherService, studentService);
        teacherService.showAllGradesForStudent("matt@gmail.com");

        entityManager.close();
        entityManagerFactory.close();
    }
}
