package com.saleh.asyncjava;

// Virtual thread gets unmounted from the carrier thread when its sleeping

public class NonBlockingVirtualThreads {
    public static void doWork() {
        // code ...
        // unmount
        try {
            Thread.sleep(3000);
        } catch (Exception ex) {}
        // mount
        // code...
    }

    public static void main(String[] args) {
        int MAX = 100;

        for (var i = 0; i < MAX; i++) {
            Thread.startVirtualThread(NonBlockingVirtualThreads::doWork);
        }

        try { Thread.sleep(3000); } catch (Exception ex) {}
        System.out.println("DONE");
    }
}
