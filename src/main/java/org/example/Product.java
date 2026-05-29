package org.example;

public class Product {
    private String name;
    private double price;

    public Product(String name, double price) throws EmptyValueException, ShortNameException, NegativeValueException {
        if (name == null || name.trim().isEmpty()) {
            throw new EmptyValueException("Name cannot be null");
        }
        if (name.length() < 3) {
            throw new ShortNameException("Name must be at least 3 characters");
        }
        if (price < 0) {
            throw new NegativeValueException("Price cannot be negative");
        }
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}
