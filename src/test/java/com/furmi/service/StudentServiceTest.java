package com.furmi.service;

import com.furmi.StudentInterface;
import com.furmi.model.Student;
import com.furmi.repository.StudentRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

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
    public void shouldNotShowAnyGrades() {
        //given
        Student student = new Student("Kalv", "Klein", "calvin@gmail.com", "2015-08-19", "2B");
        when(studentRepository.findByEmail(student.getEmail())).thenReturn(student);

        //when
        studentService.showAllStudentGrades("calvin@gmail.com");
        //then
        String outPut = outContent.toString();
        String expected = "";

        assertEquals(expected, outPut);
    }

    @Test
    public void shouldNotShowSubjectGrades() {
        Student student = new Student("Kalv", "Klein", "calvin@gmail.com", "2015-08-19", "2B");
        when(studentRepository.findByEmail(student.getEmail())).thenReturn(student);

        //when
        studentService.showSubjectGrades("calvin@gmail.com", "Polish");
        //then
        String outPut = outContent.toString();
        String expected = "";

        assertEquals(expected, outPut);
    }

    @Test
    public void shouldShowTwoStudentsFromClass2B() {
        //given need a little check
        String className = "2B";
        Student student1 = new Student("Kalv", "Klein", "calvin@gmail.com", "2015-08-19", className);
        Student student2 = new Student("Monthy", "Python", "monthy@gmail.com", "2015-04-29", className);
        List<Student> studs = List.of(student1, student2);
        when(studentRepository.getAllStudentsInClass(className)).thenReturn(studs);

        //when
        studentService.showAllStudentsInClass(className);
        //then
        String consoleOutPut = originalOut.toString();
        String expectedString = "Student{id=null, firstName='Kalv', lastName='Klein', email='calvin@gmail.com', birthDay='2015-08-19', className='2B'}\n" +
                "Student{id=null, firstName='Monthy', lastName='Python', email='monthy@gmail.com', birthDay='2015-04-29', className='2B'}";

        assertEquals(expectedString, consoleOutPut.trim());
        verify(studentRepository, times(1)).getAllStudentsInClass(className);
    }

}