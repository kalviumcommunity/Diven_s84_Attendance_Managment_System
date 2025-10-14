package com.school;

public class Student implements Storable {
    private static int nextStudentIdCounter = 1;
    
    private int studentId;
    private String name;

    public Student(String name) {
        this.studentId = nextStudentIdCounter++;
        this.name = name;
    }

    public int getStudentId() {
        return studentId;
    }
    
    public int getId() {
        return studentId;
    }

    public String getName() {
        return name;
    }

    public void displayDetails() {
        System.out.println("Student ID: " + this.studentId + ", Name: " + this.name);
    }
    
    @Override
    public String toDataString() {
        return studentId + "," + name;
    }
}