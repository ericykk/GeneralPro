package com.eric.general.service.impl;


import com.eric.general.dao.VoteUserPoMapper;
import com.eric.general.model.VoteUserPO;
import com.eric.general.service.IVoteService;
import org.apache.commons.collections.CollectionUtils;
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
    public List<VoteUserPO> getAllVoteUser() throws Exception {
        List<VoteUserPO> voteUserPOList = voteUserPoMapper.getAllVoteUserPO();
        if (CollectionUtils.isEmpty(voteUserPOList)) {
            throw new Exception("投票用户为空！");
        }
        return voteUserPoMapper.getAllVoteUserPO();
    }
}
