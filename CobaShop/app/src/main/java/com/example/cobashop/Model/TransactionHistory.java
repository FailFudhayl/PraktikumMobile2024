package com.example.cobashop.Model;

public class TransactionHistory {
    private int id;
    private String title;
    private String image;
    private String transactionDate;
    private int quantity;
    private double totalPrice;

    // Constructor
    public TransactionHistory(int id, String title, String image, String transactionDate, int quantity, double totalPrice) {
        this.id = id;
        this.title = title;
        this.image = image;
        this.transactionDate = transactionDate;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(String transactionDate) {
        this.transactionDate = transactionDate;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
}

