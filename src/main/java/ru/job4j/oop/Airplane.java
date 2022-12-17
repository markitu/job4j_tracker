package ru.job4j.oop;

public class Airplane implements Vehicle {
    @Override
    public void move() {
        System.out.println("Самолёт летит по небу.");
    }

    @Override
    public void seats() {
        System.out.println("На борту самолёта 240 мест");
    }
}