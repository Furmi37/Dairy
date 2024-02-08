package com.furmi.service;

import com.furmi.model.Student;
import com.furmi.repository.StudentRespository;

import java.util.List;

public class StudentService {
    private final StudentRespository studentRespository;

    public StudentService(StudentRespository studentRespository) {
        this.studentRespository = studentRespository;
    }
    public void createStudent(Student student){
    studentRespository.save(student);
    }
    public void showALLStudents(){
        List<Student> list = studentRespository.getAllStudents();
        list.forEach(System.out::println);
    }
    public void deleteStudents(){
        studentRespository.deleteAllStudents();

    }
}
