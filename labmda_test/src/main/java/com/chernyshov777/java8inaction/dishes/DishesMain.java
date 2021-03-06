package com.chernyshov777.java8inaction.dishes;

import com.chernyshov777.java8inaction.oreilly.Test;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class DishesMain {
    public static void main(String[] args) {
        List<Dish> menu = Arrays.asList(
                new Dish("pork", false, 800, Dish.Type.MEAT),
                new Dish("beef", false, 700, Dish.Type.MEAT),
                new Dish("chicken", false, 400, Dish.Type.MEAT),
                new Dish("french fries", true, 530, Dish.Type.OTHER),
                new Dish("rice", true, 350, Dish.Type.OTHER),
                new Dish("season fruit", true, 120, Dish.Type.OTHER),
                new Dish("pizza", true, 550, Dish.Type.OTHER),
                new Dish("prawns", false, 300, Dish.Type.FISH),
                new Dish("salmon", false, 450, Dish.Type.FISH)
        );

        List<String> names = menu.stream()
                .filter(d -> {
                    System.out.println("Filtering " + d.getName());
                    return d.getCalories() < 400;
                })
                .map(d -> {
                    System.out.println("mapping " + d.getName());
                    return d.getName();
                })
                .limit(3)
                .collect(toList());
        System.out.println(names);

        Test helloTest = new Test() {
            @Override
            public void test() {
                System.out.println("hello test");
            }
        };

        Test lambdaTest = () -> System.out.println("hell lambda test");

        helloTest.test();
        lambdaTest.test();
    }
}
