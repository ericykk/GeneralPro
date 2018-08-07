package com.eric.general.model;

import lombok.Data;

import java.util.Date;

/**
 * Description:日志操作信息类
 *
 * @author: Eric
 * @Date: 18/8/7
 */
@Data
public class OperateLogInfo {
    private Long id;

    private String operateName;

    private Long operateUid;

    private String fromIp;

    private String requestMethod;

    private String requestUri;

    private String logType;

    private String operateDesc;

    private String visitMethod;

    private String costTime;

    private Date createTime;

    private Date updateTime;

    private Byte status;

    private String visitMethodErrorInfo;
}