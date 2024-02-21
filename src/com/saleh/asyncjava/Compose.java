package com.saleh.asyncjava;

import java.util.concurrent.CompletableFuture;

public class Compose {
    public static int compute(int n) {
        return n * 2;
    }

    public static CompletableFuture<Integer> create(int n) {
        return CompletableFuture.supplyAsync(() -> compute(n));
    }

    public static void main(String[] args) {
        create(2)
                .thenCompose(data -> create(data))
                .thenAccept(System.out::println);

        // If your function returns data, use thenApply
        // If your function returns a CompletableFuture, use thenCompose
    }

    /*
    Stream                                         CompletableFuture
    map(f11) => Stream<R>
    map(f1n) => Stream<List<R>>
    flatMap(f1n) => Stream<R>                      thenCompose

    11 --> One to one
    1. --> One to n
     */
}
