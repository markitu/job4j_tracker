package ru.job4j.pojo;

public class Library {

    public static void main(String[] args) {
        Book firstBook = new Book("Clean code", 128);
        Book secondBook = new Book("Book 2", 256);
        Book thirdBook = new Book("Book 3", 512);
        Book fourthBook = new Book("Book 4", 1024);

        Book[] books = new Book[4];
        books[0] = firstBook;
        books[1] = secondBook;
        books[2] = thirdBook;
        books[3] = fourthBook;

        for (int i = 0; i < books.length; i++) {
            System.out.println(books[i].getName() + " - " + books[i].getPages() + " pages.");
        }

        Book tempBook = books[0];
        books[0] = books[3];
        books[3] = tempBook;
        System.out.println("Replace position 0 with 3");

        for (Book book : books) {
            System.out.println(book.getName() + " - " + book.getPages() + " pages.");
        }

        System.out.println("Show books with name 'Clean code'");
        for (int i = 0; i < books.length; i++) {
            if ("Clean code".equals(books[i].getName())) {
                System.out.println(books[i].getName() + " - " + books[i].getPages() + " pages.");
            }

        }
    }
}