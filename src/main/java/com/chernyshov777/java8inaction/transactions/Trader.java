package com.chernyshov777.java8inaction.transactions;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Trader {
    private final String name;
    private final String city;
}
