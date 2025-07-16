package com.school;

public class Main {
    public static void main(String[] args) {
        Student[] students = {
            new Student(1, "Alice"),
            new Student(2, "Bob"),
            new Student(3, "Charlie")
        };

        Course[] courses = {
            new Course("CS101", "Intro to Computer Science"),
            new Course("MATH201", "Calculus I"),
            new Course("ENG150", "English Literature")
        };

        System.out.println("Students:");
        for (Student s : students) {
            System.out.println(s);
        }

        System.out.println("\nCourses:");
        for (Course c : courses) {
            System.out.println(c);
        }
    }
}