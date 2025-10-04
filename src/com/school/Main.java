package com.school;

import java.util.ArrayList;
import java.util.List;

public class Main {
  // Method to demonstrate polymorphism with Person hierarchy
  public static void displaySchoolDirectory(List<Person> people) {
    System.out.println("\n--- School Directory (Polymorphic Display) ---");
    for (Person person : people) {
      person.displayDetails(); // Polymorphic call - each subclass overrides this method
    }
  }

  public static void main(String[] args) {
    System.out.println("--- School Attendance System ---");

    // Demonstrating Person hierarchy
    System.out.println("\n--- Part 7: Polymorphic Behaviour Demonstration ---");
    
    // Creating Students with grade levels
    Student student1 = new Student("Alice Wonderland", "Grade 11");
    Student student2 = new Student("Bob The Builder", "Grade 10");
    
    // Creating Teachers
    Teacher teacher1 = new Teacher("Dr. Sarah Johnson", "Computer Science");
    Teacher teacher2 = new Teacher("Mr. Michael Brown", "Mathematics");
    
    // Creating Staff
    Staff staff1 = new Staff("Jennifer Davis", "Administrative Assistant");
    Staff staff2 = new Staff("Robert Wilson", "IT Support");

    // Create ArrayList<Person> for polymorphic demonstration
    ArrayList<Person> schoolPeople = new ArrayList<>();
    schoolPeople.add(student1);
    schoolPeople.add(student2);
    schoolPeople.add(teacher1);
    schoolPeople.add(teacher2);
    schoolPeople.add(staff1);
    schoolPeople.add(staff2);

    // Demonstrate polymorphism by calling displaySchoolDirectory
    displaySchoolDirectory(schoolPeople);

    Course course1 = new Course("Intro to Programming");

    System.out.println("\nAvailable Courses:");
    course1.displayDetails();

    // --- Attendance Recording ---
    System.out.println("\n--- Attendance Recording ---");
    List<AttendanceRecord> attendanceLog = new ArrayList<>();

    // Record valid attendance using Student and Course objects
    AttendanceRecord record1 = new AttendanceRecord(student1, course1, "Present");
    attendanceLog.add(record1);

    // Attempt to record invalid attendance status
    AttendanceRecord record2 = new AttendanceRecord(student2, course1, "Late");
    attendanceLog.add(record2); // Will be stored as "Invalid"

    // Record another valid attendance
    AttendanceRecord record3 = new AttendanceRecord(student2, course1, "Absent");
    attendanceLog.add(record3);

    System.out.println("\n--- Attendance Log ---");
    for (AttendanceRecord record : attendanceLog) {
      record.displayRecord();
    }

    // --- Part 7: File Storage Implementation with Polymorphism ---
    System.out.println("\n--- Part 7: File Storage Implementation with Polymorphism ---");
    
    // Filter students from schoolPeople list using instanceof
    ArrayList<Student> students = new ArrayList<>();
    for (Person person : schoolPeople) {
      if (person instanceof Student) {
        students.add((Student) person); // Cast to Student
      }
    }
    
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

    System.out.println("\nPart 7: File Storage Implementation Complete.");
  }
}