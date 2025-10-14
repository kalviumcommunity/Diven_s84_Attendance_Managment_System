package com.school;

import java.util.List;
import java.util.Scanner;

public class Main {
    private static RegistrationService registrationService;
    private static AttendanceService attendanceService;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("--- Part 10: Interactive Console Menu System ---");
        
        // Initialize services
        initializeServices();
        
        // Load some sample data for demonstration
        loadSampleData();
        
        // Start interactive menu
        runInteractiveMenu();
    }
    
    private static void initializeServices() {
        FileStorageService storageService = new FileStorageService();
        registrationService = new RegistrationService(storageService);
        attendanceService = new AttendanceService(storageService, registrationService);
    }
    
    private static void loadSampleData() {
        System.out.println("\nLoading sample data...");
        
        // Register sample students
        registrationService.registerStudent("Alice Johnson");
        registrationService.registerStudent("Bob Smith");
        registrationService.registerStudent("Charlie Brown");
        
        // Register sample teachers
        registrationService.registerTeacher("Dr. Smith", "Computer Science");
        registrationService.registerTeacher("Prof. Johnson", "Mathematics");
        
        // Register sample staff
        registrationService.registerStaff("John Admin", "Administrator");
        
        // Create sample courses
        registrationService.createCourse("Introduction to Programming");
        registrationService.createCourse("Advanced Mathematics");
        
        System.out.println("Sample data loaded successfully!");
    }
    
    private static void runInteractiveMenu() {
        boolean running = true;
        
        while (running) {
            displayMainMenu();
            int choice = getMenuChoice();
            
            switch (choice) {
                case 1:
                    handleRegistrationMenu();
                    break;
                case 2:
                    handleAttendanceMenu();
                    break;
                case 3:
                    displaySchoolDirectory(registrationService);
                    break;
                case 4:
                    saveAllData();
                    break;
                case 5:
                    running = false;
                    System.out.println("Thank you for using the School Management System!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
        
        scanner.close();
    }
    
    private static void displayMainMenu() {
        System.out.println("\n=== School Management System ===");
        System.out.println("1. Registration Management");
        System.out.println("2. Attendance Management");
        System.out.println("3. View School Directory");
        System.out.println("4. Save All Data");
        System.out.println("5. Exit");
        System.out.print("Enter your choice (1-5): ");
    }
    
    private static int getMenuChoice() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            return -1;
        }
    }
    
    private static void handleRegistrationMenu() {
        System.out.println("\n=== Registration Management ===");
        System.out.println("1. Register Student");
        System.out.println("2. Register Teacher");
        System.out.println("3. Register Staff");
        System.out.println("4. Create Course");
        System.out.println("5. Back to Main Menu");
        System.out.print("Enter your choice (1-5): ");
        
        int choice = getMenuChoice();
        
        switch (choice) {
            case 1:
                registerNewStudent();
                break;
            case 2:
                registerNewTeacher();
                break;
            case 3:
                registerNewStaff();
                break;
            case 4:
                createNewCourse();
                break;
            case 5:
                return;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }
    
    private static void handleAttendanceMenu() {
        System.out.println("\n=== Attendance Management ===");
        System.out.println("1. Mark Attendance");
        System.out.println("2. View All Attendance Records");
        System.out.println("3. View Attendance by Student");
        System.out.println("4. View Attendance by Course");
        System.out.println("5. Back to Main Menu");
        System.out.print("Enter your choice (1-5): ");
        
        int choice = getMenuChoice();
        
        switch (choice) {
            case 1:
                markStudentAttendance();
                break;
            case 2:
                attendanceService.displayAttendanceLog();
                break;
            case 3:
                viewAttendanceByStudent();
                break;
            case 4:
                viewAttendanceByCourse();
                break;
            case 5:
                return;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }
    
    private static void registerNewStudent() {
        System.out.print("Enter student name: ");
        String name = scanner.nextLine();
        registrationService.registerStudent(name);
    }
    
    private static void registerNewTeacher() {
        System.out.print("Enter teacher name: ");
        String name = scanner.nextLine();
        System.out.print("Enter subject taught: ");
        String subject = scanner.nextLine();
        registrationService.registerTeacher(name, subject);
    }
    
    private static void registerNewStaff() {
        System.out.print("Enter staff name: ");
        String name = scanner.nextLine();
        System.out.print("Enter staff role: ");
        String role = scanner.nextLine();
        registrationService.registerStaff(name, role);
    }
    
    private static void createNewCourse() {
        System.out.print("Enter course name: ");
        String courseName = scanner.nextLine();
        registrationService.createCourse(courseName);
    }
    
    private static void markStudentAttendance() {
        System.out.print("Enter student ID: ");
        int studentId = getMenuChoice();
        System.out.print("Enter course ID: ");
        int courseId = getMenuChoice();
        System.out.print("Enter attendance status (Present/Absent): ");
        String status = scanner.nextLine();
        
        attendanceService.markAttendance(studentId, courseId, status);
    }
    
    private static void viewAttendanceByStudent() {
        System.out.print("Enter student ID: ");
        int studentId = getMenuChoice();
        Student student = registrationService.findStudentById(studentId);
        
        if (student != null) {
            attendanceService.displayAttendanceLog(student);
        } else {
            System.out.println("Student not found with ID: " + studentId);
        }
    }
    
    private static void viewAttendanceByCourse() {
        System.out.print("Enter course ID: ");
        int courseId = getMenuChoice();
        Course course = registrationService.findCourseById(courseId);
        
        if (course != null) {
            attendanceService.displayAttendanceLog(course);
        } else {
            System.out.println("Course not found with ID: " + courseId);
        }
    }
    
    private static void saveAllData() {
        System.out.println("\n--- Saving All Data ---");
        registrationService.saveAllRegistrations();
        attendanceService.saveAttendanceData();
        System.out.println("All data saved successfully!");
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