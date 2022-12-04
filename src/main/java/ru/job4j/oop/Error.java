package ru.job4j.oop;

public class Error {
    private boolean active;
    private int status;
    private String message;

    public Error() {
    }

    public Error(boolean active, int status, String message) {
        this.active = active;
        this.status = status;
        this.message = message;
    }

    public static void main(String[] args) {
        Error error = new Error();
        error.status = 100;
        error.active = true;
        error.message = "Hello, World!";
        error.printInfo();
        Error error1 = new Error(false, 99, "This one is not active!");
        error1.printInfo();
        Error error2 = new Error(true, 1, "This one is active!");
        error2.printInfo();
    }

    public void printInfo() {
        System.out.println("Статус: " + status);
        System.out.println("Активность: " + active);
        System.out.println("Сообщение: " + message);
    }
}