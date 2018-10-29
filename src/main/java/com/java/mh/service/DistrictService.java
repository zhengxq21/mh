   package com.java.mh.service;

import com.java.mh.entity.District;

import java.util.List;

public interface DistrictService {

    public List<District> getDistrict();

    /**
     * 分页查询地区列表
     * @param page
     * @param pageSize
     * @return
     */
    public List<District> list(Integer page,Integer pageSize);

    /**
     * 查询地区总数
     * @return
     */
    public Long getCount();


    public void save(District district);


    public void delete(Integer id);
}
