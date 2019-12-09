package com.czr.customer.VO;

import java.util.Date;

public class WorkerVO {

    private String customerName;

    private String doctorName;

    private String nurseName;

    private String careWorkerName;

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

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public String getNurseName() {
        return nurseName;
    }

    public void setNurseName(String nurseName) {
        this.nurseName = nurseName;
    }

    public String getCareWorkerName() {
        return careWorkerName;
    }

    public void setCareWorkerName(String careWorkerName) {
        this.careWorkerName = careWorkerName;
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
        return "WorkerVO{" +
                "customerName='" + customerName + '\'' +
                ", doctorName='" + doctorName + '\'' +
                ", nurseName='" + nurseName + '\'' +
                ", careWorkerName='" + careWorkerName + '\'' +
                ", id=" + id +
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
