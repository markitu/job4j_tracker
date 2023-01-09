package ru.job4j.queue;

import java.util.Queue;

public class AppleStore {
    private final Queue<Customer> queue;
    private final int count;

    public AppleStore(Queue<Customer> queue, int count) {
        this.queue = queue;
        this.count = count;
    }

    public String getLastHappyCustomer() {
        String s = "";
        for (int i = 1; i < count; i++) {
            queue.poll();
        }
        if (queue.size() != 0) {
            s = queue.poll().name();
        }
        return s;
    }

    public String getLastUpsetCustomer() {
        String s = "";
        for (int i = 1; i <= count; i++) {
            queue.poll();
        }
        if (queue.size() != 0) {
            s = queue.poll().name();
        }
        return s;
    }
}