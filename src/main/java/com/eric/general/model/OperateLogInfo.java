package com.eric.general.model;

import java.util.Date;

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOperateName() {
        return operateName;
    }

    public void setOperateName(String operateName) {
        this.operateName = operateName == null ? null : operateName.trim();
    }

    public Long getOperateUid() {
        return operateUid;
    }

    public void setOperateUid(Long operateUid) {
        this.operateUid = operateUid;
    }

    public String getFromIp() {
        return fromIp;
    }

    public void setFromIp(String fromIp) {
        this.fromIp = fromIp == null ? null : fromIp.trim();
    }

    public String getRequestMethod() {
        return requestMethod;
    }

    public void setRequestMethod(String requestMethod) {
        this.requestMethod = requestMethod == null ? null : requestMethod.trim();
    }

    public String getRequestUri() {
        return requestUri;
    }

    public void setRequestUri(String requestUri) {
        this.requestUri = requestUri == null ? null : requestUri.trim();
    }

    public String getLogType() {
        return logType;
    }

    public void setLogType(String logType) {
        this.logType = logType == null ? null : logType.trim();
    }

    public String getOperateDesc() {
        return operateDesc;
    }

    public void setOperateDesc(String operateDesc) {
        this.operateDesc = operateDesc == null ? null : operateDesc.trim();
    }

    public String getVisitMethod() {
        return visitMethod;
    }

    public void setVisitMethod(String visitMethod) {
        this.visitMethod = visitMethod == null ? null : visitMethod.trim();
    }

    public String getCostTime() {
        return costTime;
    }

    public void setCostTime(String costTime) {
        this.costTime = costTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public String getVisitMethodErrorInfo() {
        return visitMethodErrorInfo;
    }

    public void setVisitMethodErrorInfo(String visitMethodErrorInfo) {
        this.visitMethodErrorInfo = visitMethodErrorInfo == null ? null : visitMethodErrorInfo.trim();
    }
}