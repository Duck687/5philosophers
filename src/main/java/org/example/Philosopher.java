package org.example;

class Philosopher implements Runnable {
  private final int id;
  private final Fork leftFork;
  private final Fork rightFork;

  public Philosopher(int id, Fork leftFork, Fork rightFork) {
    this.id = id;
    this.leftFork = leftFork;
    this.rightFork = rightFork;
  }

  private void think() throws InterruptedException {
    System.out.println("Philosopher " + id + " is thinking...");
    Thread.sleep((long) (Math.random() * 10000));
  }

  private void eat() throws InterruptedException {
    System.out.println("Philosopher " + id + " is eating...");
    Thread.sleep((long) (Math.random() * 10000));
  }

  public void run() {
    try {
      while (true) {
        think();
        leftFork.take();
        System.out.println("Philosopher " + id + " has taken left fork...");
        rightFork.take();
        System.out.println("Philosopher " + id + " has taken right fork...");
        eat();
        leftFork.setFree();
        System.out.println("Philosopher " + id + " has released left fork...");
        rightFork.setFree();
        System.out.println("Philosopher " + id + " has released right fork...");
      }
    } catch (InterruptedException e) {
      Thread.currentThread().interrupt();
      return;
    }
  }
}