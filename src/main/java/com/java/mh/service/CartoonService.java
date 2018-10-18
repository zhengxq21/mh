package com.java.mh.service;

import com.java.mh.entity.Cartoon;

/**
 * 漫画service接口
 */
public interface CartoonService {
    /**
     * 添加或修改漫画
     */
    public Cartoon save(Cartoon cartoon);
}
