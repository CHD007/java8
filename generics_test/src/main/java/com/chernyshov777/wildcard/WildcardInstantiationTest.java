package com.chernyshov777.wildcard;

public class WildcardInstantiationTest {
    public class A<T, W> {
        T first;
        W second;

        @Override
        public String toString() {
            return "first: " + first.toString() + "\nsecond: " + second.toString();
        }
    }

    public static void main(String[] args) {
    }

    public static void printA(A<String,?> a) {
        System.out.println(a.toString());
    }
}
