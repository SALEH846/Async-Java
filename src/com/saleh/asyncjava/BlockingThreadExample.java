package com.saleh.asyncjava;

public class BlockingThreadExample {
    public static void doWork() {
        try {
            Thread.sleep(5000);
        } catch (Exception ex) {}
    }

    public static void main(String[] args) {
        int MAX = 100;

        for (var i = 0; i < MAX; i++) {
            new Thread(BlockingThreadExample::doWork).start();
        }

        try { Thread.sleep(5000); } catch (Exception ex) {}
        System.out.println("DONE");
    }
}
