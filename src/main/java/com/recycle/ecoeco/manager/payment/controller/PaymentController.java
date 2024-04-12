package com.recycle.ecoeco.manager.payment.controller;


import com.recycle.ecoeco.manager.payment.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/manager/ordertab/payment")
public class PaymentController {


    private final PaymentService paymentService;

    @Autowired
    public PaymentController(PaymentService paymentService){
        this.paymentService = paymentService;
    }

    @GetMapping("/payment_list")
    public void findPaymentList(){
        System.out.println("payment_list");
    }
    @GetMapping("/payment_info")
    public void payment_info(){
        System.out.println("payment_info");
    }
}
