package com.furmi.service;

import com.furmi.model.Grade;
import com.furmi.model.Student;
import com.furmi.repository.StudentRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class StudentServiceTest {
    private StudentRepository studentRepository;
    private StudentService studentService;
    private final PrintStream originalOut = System.out;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();


    @BeforeEach
    public void setUp() {
        studentRepository = mock(StudentRepository.class);
        System.setOut(new PrintStream(outContent));

        studentService = new StudentService(studentRepository);
    }

    @AfterEach
    void after() {
        System.setOut(originalOut);
    }

    @Test
    public void shouldUpdateStudentFirstName() {
        //given
        Student student = new Student("Kalv", "Klein", "calvin@gmail.com", "2015-08-19", "2B");
        when(studentRepository.findByEmail(student.getEmail())).thenReturn(student);

        //when
        String expectedFirstName = "Calvin";
        studentService.updateStudentFirstName("calvin@gmail.com", expectedFirstName);

        //then
        assertEquals(expectedFirstName, student.getFirstName());
    }

    @Test
    public void shouldNotGetAnyGrades() {
        //given
        Student student = new Student("Kalv", "Klein", "calvin@gmail.com", "2015-08-19", "2B");
        when(studentRepository.findByEmail(student.getEmail())).thenReturn(student);

        //when
        Set<Grade> result = studentService.getAllStudentGrades("calvin@gmail.com");
        //then
        int expected = 0;
        assertEquals(expected, result.size());
    }

    @Test
    public void shouldNotGetSubjectGrades() {
        Student student = new Student("Kalv", "Klein", "calvin@gmail.com", "2015-08-19", "2B");
        when(studentRepository.findByEmail(student.getEmail())).thenReturn(student);

        //when
        List<Grade> result = studentService.getSubjectGrades("calvin@gmail.com", "Polish");
        //then
        assertEquals(0, result.size());
    }

    @Test
    public void shouldGetTwoStudentsFromClass2B() {
        //given
        String className = "2B";
        Student student1 = new Student("Kalv", "Klein", "calvin@gmail.com", "2015-08-19", className);
        Student student2 = new Student("Monthy", "Python", "monthy@gmail.com", "2015-04-29", className);
        List<Student> students = List.of(student1, student2);
        when(studentRepository.getAllStudentsInClass(className)).thenReturn(students);

        //when
        List<Student> result = studentService.getAllStudentsInClass(className);
        //then
        assertEquals(students, result);
        verify(studentRepository, times(1)).getAllStudentsInClass(className);
    }

}