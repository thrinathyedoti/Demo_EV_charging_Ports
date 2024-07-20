package project.example.springapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import project.example.springapp.model.Orders;
import project.example.springapp.service.OrderService;

import java.util.List;

@RestController
public class OrderController {

    @Autowired
    OrderService orderService;

    @RequestMapping("addorder/{cusId}")
    public String addOrder(@PathVariable int cusId){
        orderService.orderfromproduct(cusId);
        return "Ordered Successfully :-)";
    }
    @RequestMapping("allorders")
    public List<Orders> allOrders(){
        return orderService.allOrders();
    }

}
