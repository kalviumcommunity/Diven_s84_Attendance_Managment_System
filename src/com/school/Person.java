package com.school;

public class Person {
    private static int nextIdCounter = 1; // Universal auto-ID generator
    
    protected int id;
    protected String name;
    
    // Constructor
    public Person(String name) {
        this.id = nextIdCounter++;
        this.name = name;
    }
    
    // Getter methods
    public int getId() {
        return id;
    }
    
    public String getName() {
        return name;
    }
    
    // Base displayDetails method
    public void displayDetails() {
        System.out.println("ID: " + this.id + ", Name: " + this.name);
    }
}