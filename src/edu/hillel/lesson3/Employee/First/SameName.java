package edu.hillel.lesson3.Employee.First;

import edu.hillel.lesson3.Employee.Employee;

public class SameName extends Employee {
    private final String gender;

    public SameName(String fullName, String jobTitle, String email, String phone, int age, String gender) {
        super(fullName, jobTitle, email, phone, age);
        this.gender = gender;
    }

    public String getGender() {
        return gender;
    }
}
