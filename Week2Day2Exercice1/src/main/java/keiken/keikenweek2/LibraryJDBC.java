package keiken.keikenweek2;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class LibraryJDBC {
    private Connection conn;

    // Constructor
    public LibraryJDBC() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:8889/library";
            String username = "Test";
            String password = "test";
            conn = DriverManager.getConnection(url, username, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    // Book management methods
    public void addBook(Book book) throws SQLException {
        String sql = "INSERT INTO Book (title, author, publisher, publication_date, isbn , genre,availability) VALUES (?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, book.getTitle());
        pstmt.setString(2, book.getAuthor());
        pstmt.setString(3, book.getPublisher());
        pstmt.setDate(4, new java.sql.Date(book.getPublicationDate().getTime()));
        pstmt.setString(5, book.getISBN());
        pstmt.setString(6, book.getGenre());
        pstmt.setBoolean(7, book.isAvailable());
        pstmt.executeUpdate();
    }
    public Book getBookById(int id) throws SQLException {
        String sql = "SELECT * FROM Book WHERE id = ?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, id);
        ResultSet rs = pstmt.executeQuery();
        if (rs.next()) {
            Book book = new Book(rs.getInt("id"), rs.getString("title"), rs.getString("author"), rs.getString("publisher"), rs.getDate("publication_date"), rs.getString("ISBN"),rs.getString("genre"));
            return book;
        }
        return null;
    }
    public void removeBook(Book book) throws SQLException {
        String sql = "DELETE FROM Book WHERE id = ?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, book.getId());
        pstmt.executeUpdate();
    }

    public void updateBookAvailability(Book book, boolean isAvailable) throws SQLException {
        String sql = "UPDATE Book SET availability = ? WHERE id = ?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setBoolean(1, isAvailable);
        pstmt.setInt(2, book.getId());
        pstmt.executeUpdate();
    }

    // User management methods
    public void addUser(User user) throws SQLException {
        String sql = "INSERT INTO User (name,address,email, phone) VALUES (?, ?, ?, ?)";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, user.getName());
        pstmt.setString(2, user.getAddress());
        pstmt.setString(3, user.getEmail());
        pstmt.setString(4, user.getPhone());
        pstmt.executeUpdate();
    }
    public User getUserById(int id) throws SQLException {
        String sql = "SELECT * FROM User WHERE id = ?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, id);
        ResultSet rs = pstmt.executeQuery();
        if (rs.next()) {
            User user = new User(rs.getInt("id"), rs.getString("name"), rs.getString("address"),rs.getString("email"), rs.getString("phone"));
            return user;
        }
        return null;
    }
    public void removeUser(User user) throws SQLException {
        String sql = "DELETE FROM User WHERE id = ?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, user.getID());
        pstmt.executeUpdate();
    }

    // Transaction management methods

    public Transaction getTransactionById(int id) throws SQLException {
        String sql = "SELECT * FROM Transaction WHERE id = ?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, id);
        ResultSet rs = pstmt.executeQuery();
        if (rs.next()) {
            Book book = getBookById(rs.getInt("book_id"));
            User user = getUserById(rs.getInt("user_id"));
            Transaction transaction = new Transaction(rs.getInt("id"), book, user, rs.getDate("checkout_date").toLocalDate(), rs.getDate("due_date").toLocalDate());
            transaction.setReturnDate(rs.getDate("return_date").toLocalDate());
            transaction.setFineAmount(rs.getDouble("fine_amount"));
            return transaction;
        }
        return null;
    }
    public void checkoutBook(Book book, User user, LocalDate checkoutDate, LocalDate dueDate, LocalDate return_date, float fine_amount,ArrayList<Transaction> transactions) throws SQLException {
        String sql = "INSERT INTO Transaction (book_id, user_id, checkout_date, due_date,return_date,fine_amount) VALUES (?, ?, ?, ?, ?, ?)";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, book.getId());
        pstmt.setInt(2, user.getID());
        pstmt.setDate(3, java.sql.Date.valueOf(checkoutDate));
        pstmt.setDate(4, java.sql.Date.valueOf(dueDate));
        pstmt.setDate(5, java.sql.Date.valueOf(return_date));
        pstmt.setDouble(6, fine_amount);
        pstmt.executeUpdate();
        book.setAvailable(false);
        user.addTransaction(new Transaction(transactions.size() + 1, book, user, checkoutDate, dueDate));
    }

    public void returnBook(Transaction transaction, LocalDate returnDate, double fineAmount) throws SQLException {
        String sql = "UPDATE Transaction SET return_date = ?, fine_amount = ? WHERE id = ?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setDate(1, java.sql.Date.valueOf(returnDate));
        pstmt.setDouble(2, fineAmount);
        pstmt.setInt(3, transaction.getId());
        pstmt.executeUpdate();
        transaction.setReturnDate(returnDate);
        transaction.setFineAmount(fineAmount);
        transaction.getBook().setAvailable(true);
    }
}

