package com.chernyshov777.java8inaction.transactions;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class TransactionsMain {
    public static void main(String[] args) {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan","Cambridge");
        Trader brian = new Trader("Brian","Cambridge");

        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );

        List<Trader> traders = transactions.stream()
                .map(Transaction::getTrader)
                .collect(Collectors.toList());

        System.out.println("all transaction from 2011 sorted by value:");
        System.out.println(transactions2011Sorted(transactions));
        System.out.println("all unique cities where the traders work:");
        System.out.println(findAllUniqueCities(traders));
        System.out.println("all traders from Cambridge sorted by name:");
        System.out.println(findAllTradersFromCambridge(traders));
        System.out.println("all traders names sorted alphabetically");
        System.out.println(allTradersName(traders));
        System.out.println("are any traders from Milan - " + areAnyTradersFromMilan(traders));
        System.out.println("all transaction values from traders living in Cambridge: " + allTransactionValuesFromTradersLivingInCambridge(transactions));
        System.out.println("highest value of all transactions " + highestValueOfAllTransactions(transactions));
        System.out.println("transaction with smallest value " + transactionWithSmallestValue(transactions).get());
    }

    /**
     * Find all transactions in the year 2011 and sort them by value (small to high).
     */
    private static List<Transaction> transactions2011Sorted(List<Transaction> transactions) {
        return transactions.stream()
                .filter(t -> t.getYear() == 2011)
                .sorted(Comparator.comparingInt(Transaction::getValue))
                .collect(Collectors.toList());
    }

    /**
     * All the unique cities where the traders work
     */
    private static List<String> findAllUniqueCities(List<Trader> traders) {
        return traders.stream()
                .map(Trader::getCity)
                .distinct()
                .collect(Collectors.toList());
    }

    /**
     * Find all traders from Cambridge and sort them by name.
     */
    private static List<Trader> findAllTradersFromCambridge(List<Trader> traders) {
        return traders.stream()
                .filter(t -> t.getCity().equals("Cambridge"))
                .sorted(Comparator.comparing(Trader::getName))
                .collect(Collectors.toList());
    }

    /**
     * All traders name sorted alphabetically.
     */
    private static List<String> allTradersName(List<Trader> traders) {
        return traders.stream()
                .map(Trader::getName)
                .distinct()
                .sorted()
                .collect(Collectors.toList());
    }

    private static boolean areAnyTradersFromMilan(List<Trader> traders) {
        return traders.stream()
                .anyMatch(t -> t.getCity().equals("Milan"));
    }

    private static List<Integer> allTransactionValuesFromTradersLivingInCambridge(List<Transaction> transactions) {
        return transactions.stream()
                .filter(t -> t.getTrader().getCity().equals("Cambridge"))
                .map(Transaction::getValue)
                .collect(Collectors.toList());
    }

    private static int highestValueOfAllTransactions(List<Transaction> transactions) {
        return transactions.stream()
                .map(Transaction::getValue)
                .reduce(0, Integer::max);
    }

    private static Optional<Transaction> transactionWithSmallestValue(List<Transaction> transactions) {
        return transactions.stream()
                .min(Comparator.comparingInt(Transaction::getValue));
    }
}
