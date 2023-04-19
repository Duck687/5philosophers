package org.example;
public class DiningPhilosophers {
  public static void main(String[] args) {
    int numberOfPhilosophers = 5;
    Fork[] forks = new Fork[numberOfPhilosophers];
    Philosopher[] philosophers = new Philosopher[numberOfPhilosophers];

    for (int i = 0; i < numberOfPhilosophers; i++) {
      forks[i] = new Fork();
    }

    for (int i = 0; i < numberOfPhilosophers; i++) {
      Fork leftFork = forks[i];
      Fork rightFork = forks[(i + 1) % numberOfPhilosophers];
      philosophers[i] = new Philosopher(i + 1, leftFork, rightFork);
      new Thread(philosophers[i]).start();
    }
  }
}