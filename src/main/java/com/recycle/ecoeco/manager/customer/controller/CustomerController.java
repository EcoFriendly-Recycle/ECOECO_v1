package com.recycle.ecoeco.manager.customer.controller;

import com.recycle.ecoeco.manager.customer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/manager/customer")
public class CustomerController {

    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService){
        this.customerService = customerService;
    }

    @GetMapping("/customer_list")
    public void findCustomerList(){
        System.out.println("customer_list");
    }

    @GetMapping("/customer_info")
    public void customer_info(){
        System.out.println("customer_info");
    }



}
