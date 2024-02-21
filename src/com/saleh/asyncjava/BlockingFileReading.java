package com.saleh.asyncjava;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class BlockingFileReading {
    public static void fetch(int index, String path) {
        try {
            System.out.println(index + " before " + Thread.currentThread());

            var numberOfLines = Files.lines(Paths.get(path)).count();

            System.out.println(index + " after " + Thread.currentThread() + " " + numberOfLines);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void main(String[] args) {
        int MAX = 10;
        var executorService = Executors.newFixedThreadPool(MAX);

        for (int i = 0; i < MAX; i++) {
            int index = i;
            executorService.submit(() -> fetch(index, ".gitignore"));
        }

        executorService.shutdown();
        try {
            executorService.awaitTermination(10, TimeUnit.SECONDS);
        } catch (InterruptedException ex) {
            System.out.println(ex.getMessage());
        }
    }
}