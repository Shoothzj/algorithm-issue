package com.github.shoothzj.algorithm.leetcode.concurrent;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.IntConsumer;

class FizzBuzz {
    private int n;

    private AtomicInteger atomicInteger = new AtomicInteger(1);

    public FizzBuzz(int n) {
        this.n = n;
    }

    // printFizz.run() outputs "fizz".
    public void fizz(Runnable printFizz) throws InterruptedException {
        while (true) {
            int i = atomicInteger.get();
            if (i % 5 != 0 && i % 3 == 0) {
                printFizz.run();
                atomicInteger.compareAndSet(i, i + 1);
            }
        }
    }

    // printBuzz.run() outputs "buzz".
    public void buzz(Runnable printBuzz) throws InterruptedException {
        while (true) {
            int i = atomicInteger.get();
            if (i % 3 != 0 && i % 5 == 0) {
                printBuzz.run();
                atomicInteger.compareAndSet(i, i + 1);
            }
        }
    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        while (true) {
            int i = atomicInteger.get();
            if (i % 15 == 0) {
                printFizzBuzz.run();
                atomicInteger.compareAndSet(i, i + 1);
            }
        }
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void number(IntConsumer printNumber) throws InterruptedException {
        while (true) {
            int i = atomicInteger.get();
            if (i % 3 != 0 && i % 5 != 0) {
                printNumber.accept(i);
                atomicInteger.compareAndSet(i, i + 1);
            }
        }
    }

}