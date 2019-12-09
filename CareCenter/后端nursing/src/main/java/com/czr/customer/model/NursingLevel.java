package com.czr.customer.model;

import java.util.Date;

public class NursingLevel {

    private Integer id;

    private String create_by;

    private Date create_date;

    private String update_by;

    private Date update_date;

    private String content;

    private String remarks;

    private Integer del_flag;

    private String level_name;

    private Integer level_status;

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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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

    public String getLevel_name() {
        return level_name;
    }

    public void setLevel_name(String level_name) {
        this.level_name = level_name;
    }

    public Integer getLevel_status() {
        return level_status;
    }

    public void setLevel_status(Integer level_status) {
        this.level_status = level_status;
    }

    @Override
    public String toString() {
        return "NursingLevel{" +
                "id=" + id +
                ", create_by='" + create_by + '\'' +
                ", create_date=" + create_date +
                ", update_by='" + update_by + '\'' +
                ", update_date=" + update_date +
                ", content='" + content + '\'' +
                ", remarks='" + remarks + '\'' +
                ", del_flag=" + del_flag +
                ", level_name='" + level_name + '\'' +
                ", level_status=" + level_status +
                '}';
    }
}
