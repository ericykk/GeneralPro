package com.eric.general.model;

import java.util.Date;

public class VoteUserPO {
    private Long id;

    private String userName;

    private Long userNo;

    private Integer voteWeight;

    private Date createAt;

    private String phoneNo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public Long getUserNo() {
        return userNo;
    }

    public void setUserNo(Long userNo) {
        this.userNo = userNo;
    }

    public Integer getVoteWeight() {
        return voteWeight;
    }

    public void setVoteWeight(Integer voteWeight) {
        this.voteWeight = voteWeight;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo == null ? null : phoneNo.trim();
    }
}