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
        StudentService studentService = new StudentService(studentRepository);
        GradesRepository gradesRepository = new GradesRepository(entityManager);

        TeacherRepository teacherRepository = new TeacherRepository(entityManager);
        TeacherService teacherService = new TeacherService(teacherRepository,
                studentRepository, gradesRepository);


        Teacher t = new Teacher("Martin", "Schmitt", 6000, "Computer Science", "mgr", "2024-01-01");
        Student s1 = new Student();
        s1.setFirstName("Mark");
        s1.setLastName("Godawski");
        s1.setEmail("mark@gmail.com");
        s1.setBirthDay("2015-04-09");
        s1.setClassName("2B");
//        s1.setId(4);
        Student s2 = new Student("Calvin", "Klein", "calvin@gmail.com", "2015-08-19", "2B");
//        Subject subject = new Subject(5, "Computer Science", 105);
////
//        teacherService.createStudent(new Student("Monthy", "Python", "monthy@gmail.com", "2015-01-02", "2B"));
//        studentService.showSubjectGrades("matt@gmail.com", "Polish");
        studentService.showAllStudentsInClass("2B");
        //working
//        teacherService.addGrade("calvin@gmail.com", 5, "2024-02-14", "Polish");
//        teacherService.showAllGradesForStudent("matt@gmail.com");
//        studentService.showAllStudents();
//        System.out.println("Matt grades:");
//        teacherService.showAllGradesForStudent("matt@gmail.com");
//        teacherService.createStudent(s2);
//        studentService.updateStudentFirstName("matt@gmail.com", "Matthew");
//        teacherService.changeGrade(38, 4,"2024-02-13");
//        teacherService.showNumberOfStudentsInClass("2B");

        entityManager.close();
        entityManagerFactory.close();
    }
}
