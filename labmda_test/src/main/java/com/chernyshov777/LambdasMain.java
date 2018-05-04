package com.chernyshov777;

import java.util.*;
import java.util.function.Predicate;

/**
 * Hello world!
 *
 */
public class LambdasMain {
    public static void main( String[] args ) {
        List<Person> people = Arrays.asList(
                new Person("Charles", "Dickens", 60),
                new Person("Lewis", "Carroll", 42),
                new Person("Thomas", "Carlyle", 51),
                new Person("Charlotte", "Bronte", 45),
                new Person("Matthew", "Arnold", 39)
        );

        for (Person person : people) {
            if (person.getAge() == 42) {
                people.remove(person);
            }
        }

        //Step 1: Sort list by last name
    
        Collections.sort(people, Comparator.comparing(Person::getLastName));
    
        //Step 2: Create a method that prints all elements in the list
        
        printAllElements(people);
        
        //Step 3: Create a method that prints all people that have last name beginning with C
    
        System.out.println("\n People which last name beginning with C:\n");
        
        printAllElements(people, p -> p.getLastName().matches("C.*"));
    }
    
    public static <T> void printAllElements(List<T> elements) {
        elements.forEach(System.out::println);
    }
    
    public static void printAllElements(List<Person> people, Predicate<Person> predicate) {
        people.stream()
                .filter(predicate)
                .forEach(System.out::println);

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 0);
        Optional<Integer> first =
                numbers.stream()
                        .filter(e -> e > 5)
                        .findFirst();
        first.ifPresent(System.out::println);
    }

}
