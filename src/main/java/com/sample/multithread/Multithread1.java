package com.sample.multithread;

public class Multithread1 extends Thread {
  @Override
  public void run() {
    System.out.println("Thread 1 is running");
  }

  public static void main(String[] args) {
    Multithread1 thread = new Multithread1();
    Runnable runnable = new RunnableOne();
    Thread thread2 = new Thread(runnable);
    thread.start();
    thread2.start();
  }
}

class RunnableOne implements Runnable {

  @Override
  public void run() {
    System.out.println("Thread 2 is running");
  }

}