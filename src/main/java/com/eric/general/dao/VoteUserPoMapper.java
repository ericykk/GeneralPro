package com.eric.general.dao;

import com.eric.general.model.VoteUserPO;

import java.util.List;

public interface VoteUserPoMapper {
    int deleteByPrimaryKey(Long id);

    int insert(VoteUserPO record);

    int insertSelective(VoteUserPO record);

    VoteUserPO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(VoteUserPO record);

    int updateByPrimaryKey(VoteUserPO record);

    List<VoteUserPO> getAllVoteUserPO();
}