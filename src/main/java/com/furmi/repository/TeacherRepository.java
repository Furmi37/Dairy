package com.furmi.repository;

import com.furmi.model.Grades;
import com.furmi.model.Student;
import com.furmi.model.Teacher;
import jakarta.persistence.EntityManager;

import java.util.List;

public class TeacherRepository {
    private final EntityManager entityManager;

    public TeacherRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void saveTeacher(Teacher teacher) {
        entityManager.getTransaction().begin();
        entityManager.persist(teacher);

        entityManager.getTransaction().commit();
    }

    public void saveStudent(Student student) {
        entityManager.getTransaction().begin();
        entityManager.persist(student);
        entityManager.getTransaction().commit();
    }

    public void deleteStudent(Student student) {
        entityManager.getTransaction().begin();
        entityManager.remove(student);
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
