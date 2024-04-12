package com.recycle.ecoeco.manager.payment.controller;

import com.recycle.ecoeco.manager.payment.service.CalulateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/manager/ordertab/calculate")
public class CalulateController {

    private final CalulateService calulateService;

    @Autowired
    public CalulateController(CalulateService calulateService){
        this.calulateService = calulateService;
    }

    @GetMapping("/calculate_list")
    public void findCalculateList(){
        System.out.println("calculate_list");
    }

    @GetMapping("/calculate_info")
    public void calculate_info(){
        System.out.println("calculate_info");
    }
}
