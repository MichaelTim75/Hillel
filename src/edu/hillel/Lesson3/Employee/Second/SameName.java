package edu.hillel.Lesson3.Employee.Second;

import edu.hillel.Lesson3.Employee.Employee;

public class SameName extends Employee {
    private final boolean male;

    public SameName(String fullName, String jobTitle, String email, String phone, int age, boolean male) {
        super(fullName, jobTitle, email, phone, age);
        this.male = male;
    }

    public boolean isMale() {
        return male;
    }
}
