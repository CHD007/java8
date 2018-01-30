package com.chernyshov777.java8inaction;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ApplesMain {
    private int number = 0;
    private List<Apple> apples;

    public ApplesMain() {
        apples = Arrays.asList(new Apple(100, "green"),
                new Apple(155, "yellow"),
                new Apple(160, "green"),
                new Apple(130, "yellow"));
    }

    public static void main(String[] args) {
        ApplesMain applesMain = new ApplesMain();


        System.out.println(applesMain.getGreenApples());

        applesMain.testLambdaAccessToVariables();
    }

    public List<Apple> getGreenApples() {
        return filterApples(apples, Apple::isGreenApple);
    }

    public List<Apple> filterApples(List<Apple> apples, Predicate<Apple> predicate) {
        return apples.stream()
                .filter(predicate)
                .collect(Collectors.toList());
    }

    public void testLambdaAccessToVariables() {
        int localNumber = 10;

        Consumer<Integer> consumerLocal = (Integer a) -> System.out.println(a + localNumber);
        Consumer<Integer> consumerInstance = (Integer a) -> System.out.println(a + number);
        consumerLocal.accept(10);
        consumerInstance.accept(10);

//        localNumber = 15; error - localNumber should be final or effectively final
    }
}
