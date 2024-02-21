package com.saleh.asyncjava;

import java.util.concurrent.CompletableFuture;

public class Sample2 {
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
        create(4)
                .thenApply(data -> {
                    System.out.println(Thread.currentThread());
                    return data + 1;
                })
                .thenAccept(System.out::println);

        /*
            Stream                               CompletableFuture
            map(Function<T, R> apply)            thenApply
            forEach(Consumer<T> accept)          thenAccept
            NOTE: forEach is a terminal operator as it ends the stream while thenAccept is not terminal
         */

        System.out.println("Started the computation " + Thread.currentThread());

        try {
            Thread.sleep(2000);
        } catch (Exception ex) {

        }
    }
}
