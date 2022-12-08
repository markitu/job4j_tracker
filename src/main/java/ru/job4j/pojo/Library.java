package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book cleanCode = new Book("Clean code", 244);
        Book badCode = new Book("Bad code", 444);
        Book goodCode = new Book("Good code", 123);
        Book learningJava = new Book("Learning Java", 100500);
        Book[] books = new Book[4];
        books[0] = cleanCode;
        books[1] = badCode;
        books[2] = goodCode;
        books[3] = learningJava;
        for (int index = 0; index < books.length; index++) {
            Book book = books[index];
            System.out.println(book.getName() + " - " + book.getPages() + " pages.");
        }
        Book temp = books[0];
        books[0] = books[3];
        books[3] = temp;
        for (Book book : books) {
            System.out.println(book.getName() + " - " + book.getPages() + " pages.");
        }
        for (Book book : books) {
            if ("Clean code".equals(book.getName())) {
                System.out.println(book.getName());
            }
        }
    }
}