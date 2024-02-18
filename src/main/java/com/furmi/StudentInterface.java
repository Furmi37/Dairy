package com.furmi;


import com.furmi.model.Student;
import com.furmi.model.Teacher;
import com.furmi.repository.GradesRepository;
import com.furmi.repository.StudentRepository;
import com.furmi.repository.TeacherRepository;
import com.furmi.service.StudentService;
import com.furmi.service.TeacherService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.Scanner;

public class StudentInterface {
    private final int EXIT = 0;
    private final Scanner sc = new Scanner(System.in);
    private final int TEACHER = 1;
    private final int STUDENT = 2;

    public void loop(TeacherService teacherService, StudentService studentService) {
        int option = 15;
        System.out.println("Welecome in school dairy!");
        do {
            printLoopOptions();
            option = sc.nextInt();
            sc.nextLine();
            switch (option) {
                case EXIT -> exit();
                case TEACHER -> teacherLoop(teacherService);
                case STUDENT -> studentLoop(studentService);
                default -> throw new IllegalArgumentException("Illegal argument you have to choose options from 0-2");

            }
        } while (option != 0);
    }

    private void teacherLoop(TeacherService teacherService) {
        int teacherOption = 5;
        final int ADD_STUDENT = 1;
        final int ADD_GRADE = 2;
        final int CHANGE_GRADE = 3;

        System.out.println("You entered TEACHER panel");
        do {
            printTeacherOptions();
            teacherOption = sc.nextInt();
            sc.nextLine();
            switch (teacherOption) {
                case EXIT -> exit();
                case ADD_STUDENT -> teacherService.createStudent(createStudentData());
                case ADD_GRADE -> teacherService.addGrade(emailData(), gradeData(), addDateData(), subjectData());
                case CHANGE_GRADE -> teacherService.changeGrade(gradeIdData(), gradeData(), addDateData());
                default -> throw new IllegalArgumentException("Illegal argument you have to choose options from 0-3");
            }
        } while (teacherOption != 0);
    }

    private void studentLoop(StudentService studentService) {
        int studentOption = 5;
        final int UPDATE_FIRST_NAME = 1;
        final int SHOW_ALL_GRADES = 2;
        final int SHOW_STUDENTS_FROM_CLASS = 3;

        System.out.println("You entered STUDENT panel");
        do {
            printStudentOptions();
            studentOption = sc.nextInt();
            sc.nextLine();
            switch (studentOption) {
                case EXIT -> exit();
                case UPDATE_FIRST_NAME -> studentService.updateStudentFirstName(emailData(), firstNameData());
                case SHOW_ALL_GRADES -> studentService.showAllStudentGrades(emailData());
                case SHOW_STUDENTS_FROM_CLASS -> studentService.showAllStudentsInClass(classNameData());
                default -> throw new IllegalArgumentException("Illegal argument you have to choose options from 0-3");
            }
        } while (studentOption != 0);
    }

    private void exit() {
        System.out.println("Exiting..");
    }


    private void printLoopOptions() {
        System.out.println("Choose option:");
        System.out.println(" 0 - Exit program");
        System.out.println(" 1 - Enter teacher panel");
        System.out.println(" 2 - Enter student panel");
    }

    private void printTeacherOptions() {
        System.out.println("Choose task:");
        System.out.println(" 0 - Exit teacher panel");
        System.out.println(" 1 - Add student");
        System.out.println(" 2 - Add grade");
        System.out.println(" 3 - Change grade");
    }

    private void printStudentOptions() {
        System.out.println("Choose task:");
        System.out.println(" 0 - Exit student panel");
        System.out.println(" 1 - Update student first name");
        System.out.println(" 2 - Show all grades");
        System.out.println(" 3 - Show students from class");
    }

    public Student createStudentData() {
        System.out.println("Creating a student.");
        String firstName = firstNameData();
        System.out.println("Enter last name:");
        String lastName = sc.nextLine();
        System.out.println("Enter email:");
        String email = sc.nextLine();
        System.out.println("Enter birth day:");
        String birthDay = sc.nextLine();
        String className = classNameData();
        return new Student(firstName, lastName, email, birthDay, className);
    }

    private String emailData() {
        System.out.println("Enter student email: ");
        return sc.nextLine();
    }

    private int gradeData() {
        System.out.println("Enter grade: ");
        return sc.nextInt();
    }

    private String addDateData() {
        sc.nextLine();
        System.out.println("Enter date (yyyy-mm-dd): ");
        return sc.nextLine();
    }

    private String subjectData() {
        System.out.println("Enter subject: ");
        return sc.nextLine();
    }

    private int gradeIdData() {
        System.out.println("Enter grade id: ");
        return sc.nextInt();
    }

    private String firstNameData() {
        System.out.println("Enter first name: ");
        return sc.nextLine();
    }

    private String classNameData() {
        System.out.println("Enter class name: ");
        return sc.nextLine();
    }

}


