package com.school;

import java.util.ArrayList;
import java.util.List;

public class AttendanceService {
    private List<AttendanceRecord> attendanceLog;
    private FileStorageService storageService;

    // Constructor
    public AttendanceService(FileStorageService storageService) {
        this.attendanceLog = new ArrayList<>();
        this.storageService = storageService;
    }

    // Overloaded markAttendance method 1: Using Student and Course objects directly
    public void markAttendance(Student student, Course course, String status) {
        AttendanceRecord record = new AttendanceRecord(student, course, status);
        attendanceLog.add(record);
        System.out.println("Attendance marked for " + student.getName() + " in " + course.getCourseName());
    }

    // Overloaded markAttendance method 2: Using IDs with lookup
    public void markAttendance(int studentId, int courseId, String status, List<Student> allStudents, List<Course> allCourses) {
        Student student = findStudentById(studentId, allStudents);
        Course course = findCourseById(courseId, allCourses);
        
        if (student != null && course != null) {
            markAttendance(student, course, status); // Call the first overloaded method
        } else {
            if (student == null) {
                System.out.println("Error: Student with ID " + studentId + " not found.");
            }
            if (course == null) {
                System.out.println("Error: Course with ID " + courseId + " not found.");
            }
        }
    }

    // Helper method to find student by ID
    private Student findStudentById(int studentId, List<Student> allStudents) {
        for (Student student : allStudents) {
            if (student.getId() == studentId) {
                return student;
            }
        }
        return null;
    }

    // Helper method to find course by ID
    private Course findCourseById(int courseId, List<Course> allCourses) {
        for (Course course : allCourses) {
            if (course.getCourseId() == courseId) {
                return course;
            }
        }
        return null;
    }

    // Overloaded displayAttendanceLog method 1: Display all records
    public void displayAttendanceLog() {
        System.out.println("\n--- Complete Attendance Log ---");
        if (attendanceLog.isEmpty()) {
            System.out.println("No attendance records found.");
            return;
        }
        
        for (AttendanceRecord record : attendanceLog) {
            record.displayRecord();
        }
    }

    // Overloaded displayAttendanceLog method 2: Display records for specific student
    public void displayAttendanceLog(Student student) {
        System.out.println("\n--- Attendance Log for " + student.getName() + " ---");
        boolean found = false;
        
        for (AttendanceRecord record : attendanceLog) {
            if (record.getStudent().getId() == student.getId()) {
                record.displayRecord();
                found = true;
            }
        }
        
        if (!found) {
            System.out.println("No attendance records found for " + student.getName());
        }
    }

    // Overloaded displayAttendanceLog method 3: Display records for specific course
    public void displayAttendanceLog(Course course) {
        System.out.println("\n--- Attendance Log for " + course.getCourseName() + " ---");
        boolean found = false;
        
        for (AttendanceRecord record : attendanceLog) {
            if (record.getCourse().getCourseId() == course.getCourseId()) {
                record.displayRecord();
                found = true;
            }
        }
        
        if (!found) {
            System.out.println("No attendance records found for " + course.getCourseName());
        }
    }

    // Method to save attendance data using FileStorageService
    public void saveAttendanceData() {
        storageService.saveData(attendanceLog, "attendance_log.txt");
    }

    // Getter for attendanceLog (useful for testing or external access)
    public List<AttendanceRecord> getAttendanceLog() {
        return new ArrayList<>(attendanceLog); // Return a copy to maintain encapsulation
    }
}