package org.souayrioss.visionarycroftingspringmvc.web;

import org.souayrioss.visionarycroftingspringmvc.Repository.OrderRepository;
import org.souayrioss.visionarycroftingspringmvc.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderRepository orderRepository;

    @PostMapping("/save")
    public Order saveOrder(@RequestBody Order order){
        System.out.println(order);
        return order;
    }
    @GetMapping("/")
    public Order getAll(){
        return new Order();
    }
}
