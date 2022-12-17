package ru.job4j.oop;

public class Bus implements Vehicle {
    @Override
    public void move() {
        System.out.println("Автобус едет по дороге в Казань");
    }

    @Override
    public void seats() {
        System.out.println("В автобусе 60 мест");
    }
}