package com.furmi.service;

import com.furmi.model.Grade;
import com.furmi.model.Student;
import com.furmi.model.Teacher;
import com.furmi.repository.GradesRepository;
import com.furmi.repository.StudentRepository;
import com.furmi.repository.TeacherRepository;

import java.util.List;
import java.util.Set;

public class TeacherService {
    private final TeacherRepository teacherRepository;
    private final StudentRepository studentRepository;
    private final GradesRepository gradesRepository;


    public TeacherService(TeacherRepository teacherRepository, StudentRepository studentRepository, GradesRepository gradesRepository) {
        this.teacherRepository = teacherRepository;
        this.studentRepository = studentRepository;
        this.gradesRepository = gradesRepository;

    }

    public void createTeacher(Teacher teacher) {
        teacherRepository.saveTeacher(teacher);
    }

    public void createStudent(Student student) {
        teacherRepository.saveStudent(student);
    }

    public void deleteStudent(String email) {
        Student student = studentRepository.findByEmail(email);

        teacherRepository.removeStudent(student);
    }

    public void addGrade(String email, int grade, String addDate, String subject) {
        Student student = studentRepository.findByEmail(email);

        Grade grade1 = new Grade();
        grade1.setGrade(grade);
        grade1.setAddDate(addDate);
        grade1.setSubject(subject);
        grade1.setStudent(student);

        student.getGrades().add(grade1);
        teacherRepository.saveStudent(student);
    }

    public void changeGrade(long id, int newGrade, String date) {
        Grade grade = gradesRepository.findById(id);

        grade.setGrade(newGrade);
        grade.setAddDate(date);
        gradesRepository.save(grade);
    }

    public Set<Grade> getAllGradesForStudent(String email) {
        Student student = studentRepository.findByEmail(email);
        return student.getGrades();
    }

    public void deleteAllGrades() {
        gradesRepository.deleteAll();
    }

    public int getNumberOfStudentsInClass(String className) {
        return teacherRepository.getNumberOfStudentsInClass(className).size();
    }
}
