package com.czr.customer.model;

import java.util.Date;

public class NursingContent {
    private Integer id;

    private String create_by;

    private Date create_date;

    private String update_by;

    private Date update_date;

    private String remarks;

    private Integer del_flag;

    private String serial_number;

    private String nursing_name;

    private float service_price;

    private String describe;

    private Integer increment_flag;

    private Integer status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCreate_by() {
        return create_by;
    }

    public void setCreate_by(String create_by) {
        this.create_by = create_by;
    }

    public Date getCreate_date() {
        return create_date;
    }

    public void setCreate_date(Date create_date) {
        this.create_date = create_date;
    }

    public String getUpdate_by() {
        return update_by;
    }

    public void setUpdate_by(String update_by) {
        this.update_by = update_by;
    }

    public Date getUpdate_date() {
        return update_date;
    }

    public void setUpdate_date(Date update_date) {
        this.update_date = update_date;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Integer getDel_flag() {
        return del_flag;
    }

    public void setDel_flag(Integer del_flag) {
        this.del_flag = del_flag;
    }

    public String getSerial_number() {
        return serial_number;
    }

    public void setSerial_number(String serial_number) {
        this.serial_number = serial_number;
    }

    public String getNursing_name() {
        return nursing_name;
    }

    public void setNursing_name(String nursing_name) {
        this.nursing_name = nursing_name;
    }

    public float getService_price() {
        return service_price;
    }

    public void setService_price(float service_price) {
        this.service_price = service_price;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public Integer getIncrement_flag() {
        return increment_flag;
    }

    public void setIncrement_flag(Integer increment_flag) {
        this.increment_flag = increment_flag;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "NursingContent{" +
                "id=" + id +
                ", create_by='" + create_by + '\'' +
                ", create_date=" + create_date +
                ", update_by='" + update_by + '\'' +
                ", update_date=" + update_date +
                ", remarks='" + remarks + '\'' +
                ", del_flag=" + del_flag +
                ", serial_number='" + serial_number + '\'' +
                ", nursing_name='" + nursing_name + '\'' +
                ", service_price=" + service_price +
                ", describe='" + describe + '\'' +
                ", increment_flag=" + increment_flag +
                ", status=" + status +
                '}';
    }
}
