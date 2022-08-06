package com.Tutor;

import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main(String[] args) {
        Foo foo = new Foo();
        Runnable r1  = () -> System.out.println("first");
        Runnable r2  = () -> System.out.println("second");
        Runnable r3  = () -> System.out.println("third");

        CompletableFuture.runAsync(() -> {
            foo.second(r2);
        });

        CompletableFuture.runAsync(() -> {
            foo.third(r3);
        });

        CompletableFuture.runAsync(() -> {
            foo.first(r1);
        }).join();
    }
}
