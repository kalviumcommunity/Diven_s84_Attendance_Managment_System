package com.school;

public class Course {
  private static int nextCourseIdCounter = 101; // Start course IDs from 101 and made private

  private int courseId; // Changed to int
  private String courseName;

  // Constructor
  public Course(String courseName) {
    this.courseId = nextCourseIdCounter++; // Auto-increment and assign ID
    this.courseName = courseName; // Assign course name
  }

  public int getCourseId() {
    return courseId;
  }

  public String getCourseName() {
    return courseName;
  }

  public void displayDetails() {
    // Displaying courseId with a prefix for better readability
    System.out.println("Course ID: C" + this.courseId + ", Name: " + this.courseName);
  }
}