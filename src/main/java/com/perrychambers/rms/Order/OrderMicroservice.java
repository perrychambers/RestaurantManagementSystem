package com.perrychambers.rms.Order;

import com.perrychambers.rms.Recipe.Recipe;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/order")
public class OrderMicroservice {
    ArrayList<Order> orders = new ArrayList<Order>();
    String incomingOrder;

    @PostMapping("/new")
    public String newOrder(@RequestParam("orderItem") String name) {
        String orderItem = name;
        System.out.println(orderItem);
        Order newOrder = new Order(orderItem);
        newOrder.setId(orders.size());

        orders.add(newOrder);

        return "New Order created. ";
    }

    @GetMapping("/orders")
    @ResponseBody
    public ArrayList<Order> getOrders() {
        return orders;
    }

    @DeleteMapping("/serve")
    @ResponseBody String serveOrder(@RequestParam("id")String id) {
        int orderID = Integer.parseInt(id);
        orders.remove(orderID);
        return "Order with ID: " + orderID + " has been served.";
    }

}
