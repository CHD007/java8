package com.chernyshov777.annotations;

public class AnnoMain {
    public static void main(String[] args) {
        Apple apple = addAnnotationToType();

    }

    public static Apple addAnnotationToType() {
        return new Apple("green");
    }
}
