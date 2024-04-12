package com.recycle.ecoeco.user.main.controller;

import com.recycle.ecoeco.user.main.service.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user/main")
public class MainPageController {

    private final MainService mainService;

    @Autowired
    public MainPageController(MainService mainService) {
        this.mainService = mainService;
    }


    @GetMapping("/crowdfundingPage")
    public void crowdfundingPage() {
        System.out.println("crowdfundingPage");
    }

    @GetMapping("/deliveryInfoInputPage")
    public void deliveryInfoInputPage() {
        System.out.println("deliveryInfoInputPage");
    }

    @GetMapping("/faqDetailsPage")
    public void faqDetailsPage() {
        System.out.println("faqDetailsPage");
    }

    @GetMapping("/faqPage")
    public void faqPage() {
        System.out.println("faqPage");
    }

    @GetMapping("/integratedSearchResultsPage")
    public void integratedSearchResultsPage() {
        System.out.println("integratedSearchResultsPage");
    }

    @GetMapping("/kakaoPayCompletePage")
    public void kakaoPayCompletePage() {
        System.out.println("kakaoPayCompletePage");
    }

    @GetMapping("/kakaoPayPage")
    public void kakaoPayPage() {
        System.out.println("kakaoPayPage");
    }

    @GetMapping("/makerFaq")
    public void makerFaqPage() {
        System.out.println("makerFaq");
    }

    @GetMapping("/notice")
    public void noticePage() {
        System.out.println("notice");
    }

    @GetMapping("/noticeClickDetailPage")
    public void noticeClickDetailPage() {
        System.out.println("noticeClickDetailPage");
    }

    @GetMapping("/popularProject")
    public void popularProject() {
        System.out.println("popularProject");
    }

    @GetMapping("/prepaymentCompletePage")
    public void prepaymentCompletePage() {
        System.out.println("prepaymentCompletePage");
    }

    @GetMapping("/prepaymentPage")
    public void prepaymentPage() {
        System.out.println("prepaymentPage");
    }

    @GetMapping("/supporterFaq")
    public void supporterFaq() {
        System.out.println("supporterFaq");
    }

    @GetMapping("/usGreenWriteDetailAndComment")
    public void usGreenWriteDetailAndComment() {
        System.out.println("usGreenWriteDetailAndComment");
    }

    @GetMapping("/usGreenWritePage")
    public void usGreenWritePage() {
        System.out.println("usGreenWritePage");
    }

    @GetMapping("/usGreenWritingPage")
    public void usGreenWritingPage() {
        System.out.println("usGreenWritingPage");
    }


}