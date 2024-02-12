package com.furmi.service;

import com.furmi.model.Grades;
import com.furmi.model.Student;
import com.furmi.model.Teacher;
import com.furmi.repository.StudentRepository;
import com.furmi.repository.TeacherRepository;

import java.util.Set;

public class TeacherService {
    private final TeacherRepository teacherRepository;
    private final StudentRepository studentRepository;
    private final com.furmi.repository.gradesRespository gradesRespository;

    public TeacherService(TeacherRepository teacherRepository, StudentRepository studentRepository, com.furmi.repository.gradesRespository gradesRespository) {
        this.teacherRepository = teacherRepository;
        this.studentRepository = studentRepository;
        this.gradesRespository = gradesRespository;
    }


    public void createTeacher(Teacher teacher) {
        teacherRepository.saveTeacher(teacher);
    }

    public void createStudent(Student student) {
        teacherRepository.saveStudent(student);
    }

    public void deleteStudent(Student student) {
        teacherRepository.deleteStudent(student);
    }

    public void addGrade(String email, int grade, String add_date, String subject) {
        Student student = studentRepository.findByEmail(email);

        Grades grade1 = new Grades();
        grade1.setGrade(grade);
        grade1.setAdd_date(add_date);
        grade1.setSubject(subject);


        student.getGrades().add(grade1);

        teacherRepository.saveStudent(student);
    }

    public void showAllGradesForStudent(String email) {
        Student student = studentRepository.findByEmail(email);
        Set<Grades> grades = student.getGrades();
        grades.forEach(System.out::println);
    }

    public void deleteAllGrades() {


        gradesRespository.deleteAll();
    }


    public void changeGrade(Grades grade) {

    }
}
