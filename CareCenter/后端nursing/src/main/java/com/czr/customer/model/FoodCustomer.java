package com.czr.customer.model;

import java.util.Date;

public class FoodCustomer {
    private Integer id;

    private String create_by;

    private Date create_date;

    private String update_by;

    private Date update_date;

    private String customer_name;

    private String bed_id;

    private String room_number;

    private String taste;

    private String attention;

    private String remarks;

    private Integer del_flag;

    private String customer_id;

    private Integer customer_sex;

    private Integer customer_age;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBed_id() {
        return bed_id;
    }

    public void setBed_id(String bed_id) {
        this.bed_id = bed_id;
    }

    public String getRoom_number() {
        return room_number;
    }

    public void setRoom_number(String room_number) {
        this.room_number = room_number;
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

    public String getTaste() {
        return taste;
    }

    public void setTaste(String taste) {
        this.taste = taste;
    }

    public String getAttention() {
        return attention;
    }

    public void setAttention(String attention) {
        this.attention = attention;
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

    public String getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(String customer_id) {
        this.customer_id = customer_id;
    }

    public String getCustomer_name() {
        return customer_name;
    }

    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }

    public Integer getCustomer_sex() {
        return customer_sex;
    }

    public void setCustomer_sex(Integer customer_sex) {
        this.customer_sex = customer_sex;
    }

    public Integer getCustomer_age() {
        return customer_age;
    }

    public void setCustomer_age(Integer customer_age) {
        this.customer_age = customer_age;
    }

    @Override
    public String toString() {
        return "FoodCustomer{" +
                "id=" + id +
                ", create_by='" + create_by + '\'' +
                ", create_date=" + create_date +
                ", update_by='" + update_by + '\'' +
                ", update_date=" + update_date +
                ", customer_name='" + customer_name + '\'' +
                ", bed_id='" + bed_id + '\'' +
                ", room_number='" + room_number + '\'' +
                ", taste='" + taste + '\'' +
                ", attention='" + attention + '\'' +
                ", remarks='" + remarks + '\'' +
                ", del_flag=" + del_flag +
                ", customer_id='" + customer_id + '\'' +
                ", customer_sex=" + customer_sex +
                ", customer_age=" + customer_age +
                '}';
    }
}
