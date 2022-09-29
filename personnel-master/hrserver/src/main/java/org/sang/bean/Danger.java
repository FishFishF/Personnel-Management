package org.sang.bean;

public class Danger {
    Long id;
    Long eid;

    public Danger(Long id, Long eid) {
        this.id = id;
        this.eid = eid;
    }

    public Danger() {

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
}
