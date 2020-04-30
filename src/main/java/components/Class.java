package components;

import java.util.ArrayList;

public class Class {
    private String name;
    private String classroom;
    private ArrayList<Student> studentList;
    private Teacher professor;

    public Class(String name, String classroom , ArrayList<Student> studentList, Teacher professor){
        this.name = name;
        this.classroom = classroom;
        this.studentList = studentList;
        this.professor = professor;
    }

    public void addStudent(Student student){
        studentList.add(student);
    }

    public void printClassInformation () {
        System.out.println("Name class: " + name );
        System.out.println("Teacher: " + professor.getName());
        System.out.println("Students: ");
        for (int i = 0; i<studentList.size(); i++){
            System.out.println(studentList.get(i).getName());
        }

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClassroom() {
        return classroom;
    }

    public void setClassroom(String classroom) {
        this.classroom = classroom;
    }

    public ArrayList<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(ArrayList<Student> studentList) {
        this.studentList = studentList;
    }

    public Teacher getProfessor() {
        return professor;
    }

    public void setProfessor(Teacher professor) {
        this.professor = professor;
    }
}
