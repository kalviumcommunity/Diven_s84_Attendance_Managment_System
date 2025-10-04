
package com.school;

public class AttendanceRecord implements Storable {
  private Student student;
  private Course course;
  private String status;

  // Constructor
  public AttendanceRecord(Student student, Course course, String status) {
    this.student = student;
    this.course = course;

    if ("Present".equalsIgnoreCase(status) || "Absent".equalsIgnoreCase(status)) {
      this.status = status;
    } else {
      this.status = "Invalid";
      System.out.println("Warning: Invalid status provided. Setting status to 'Invalid'.");
    }
  }

  public Student getStudent() {
    return student;
  }

  public Course getCourse() {
    return course;
  }

  public String getStatus() {
    return status;
  }

  public void displayRecord() {
    System.out.println("Attendance: " + student.getName() + " (ID: " + student.getId() + ") in " + 
                      course.getCourseName() + " (Course ID: C" + course.getCourseId() + ") - Status: " + status);
  }

  @Override
  public String toDataString() {
    return student.getId() + "," + course.getCourseId() + "," + status;
  }
}
