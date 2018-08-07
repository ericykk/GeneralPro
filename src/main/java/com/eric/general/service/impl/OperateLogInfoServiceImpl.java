package com.eric.general.service.impl;

import com.eric.general.dao.OperateLogInfoMapper;
import com.eric.general.model.OperateLogInfo;
import com.eric.general.service.IOperateLogInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 描述:
 * 操作日志服务
 *
 * @author eric
 * @create 2018-05-07 下午4:34
 */
@Slf4j
@Service
public class OperateLogInfoServiceImpl implements IOperateLogInfoService {

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
