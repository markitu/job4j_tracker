package ru.job4j.tracker;

import org.junit.jupiter.api.Test;
import ru.job4j.tracker.item.Item;
import ru.job4j.tracker.item.ItemAscByName;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ItemAscByNameTest {
    @Test
    void compareItemAscByName() {
        List<Item> items = new ArrayList<>();
        List<Item> expected = new ArrayList<>();
        items.add(new Item("Zahar"));
        items.add(new Item("Nikolay"));
        items.add(new Item("Anatoliy"));
        items.add(new Item("Igor"));
        expected.add(new Item("Anatoliy"));
        expected.add(new Item("Igor"));
        expected.add(new Item("Nikolay"));
        expected.add(new Item("Zahar"));
        items.sort(new ItemAscByName());
        assertThat(items).isEqualTo(expected);
    }
}