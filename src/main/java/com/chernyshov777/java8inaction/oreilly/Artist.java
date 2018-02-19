package com.chernyshov777.java8inaction.oreilly;

import lombok.Data;

import java.util.Set;

@Data
public class Artist {
    private String name;
    private Set<String> members;
    private String origin;
}
