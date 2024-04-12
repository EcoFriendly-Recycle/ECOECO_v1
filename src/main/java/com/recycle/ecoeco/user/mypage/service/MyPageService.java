package com.recycle.ecoeco.user.mypage.service;

import com.recycle.ecoeco.user.mypage.model.dao.MypageMapper;
import com.recycle.ecoeco.user.mypage.model.dto.UserInfoDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class MyPageService {

    private final MypageMapper mypageMapper;

    public MyPageService(MypageMapper mypageMapper) {
        this.mypageMapper = mypageMapper;
    }

    public boolean selectUserById(String userId) {

        String result = mypageMapper.selectUserById(userId);

        return result != null;
    }

    /* 회원 가입시 가입일 넣어주는 메소드 */
    SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd");
    Date date = new Date();
    String localTime = format.format(date);


    public void joinus(UserInfoDTO user) {

        String result = mypageMapper.joinus(user);

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        user.setUserPwd(passwordEncoder.encode(user.getUserPwd()));

    }
}
