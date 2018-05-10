package com.eric.general.service;

import com.eric.general.model.VoteUserPO;

import java.util.List;

/**
 * 描述:
 * ${DESCRIPTION}
 *
 * @author eric
 * @create 2018-04-25 下午3:15
 */
public interface IVoteService {
    List<VoteUserPO> getAllVoteUser() throws Exception;
}
