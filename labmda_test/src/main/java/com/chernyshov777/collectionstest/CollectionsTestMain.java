package com.chernyshov777.collectionstest;

import com.chernyshov777.Person;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class CollectionsTestMain {
    public static void main(String[] args) {
        List<Person> people = Arrays.asList(
                new Person("Charles", "Dickens", 60),
                new Person("Lewis", "Carroll", 42),
                new Person("Thomas", "Carlyle", 51),
                new Person("Charlotte", "Bronte", 45),
                new Person("Matthew", "Arnold", 39)
        );


        System.out.println("//////////////////////////////////////");
        testCollectionToArray(people);
    }


    public static void testCollectionToArray(Collection<Person> collection) {
        Object[] objects = collection.toArray();
        for (Object object : objects) {
            System.out.println(object.toString());
        }
        Person[] people = new Person[10];
        Person[] peopleArray = collection.toArray(people);
        for (Person person : peopleArray) {
            System.out.println(person);
        }
        System.out.println("base array people = " + people);
        System.out.println("created array = " + peopleArray);
    }
}
