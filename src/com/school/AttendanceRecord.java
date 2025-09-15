
package com.school;

public class AttendanceRecord implements Storable {
  private int studentId;
  private int courseId;
  private String status;

  // Constructor
  public AttendanceRecord(int studentId, int courseId, String status) {
    this.studentId = studentId;
    this.courseId = courseId;

    if ("Present".equalsIgnoreCase(status) || "Absent".equalsIgnoreCase(status)) {
      this.status = status;
    } else {
      this.status = "Invalid";
      System.out.println("Warning: Invalid status provided. Setting status to 'Invalid'.");
    }
  }

  public int getStudentId() {
    return studentId;
  }

  public int getCourseId() {
    return courseId;
  }

  public String getStatus() {
    return status;
  }

  public void displayRecord() {
    System.out.println("Attendance: Student ID" + studentId + " in Course ID C" + courseId + " - Status: " + status);
  }

  @Override
  public String toDataString() {
    return studentId + "," + courseId + "," + status;
  }
}
