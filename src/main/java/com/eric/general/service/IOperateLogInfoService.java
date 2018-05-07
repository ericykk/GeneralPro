package com.eric.general.service;

import com.eric.general.model.OperateLogInfo;

/**
 * 描述:
 * 日志服务类
 *
 * @author eric
 * @create 2018-05-07 下午4:32
 */
public interface IOperateLogInfoService {
    /**
     * 保存日志记录
     *
     * @param operateLogInfo
     * @return
     */
    int insertOperateLog(OperateLogInfo operateLogInfo);

    /**
     * 更新操作日志
     *
     * @param operateLogInfo
     * @return
     */
    int updateOperateLog(OperateLogInfo operateLogInfo);
}
