package com.saleh.asyncjava;

import java.util.concurrent.CompletableFuture;

public class Sample {
    public static int compute(int n) {
        return n * 2;
    }

    public static CompletableFuture<Integer> create(int n) {
        // There are two functions about which you should know about
        // 1. CompletableFuture.supplyAsync() -- if something will be returned
        // 2. CompletableFuture.runAsync() -- If nothing will be returned
        return CompletableFuture.supplyAsync(() -> compute(n));
    }

    public static void main(String[] args) {
        // In this case, the result will be:
        // ```
        // 9
        // Started the computation
        // ```
        // Because the future returned immediately
        create(4)
                .thenApply(data -> {
                    System.out.println(Thread.currentThread());
                    return data + 1;
                })
                .thenAccept(System.out::println);

        System.out.println("Started the computation " + Thread.currentThread());
    }
}
