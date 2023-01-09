package ru.job4j.collection;

import java.util.HashMap;

public class UsageMap {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("admin@mail.ru", "Ivanov Ivan Ivanovich");
        map.put("moderator@mail.ru", "Petrov Petr Petrovich");
        map.put("support@mail.ru", "Sidorova Daria Petrovna");
        for (String key : map.keySet()) {
            String value = map.get(key);
            System.out.println(key + " " + value);
        }
    }
}