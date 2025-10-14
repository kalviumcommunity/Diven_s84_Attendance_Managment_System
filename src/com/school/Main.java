package com.school;

public class Main {
    public static void main(String[] args) {
        System.out.println("--- Part 3: Constructor Initialization & Auto-ID Generation ---");
        
        // Create students using new constructor
        System.out.println("\nCreating Students:");
        Student student1 = new Student("Alice Johnson");
        Student student2 = new Student("Bob Smith");
        Student student3 = new Student("Charlie Brown");
        Student student4 = new Student("Diana Prince");
        
        // Display student details to show auto-ID generation
        student1.displayDetails();
        student2.displayDetails();
        student3.displayDetails();
        student4.displayDetails();
        
        // Create courses using new constructor
        System.out.println("\nCreating Courses:");
        Course course1 = new Course("Introduction to Programming");
        Course course2 = new Course("Advanced Mathematics");
        Course course3 = new Course("Physics Fundamentals");
        Course course4 = new Course("English Literature");
        
        // Display course details to show auto-ID generation
        course1.displayDetails();
        course2.displayDetails();
        course3.displayDetails();
        course4.displayDetails();
        
        // Demonstrate that IDs are automatically generated and unique
        System.out.println("\n--- Auto-ID Generation Verification ---");
        System.out.println("Student IDs: " + student1.getStudentId() + ", " + 
                          student2.getStudentId() + ", " + 
                          student3.getStudentId() + ", " + 
                          student4.getStudentId());
        System.out.println("Course IDs: " + course1.getCourseId() + ", " + 
                          course2.getCourseId() + ", " + 
                          course3.getCourseId() + ", " + 
                          course4.getCourseId());
    }
}