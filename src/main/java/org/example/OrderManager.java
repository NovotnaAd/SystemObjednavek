package org.example;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderManager {
    private List<Order> orders;

    public OrderManager(List<Order> orders) {
        this.orders = orders;
    }

    public void addOrder(Order order) {
        orders.add(order);
    }

    public double getTotalValueOfAllOrders() {
        double total = 0;
        for (Order order : orders) {
            total += order.getOrderTotal();
        }
        return total;
    }

    public double getAverageValueOfAllOrders() {
        if (orders.isEmpty()) {
        return 0;
        }
        return getTotalValueOfAllOrders() / orders.size();
    }

    public Product getBestsellerProduct() {
        if (orders.isEmpty()) {
            return null;
        }
        Map<Product, Integer> productSales = new HashMap<>();

        for (Order order : orders) {
            for (OrderItem item : order.getItems()) {
                Product product = item.getProduct();
                int quantity =  item.getQuantity();

                productSales.put(product, productSales.getOrDefault(product, 0) + quantity);
            }
        }
        Product bestseller = null;
        int maxQuantity = 0;
        for (Map.Entry<Product, Integer> entry : productSales.entrySet()) {
            if (entry.getValue() > maxQuantity){
                maxQuantity = entry.getValue();
                bestseller = entry.getKey();
            }
        }
        return bestseller;
    }
    public void exportCSV(String fileName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {

            writer.write("customer_name, customer_surename, total_price, date");
            writer.newLine();

            for (Order order : orders) {
                writer.write(order.getCustomer().getName() + " " + order.getCustomer().getSurname() + " " + order.getOrderTotal() + " " + order.getLocalDate());

                writer.newLine();
            }
            System.out.println("CSV file was exported as: " + fileName);
        }
        catch (IOException e) {
            System.out.println("Error writing to CSV file: " + e.getMessage());
        }
    }

}
