package com.furmi;

import com.furmi.model.Grade;
import com.furmi.model.Student;
import com.furmi.service.StudentService;
import com.furmi.service.TeacherService;

import java.util.Scanner;

public class StudentInterface {
    private final int EXIT = 0;
    private StudentService studentService;
    private TeacherService teacherService;

    //teacher edit user soutami wczytuje dane
    //menu z rozdzieleniem na student/teacher i dalej ich funkcje
    //wczytuje maila
    //wczytuje dane

    //z app wywaluje z service niezbedne metody

    //menu teacher/student osbone metody
    class Option {
        private final Scanner sc = new Scanner(System.in);

        private final int TEACHER = 1;
        private final int STUDENT = 2;


        public Option() {
        }

        public void Loop() {
            int option = 15;
            System.out.println("Welecome in school dairy!");
            do {
                printLoopOptions();
                option = sc.nextInt();
                switch (option) {
                    case EXIT -> exit();
                    case TEACHER -> teacherLoop();
                    case STUDENT -> studentLoop();
                    default ->
                            throw new IllegalArgumentException("Illegal argument you have to choose options from 0-2");

                }


            } while (option != 0);
        }

        private void teacherLoop() {
            int teacherOption = 5;

            final int ADD_STUDENT = 1;
            final int ADD_GRADE = 2;
            final int CHANGE_GRADE = 3;

            System.out.println("You entered TEACHER panel");
            do {
                printTeacherOptions();
                teacherOption = sc.nextInt();
                switch (teacherOption) {
                    case EXIT -> exit();
                    case ADD_STUDENT -> teacherService.createStudent(createStudentData());
                    case ADD_GRADE -> teacherService.addGrade(emailData(), gradeData(), addDateData(), subjectData());
                    case CHANGE_GRADE -> teacherService.changeGrade(gradeIdData(), gradeData(), addDateData());
                    default ->
                            throw new IllegalArgumentException("Illegal argument you have to choose options from 0-3");
                }
            } while (teacherOption != 0);
        }

        private void studentLoop() {
            int studOption = 5;
            System.out.println("You entered STUDENT panel");
            printStudentOptions();
            studOption = sc.nextInt();
        }

        private void exit() {
            System.out.println("Closing program...");
        }

        private void printLoopOptions() {
            System.out.println("Choose user:");
            System.out.println(" 0 - exit program");
            System.out.println(" 1 - for teacher");
            System.out.println(" 2 - for student");
        }

        private void printTeacherOptions() {
            System.out.println("Choose task:");
            System.out.println(" 0 - exit program");
            System.out.println(" 1 - add student");
            System.out.println(" 2 - add grade");
            System.out.println(" 3 - change grade");
        }

        private void printStudentOptions() {
            System.out.println("Choose task:");
            System.out.println(" 0 - exit program");
            System.out.println(" 1 - add student");
            System.out.println(" 2 - add grade");
            System.out.println(" 3 - change grade");
        }

        private Student createStudentData() {
            System.out.println("Creating a student, enter first name: ");
            String firstName = sc.nextLine();
            System.out.println("Enter last name:");
            String lastName = sc.nextLine();
            System.out.println("Enter email:");
            String email = sc.nextLine();
            System.out.println("Enter birth day:");
            String birthDay = sc.nextLine();
            System.out.println("Enter class name:");
            String className = sc.nextLine();
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

    }
}
