package com.micro.order;

import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private List<Order> orders = new ArrayList<>();

    @GetMapping
    public List<Order> getOrders() {
        return orders;
    }

    @PostMapping
    public Order createOrder(@RequestBody Order order) {
        orders.add(order);
        return order;
    }

    @GetMapping("/{id}")
    public Order getOrderById(@PathVariable Long id) {
        return orders.stream()
                     .filter(o -> o.getId().equals(id))
                     .findFirst()
                     .orElseThrow(() -> new RuntimeException("Order not found"));
    }

    @DeleteMapping("/{id}")
    public String deleteOrder(@PathVariable Long id) {
        orders.removeIf(o -> o.getId().equals(id));
        return "Deleted order with id: " + id;
    }
}
