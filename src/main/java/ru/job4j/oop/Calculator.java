package ru.job4j.oop;

public class Calculator {
    private static int x = 5;

    public static int sum(int y) {
        return x + y;
    }

    public int multiply(int a) {
        return x * a;
    }

    public static int minus(int z) {
        return z - x;
    }

    public int divide(int b) {
        return b / x;
    }

    public int sumAllOperation(int c) {
        return sum(c) + minus(c) + divide(c) + multiply(c);
    }

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        System.out.println(calculator.multiply(5));
        System.out.println(sum(100));
        System.out.println(minus(99));
        System.out.println(calculator.divide(50));
        System.out.println(calculator.sumAllOperation(25));
    }
}