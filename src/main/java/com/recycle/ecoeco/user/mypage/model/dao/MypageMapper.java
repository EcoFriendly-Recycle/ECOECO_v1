package com.recycle.ecoeco.user.mypage.model.dao;

import com.recycle.ecoeco.user.mypage.model.dto.UserInfoDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MypageMapper {
    String selectUserById(String userId);

    String joinus(UserInfoDTO user);
}
