package com.school;

import java.util.ArrayList;
import java.util.List;

public class Main {
  public static void main(String[] args) {
    System.out.println("--- School Attendance System ---");

    // Demonstrating Person hierarchy
    System.out.println("\n--- Part 5: Person Hierarchy Demonstration ---");
    
    // Creating Students with grade levels
    Student student1 = new Student("Alice Wonderland", "Grade 11");
    Student student2 = new Student("Bob The Builder", "Grade 10");
    
    // Creating Teachers
    Teacher teacher1 = new Teacher("Dr. Sarah Johnson", "Computer Science");
    Teacher teacher2 = new Teacher("Mr. Michael Brown", "Mathematics");
    
    // Creating Staff
    Staff staff1 = new Staff("Jennifer Davis", "Administrative Assistant");
    Staff staff2 = new Staff("Robert Wilson", "IT Support");

    Course course1 = new Course("Intro to Programming");

    System.out.println("\nRegistered Students:");
    student1.displayDetails();
    student2.displayDetails();
    
    System.out.println("\nTeaching Staff:");
    teacher1.displayDetails();
    teacher2.displayDetails();
    
    System.out.println("\nNon-Teaching Staff:");
    staff1.displayDetails();
    staff2.displayDetails();

    System.out.println("\nAvailable Courses:");
    course1.displayDetails();

    // --- Attendance Recording ---
    System.out.println("\n--- Attendance Recording ---");
    List<AttendanceRecord> attendanceLog = new ArrayList<>();

    // Record valid attendance using inherited getId() method
    AttendanceRecord record1 = new AttendanceRecord(student1.getId(), course1.getCourseId(), "Present");
    attendanceLog.add(record1);

    // Attempt to record invalid attendance status
    AttendanceRecord record2 = new AttendanceRecord(student2.getId(), course1.getCourseId(), "Late");
    attendanceLog.add(record2); // Will be stored as "Invalid"

    // Record another valid attendance
    AttendanceRecord record3 = new AttendanceRecord(student2.getId(), course1.getCourseId(), "Absent");
    attendanceLog.add(record3);

    System.out.println("\n--- Attendance Log ---");
    for (AttendanceRecord record : attendanceLog) {
      record.displayRecord();
    }

    // --- Part 6: File Storage Implementation ---
    System.out.println("\n--- Part 6: File Storage Implementation ---");
    
    // Create and populate ArrayLists
    ArrayList<Student> students = new ArrayList<>();
    students.add(student1);
    students.add(student2);
    
    ArrayList<Course> courses = new ArrayList<>();
    courses.add(course1);
    
    ArrayList<AttendanceRecord> records = new ArrayList<>();
    records.addAll(attendanceLog);
    
    // Create FileStorageService instance
    FileStorageService fileService = new FileStorageService();
    
    // Save data to files
    fileService.saveData(students, "students.txt");
    fileService.saveData(courses, "courses.txt");
    fileService.saveData(records, "attendance_log.txt");

    System.out.println("\nPart 6: File Storage Implementation Complete.");
  }
}