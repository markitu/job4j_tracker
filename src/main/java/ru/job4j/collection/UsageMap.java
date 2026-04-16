package ru.job4j.collection;

import java.util.HashMap;

public class UsageMap {

    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("admin@mail.ru", "admin");
        map.put("manager@mail.ru", "manager");
        map.put("user@mail.ru", "user");
        map.put("user@mail.ru", "newUser");

        for (String key : map.keySet()) {
            String value = map.get(key);
            System.out.println(key + " = " + value);
        }

    }
}