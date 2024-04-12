package com.recycle.ecoeco.user.mypage.controller;

import com.recycle.ecoeco.user.mypage.model.dto.UserInfoDTO;
import com.recycle.ecoeco.user.mypage.service.MyPageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Slf4j
@Controller
@RequestMapping("user/mypage")
public class MyPageController {

    private final MyPageService myPageService;

    @Autowired
    public MyPageController(MyPageService myPageService) {
        this.myPageService = myPageService;
    }

    /* 로그인 페이지 이동 */
    @GetMapping("/login")
    public void loginPage() {}

    /* 회원가입 페이지 이동 */
    @GetMapping("/joinus")
    public void joinusPage() {}

    /* 아이디 중복 체크 : 비동기 통신
     * ResponseEntity : 사용자의 HttpRequest에 대한 응답 데이터를 포함하는 클래스
     * (HttpStatus, HttpHeaders, HttpBody 를 포함한다)
     * 규약에 맞는 HttpResponse를 반환하는데 사용 목적이 있다.
     */
    @PostMapping("/idDupCheck")
    public ResponseEntity<String> checkDuplication(@RequestBody UserInfoDTO user) {

        log.info("Request Check ID : {}", user.getUserId());

        String result ="사용가능한 아이디 입니다.";

        if(myPageService.selectUserById(user.getUserId())) {
            result = "중복 된 아이디 입니다.";
        }
        return ResponseEntity.ok(result);
    }

    @PostMapping("/joinus")
    public String joinus(UserInfoDTO user) {
        myPageService.joinus(user);
        return "redirect:/login";
    }



    /* 아이디 비밀번호 찾기 선택 페이지 이동 */
    @GetMapping("/findSearchInfo")
    public void findSearchInfoPage() {}

    /* 아이디 찾기 페이지 이동 */
    @GetMapping("/findId")
    public void findIdPage() {}

    /* 비밀번호 찾기 페이지 이동 */
    @GetMapping("/findPwd")
    public void findPwdPage() {}

    /* 마이페이지 이동 메일화면 이동 */
    @GetMapping("/mypageMain")
    public void mypageMainPage() {}

    /* 서포터 나의 프로젝트 이동 */
    @GetMapping("/mypage_MyProject")
    public void mypage_MyProjectPage() {}

    /* 후원한 프로젝트 이동 */
    @GetMapping("/mypage_SupportProject")
    public void mypage_SupportProjectPage() {}

    /* 후원한 프로젝트 상세보기 이동 */
    @GetMapping("/mypage_SupportProject_Detail")
    public void mypage_SupportProject_DetailPage() {}

    /* 내정보 이동 */
    @GetMapping("/mypage_CheckMyInfo")
    public void mypage_CheckMyInfoPage() {}

    /* 메이커 페이지 이동 */
    @GetMapping("/mypageMain_Maker")
    public void mypageMain_MakerPage() {}

    /* 메이커 나의 프로젝트 이동 */
    @GetMapping("/mypage_MyprojectList")
    public void mypage_MyprojectListPage() {}

    /* 메이커 나의 프로젝트 상세화면 이동 */
    @GetMapping("/mypage_MyprojectList_Detail")
    public void mypage_MyprojectList_DetailPage() {}

    /* 메이커 나의 프로젝트 상세페이지 결제현황 이동 */
    @GetMapping("/payment_Status")
    public void payment_StatusPage() {}

    /* 메이커 나의 프로젝트 상세페이지 정산정보 이동 */
    @GetMapping("/settlement_Info")
    public void settlement_InfoPage() {}

    /* 메이커 나의 프로젝트 상세페이지 정산정보 -> 정산내역 이동 */
    @GetMapping("/settlement_Info_Details")
    public void settlement_Info_DetailsPage() {}

    /* 메이커 나의 프로젝트 상세페이지 새소식 이동 */
    @GetMapping("/news")
    public void newsPage() {}

    /* 새소식 등록 페이지 이동 */
    @GetMapping("/registNews")
    public void registNewsPage() {}

    /* 새소식 조회 페이지 이동 */
    @GetMapping("/registNewsDetail")
    public void registNewsDetailPage() {}
}
