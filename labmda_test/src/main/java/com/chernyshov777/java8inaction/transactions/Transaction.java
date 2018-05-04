package com.chernyshov777.java8inaction.transactions;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Transaction {
    private Trader trader;
    private final int year;
    private final int value;
}
