package com.czr.customer.model;

import java.util.Date;
public class Food {

    private Integer id;

    private String create_by;

    private Date create_date;

    private String update_by;

    private Date update_date;

    private String remarks;

    private Integer del_flag;

    private String name;

    private Integer type;

    private Integer tag;

    private float price;

    private String picture;

    private Integer momal_flag;

    private Integer mon_flag;

    private Integer tue_flag;

    private Integer wed_flag;

    private Integer thu_flag;

    private Integer fri_flag;

    private Integer sat_flag;

    private Integer sun_flag;

    private Integer supply_type;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getTag() {
        return tag;
    }

    public void setTag(Integer tag) {
        this.tag = tag;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public Integer getMomal_flag() {
        return momal_flag;
    }

    public void setMomal_flag(Integer momal_flag) {
        this.momal_flag = momal_flag;
    }

    public Integer getMon_flag() {
        return mon_flag;
    }

    public void setMon_flag(Integer mon_flag) {
        this.mon_flag = mon_flag;
    }

    public Integer getTue_flag() {
        return tue_flag;
    }

    public void setTue_flag(Integer tue_flag) {
        this.tue_flag = tue_flag;
    }

    public Integer getWed_flag() {
        return wed_flag;
    }

    public void setWed_flag(Integer wed_flag) {
        this.wed_flag = wed_flag;
    }

    public Integer getThu_flag() {
        return thu_flag;
    }

    public void setThu_flag(Integer thu_flag) {
        this.thu_flag = thu_flag;
    }

    public Integer getFri_flag() {
        return fri_flag;
    }

    public void setFri_flag(Integer fri_flag) {
        this.fri_flag = fri_flag;
    }

    public Integer getSat_flag() {
        return sat_flag;
    }

    public void setSat_flag(Integer sat_flag) {
        this.sat_flag = sat_flag;
    }

    public Integer getSun_flag() {
        return sun_flag;
    }

    public void setSun_flag(Integer sun_flag) {
        this.sun_flag = sun_flag;
    }

    public Integer getSupply_type() {
        return supply_type;
    }

    public void setSupply_type(Integer supply_type) {
        this.supply_type = supply_type;
    }

    @Override
    public String toString() {
        return "Food{" +
                "id=" + id +
                ", create_by='" + create_by + '\'' +
                ", create_date=" + create_date +
                ", update_by='" + update_by + '\'' +
                ", update_date=" + update_date +
                ", remarks='" + remarks + '\'' +
                ", del_flag=" + del_flag +
                ", name='" + name + '\'' +
                ", type=" + type +
                ", tag=" + tag +
                ", price=" + price +
                ", picture='" + picture + '\'' +
                ", momal_flag=" + momal_flag +
                ", mon_flag=" + mon_flag +
                ", tus_flag=" + tue_flag +
                ", wed_flag=" + wed_flag +
                ", thu_flag=" + thu_flag +
                ", fri_flag=" + fri_flag +
                ", sat_flag=" + sat_flag +
                ", sun_flag=" + sun_flag +
                ", supply_type=" + supply_type +
                '}';
    }
}
