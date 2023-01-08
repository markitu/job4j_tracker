package ru.job4j.queue;

import java.util.NoSuchElementException;
import java.util.Queue;

public class AppleStore {
    private final Queue<Customer> queue;
    private final int count;

    public AppleStore(Queue<Customer> queue, int count) {
        if (queue == null) {
            throw new IllegalArgumentException("queue cannot be null");
        }
        if (count < 0) {
            throw new IllegalArgumentException("count cannot be less than 0");
        }
        this.queue = queue;
        this.count = count;
    }

    public String getLastHappyCustomer() {
        for (int i = 1; i < count; i++) {
            queue.poll();
        }
        if (queue.peek() == null) {
            throw new NoSuchElementException("There are no happy customers in the queue.");
        }
        return queue.peek().name();
    }

    public String getLastUpsetCustomer() {
        for (int i = 1; i <= count; i++) {
            queue.poll();
        }
        if (queue.peek() == null) {
            throw new NoSuchElementException("There are no upset customers in the queue.");
        }
        return queue.peek().name();
    }
}