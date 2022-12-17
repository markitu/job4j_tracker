package ru.job4j.oop;

public class Train implements Vehicle {
    @Override
    public void move() {
        System.out.println("Поезд едет по рельсам в Москву");
    }

    @Override
    public void seats() {
        System.out.println("В поезде 324 места");
    }
}