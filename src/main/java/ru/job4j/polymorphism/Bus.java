package ru.job4j.polymorphism;

public class Bus implements Transport {

    @Override
    public void move() {
        System.out.println("Путь займет 12 минут.");
    }

    @Override
    public void passengers(int count) {
        System.out.println("В автобусе сейчас " + count + " пассажиров.");
    }

    @Override
    public int refuel(int fuel) {
        return 100 - fuel;
    }

}