package com.example.restaurantB.model;

public class TableStatus {
    private Long id;
    private int tableNumber;
    private boolean isAvailable;

    public TableStatus() {}

    public TableStatus(Long id, int tableNumber, boolean isAvailable) {
        this.id = id;
        this.tableNumber = tableNumber;
        this.isAvailable = isAvailable;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getTableNumber() {
        return tableNumber;
    }

    public void setTableNumber(int tableNumber) {
        this.tableNumber = tableNumber;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }
}
