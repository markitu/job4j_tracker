package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;

public class Tracker {
    private final List<Item> items = new ArrayList<>();
    private int ids = 1;
    private int size = 0;

    public Item add(Item item) {
        item.setId(ids++);
        items.add(size++, item);
        return item;
    }

    public Item findById(int id) {
        int index = indexOf(id);
        return index != -1 ? items.get(index) : null;
    }

    public List<Item> findAll() {
        return items;
    }

    public List<Item> findByName(String key) {
        List<Item> result = new ArrayList<>();
        int count = 0;
        for (int i = 0; i < size; i++) {
            if (findAll().get(i).getName().equals(key)) {
                result.add(count, findAll().get(i));
                count++;
            }
        }
        return result;
    }

    private int indexOf(int id) {
        int rsl = -1;
        for (int index = 0; index < size; index++) {
            if (items.get(index).getId() == id) {
                rsl = index;
                break;
            }
        }
        return rsl;
    }

    public boolean replace(int id, Item item) {
        int index = indexOf(id);
        boolean rls = index != -1;
        if (rls) {
            item.setId(id);
            items.remove(index);
            items.add(item);
        }
        return rls;
    }

    public boolean delete(int id) {
        int index = indexOf(id);
        boolean rls = index != -1;
        if (rls) {
            items.remove(index);
            size--;
        }
        return rls;
    }
}