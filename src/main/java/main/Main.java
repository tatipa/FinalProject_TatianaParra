package main;

import components.*;
import components.Class;
import university.University;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        University university = new University();
        boolean exit = false;
        Scanner scanner = new Scanner(System.in);

        while (!exit){

            System.out.println("Would you like to do with the university?");
            System.out.println("1.Print the teacher list");
            System.out.println("2.Print the class information");
            System.out.println("3.Create a new student");
            System.out.println("4.Create a new class");
            System.out.println("5.Create a new teacher");
            System.out.println("6.Find a student in a list of classes");
            System.out.println("7.Exit");

            int option = scanner.nextInt();
            scanner.nextLine();
            if (option < 0 && option > 7){
                System.out.println("The number is invalid");
            }
            if (option == 1){
                university.teacherList();
            }
            if (option == 2){
                int classOption = getClassOption(university, scanner);
                university.getClassList().get(classOption-1).printClassInformation();
            }
            if (option == 3){
                System.out.println("Insert the name");
                String name = scanner.nextLine();
                System.out.println("Insert the age");
                int age = scanner.nextInt();
                scanner.nextLine();
                Student student = university.addStudent(name, age);
                int classOption = getClassOption(university, scanner);
                university.getClassList().get(classOption-1).addStudent(student);
                System.out.println("The student name: " + student.getName() + " with id: " + student.getId() );
            }
            if (option == 4){
                System.out.println("Insert the name");
                String name = scanner.nextLine();
                System.out.println("Insert the classroom");
                String classroom = scanner.nextLine();
                System.out.println("Select teacher number");
                for (int i = 0; i<university.getTeacherList().size(); i++){
                    System.out.println((i+1) + ". " + university.getTeacherList().get(i).getName());
                }
                int teacherNumber = scanner.nextInt();
                scanner.nextLine();
                ArrayList <Student> studentSelectedList = new ArrayList<>();
                studentSelectedList.add(printAddStudentToClass(university, scanner));
                System.out.println("Do you want to add another student? 1. Yes  2. No");
                int studentOption = scanner.nextInt();
                scanner.nextLine();
                while (studentOption == 1){
                    studentSelectedList.add(printAddStudentToClass(university, scanner));
                    System.out.println("Do you want to add another student? 1. Yes  2. No");
                    studentOption = scanner.nextInt();
                    scanner.nextLine();
                }
                Class subject = new Class(name, classroom, studentSelectedList, university.getTeacherList().get(teacherNumber-1));
                university.addClass(subject);
            }
            if (option == 5){
                System.out.println("Insert the name");
                String name = scanner.nextLine();
                System.out.println("What kind of teacher it is?");
                System.out.println("1.Part Time");
                System.out.println("2.Full time");
                int optionTeacher = scanner.nextInt();
                scanner.nextLine();
                if (optionTeacher == 1){
                    System.out.println("How many hours per week");
                    int hours = scanner.nextInt();
                    scanner.nextLine();
                    Teacher partTimeTeacher = new PartTimeTeacher(name, hours);
                    university.addTeacher(partTimeTeacher);
                } else if (optionTeacher == 2){
                    System.out.println("How many years of experience?");
                    int years = scanner.nextInt();
                    scanner.nextLine();
                    Teacher fullTime = new FullTimeTeacher(name, years);
                    university.addTeacher(fullTime);
                }
            }
            if(option == 6){
                System.out.println("Insert the student id");
                int id = scanner.nextInt();
                scanner.nextLine();
                ArrayList<Class> classStudentList =  university.findStudentClass(id);
                for (int i = 0; i < classStudentList.size(); i++){
                    System.out.println(classStudentList.get(i).getName());
                }
            }
            if (option == 7){
                System.out.println("The End");
                exit = true;
            }
        }
    }

    private static int getClassOption(University university, Scanner scanner) {
        System.out.println("Which class do you want?");
        for (int i = 0; i<university.getClassList().size(); i++){
            System.out.println((i+1) + ". " + university.getClassList().get(i).getName());
        }
        int classOption = scanner.nextInt();
        scanner.nextLine();
        return classOption;
    }

    private static Student printAddStudentToClass(University university, Scanner scanner) {
        System.out.println("Select student number");
        for (int i = 0; i<university.getStudentList().size(); i++){
            System.out.println((i+1) + ". " + university.getStudentList().get(i).getName() + " / " + university.getStudentList().get(i).getId());
        }
        int studentNumber = scanner.nextInt();
        scanner.nextLine();
        return university.getStudentList().get(studentNumber-1);
    }
}
