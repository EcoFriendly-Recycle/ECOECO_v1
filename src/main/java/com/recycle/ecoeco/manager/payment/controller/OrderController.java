package com.recycle.ecoeco.manager.payment.controller;

import com.recycle.ecoeco.manager.payment.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/manager/ordertab/order")
public class OrderController {

    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService){
        this.orderService = orderService;
    }

    @GetMapping("/order_list")
    public void findOrderList(){
        System.out.println("order_list");
    }

    @GetMapping("/order_info")
    public void order_info(){
        System.out.println("order_info");
    }
}
