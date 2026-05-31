package org.example;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        OrderManager orderManager = new OrderManager(new ArrayList<>());

        try{
            System.out.println("Customer name: ");
            String customerName = scanner.nextLine();
            System.out.println("Customer surname: ");
            String customerSurname = scanner.nextLine();
            System.out.println("Customer email: ");
            String customerEmail = scanner.nextLine();
            Customer customer = new Customer(customerName,customerSurname, customerEmail);

            List<OrderItem> orderItems = new ArrayList<>();
            System.out.println("Product name: ");
            String productName = scanner.nextLine();
            System.out.println("Product price: ");
            double productPrice = Double.parseDouble(scanner.nextLine());
            Product product = new Product(productName,productPrice);

            System.out.println("Product quantity: ");
            int quantity = Integer.parseInt(scanner.nextLine());

            OrderItem item = new OrderItem(product,quantity);
            orderItems.add(item);

            Order order = new Order(LocalDate.now(),customer,orderItems);
            orderManager.addOrder(order);

            System.out.println("Order has been created");

            System.out.println("Total price of all products: " + orderManager.getTotalValueOfAllOrders());
            System.out.println("Average price of all products: " + orderManager.getAverageValueOfAllOrders());

            Product bestseller = orderManager.getBestsellerProduct();
            if(bestseller != null) {
                System.out.println("Best product: " + bestseller.getName());
            }

            orderManager.exportCSV("Orders.csv");

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        scanner.close();
    }
}
