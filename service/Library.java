package service;

import model.Book;
import model.User;
import java.util.*;

public class Library {
    private Map<Integer, Book> books = new HashMap<>();
    private Map<Integer, User> users = new HashMap<>();

    public void addBook(Book book) {
        books.put(book.getId(), book);
    }

    public void addUser(User user) {
        users.put(user.getId(), user);
    }

    public void showBooks() {
        books.values().forEach(System.out::println);
    }

    public void borrowBook(int bookId, int userId) {
        Book book = books.get(bookId);
        if (book != null && book.isAvailable()) {
            book.borrowBook();
            System.out.println(users.get(userId).getName() + " borrowed " + book.getTitle());
        } else {
            System.out.println("Book not available!");
        }
    }

    public void returnBook(int bookId, int userId) {
        Book book = books.get(bookId);
        if (book != null && !book.isAvailable()) {
            book.returnBook();
            System.out.println(users.get(userId).getName() + " returned " + book.getTitle());
        } else {
            System.out.println("Invalid return!");
        }
    }

    public void searchBook(String keyword) {
        books.values().stream()
                .filter(b -> b.getTitle().toLowerCase().contains(keyword.toLowerCase())
                        || b.getAuthor().toLowerCase().contains(keyword.toLowerCase()))
                .forEach(System.out::println);
    }
}
