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
        Error defaultError = new Error();
        Error badGateway = new Error(true, 502, "Bad gateway");
        Error internalServerError = new Error(false, 500, "Internal server error");
        defaultError.printInfo();
        badGateway.printInfo();
        internalServerError.printInfo();
    }

    public void printInfo() {
        System.out.println("Status: " + status);
        System.out.println("Active: " + active);
        System.out.println("Message: " + message);
    }
}