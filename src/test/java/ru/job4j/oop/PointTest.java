package ru.job4j.oop;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.offset;


class PointTest {

    @Test
    void when0Minus33and313Then5() {
        Point a = new Point(0, -3, 3);
        Point b = new Point(3, 1, 3);
        double expected = 5;
        double rsl = a.distance3d(b);
        assertThat(rsl).isCloseTo(expected, offset(0.001));
    }

    @Test
    void when000and000Then0() {
        Point a = new Point(0, 0, 0);
        Point b = new Point(0, 0, 0);
        double expected = 0;
        double rsl = a.distance3d(b);
        assertThat(rsl).isCloseTo(expected, offset(0.001));
    }
}