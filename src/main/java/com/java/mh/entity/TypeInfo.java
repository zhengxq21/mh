package com.java.mh.entity;

import org.springframework.stereotype.Controller;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * 漫画所属类型信息
 */
@Entity(name="t_type_info")
public class TypeInfo {
    @Id
    @GeneratedValue
    private Integer id;

    @Column
    private Integer typeId;

    @Column
    private Integer cartoonId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public Integer getCartoonId() {
        return cartoonId;
    }

    public void setCartoonId(Integer cartoonId) {
        this.cartoonId = cartoonId;
    }
}
