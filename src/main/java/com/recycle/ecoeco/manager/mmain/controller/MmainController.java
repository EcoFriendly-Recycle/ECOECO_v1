package com.recycle.ecoeco.manager.mmain.controller;

import com.recycle.ecoeco.manager.mmain.service.MmainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/manager/mmain")
public class MmainController {

    private final MmainService mmainService;

    @Autowired
    public MmainController(MmainService mmainService){
        this.mmainService = mmainService;
    }

    @GetMapping("/mmain")
    public void findmmain(){
        System.out.println("mmain");
    }

}
