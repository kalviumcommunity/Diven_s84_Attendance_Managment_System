package com.school;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("--- Part 9: SOLID Service Layer: RegistrationService & AttendanceService Separation ---");
        
        // Instantiate services with dependency injection
        FileStorageService storageService = new FileStorageService();
        RegistrationService registrationService = new RegistrationService(storageService);
        AttendanceService attendanceService = new AttendanceService(storageService, registrationService);
        
        // Register students using RegistrationService
        System.out.println("\nRegistering Students:");
        registrationService.registerStudent("Alice Johnson");
        registrationService.registerStudent("Bob Smith");
        registrationService.registerStudent("Charlie Brown");
        registrationService.registerStudent("Diana Prince");
        
        // Register teachers using RegistrationService
        System.out.println("\nRegistering Teachers:");
        registrationService.registerTeacher("Dr. Smith", "Computer Science");
        registrationService.registerTeacher("Prof. Johnson", "Mathematics");
        registrationService.registerTeacher("Ms. Brown", "Physics");
        
        // Register staff using RegistrationService
        System.out.println("\nRegistering Staff:");
        registrationService.registerStaff("John Admin", "Administrator");
        registrationService.registerStaff("Jane Security", "Security Guard");
        
        // Create courses using RegistrationService
        System.out.println("\nCreating Courses:");
        registrationService.createCourse("Introduction to Programming");
        registrationService.createCourse("Advanced Mathematics");
        registrationService.createCourse("Physics Fundamentals");
        registrationService.createCourse("English Literature");
        
        // Display school directory
        displaySchoolDirectory(registrationService);
        
        // Mark attendance using IDs
        System.out.println("\n--- Marking Attendance ---");
        attendanceService.markAttendance(1, 101, "Present");
        attendanceService.markAttendance(2, 101, "Absent");
        attendanceService.markAttendance(3, 102, "Present");
        attendanceService.markAttendance(4, 103, "Present");
        attendanceService.markAttendance(1, 102, "Present");
        
        // Display attendance log
        attendanceService.displayAttendanceLog();
        
        // Save all data
        System.out.println("\n--- Saving Data ---");
        registrationService.saveAllRegistrations();
        attendanceService.saveAttendanceData();
        
        System.out.println("\n--- Part 9 Complete ---");
        System.out.println("Check the generated files: students.txt, teachers.txt, staff.txt, courses.txt, attendance_log.txt");
    }
    
    // Updated displaySchoolDirectory method
    private static void displaySchoolDirectory(RegistrationService regService) {
        System.out.println("\n--- School Directory ---");
        
        System.out.println("\nStudents:");
        for (Student student : regService.getStudents()) {
            student.displayDetails();
        }
        
        System.out.println("\nTeachers:");
        for (Teacher teacher : regService.getTeachers()) {
            teacher.displayDetails();
        }
        
        System.out.println("\nStaff:");
        for (Staff staff : regService.getStaffMembers()) {
            staff.displayDetails();
        }
        
        System.out.println("\nCourses:");
        for (Course course : regService.getCourses()) {
            course.displayDetails();
        }
        
        System.out.println("\nAll People (Teachers and Staff):");
        List<Person> allPeople = regService.getAllPeople();
        for (Person person : allPeople) {
            person.displayDetails();
        }
    }
}