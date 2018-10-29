package com.java.mh.service;

import com.java.mh.entity.Cartoon;

import java.util.List;

/**
 * 漫画service接口
 */
public interface CartoonService {
    /**
     * 添加或修改漫画
     */
    public Cartoon save(Cartoon cartoon);

    public List<Cartoon> list(Cartoon cartoon,Integer page,Integer rows);

    public Integer getCount(Cartoon cartoon);
}
