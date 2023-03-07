package keiken.keikenweek2;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;

public class Library {
    private ArrayList<Book> books;
    private ArrayList<User> users;
    private ArrayList<Transaction> transactions;

    // Constructor
    public Library() {
        this.books = new ArrayList<Book>();
        this.users = new ArrayList<User>();
        this.transactions = new ArrayList<Transaction>();
    }

    // Getters and setters
    public ArrayList<Book> getBooks() {
        return books;
    }

    public void setBooks(ArrayList<Book> books) {
        this.books = books;
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public void setUsers(ArrayList<User> users) {
        this.users = users;
    }

    public ArrayList<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(ArrayList<Transaction> transactions) {
        this.transactions = transactions;
    }

    // Book management methods
    public void addBook(Book book) {
        books.add(book);
    }

    public void removeBook(Book book) {
        books.remove(book);
    }

    public void updateBookAvailability(Book book, boolean isAvailable) {
        book.setAvailable(isAvailable);
    }

    // User management methods
    public void addUser(User user) {
        users.add(user);
    }

    public void removeUser(User user) {
        users.remove(user);
    }

    // Transaction management methods
    public void checkoutBook(Book book, User user, LocalDate checkoutDate, LocalDate dueDate) {
        Transaction transaction = new Transaction(transactions.size() + 1, book, user, checkoutDate, dueDate);
        transactions.add(transaction);
        book.setAvailable(false);
        user.addTransaction(transaction);
    }

    public void returnBook(Transaction transaction, LocalDate returnDate, double fineAmount) {
        transaction.setReturnDate(returnDate);
        transaction.setFineAmount(fineAmount);
        transaction.getBook().setAvailable(true);
    }
}

