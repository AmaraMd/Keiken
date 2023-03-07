package keiken.keikenweek2;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        LibraryJDBC libraryJDBC = new LibraryJDBC();

        Date publicationDate = null;
        try {
            publicationDate = new SimpleDateFormat("yyyy").parse("1925");
        } catch (ParseException e) {
            e.printStackTrace();
        }

        try {
            // Create and add a new book
            Book book1 = new Book(1, "The Great Gatsby", "F. Scott Fitzgerald", "Scribner", publicationDate, "ISBN1234567890", "Fiction");
            libraryJDBC.addBook(book1);

            // Update the availability of a book
            Book bookToUpdate = libraryJDBC.getBookById(13); // assuming there is a book with id = 1 in the database
            libraryJDBC.updateBookAvailability(bookToUpdate, false);

            // Add a new user
            User newUser = new User(1,"Name", "adress","Email", "Phone");
            libraryJDBC.addUser(newUser);

            // Remove a user
           /* User userToRemove = libraryJDBC.getUserById(2); // assuming there is a user with id = 1 in the database
            libraryJDBC.removeUser(userToRemove);*/

            // Checkout a book
            Book bookToCheckout = libraryJDBC.getBookById(14); // assuming there is a book with id = 2 in the database
            User userToCheckout = libraryJDBC.getUserById(2); // assuming there is a user with id = 2 in the database
            LocalDate checkoutDate = LocalDate.now();
            LocalDate dueDate = checkoutDate.plusDays(14); // assuming the due date is 2 weeks after checkout date
            ArrayList<Transaction> transactions = new ArrayList<>();
            LocalDate returnDate1 = LocalDate.of(2023,04,24);
            libraryJDBC.checkoutBook(bookToCheckout, userToCheckout, checkoutDate, dueDate, returnDate1,200,transactions);

            // Return a book
            Transaction transactionToReturn = libraryJDBC.getTransactionById(3); // assuming there is a transaction with id = 1 in the database
            LocalDate returnDate = LocalDate.now();
            double fineAmount = 0.0; // assuming no fine is imposed
            libraryJDBC.returnBook(transactionToReturn, returnDate, fineAmount);

            // Remove a book
            Book bookToRemove = libraryJDBC.getBookById(13); // assuming there is a book with id = 3 in the database
            libraryJDBC.removeBook(bookToRemove);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}




