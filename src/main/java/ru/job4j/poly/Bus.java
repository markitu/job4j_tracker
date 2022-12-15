package ru.job4j.poly;

public class Bus implements Transport {
    @Override
    public void drive() {
        System.out.println("Выезжаем через 5 минут.");
    }

    @Override
    public void passengers(int n) {
        System.out.println("В автобусе находится " + n + " пассажиров.");
    }

    @Override
    public double refill(double fuel) {
        return fuel * 56;
    }
}