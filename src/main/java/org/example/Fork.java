package org.example;

class Fork {
  private boolean full = false;

  public synchronized void take() {
    while (full) {
      try {
        wait();
      } catch (InterruptedException e) {
      }
    }
    full = true;
  }

  public synchronized void put() {
    full = true;
    notifyAll();
  }

  public synchronized void setFree() {
    full = false;
    notifyAll();
  }

  public boolean isFull() {
    return full;
  }
}
