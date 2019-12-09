package com.czr.customer.model;

import java.util.Date;

public class Outgoing {
    private Integer id;

    private Integer customerId;

    private Date createTime;

    private Integer createBy;

    private Date updateTime;

    private Integer updateBy;

    private Integer isDeleted;

    private String outgoingReason;

    private Date outgoingTime;

    private Date expectedReturnTime;

    private Date actualReturnTime;

    private String escorted;

    private String relation;

    private String escortedTel;

    private String auditStatus;

    private String auditPerson;

    private Date auditTine;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getCreateBy() {
        return createBy;
    }

    public void setCreateBy(Integer createBy) {
        this.createBy = createBy;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(Integer updateBy) {
        this.updateBy = updateBy;
    }

    public Integer getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Integer isDeleted) {
        this.isDeleted = isDeleted;
    }

    public String getOutgoingReason() {
        return outgoingReason;
    }

    public void setOutgoingReason(String outgoingReason) {
        this.outgoingReason = outgoingReason == null ? null : outgoingReason.trim();
    }

    public Date getOutgoingTime() {
        return outgoingTime;
    }

    public void setOutgoingTime(Date outgoingTime) {
        this.outgoingTime = outgoingTime;
    }

    public Date getExpectedReturnTime() {
        return expectedReturnTime;
    }

    public void setExpectedReturnTime(Date expectedReturnTime) {
        this.expectedReturnTime = expectedReturnTime;
    }

    public Date getActualReturnTime() {
        return actualReturnTime;
    }

    public void setActualReturnTime(Date actualReturnTime) {
        this.actualReturnTime = actualReturnTime;
    }

    public String getEscorted() {
        return escorted;
    }

    public void setEscorted(String escorted) {
        this.escorted = escorted == null ? null : escorted.trim();
    }

    public String getRelation() {
        return relation;
    }

    public void setRelation(String relation) {
        this.relation = relation == null ? null : relation.trim();
    }

    public String getEscortedTel() {
        return escortedTel;
    }

    public void setEscortedTel(String escortedTel) {
        this.escortedTel = escortedTel == null ? null : escortedTel.trim();
    }

    public String getAuditStatus() {
        return auditStatus;
    }

    public void setAuditStatus(String auditStatus) {
        this.auditStatus = auditStatus == null ? null : auditStatus.trim();
    }

    public String getAuditPerson() {
        return auditPerson;
    }

    public void setAuditPerson(String auditPerson) {
        this.auditPerson = auditPerson == null ? null : auditPerson.trim();
    }

    public Date getAuditTine() {
        return auditTine;
    }

    public void setAuditTine(Date auditTine) {
        this.auditTine = auditTine;
    }

    @Override
    public String toString() {
        return "Outgoing{" +
                "id=" + id +
                ", customerId=" + customerId +
                ", createTime=" + createTime +
                ", createBy=" + createBy +
                ", updateTime=" + updateTime +
                ", updateBy=" + updateBy +
                ", isDeleted=" + isDeleted +
                ", outgoingReason='" + outgoingReason + '\'' +
                ", outgoingTime=" + outgoingTime +
                ", expectedReturnTime=" + expectedReturnTime +
                ", actualReturnTime=" + actualReturnTime +
                ", escorted='" + escorted + '\'' +
                ", relation='" + relation + '\'' +
                ", escortedTel='" + escortedTel + '\'' +
                ", auditStatus='" + auditStatus + '\'' +
                ", auditPerson='" + auditPerson + '\'' +
                ", auditTine=" + auditTine +
                '}';
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }
}