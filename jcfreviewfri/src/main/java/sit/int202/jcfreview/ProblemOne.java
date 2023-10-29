package sit.int202.jcfreview;

import java.util.*;

public class ProblemOne {
    public static void main(String[] args) {
        Student s1 = new Student(10001, "Somsri", 3.25);
        Student s2 = new Student(10002, "Somsak", 3.00);
        Student s3 = new Student(10009, "Somchai", 3.26);
        Student s4 = new Student(10007, "Somsiri", 3.25);
        Student s5 = new Student(10037, "Sirisopaphan", 3.25);

        System.out.println("======= HashSet =======");

        Set<Student> studentSet1 = new HashSet<>();
        studentSet1.add(s1);
        studentSet1.add(s2);
        studentSet1.add(s3);
        studentSet1.add(s4);
        studentSet1.add(s5);
        for (Student student : studentSet1) {
            System.out.println(student + " -> " + student.hashCode());
        }
        System.out.println("------- Sort by GPAX -------");
        List<Student> studentList1 = studentSet1.stream().sorted(Student.SORT_BY_GPAX).toList();
        for (Student student : studentList1) {
            System.out.println(student + " -> " + student.hashCode());
        }
        System.out.println("------- Sort by Name -------");
        List<Student> studentList2 = studentSet1.stream().sorted(Student.SORT_BY_NAME).toList();
        for (Student student : studentList2) {
            System.out.println(student + " -> " + student.hashCode());
        }

        System.out.println("======= TreeSet =======");

        Set<Student> studentSet2 = new TreeSet<>();
        studentSet2.add(s1);
        studentSet2.add(s2);
        studentSet2.add(s3);
        studentSet2.add(s4);
        studentSet2.add(s5);
        for (Student student : studentSet2) {
            System.out.println(student + " -> " + student.hashCode());
        }
        System.out.println("------- Sort by GPAX -------");
        List<Student> studentList3 = studentSet2.stream().sorted(Student.SORT_BY_GPAX).toList();
        for (Student student : studentList3) {
            System.out.println(student + " -> " + student.hashCode());
        }
        System.out.println("------- Sort by Name -------");
        List<Student> studentList4 = studentSet2.stream().sorted(Student.SORT_BY_NAME).toList();
        for (Student student : studentList4) {
            System.out.println(student + " -> " + student.hashCode());
        }
    }
}
