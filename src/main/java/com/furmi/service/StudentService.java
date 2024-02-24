package com.furmi.service;

import com.furmi.model.Grade;
import com.furmi.model.Student;
import com.furmi.repository.StudentRepository;

import java.util.List;
import java.util.Set;

public class StudentService {
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;

    }

    public void updateStudentFirstName(String email, String firstName) {
        Student student = studentRepository.findByEmail(email);

        student.setFirstName(firstName);

        studentRepository.saveStudentInfo(student);
    }

    public Set<Grade> getAllStudentGrades(String email) {
        Student student = studentRepository.findByEmail(email);
        return student.getGrades();
    }

    public List<Grade> getSubjectGrades(String email, String subject) {
        return studentRepository.getSubjectGrades(email, subject);
    }

    public List<Student> getAllStudentsInClass(String className) {
        return studentRepository.getAllStudentsInClass(className);
    }
}
