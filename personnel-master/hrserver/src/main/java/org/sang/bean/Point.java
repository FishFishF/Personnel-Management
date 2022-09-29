package org.sang.bean;

public class Point {
    private Long id;
    private Long eid;
    private String name;
    private int points;

    public Point(Long id, Long eid, String name, int points) {
        this.id = id;
        this.eid = eid;
        this.name = name;
        this.points = points;
    }

    public Point() {
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

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }
}
