package com.school;

public class Staff extends Person implements Storable {
    private String role;
    
    // Constructor
    public Staff(String name, String role) {
        super(name); // Call parent constructor
        this.role = role;
    }
    
    // Getter methods
    public String getRole() {
        return role;
    }
    
    @Override
    public void displayDetails() {
        super.displayDetails(); // Call parent displayDetails()
        System.out.println("Staff Role: " + this.role + ", Role: Staff");
    }
    
    @Override
    public String toDataString() {
        return id + "," + name + "," + role;
    }
}