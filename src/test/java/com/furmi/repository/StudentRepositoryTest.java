package com.furmi.repository;

import com.furmi.model.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class StudentRepositoryTest {

    private EntityManager entityManager;
    private TypedQuery<Student> typedQuery;
    private Query query;
    private StudentRepository studentRepository;
    private EntityTransaction entityTransaction;

    @BeforeEach
    public void setUp() {
        entityManager = mock(EntityManager.class);
        typedQuery = mock(TypedQuery.class);
        query = mock(Query.class);
        entityTransaction = mock(EntityTransaction.class);

        studentRepository = new StudentRepository(entityManager);
    }

    @Test
    void shouldReturnOneStudentFromDb() {
        //given
        int id = 1;
        Student student = new Student();
        student.setId(id);
        student.setFirstName("Name");
        student.setLastName("LastName");

        when(entityManager.find(Student.class, id)).thenReturn(student);
        //when
        Student result = studentRepository.findById(id);
        //then
        assertEquals(student, result);
    }

    @Test
    void shouldInvokeStudentToDbUsingPersistMethod() {
        //given
        int id = 1;
        Student student = new Student();
        student.setId(id);
        student.setFirstName("Name");
        student.setLastName("LastName");

        when(entityManager.getTransaction()).thenReturn(entityTransaction);
        //when
        studentRepository.saveStudentInfo(student);
        //then
        verify(entityManager, times(1)).persist(student);
    }

    @Test
    void showGetTwoStudentsFromClass2B() {
        //given
        String className = "2B";
        Student student1 = new Student("Kalv", "Klein", "calvin@gmail.com", "2015-08-19", className);
        Student student2 = new Student("Monthy", "Python", "monthy@gmail.com", "2015-04-29", className);

        List<Student> studs = List.of(student1, student2);

        when(entityManager.createQuery("FROM Student s WHERE s.className = :className", Student.class).setParameter("className", className)).thenReturn(typedQuery);
        when(typedQuery.getResultList()).thenReturn(studs);

        //when
        List<Student> result = studentRepository.getAllStudentsInClass(className);
        //then
        assertEquals(studs, result);
    }

    @Test
    void shouldGetSubjectGrades() {
        
    }


}