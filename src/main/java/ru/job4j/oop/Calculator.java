package ru.job4j.oop;

public class Calculator {

    private static int x = 5;

    public static int sum(int y) {
        return x + y;
    }

    public int multiply(int y) {
        return x * y;
    }

    public static int minus(int y) {
        return y - x;
    }

    public int divide(int y) {
        return y / x;
    }

    public int sumAllOperation(int y) {
        return sum(y) + multiply(y) + minus(y) + divide(y);
    }

    public static void main(String[] args) {
        System.out.println("Sum result: " + Calculator.sum(10));
        System.out.println("Multiply result: " + new Calculator().multiply(20));
        System.out.println("Minus result: " + Calculator.minus(30));
        System.out.println("Divide result: " + new Calculator().divide(11));
        System.out.println("Summary result: " + new Calculator().sumAllOperation(50));
    }
}