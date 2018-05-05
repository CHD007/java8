package com.chernyshov777;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CastsTest {

    public static void main(String[] args) {
        CastsTest castsTest = new CastsTest();
        castsTest.m1();
    }

    /**
     *  Unchecked upcast example
     */
    public void m1() {
        System.out.println("Upcast: ArrayList to List");
        List<Date> dateList = new ArrayList<>();
        dateList.add(new Date());
        m2(dateList);
    }

    /**
     * Unchecked downcast
     */
    public void m2(Object object) {
        System.out.println("Unsafe downcast Object to List<String>");
        List<String> list = (List<String>) object; // actually it is a cast from Object to the raw type List that's why no error occur here
        // the compiler emits "unchecked" warnings for every dynamic cast whose target type is a parameterized type
        // cause runtime type of parameterized type is raw type (because of type erasure)
        // so in previous example there is no guarantee that list will contains Strings
        List unparameterizedList = (List) object; // no unchecked warnings because it is a cast to raw type
        m3(list);
    }

    /**
     * ClassCastException
     */
    public void m3(List<String> list) {
        System.out.println("Trying to get String from casted to List<String> list that is actually List<Date>");
        try {
            String string = list.get(0); // ClassCastException
        } catch (ClassCastException exception) {
            System.out.println("When we retrieve elements from that list we expect Strings, but in fact we receive Dates" +
                    "and a ClassCastException occur");
            exception.printStackTrace();
        }
    }
}
