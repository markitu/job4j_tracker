package ru.job4j.pojo;

import java.util.Date;

public class College {
    public static void main(String[] args) {
        Student student = new Student();
        student.setFullName("Ivanov Ivan Ivanovich");
        student.setGroup("Geodeziya i kartografiya");
        student.setStartDate(new Date());

        System.out.println(student.getFullName() + " zachislen v gruppu "
        + student.getGroup() + " " + student.getStartDate());
    }
}