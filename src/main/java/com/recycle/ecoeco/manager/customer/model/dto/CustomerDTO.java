package com.recycle.ecoeco.manager.customer.model.dto;

import java.util.Date;

public class CustomerDTO implements java.io.Serializable{
    private int userNo;
    private String userId;
    private String userPwd;
    private String userName;
    private String userPnum;
    private String userEmail;
    private int userBirth;
    private char userGender;
    private String userGrade;
    private int userPoint;
    private Date userDate;
    private int userAccount;
    private String userAddress;
    private char managerYN;

    public CustomerDTO(){

    }

    public CustomerDTO(int userNo, String userId, String userPwd, String userName, String userPnum, String userEmail, int userBirth, char userGender, String userGrade, int userPoint, Date userDate, int userAccount, String userAddress, char managerYN) {
        this.userNo = userNo;
        this.userId = userId;
        this.userPwd = userPwd;
        this.userName = userName;
        this.userPnum = userPnum;
        this.userEmail = userEmail;
        this.userBirth = userBirth;
        this.userGender = userGender;
        this.userGrade = userGrade;
        this.userPoint = userPoint;
        this.userDate = userDate;
        this.userAccount = userAccount;
        this.userAddress = userAddress;
        this.managerYN = managerYN;
    }

    public int getUserNo() {
        return userNo;
    }

    public void setUserNo(int userNo) {
        this.userNo = userNo;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPnum() {
        return userPnum;
    }

    public void setUserPnum(String userPnum) {
        this.userPnum = userPnum;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public int getUserBirth() {
        return userBirth;
    }

    public void setUserBirth(int userBirth) {
        this.userBirth = userBirth;
    }

    public char getUserGender() {
        return userGender;
    }

    public void setUserGender(char userGender) {
        this.userGender = userGender;
    }

    public String getUserGrade() {
        return userGrade;
    }

    public void setUserGrade(String userGrade) {
        this.userGrade = userGrade;
    }

    public int getUserPoint() {
        return userPoint;
    }

    public void setUserPoint(int userPoint) {
        this.userPoint = userPoint;
    }

    public Date getUserDate() {
        return userDate;
    }

    public void setUserDate(Date userDate) {
        this.userDate = userDate;
    }

    public int getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(int userAccount) {
        this.userAccount = userAccount;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    public char getManagerYN() {
        return managerYN;
    }

    public void setManagerYN(char managerYN) {
        this.managerYN = managerYN;
    }

    @Override
    public String toString() {
        return "CustomerDTO{" +
                "userNo=" + userNo +
                ", userId='" + userId + '\'' +
                ", userPwd='" + userPwd + '\'' +
                ", userName='" + userName + '\'' +
                ", userPnum='" + userPnum + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", userBirth=" + userBirth +
                ", userGender=" + userGender +
                ", userGrade='" + userGrade + '\'' +
                ", userPoint=" + userPoint +
                ", userDate=" + userDate +
                ", userAccount=" + userAccount +
                ", userAddress='" + userAddress + '\'' +
                ", managerYN=" + managerYN +
                '}';
    }
}
