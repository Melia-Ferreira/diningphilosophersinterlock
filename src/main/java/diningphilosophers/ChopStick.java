package diningphilosophers;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ChopStick {

    private final Lock stick = new ReentrantLock();

    private static int stickCount = 0;

    private boolean iAmFree = true;
    private final int myNumber;

    public ChopStick() {
        myNumber = ++stickCount;
    }

    synchronized public void release() {
        stick.unlock();
        System.out.println("Stick " + myNumber + " Released");
    }

    synchronized public boolean take(int delay) throws InterruptedException {
        return stick.tryLock();
    }

    @Override
    public String toString() {
        return "Stick#" + myNumber;
    }
}
