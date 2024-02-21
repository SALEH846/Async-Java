package com.saleh.asyncjava;

import java.util.concurrent.CompletableFuture;

public class Sample3 {
    public static int compute(int n) {
        System.out.println("compute called...");

        try {
            Thread.sleep(100);
        } catch (Exception ex) {

        }

        return n * 2;
    }

    public static CompletableFuture<Integer> create(int n) {
        return CompletableFuture.supplyAsync(() -> compute(n));
    }

    public static void main(String[] args) {
        create(4) // CompletableFuture<Integer>
                .thenApply(data -> data + 1.0) // CompletableFuture<Double>
                .thenAccept(System.out::println) // CompletableFuture<void>
                .thenRun(() -> System.out.println("Log some info...")); // CompletableFuture<void>

        /*
            Stream                               CompletableFuture
            map(Function<T, R> apply)            thenApply
            forEach(Consumer<T> accept)          thenAccept
            NOTE: `forEach` is a terminal operator as it ends the stream while `thenAccept` is not terminal
         */

        System.out.println("Started the computation " + Thread.currentThread());

        try {
            Thread.sleep(2000);
        } catch (Exception ex) {

        }
    }
}
