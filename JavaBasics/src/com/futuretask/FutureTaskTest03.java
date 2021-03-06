package com.futuretask;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;

public class FutureTaskTest03 {
    public static void main(String[] args) {
        FutureTask<String> futureTask = new FutureTask< >(new Callable<String>() {
            @Override
            public String call() throws Exception {
                System.out.println(Thread.currentThread().getName() + " starts to run.");
                //Thread.sleep(5000);
                if(true) throw new InterruptedException();
                System.out.println(Thread.currentThread().getName() + " wakes up.");
                return "futurecall";
            }
        });

        Thread thread = new Thread(futureTask);
        thread.start();
        try {
            System.out.println(Thread.currentThread().getName() + "->" + futureTask.get() + "<-");
        } catch (ExecutionException ex) {
            System.out.println("ExecutionException exception:" + ex);
        } catch (InterruptedException ex) {
            System.out.println("InterruptedException exception:" + ex);
        } catch (Exception ex) {
            System.out.println("Exception exception:" + ex);
        }
        System.out.println(Thread.currentThread().getName() + " finished!");
    }
}
