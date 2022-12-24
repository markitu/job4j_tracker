package ru.job4j.ex;

public class FactRec {
    public static int calc(int n) {
        int result;
        if (n == 0 || n == 1) {
            result = 1;
            return result;
        }
        return calc(n - 1) * n;
    }

    public static void main(String[] args) {
        int rsl = calc(3);
        System.out.println(rsl);
    }
}