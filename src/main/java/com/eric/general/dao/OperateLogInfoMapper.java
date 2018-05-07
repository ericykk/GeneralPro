package com.eric.general.dao;

import com.eric.general.model.OperateLogInfo;

public interface OperateLogInfoMapper {
    int deleteByPrimaryKey(Long id);

    int insert(OperateLogInfo record);

    int insertSelective(OperateLogInfo record);

    OperateLogInfo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(OperateLogInfo record);

    int updateByPrimaryKey(OperateLogInfo record);
}