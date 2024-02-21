package com.saleh.asyncjava;

import java.util.concurrent.CompletableFuture;

public class Combine {
    public static int compute(int n) {
        return n * 2;
    }

    public static CompletableFuture<Integer> create(int n) {
        return CompletableFuture.supplyAsync(() -> compute(n));
    }

    public static void main(String[] args) {
        var cf1 = create(2);
        var cf2 = create(3);

        cf1.thenCombine(cf2, (data1, data2) -> data1 + data2)
                .thenAccept(System.out::println);
    }
}
