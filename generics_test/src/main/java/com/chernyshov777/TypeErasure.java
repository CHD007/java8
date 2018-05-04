package com.chernyshov777;

import java.util.ArrayList;

public class TypeErasure {
    public static void main(String[] args) {
        System.out.println("runtime type of ArrayList<String>: " + new ArrayList<String>().getClass());
        System.out.println("runtime type of ArrayList<Long>: " + new ArrayList<Long>().getClass());
        Object object = new String();
        System.out.println("runtime type of String casted to Object: " + object.getClass());
    }
}
