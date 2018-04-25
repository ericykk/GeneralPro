package com.eric.general.service.impl;


import com.eric.general.dao.VoteUserPoMapper;
import com.eric.general.model.VoteUserPO;
import com.eric.general.service.IVoteService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 描述:
 *
 * @author eric
 * @create 2018-04-25 下午3:15
 */
@Service
public class VoteServiceImpl implements IVoteService {

    @Resource
    private VoteUserPoMapper voteUserPoMapper;

    @Override
    public List<VoteUserPO> getAllVoteUser() {
        return voteUserPoMapper.getAllVoteUserPO();
    }
}
