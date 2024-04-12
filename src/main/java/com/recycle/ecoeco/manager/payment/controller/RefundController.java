package com.recycle.ecoeco.manager.payment.controller;

import com.recycle.ecoeco.manager.payment.service.RefundService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/manager/ordertab/refund")
public class RefundController {

    private final RefundService refundService;

    @Autowired
    public RefundController(RefundService refundService){
        this.refundService = refundService;
    }

    @GetMapping("/refund_list")
    public void findRefundList(){

        System.out.println("refund_list");
    }

    @GetMapping("/refund_info")
    public void refund_info(){
        System.out.println("refund_info");
    }
}
