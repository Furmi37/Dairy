package com.furmi.repository;

import com.furmi.model.Student;
import com.furmi.model.Teacher;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


class TeacherRepositoryTest {
    private EntityManager entityManager;
    private TypedQuery query;
    private TeacherRepository teacherRepository;
    private EntityTransaction entityTransaction;

    @BeforeEach
    void setUp() {
        entityManager = mock(EntityManager.class);
        query = mock(TypedQuery.class);
        entityTransaction = mock(EntityTransaction.class);

        teacherRepository = new TeacherRepository(entityManager);
    }

    @Test
    void shouldInvokeTeacherToDbUsingPersistMethod() {
        //given
        int id = 1;
        Teacher teacher = new Teacher();
        teacher.setFirstName("Monthy");
        teacher.setLastName("Python");
        teacher.setId(id);

        when(entityManager.getTransaction()).thenReturn(entityTransaction);
        //when
        teacherRepository.saveTeacher(teacher);
        //then
        verify(entityManager, times(1)).persist(teacher);
    }

    @Test
    void shouldInvokeStudentToDbUsingPersistMethod() {
        //given
        int id = 1;
        Student student = new Student();
        student.setId(id);
        student.setFirstName("Mark");
        student.setLastName("Plaza");

        when(entityManager.getTransaction()).thenReturn(entityTransaction);
        //when
        teacherRepository.saveStudent(student);
        //then
        verify(entityManager, times(1)).persist(student);
    }

    @Test
    void shouldDeleteStudent() {
        //given
        int id = 1;
        Student student = new Student();
        student.setId(id);
        student.setFirstName("Mark");
        student.setLastName("Plaza");
        when(entityManager.getTransaction()).thenReturn(entityTransaction);
        //when
        teacherRepository.removeStudent(student);
        //then
        verify(entityManager, times(1)).remove(student);
    }

    @Test
    void shouldGetTwoTeachers() {
        //given
        Teacher t1 = new Teacher("Jack", "Lanoszka", 3000, "German", "mgr", "2024-09-01");
        Teacher t2 = new Teacher("George", "Carpenter", 4000, "Phisical Education", "mgr", "2024-09-01");
        List<Teacher> teachers = List.of(t1, t2);

        when(entityManager.getTransaction()).thenReturn(entityTransaction);
        when(entityManager.createQuery("FROM Teacher", Teacher.class)).thenReturn((query));
        when(query.getResultList()).thenReturn(teachers);
        //when
        List<Teacher> result = teacherRepository.getAllTeachers();
        //then
        assertEquals(teachers, result);
    }

    @Test
    void getNumberOfStudentsInClass() {
        //given
        String className = "2B";
        Student student1 = new Student("Kalv", "Klein", "calvin@gmail.com", "2015-08-19", "2B");
        Student student2 = new Student("Monthy", "Python", "monthy@gmail.com", "2015-04-29", "2B");
        Student student3 = new Student("Steven", "Segall", "steven@gmail.com", "2015-04-29", "2B");

        List<Student> studs = List.of(student1, student2, student3);

        when(entityManager.createQuery(
                "SELECT COUNT(id)  FROM Student WHERE className = :className", Student.class)).thenReturn(query);
        when(query.setParameter("className", className)).thenReturn(query);
        when(query.getResultList()).thenReturn(studs);

        //when
        List<Student> result = teacherRepository.getNumberOfStudentsInClass(className);

        //then
        assertEquals(studs.size(), result.size());
    }
}