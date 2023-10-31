package edu.hillel.lesson3.Employee;

import edu.hillel.lesson3.Employee.First.SameName;

public class Main {
    public static void main(String[] args){
        SameName first=new SameName("first fullName","first jobTitle","first@gmail.com","+1",27,"male");
        System.out.println("first: fullName="+first.getFullName()+
                ", jobTitle="+first.getJobTitle()+
                ", email="+first.getEmail()+
                ", phone="+first.getPhone()+
                ", age="+first.getAge()+
                ", gender="+first.getGender());

        edu.hillel.lesson3.Employee.Second.SameName second=new edu.hillel.lesson3.Employee.Second.SameName("second fullName","second jobTitle","second@gmail.com","+2",35,false);

        System.out.println("second: fullName="+second.getFullName()+
                ", jobTitle="+second.getJobTitle()+
                ", email="+second.getEmail()+
                ", phone="+second.getPhone()+
                ", age="+second.getAge()+
                ", gender="+(second.isMale()?"male":"female"));
    }
}
