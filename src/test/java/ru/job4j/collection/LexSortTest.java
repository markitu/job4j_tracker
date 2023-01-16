package ru.job4j.collection;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class LexSortTest {
    @Test
    public void sortNum1and2and10() {
        String[] input = {
                "10. Task.",
                "1. Task.",
                "2. Task."
        };
        String[] out = {
                "1. Task.",
                "2. Task.",
                "10. Task."
        };
        Arrays.sort(input, new LexSort());
        assertThat(input).containsExactly(out);
    }

    @Test
    public void sortNum11and21and24and31() {
        String[] input = {"24. Hey", "21. Privet", "31. Hop", "11. Welcome"};
        String[] out = {"11. Welcome", "21. Privet", "24. Hey", "31. Hop"};
        Arrays.sort(input, new LexSort());
        assertThat(input).containsExactly(out);
    }

}