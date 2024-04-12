package com.recycle.ecoeco.user.mypage.model.dto;

import com.recycle.ecoeco.common.UserRole;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Arrays;
import java.util.Collection;
import java.util.Date;

@Getter
@Setter
@ToString
public class UserInfoDTO implements UserDetails {

    private int userNo;
    private String userId;
    private String userPwd;
    private String userName;
    private String userEmail;
    private int userBirth;
    private String userGender;
    private int userPoint;
    private java.util.Date userDate;
    private int userAccount;
    private String userAddress;
    private UserRole managerYN;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        String roleName = "";
        if(managerYN != null) roleName = managerYN.name();
        return Arrays.asList(new SimpleGrantedAuthority(roleName));
    }

    @Override
    public String getPassword() {
        return userPwd;
    }

    @Override
    public String getUsername() {
        return userId;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
