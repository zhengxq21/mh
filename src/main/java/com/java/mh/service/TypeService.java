package com.java.mh.service;

import com.java.mh.entity.Type;

import java.util.List;

public interface TypeService {
    /**
     * 获得漫画类型表
     * @return
     */
    List<Type> getTypes();

    /**
     * 分页查询漫画类型列表
     * @param page
     * @param pageSize
     * @return
     */
    List<Type> list(Integer page,Integer pageSize);

    /**
     * 查询漫画类型总数
     * @return
     */
    long count();

    /**
     * 保存漫画类型
     * @param type
     */
    void save(Type type);

    /**
     * 删除漫画类型
     * @param id
     */
    void delete(Integer id);

}
