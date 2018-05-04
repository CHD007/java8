package com.chernyshov777.optionaltest;

import org.junit.Test;

import java.util.NoSuchElementException;
import java.util.Optional;

import static org.junit.Assert.*;

public class OptionalTests {
    @Test
    public void whenCreateOptionalEmpty_thenCorrect() {
        Optional<String> empty = Optional.empty();
        assertFalse(empty.isPresent());
    }

    @Test
    public void givenNonNull_whenCreatesNonNullable_thenCorrect() {
        String name = "nonNullable";
        Optional<String> opt = Optional.of(name);
        assertEquals("Optional[nonNullable]", opt.toString());
    }

    @Test(expected = NullPointerException.class)
    public void givenNull_whenThrowsErrorOnCreate_thenCorrect() {
        String name = null;
        Optional<String> opt = Optional.of(name);
    }

    @Test
    public void givenNonNull_whenCreatesNullable_thenCorrects() {
        String name = null;
        Optional<String> opt = Optional.ofNullable(name);
        assertEquals("Optional.empty", opt.toString());
    }

    @Test
    public void givenOptional_whenIsPresentWorks_thenCorrect() {
        Optional<String> name = Optional.of("name");
        assertTrue(name.isPresent());

        name.ifPresent(System.out::println);

        Optional<Object> opt = Optional.ofNullable(null);
        assertFalse(opt.isPresent());
    }

    @Test
    public void whenOrElseWorks_thenCorrect() {
        String nullName = null;
        String name = Optional.ofNullable(nullName).orElse("default");
        assertEquals("default", name);
    }

    @Test
    public void whenOrElseGetWorks_thenCorrect() {
        String nullName = null;
        String name = Optional.ofNullable(nullName).orElseGet(() -> "default");
        assertEquals("default", name);
    }

    public String getMyDefault() {
        System.out.println("Getting Default Value");
        return "default";
    }

    @Test
    public void whenOrElseGetAndOrElseOverlap_thenCorrect() {
        String text = null;

        System.out.println("\nwhenOrElseGetAndOrElseOverlap_thenCorrect method");
        System.out.println("Using orElseGet");
        String orElseGet = Optional.ofNullable(text).orElseGet(this::getMyDefault);
        assertEquals("default", orElseGet);

        System.out.println("Using orElset");
        String orElse = Optional.ofNullable(text).orElse(getMyDefault());
        assertEquals("default", orElse);
    }

    @Test
    public void whenOrElseGetAndOrElseDiffer_thenCorrect() {
        String text = "Text Present";

        System.out.println("\nwhenOrElseGetAndOrElseDiffer_thenCorrect method");
        System.out.println("Using orElseGet");
        String orElseGet = Optional.ofNullable(text).orElseGet(this::getMyDefault);
        assertEquals("Text Present", orElseGet);

        System.out.println("Using orElse");
        String orElse = Optional.ofNullable(text).orElse(getMyDefault());
        assertEquals("Text Present", orElse);
    }

    @Test (expected = IllegalArgumentException.class)
    public void whenOrElseThrowsWorks_thenCorrect() {
        String nullName = null;
        String name = Optional.ofNullable(nullName).orElseThrow(IllegalArgumentException::new);
    }

    @Test
    public void givenOptional_whenGetsValue_thenCorrect() {
        Optional<String> name = Optional.of("name");
        assertEquals("name", name.get());
    }

    @Test (expected = NoSuchElementException.class)
    public void givenOptionalWithNull_whenGetThrowsException_thenCorrect() {
        Optional<String> opt = Optional.ofNullable(null);
        opt.get();
    }
}
