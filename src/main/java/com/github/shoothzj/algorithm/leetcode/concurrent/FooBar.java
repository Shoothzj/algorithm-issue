package com.github.shoothzj.algorithm.leetcode.concurrent;

class FooBar {

    private volatile boolean foo = true;

    private int n;

    public FooBar(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        
        for (int i = 0; i < n; i++) {
            //这里可以加锁来避免自旋,提高效率
            while (!foo) {

            }
        	// printFoo.run() outputs "foo". Do not change or remove this line.
        	printFoo.run();
            foo = false;
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        
        for (int i = 0; i < n; i++) {
            while (foo) {

            }
            // printBar.run() outputs "bar". Do not change or remove this line.
        	printBar.run();
            foo = true;
        }
    }
}