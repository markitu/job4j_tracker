package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;

public class Tracker {
    private final Item[] items = new Item[100];
    private int ids = 1;
    private int size = 0;

    public Item add(Item item) {
        item.setId(ids++);
        items[size++] = item;
        return item;
    }

    public Item findById(int id) {
        Item rsl = null;
        for (int index = 0; index < size; index++) {
            Item item = items[index];
            if (item.getId() == id) {
                rsl = item;
                break;
            }
        }
        return rsl;
    }

    public Item[] findAll() {
        List<Item> result = new ArrayList<>();
        for (Item item : items) {
            if (item != null) {
                result.add(item);
            }
        }
        return result.toArray(new Item[0]);
    }

    public Item[] findByName(String name) {
        List<Item> result = new ArrayList<>();
        for (Item item : items) {
            if (item != null && name.equals(item.getName())) {
                result.add(item);
            }
        }
        return result.toArray(new Item[0]);
    }
}