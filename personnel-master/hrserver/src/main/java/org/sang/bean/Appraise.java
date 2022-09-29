package org.sang.bean;

import java.util.Date;

public class Appraise {
    private Long id;
    private Long eid;
    private String name;
    private Date appDate;
    private int appResult;
    private String appContent;
    private String remark;

    public Appraise() {
    }

    public Appraise(Long id, Long eid, String name, Date appDate, int appResult, String appContent, String remark) {
        this.id = id;
        this.eid = eid;
        this.name = name;
        this.appDate = appDate;
        this.appResult = appResult;
        this.appContent = appContent;
        this.remark = remark;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getEid() {
        return eid;
    }

    public void setEid(Long eid) {
        this.eid = eid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getAppDate() {
        return appDate;
    }

    public void setAppDate(Date appDate) {
        this.appDate = appDate;
    }

    public int getAppResult() {
        return appResult;
    }

    public void setAppResult(int appResult) {
        this.appResult = appResult;
    }

    public String getAppContent() {
        return appContent;
    }

    public void setAppContent(String appContent) {
        this.appContent = appContent;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
