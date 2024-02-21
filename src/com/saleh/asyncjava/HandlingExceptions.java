package com.saleh.asyncjava;

import java.util.concurrent.CompletableFuture;

public class HandlingExceptions {
    public static int compute(int n) {
        if (n <= 0) {
            throw new RuntimeException("Invalid input");
        }
        return n * 2;
    }

    public static CompletableFuture<Integer> create(int n) {
        return CompletableFuture.supplyAsync(() -> compute(n));
    }

    public static void main(String[] args) {
        // If exception happens in one function then the control bypasses all the operators in the chain
        // and get to the nearest `exceptionally`
        create(-4)
                .thenApply(data -> data + 1.0)
                .exceptionally(err -> {
                    System.out.println(err);
                    // return 100.0;

                    throw new RuntimeException("This is beyond repair...");
                })
                .thenAccept(System.out::println)
                .thenRun(() -> System.out.println("Log some info..."))
                .exceptionally(err -> {
                    System.out.println(err);
                    throw new RuntimeException("Sorry...");
                });

        // OK -- go to the next then
        // Exception -- go to the next exceptionally
    }
}
