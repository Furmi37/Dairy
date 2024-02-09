package com.furmi.service;

import com.furmi.model.Grades;
import com.furmi.model.Student;
import com.furmi.model.Teacher;
import com.furmi.repository.TeacherRepository;

public class TeacherService {
    private final TeacherRepository teacherRepository;

    public TeacherService(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }


public void saveTeacher(Teacher teacher){
        teacherRepository.createTeacher(teacher);
}

    public void saveStudent(Student student){
        teacherRepository.createStudent(student);
    }
    public void deleteStudent (Student student){
        teacherRepository.deleteStudent(student);
    }

    public void saveGrade(Grades grade){
        teacherRepository.addGrade(grade);
    }

    public void changeGrade(Grades grade){

    }
}
