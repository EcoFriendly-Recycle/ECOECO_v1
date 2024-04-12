package com.recycle.ecoeco.user.sub.controller;

import com.recycle.ecoeco.user.sub.service.SubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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

    @GetMapping("/reward/reward")
    public void reward(){}
    @GetMapping("/maker/maker")
    public void maker(){}

    @GetMapping("/projectInfo/projectInfo")
    public void projectInfo(){

    }

    @GetMapping("/story/story")
    public void Story(){}

    @GetMapping("/terms/terms")
    public void terms(){

    }

    
    @GetMapping("/detail/detail")
    public void detail(){}

//    임시 매핑입니다 추후 연결 예정입니다
    @GetMapping("/detail/detail-news")
    public void detailNews(){}

    @GetMapping("/detail/detail-refund")
    public void detailRefund(){}

    @GetMapping("/detail/detail-review")
    public void detailReview(){}

    @GetMapping("/detail/detail-reward")
    public void detailReward(){}
}
