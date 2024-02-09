package com.furmi.repository;

import com.furmi.model.Grades;
import com.furmi.model.Student;
import com.furmi.model.Teacher;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;

import java.sql.ResultSet;
import java.util.List;
import java.util.Set;

import static javax.swing.DropMode.ON;
import static org.hibernate.FetchMode.JOIN;
import static org.hibernate.sql.ast.Clause.FOR_UPDATE;
import static org.hibernate.sql.ast.Clause.WHERE;

public class TeacherRepository {
    private final EntityManager entityManager;

    public TeacherRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void createTeacher(Teacher teacher) {
        entityManager.getTransaction().begin();
        entityManager.persist(teacher);
        entityManager.getTransaction().commit();
    }

    public void createStudent(Student student) {
        entityManager.getTransaction().begin();
        entityManager.persist(student);
        entityManager.getTransaction().commit();
    }

    public void deleteStudent(Student student) {
        entityManager.getTransaction().begin();
        entityManager.remove(student);
        entityManager.getTransaction().commit();
    }

    public void addGrade(Grades grade) {
        entityManager.getTransaction().begin();
        entityManager.persist(grade);
        entityManager.getTransaction().commit();

    }

    public void changeGrade(Grades grade) {
        entityManager.getTransaction().begin();
        entityManager.persist(grade);
        entityManager.getTransaction().commit();
    }

//    public List<Grades> getAllGradesForStudent(Student student) {
////        SELECT student.student_id, grades.subject,grades.grade FROM student
////        JOIN grades
////        ON student.student_id = 200 AND grades.subject = 'Biology';
//        entityManager.getTransaction().begin();
//        Query query = entityManager.createQuery("FROM Student JOIN Grades ON Student.student_id = ");
//
//        return query.getResultList();
//    }

    public List<Student> getStudendsWithBirthdayThisWeek(Student student) {
        return null;
    }

    public int getNumberOfStudentsInClass(Student student) {
        return 0;
    }


}
