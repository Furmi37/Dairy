package com.furmi;

import com.furmi.model.Student;
import com.furmi.repository.gradesRespository;
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
        StudentService studentService = new StudentService(studentRepository);
        gradesRespository gradesRespository = new gradesRespository(entityManager);

        TeacherRepository teacherRepository = new TeacherRepository(entityManager);
        TeacherService teacherService = new TeacherService(teacherRepository,
                studentRepository, gradesRespository);


//        Teacher t = new Teacher(105,"Martin", "Schmitt", 6000, 5, "mgr","2024-01-01" );
        Student s1 = new Student();
        s1.setFirst_name("Mark");
        s1.setLast_name("Godawski");
        s1.setEmail("mark@gmail.com");
        s1.setBirth_day("2015-04-09");
        s1.setClass_name("2B");
        s1.setStudent_id(4);
        Student s2 = new Student(3, "Calvin", "Klein", "calvin@gmail.com", "2015-08-19", "2b");
//        Subject subject = new Subject(5, "Computer Science", 105);
////
        teacherService.addGrade("calvin@gmail.com", 4, "2024-02-14", "English");
        System.out.println("add grade -> calvin@gmail.com");
//            studentService.showAllStudents();
//        teacherService.createStudent(s2);
//        System.out.println("Sus grades:");
//        teacherService.showAllGradesForStudent("sus@gmail.com");

//        System.out.println("Matt grades:");
//        teacherService.showAllGradesForStudent("matt@gmail.com");

//        studentService.showAllStudents();

//        studentService.showAllStudents();


        entityManager.close();
        entityManagerFactory.close();
    }
}
