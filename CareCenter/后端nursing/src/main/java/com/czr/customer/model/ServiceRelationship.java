package com.czr.customer.model;

import java.util.Date;

public class ServiceRelationship {
    private Integer id;

    private Integer customerId;

    private Integer nurseId;

    private Integer doctorId;

    private Integer careWorkerId;

    private Integer isDeleted;

    private Date createTime;

    private Integer createBy;

    private Date updateTime;

    private Integer updateBy;

    public ServiceRelationship(){}

    public ServiceRelationship(ServiceRelationship serviceRelationship){
		id = serviceRelationship.getId() == null? null : serviceRelationship.getId();
		customerId = null == serviceRelationship.getCustomerId()? null : serviceRelationship.getCustomerId();
		nurseId = null == serviceRelationship.getNurseId()? null : serviceRelationship.getNurseId();
		doctorId = null == serviceRelationship.getDoctorId()? null : serviceRelationship.getDoctorId();
		careWorkerId = null == serviceRelationship.getCareWorkerId()? null : serviceRelationship.getCareWorkerId();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public Integer getNurseId() {
        return nurseId;
    }

    public void setNurseId(Integer nurseId) {
        this.nurseId = nurseId;
    }

    public Integer getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Integer doctorId) {
        this.doctorId = doctorId;
    }

    public Integer getCareWorkerId() {
        return careWorkerId;
    }

    public void setCareWorkerId(Integer careWorkerId) {
        this.careWorkerId = careWorkerId;
    }

    public Integer getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Integer isDeleted) {
        this.isDeleted = isDeleted;
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

    @Override
    public String toString() {
        return "ServiceRelationship{" +
                "id=" + id +
                ", customerId=" + customerId +
                ", nurseId=" + nurseId +
                ", doctorId=" + doctorId +
                ", careWorkerId=" + careWorkerId +
                ", isDeleted=" + isDeleted +
                ", createTime=" + createTime +
                ", createBy=" + createBy +
                ", updateTime=" + updateTime +
                ", updateBy=" + updateBy +
                '}';
    }
}