package com.school;

public class Teacher extends Person {
    private String subjectTaught;
    
    // Constructor
    public Teacher(String name, String subjectTaught) {
        super(name); // Call parent constructor
        this.subjectTaught = subjectTaught;
    }
    
    // Getter methods
    public String getSubjectTaught() {
        return subjectTaught;
    }
    
    @Override
    public void displayDetails() {
        super.displayDetails(); // Call parent displayDetails()
        System.out.println("Subject: " + this.subjectTaught + ", Role: Teacher");
    }
}