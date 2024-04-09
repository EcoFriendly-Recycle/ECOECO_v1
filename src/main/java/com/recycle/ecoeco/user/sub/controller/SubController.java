package com.recycle.ecoeco.user.sub.controller;

import com.recycle.ecoeco.user.sub.service.SubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user/sub")
public class SubController {
    private final SubService subService;

    @Autowired
    public SubController(SubService subService) {
        this.subService = subService;
    }

    @GetMapping("/story")
    public void registStory(){
        System.out.println("story");
    }

}
