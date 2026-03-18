package ru.job4j.cast;

public class VehicleExample {
    public static void main(String[] args) {
        Vehicle bus = new Bus();
        Vehicle train = new Train();
        Vehicle airplane = new Airplane();

        Vehicle[] vehicles = new Vehicle[]{bus, train, airplane};
        for (Vehicle object : vehicles) {
            object.move();
        }
    }
}