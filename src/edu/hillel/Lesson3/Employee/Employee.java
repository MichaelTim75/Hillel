package edu.hillel.Lesson3.Employee;

public class Employee {
    private final String fullName;
    private final String jobTitle;
    private final String email;
    private final String phone;
    private final int age;

    public Employee(String fullName, String jobTitle, String email, String phone, int age) {
        this.fullName = fullName;
        this.jobTitle = jobTitle;
        this.email = email;
        this.phone = phone;
        this.age = age;
    }

    public String getFullName() {
        return fullName;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public int getAge() {
        return age;
    }
}
