package com.furmi;

import com.furmi.model.Grades;
import com.furmi.model.Student;
import com.furmi.model.Teacher;
import com.furmi.repository.StudentRepository;
import com.furmi.repository.TeacherRepository;
import com.furmi.service.StudentService;
import com.furmi.service.TeacherService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("persistenceUnit");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        StudentRepository studentRepository = new StudentRepository(entityManager);
        StudentService studentService = new StudentService(studentRepository);

        TeacherRepository teacherRepository = new TeacherRepository(entityManager);
        TeacherService teacherService = new TeacherService(teacherRepository);


//        Teacher t = new Teacher(105,"Martin", "Schmitt", 6000, 5, "mgr","2024-01-01" );
//        Student student1 = new Student(208,"Sus","Wright","2015-04-01","2b");
//        Student student2= new Student(209,"Calvin","Klein","2015-08-19","2b");
//        Subject subject = new Subject(5, "Computer Science", 105);

//        Grades grade = new Grades(6,"Chemistry",209,4,"2024-02-09");
//        teacherService.saveTeacher(t);
        entityManager.getTransaction().begin();

//        teacherService.deleteStudent(student2);
//        Student byId = studentRepository.findById(208);
//        studentRepository.updateInfo(student1);
//        System.out.println(byId);
//        List<Grades> allGradesForStudent = teacherRepository.getAllGradesForStudent(student1);
//      s
//        allGradesForStudent.forEach(System.out::println);

//        teacherRepository.addGrade(grade);
//
//        entityManager.getTransaction().begin();
//        grade.setSubject1(subject);
//        subject.setTeacher1(t);
//        entityManager.getTransaction().commit();
//        List<Grades> list = new ArrayList<>();
//        list.add(grade);

        entityManager.close();
        entityManagerFactory.close();
    }
}
