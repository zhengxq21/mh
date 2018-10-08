package com.java.mh.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * 漫画发行地区
 */
@Entity(name="t_district")
public class District {
    @Id
    @GeneratedValue
    private Integer id;

    @Column(length = 200)
    private String districtName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDistrictName() {
        return districtName;
    }

    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }
}
