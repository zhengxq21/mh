package com.java.mh.service;

import com.java.mh.entity.Type;
import com.java.mh.entity.TypeInfo;

import java.util.List;

/**
 * 漫画类型详情service
 */
public interface TypeInfoService {
    int saveTypeInfos(String[] types, Integer cartoonId);

    List<TypeInfo> findTypeInfoByCartoonId(Integer cartoonId);
}
