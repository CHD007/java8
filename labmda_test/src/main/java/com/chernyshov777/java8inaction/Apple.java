package com.chernyshov777.java8inaction;

import lombok.Data;

@Data
public class Apple {
    private int weight;
    private String color;

    public Apple(int weight, String color) {
        this.weight = weight;
        this.color = color;
    }

    public static boolean isGreenApple(Apple apple) {
        return "green".equals(apple.getColor());
    }
}
