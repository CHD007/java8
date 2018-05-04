package com.chernyshov777.java8inaction.nestedtests;

public class A {
    private String name;
    private static String staticName;

    private void test() {
        B b = new B();
        b.nameB = "adf";
    }

    private void privateTest() {

    }

    private class B {
        private String nameB;

        void test() {
            System.out.println(name);

        }
    }
}