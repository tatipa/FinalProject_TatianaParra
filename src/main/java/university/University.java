package university;

import components.*;
import components.Class;

import java.util.ArrayList;

public class University {
    private ArrayList<Teacher> teacherList;
    private ArrayList<Student> studentList;
    private ArrayList<Class> classList;

    public University(){
        teacherList = new ArrayList<>();
        studentList = new ArrayList<>();
        classList = new ArrayList<>();
        Teacher partTimeTeacher = new PartTimeTeacher("Jose", 35);
        Teacher fullTimeTeacher = new FullTimeTeacher("Maria", 10);
        teacherList.add(partTimeTeacher);
        teacherList.add(fullTimeTeacher);
        Student student1 = new Student("Mari Paz", 25, 100);
        Student student2 = new Student("Gladys", 19,101);
        Student student3 = new Student("Marcela",20,102);
        Student student4 = new Student("Pedro",20,103);
        Student student5 = new Student("Carlos",22,104);
        Student student6 = new Student("Carol",20,105);
        studentList.add(student1);
        studentList.add(student2);
        studentList.add(student3);
        studentList.add(student4);
        studentList.add(student5);
        studentList.add(student6);
        ArrayList<Student> studentsSubject1 = new ArrayList<>();
        studentsSubject1.add(student3);
        studentsSubject1.add(student5);
        Class subject1 = new Class("Spanish", "A0", studentsSubject1, partTimeTeacher );
        ArrayList<Student> studentsSubject2 = new ArrayList<>();
        studentsSubject2.add(student3);
        studentsSubject2.add(student5);
        studentsSubject2.add(student1);
        Class subject2 = new Class("English", "A1", studentsSubject2, partTimeTeacher );
        ArrayList<Student> studentsSubject3 = new ArrayList<>();
        studentsSubject3.add(student2);
        studentsSubject3.add(student4);
        studentsSubject3.add(student1);
        Class subject3 = new Class("Math", "A2", studentsSubject3, fullTimeTeacher );
        ArrayList<Student> studentsSubject4 = new ArrayList<>();
        studentsSubject4.add(student1);
        studentsSubject4.add(student2);
        studentsSubject4.add(student3);
        studentsSubject4.add(student4);
        studentsSubject4.add(student5);
        studentsSubject4.add(student6);
        Class subject4 = new Class("Biology", "A1", studentsSubject4, fullTimeTeacher );
        classList.add(subject1);
        classList.add(subject2);
        classList.add(subject3);
        classList.add(subject4);
    }

    public Student addStudent(String name, int age) {
        Student student = new Student(name, age, 100+studentList.size());
        studentList.add(student);
        return student;
    }

    public void addTeacher(Teacher teacher) {
        teacherList.add(teacher);
    }

    public void addClass(Class subject) {
        classList.add(subject);
    }

    public void teacherList(){
        System.out.println("Name       / Salary");
        for (int i = 0; i< teacherList.size(); i++){
            System.out.println(teacherList.get(i).getName() + "         /"+ teacherList.get(i).calculateSalary());
        }
    }

    public ArrayList<Class> findStudentClass(int studentId) {
        ArrayList<Class> studentClassList = new ArrayList<>();
        for (int i = 0; i< classList.size(); i++){
            ArrayList<Student> classStudentList = classList.get(i).getStudentList();
            for (int j = 0; j < classStudentList.size(); j++){
                if (classStudentList.get(j).getId() == studentId){
                    studentClassList.add(classList.get(i));
                }
            }
        }
        return studentClassList;
    }

    public ArrayList<Teacher> getTeacherList() {
        return teacherList;
    }

    public void setTeacherList(ArrayList<Teacher> teacherList) {
        this.teacherList = teacherList;
    }

    public ArrayList<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(ArrayList<Student> studentList) {
        this.studentList = studentList;
    }

    public ArrayList<Class> getClassList() {
        return classList;
    }

    public void setClassList(ArrayList<Class> classList) {
        this.classList = classList;
    }
}
