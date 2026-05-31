package org.example;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrderManagerTest {

    @Test
    void getTotalValueOfAllOrders() throws Exception {
        Customer customer = new Customer("Adam", "Krátký", "adam.kratky@gmail.com");
        Product product1 = new Product("Kalhoty", 1000);
        Product product2 = new Product("Šaty", 4000);
        OrderItem item1 = new OrderItem(product1,2);
        OrderItem item2 = new OrderItem(product2,2);
        Order order = new Order(
                LocalDate.now(),
                customer,
                List.of(item1, item2)
        );
        OrderManager orderManager = new OrderManager(new ArrayList<>());
        orderManager.addOrder(order);

        assertEquals(10000, orderManager.getTotalValueOfAllOrders());
    }

    @Test
    void getAverageValueOfAllOrders() throws Exception {
        Customer customer = new Customer("Eva", "Dlouhá", "eva.dlouha@gmail.com");
        Product product = new Product("Šála", 100);
        Order order1 = new Order(
                LocalDate.now(),
                customer,
                List.of(new OrderItem(product, 2))
        );

        Order order2 = new Order(
                LocalDate.now(),
                customer,
                List.of(new OrderItem(product, 4))
        );
        OrderManager orderManager = new OrderManager(new ArrayList<>());
        orderManager.addOrder(order1);
        orderManager.addOrder(order2);

        assertEquals(300, orderManager.getAverageValueOfAllOrders());
    }

    @Test
    void getBestsellerProduct() throws Exception {
        Customer customer = new Customer("Petr", "Velký", "petr@email.com");

        Product scarf = new Product("Šála", 300);
        Product shoes = new Product("Boty", 1400);

        Order order1 = new Order(
                LocalDate.now(),
                customer,
                List.of(
                        new OrderItem(scarf, 10),
                        new OrderItem(shoes, 1)
                )
        );
        Order order2 = new Order(
                LocalDate.now(),
                customer,
                List.of(
                        new OrderItem(scarf, 5),
                        new OrderItem(shoes, 2)
                )
        );

        OrderManager orderManager = new OrderManager(new ArrayList<>());
        orderManager.addOrder(order1);
        orderManager.addOrder(order2);

        assertEquals(scarf, orderManager.getBestsellerProduct());
    }

}