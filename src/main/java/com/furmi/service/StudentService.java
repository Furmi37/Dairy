package com.furmi.service;

import com.furmi.StudentInterface;
import com.furmi.model.Grade;
import com.furmi.model.Student;
import com.furmi.repository.StudentRepository;
import jakarta.persistence.TypedQuery;

import java.util.List;
import java.util.Set;

public class StudentService {
    private final StudentRepository studentRepository;
    private final StudentInterface studentInterface;

    public StudentService(StudentRepository studentRepository, StudentInterface studentInterface) {
        this.studentRepository = studentRepository;
        this.studentInterface = studentInterface;
    }

    public void updateStudentFirstName(String email, String firstName) {
        Student student = studentRepository.findByEmail(email);

        student.setFirstName(firstName);

        studentRepository.saveStudentInfo(student);
    }

    public void showAllStudentGrades(String email) {
        Student student = studentRepository.findByEmail(email);
        Set<Grade> grades = student.getGrades();
        grades.forEach(System.out::println);
    }

    public void showSubjectGrades(String email, String subject) {
        studentRepository.getSubjectGrades(email, subject).forEach(System.out::println);
    }

    public void showAllStudentsInClass(String className) {
        List<Student> studs = studentRepository.getAllStudentsInClass(className);
        studs.forEach(System.out::println);
    }


}
