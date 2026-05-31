package org.example;

public class OrderItem {
    private Product product;
    private int quantity;

    public OrderItem(Product product, int quantity) throws NegativeValueException {
        if (quantity <= 0) {throw new NegativeValueException("Quantity cannot be 0 nor negative");}
        this.product = product;
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }
    public double getTotalPrice() {
        return product.getPrice() * quantity;
    }
}
