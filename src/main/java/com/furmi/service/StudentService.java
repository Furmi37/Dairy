package com.furmi.service;

import com.furmi.model.Student;
import com.furmi.repository.StudentRepository;

import java.util.List;

public class StudentService {
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }
    public void updateStudentInfo(Student student){
    studentRepository.updateInfo(student);
    }
    public void showAllStudents(){
        List<Student> list = studentRepository.getAllStudents();
        list.forEach(System.out::println);
    }
    public void deleteAllStudents(){
        studentRepository.deleteAllStudents();

    }
}
