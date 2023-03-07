package keiken.keikenweek2;

import java.util.ArrayList;

public class User {
    private int ID;
    private String name;
    private String address;
    private String email;
    private String phone;
    private ArrayList<Transaction> borrowingHistory;

    // Constructor
    public User( int ID, String name, String address, String email, String phone) {
        this.ID = ID;
        this.name = name;
        this.address = address;
        this.email = email;
        this.phone = phone;
        this.borrowingHistory = new ArrayList<Transaction>();
    }

    // Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public ArrayList<Transaction> getBorrowingHistory() {
        return borrowingHistory;
    }

    public void setBorrowingHistory(ArrayList<Transaction> borrowingHistory) {
        this.borrowingHistory = borrowingHistory;
    }

    public void addTransaction(Transaction transaction) {
        borrowingHistory.add(transaction);
    }
}

