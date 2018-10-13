package com.java.mh.service.impl;

import com.java.mh.entity.District;
import com.java.mh.repository.DistrictRepository;
import com.java.mh.service.DistrictService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("districtService")
public class DistrictServiceImpl implements DistrictService {

    @Resource
    private DistrictRepository districtRepository;

    @Override
    public List<District> getDistrict() {
        return districtRepository.findAll();
    }
}
