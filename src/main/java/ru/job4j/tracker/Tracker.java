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
        int index = indexOf(id);
        return index != -1 ? items[index] : null;
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

    public boolean replace(int id, Item item) {
        int index = indexOf(id);
        boolean result = index != -1;
        if (result) {
            item.setId(id);
            items[index] = item;
        }
        return result;
    }

    private int indexOf(int id) {
        int result = -1;
        for (int index = 0; index < size; index++) {
            if (items[index].getId() == id) {
                result = index;
                break;
            }
        }
        return result;
    }
}