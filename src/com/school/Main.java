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
    Student student3 = new Student("Charlie Brown", "Grade 12");
    
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
    schoolPeople.add(student3);
    schoolPeople.add(teacher1);
    schoolPeople.add(teacher2);
    schoolPeople.add(staff1);
    schoolPeople.add(staff2);

    // Demonstrate polymorphism by calling displaySchoolDirectory
    displaySchoolDirectory(schoolPeople);

    // Create courses
    Course course1 = new Course("Intro to Programming");
    Course course2 = new Course("Advanced Mathematics");

    System.out.println("\nAvailable Courses:");
    course1.displayDetails();
    course2.displayDetails();

    // --- Part 8: AttendanceService with Overloaded Methods ---
    System.out.println("\n--- Part 8: AttendanceService with Overloaded Methods ---");
    
    // Create FileStorageService and AttendanceService instances
    FileStorageService fileService = new FileStorageService();
    AttendanceService attendanceService = new AttendanceService(fileService);
    
    // Create lists of students and courses for lookup methods
    ArrayList<Student> allStudents = new ArrayList<>();
    for (Person person : schoolPeople) {
      if (person instanceof Student) {
        allStudents.add((Student) person);
      }
    }
    
    ArrayList<Course> allCourses = new ArrayList<>();
    allCourses.add(course1);
    allCourses.add(course2);

    // Demonstrate overloaded markAttendance methods
    System.out.println("\n--- Demonstrating Overloaded markAttendance Methods ---");
    
    // Method 1: Using Student and Course objects directly
    System.out.println("\n1. Using Student and Course objects directly:");
    attendanceService.markAttendance(student1, course1, "Present");
    attendanceService.markAttendance(student2, course1, "Absent");
    
    // Method 2: Using IDs with lookup
    System.out.println("\n2. Using student and course IDs with lookup:");
    attendanceService.markAttendance(student3.getId(), course1.getCourseId(), "Present", allStudents, allCourses);
    attendanceService.markAttendance(student1.getId(), course2.getCourseId(), "Present", allStudents, allCourses);
    attendanceService.markAttendance(student2.getId(), course2.getCourseId(), "Absent", allStudents, allCourses);
    
    // Test with invalid IDs
    System.out.println("\n3. Testing with invalid IDs:");
    attendanceService.markAttendance(999, course1.getCourseId(), "Present", allStudents, allCourses);
    attendanceService.markAttendance(student1.getId(), 999, "Present", allStudents, allCourses);

    // Demonstrate overloaded displayAttendanceLog methods
    System.out.println("\n--- Demonstrating Overloaded displayAttendanceLog Methods ---");
    
    // Method 1: Display all records
    attendanceService.displayAttendanceLog();
    
    // Method 2: Display records for specific student
    attendanceService.displayAttendanceLog(student1);
    attendanceService.displayAttendanceLog(student2);
    
    // Method 3: Display records for specific course
    attendanceService.displayAttendanceLog(course1);
    attendanceService.displayAttendanceLog(course2);

    // Save attendance data
    System.out.println("\n--- Saving Attendance Data ---");
    attendanceService.saveAttendanceData();

    // --- Legacy Part 7 Implementation for Comparison ---
    System.out.println("\n--- Part 7: File Storage Implementation (Legacy) ---");
    
    ArrayList<Course> courses = new ArrayList<>();
    courses.addAll(allCourses);
    
    // Save other data to files
    fileService.saveData(allStudents, "students.txt");
    fileService.saveData(courses, "courses.txt");

    System.out.println("\nPart 8: AttendanceService Implementation Complete.");
  }
}