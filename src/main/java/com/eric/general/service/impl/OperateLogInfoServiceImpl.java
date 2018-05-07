package com.eric.general.service.impl;

import com.eric.general.dao.OperateLogInfoMapper;
import com.eric.general.model.OperateLogInfo;
import com.eric.general.service.IOperateLogInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 描述:
 * 操作日志服务
 *
 * @author eric
 * @create 2018-05-07 下午4:34
 */
@Service
public class OperateLogInfoServiceImpl implements IOperateLogInfoService {

    private Logger logger = LoggerFactory.getLogger(OperateLogInfoServiceImpl.class);

    @Resource
    private OperateLogInfoMapper operateLogInfoMapper;

    @Override
    public int insertOperateLog(OperateLogInfo operateLogInfo) {
        return operateLogInfoMapper.insert(operateLogInfo);
    }

    @Override
    public int updateOperateLog(OperateLogInfo operateLogInfo) {
        return operateLogInfoMapper.updateByPrimaryKey(operateLogInfo);
    }
}
