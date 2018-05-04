package com.chernyshov777;

import lombok.Data;

/**
 * Created by Danil on 23.04.2017.
 */
@Data
public class Person {
    private String firstName;
    private String lastName;
    private int age;
    
    public Person(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }
    
    @Override
    public String toString() {
        return "Person [firstName = " + firstName + ", lastName = " + lastName + ", age = " + age;
    }
}
