package com.furmi.service;

import com.furmi.model.Student;
import com.furmi.repository.StudentRepository;

import java.util.List;

public class StudentService {
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public void updateStudentFirstName(String email, String firstName) {
        Student student = studentRepository.findByEmail(email);

        student.setFirst_name(firstName);

        studentRepository.saveStudentInfo(student);
    }

    public void showAllStudents() {
        List<Student> list = studentRepository.getAllStudents();
        list.forEach(System.out::println);
    }

    public void deleteAllStudents() {
        studentRepository.deleteAllStudents();

    }

}
