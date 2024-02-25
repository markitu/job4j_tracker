package ru.job4j.tracker;

import org.junit.jupiter.api.Test;
import ru.job4j.tracker.item.Item;
import ru.job4j.tracker.item.ItemDescByName;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ItemDescByNameTest {
    @Test
    void compareItemDescByName() {
        List<Item> items = new ArrayList<>();
        List<Item> expected = new ArrayList<>();
        items.add(new Item("Zahar"));
        items.add(new Item("Nikolay"));
        items.add(new Item("Anatoliy"));
        items.add(new Item("Igor"));
        expected.add(new Item("Zahar"));
        expected.add(new Item("Nikolay"));
        expected.add(new Item("Igor"));
        expected.add(new Item("Anatoliy"));
        items.sort(new ItemDescByName());
        assertThat(items).isEqualTo(expected);
    }
}