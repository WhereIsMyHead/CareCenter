package com.czr.customer.model;

import java.util.Date;

public class Bed {
    private Integer id;

    private Date createTime;

    private Integer createBy;

    private Date updateTime;

    private Integer updateBy;

    private Integer isDeleted;

    private String roomNumber;

    private String bedStatus;//0 空闲 1 有人 2 外出 3 退住

    private String positionType;

    private String name;//床号

    private Integer sort;

    public Bed(){}

    public Bed(Bed bed){

		id = null == bed.getId()? null : bed.getId();
		roomNumber = bed.getRoomNumber().equals("")? null : bed.getRoomNumber();
		bedStatus = bed.getBedStatus().equals("")? null : bed.getBedStatus();
		positionType = bed.getPositionType().equals("")? null : bed.getPositionType();
		name = bed.getName().equals("")? null : bed.getName();
		sort = null == bed.getSort()? null : bed.getSort();
	}

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

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber == null ? null : roomNumber.trim();
    }

    public String getBedStatus() {
        return bedStatus;
    }

    public void setBedStatus(String bedStatus) {
        this.bedStatus = bedStatus == null ? null : bedStatus.trim();
    }

    public String getPositionType() {
        return positionType;
    }

    public void setPositionType(String positionType) {
        this.positionType = positionType == null ? null : positionType.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

	@Override
	public String toString() {
		return "Bed{" +
				"id=" + id +
				", createTime=" + createTime +
				", createBy=" + createBy +
				", updateTime=" + updateTime +
				", updateBy=" + updateBy +
				", isDeleted=" + isDeleted +
				", roomNumber='" + roomNumber + '\'' +
				", bedStatus='" + bedStatus + '\'' +
				", positionType='" + positionType + '\'' +
				", name='" + name + '\'' +
				", sort=" + sort +
				'}';
	}
}