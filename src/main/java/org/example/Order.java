package org.example;

import java.time.LocalDate;
import java.util.List;

public class Order {
    private LocalDate localDate;
    private Customer customer;
    private List<OrderItem> items;

    public Order(LocalDate localDate, Customer customer, List<OrderItem> items) {
        this.localDate = localDate;
        this.customer = customer;
        this.items = items;
    }

    public LocalDate getLocalDate() {
        return localDate;
    }

    public Customer getCustomer() {
        return customer;
    }

    public List<OrderItem> getItems() {
        return items;
    }

    public double getOrderTotal() {
        double total = 0;
        for (OrderItem item : items) {
            total += item.getTotalPrice();
        }
        return total;
    }
}
