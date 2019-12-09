package com.czr.customer.model;

import java.util.Date;

public class NursingRecord {
    private Integer id;

    private String create_by;

    private Date create_date;

    private String update_by;

    private Date update_date;

    private String remarks;

    private Integer del_flag;

    private String customer_id;

    private String content_id;

    private Date nursing_time;

    private String nursing_content;

    private Integer nursing_count;

    private String staffinfo_id;

    private String nursing_id;

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

    public String getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(String customer_id) {
        this.customer_id = customer_id;
    }

    public String getContent_id() {
        return content_id;
    }

    public void setContent_id(String content_id) {
        this.content_id = content_id;
    }

    public Date getNursing_time() {
        return nursing_time;
    }

    public void setNursing_time(Date nursing_time) {
        this.nursing_time = nursing_time;
    }

    public String getNursing_content() {
        return nursing_content;
    }

    public void setNursing_content(String nursing_content) {
        this.nursing_content = nursing_content;
    }

    public Integer getNursing_count() {
        return nursing_count;
    }

    public void setNursing_count(Integer nursing_count) {
        this.nursing_count = nursing_count;
    }

    public String getStaffinfo_id() {
        return staffinfo_id;
    }

    public void setStaffinfo_id(String staffinfo_id) {
        this.staffinfo_id = staffinfo_id;
    }

    public String getNursing_id() {
        return nursing_id;
    }

    public void setNursing_id(String nursing_id) {
        this.nursing_id = nursing_id;
    }

    @Override
    public String toString() {
        return "NursingRecord{" +
                "id=" + id +
                ", create_by='" + create_by + '\'' +
                ", create_date=" + create_date +
                ", update_by='" + update_by + '\'' +
                ", update_date=" + update_date +
                ", remarks='" + remarks + '\'' +
                ", del_flag=" + del_flag +
                ", customer_id='" + customer_id + '\'' +
                ", content_id='" + content_id + '\'' +
                ", nursing_time=" + nursing_time +
                ", nursing_content='" + nursing_content + '\'' +
                ", nursing_count=" + nursing_count +
                ", staffinfo_id='" + staffinfo_id + '\'' +
                ", nursing_id='" + nursing_id + '\'' +
                '}';
    }
}
