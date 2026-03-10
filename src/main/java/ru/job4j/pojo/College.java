package ru.job4j.pojo;

import java.time.LocalDate;

public class College {

    public static void main(String[] args) {
        Student student = new Student();
        student.setFio("Mashkov Igor Andreevich");
        student.setGroup("Chemistry");
        student.setReceiptDate(LocalDate.now());

        System.out.println("Student fio is: " + student.getFio());
        System.out.println("Student group is: " + student.getGroup());
        System.out.println("Student receipt date is: " + student.getReceiptDate());
    }
}