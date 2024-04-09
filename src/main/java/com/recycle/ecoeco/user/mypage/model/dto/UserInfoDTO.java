package com.recycle.ecoeco.user.mypage.model.dto;

import java.util.Date;

public class UserInfoDTO {

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

    public UserInfoDTO () {}

    public UserInfoDTO(int userNo, String userId, String userPwd, String userName, String userEmail, int userBirth, String userGender, int userPoint, Date userDate, int userAccount, String userAddress) {
        this.userNo = userNo;
        this.userId = userId;
        this.userPwd = userPwd;
        this.userName = userName;
        this.userEmail = userEmail;
        this.userBirth = userBirth;
        this.userGender = userGender;
        this.userPoint = userPoint;
        this.userDate = userDate;
        this.userAccount = userAccount;
        this.userAddress = userAddress;
    }

    public void setUserNo(int userNo) {
        this.userNo = userNo;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public void setUserBirth(int userBirth) {
        this.userBirth = userBirth;
    }

    public void setUserGender(String userGender) {
        this.userGender = userGender;
    }

    public void setUserPoint(int userPoint) {
        this.userPoint = userPoint;
    }

    public void setUserDate(Date userDate) {
        this.userDate = userDate;
    }

    public void setUserAccount(int userAccount) {
        this.userAccount = userAccount;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    public int getUserNo() {
        return userNo;
    }

    public String getUserId() {
        return userId;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public int getUserBirth() {
        return userBirth;
    }

    public String getUserGender() {
        return userGender;
    }

    public int getUserPoint() {
        return userPoint;
    }

    public Date getUserDate() {
        return userDate;
    }

    public int getUserAccount() {
        return userAccount;
    }

    public String getUserAddress() {
        return userAddress;
    }

    @Override
    public String toString() {
        return "UserInfoDTO{" +
                "userNo=" + userNo +
                ", userId='" + userId + '\'' +
                ", userPwd='" + userPwd + '\'' +
                ", userName='" + userName + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", userBirth=" + userBirth +
                ", userGender='" + userGender + '\'' +
                ", userPoint=" + userPoint +
                ", userDate=" + userDate +
                ", userAccount=" + userAccount +
                ", userAddress='" + userAddress + '\'' +
                '}';
    }
}
