package ru.job4j.tracker;

public class StartUI {

    public static void main(String[] args) {
        Item item = new Item();
        item.setId(100);
        item.setName("Task #1");

        System.out.println(item);
    }
}