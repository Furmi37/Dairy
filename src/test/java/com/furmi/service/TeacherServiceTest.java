package com.furmi.service;

import com.furmi.StudentInterface;
import com.furmi.model.Grade;
import com.furmi.model.Student;
import com.furmi.model.Teacher;
import com.furmi.repository.GradesRepository;
import com.furmi.repository.StudentRepository;
import com.furmi.repository.TeacherRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class TeacherServiceTest {
    private TeacherService teacherService;
    private StudentRepository studentRepository;
    private TeacherRepository teacherRepository;
    private GradesRepository gradesRepository;

    private final PrintStream originalOut = System.out;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @BeforeEach
    void setUp() {
        studentRepository = mock(StudentRepository.class);
        teacherRepository = mock(TeacherRepository.class);
        gradesRepository = mock(GradesRepository.class);
        System.setOut(new PrintStream(outContent));

        teacherService = new TeacherService(teacherRepository, studentRepository, gradesRepository);
    }

    @AfterEach
    void after() {
        System.setOut(originalOut);
    }

    @Test
    void shouldCreateTeacherUsingTeacherRepositorySaveMethod() {
        //given
        Teacher teacher = new Teacher();
        teacher.setId(1);
        //when
        teacherService.createTeacher(teacher);
        //then
        verify(teacherRepository, times(1)).saveTeacher(teacher);
    }

    @Test
    void shouldCreateStudentToDbUsingRepositorySaveMethod() {
        //given
        Student student = new Student("Kalv", "Klein", "calvin@gmail.com", "2015-08-19", "2B");
        //when
        teacherService.createStudent(student);
        //then
        verify(teacherRepository, times(1)).saveStudent(student);
    }

    @Test
    void shouldDeleteStudentUsingTeacherRepositoiryMethodDeleteStudent() {
        //given
        Student student = new Student();
        String email = "calvin@gmail.com";
        student.setEmail(email);
        when(studentRepository.findByEmail(email)).thenReturn(student);
        //when
        teacherService.deleteStudent(email);
        //then
        verify(teacherRepository, times(1)).removeStudent(student);
    }

    @Test
    void shouldAddGradeToStudentUsingTeacherRepositoryMethodSave() {
        //given
        Student student = new Student();
        String email = "calvin@gmail.com";
        student.setEmail(email);
        when(studentRepository.findByEmail(email)).thenReturn(student);

        Grade grade = new Grade();
        grade.setGrade(5);
        student.getGrades().add(grade);
        //when
        teacherRepository.saveStudent(student);
        //then
        verify(teacherRepository, times(1)).saveStudent(student);
    }

    @Test
    void shouldChangeGradeFrom4To5() {
        //given
        Student student = new Student();
        String email = "calvin@gmail.com";
        student.setEmail(email);
        when(studentRepository.findByEmail(email)).thenReturn(student);

        Grade grade = new Grade();
        grade.setId(1);
        grade.setGrade(4);
        student.getGrades().add(grade);
        when(gradesRepository.findById(1L)).thenReturn(grade);

        //when
        teacherService.changeGrade(1, 5, "2024-02-10");
        //then
        assertEquals(5, grade.getGrade());
    }

    @Test
    void shouldShowStudentTwoGrades() {
        //given
        Student student = new Student();
        String email = "matt@gmail.com";
        student.setEmail(email);
        when(studentRepository.findByEmail(email)).thenReturn(student);
        teacherService.addGrade(email, 4, "2024-02-18", "Polish");
        teacherService.addGrade(email, 6, "2024-02-18", "Polish");

        //when
        Set<Grade> grades = student.getGrades();
        //then
        String expected = "[Grade{subject='Polish', grade=4, add_date='2024-02-18'}, " +
                "Grade{subject='Polish', grade=6, add_date='2024-02-18'}]";

        String consoleOutput = grades.toString();
        assertEquals(expected, consoleOutput.trim());

    }


    @Test
    void shouldDeleteAllGradesUsingGradesRepositoryMethodDeleteAll() {
        //given

        //when
        teacherService.deleteAllGrades();
        //then
        verify(gradesRepository, times(1)).deleteAll();
    }

    @Test
    void showNumberOfStudentsInClass() {
        //given need check showing reference
        String className = "2B";
        Student student1 = new Student("Kalv", "Klein", "calvin@gmail.com", "2015-08-19", className);
        Student student2 = new Student("Monthy", "Python", "monthy@gmail.com", "2015-04-29", className);
        List<Student> studs = List.of(student1, student2);
        when(teacherRepository.getNumberOfStudentsInClass(className)).thenReturn(studs);

        //when
        teacherService.showNumberOfStudentsInClass(className);
        //then
        String expected = "Number of students in class 2A is 2";
        String outPut = originalOut.toString();

        assertEquals(expected, outPut);

    }
}