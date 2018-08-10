package com.eric.general.model;

import lombok.Data;

import java.util.Date;

@Data
public class VoteUserPO {
    private Long id;

    private String userName;

    private Long userNo;

    private Integer voteWeight;

    private Date createAt;

    private String phoneNo;
}