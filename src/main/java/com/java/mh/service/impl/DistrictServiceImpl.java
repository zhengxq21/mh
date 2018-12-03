package com.java.mh.service.impl;

import com.java.mh.entity.District;
import com.java.mh.repository.DistrictRepository;
import com.java.mh.run.StartupRunner;
import com.java.mh.service.DistrictService;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("districtService")
public class DistrictServiceImpl implements DistrictService {

    @Resource
    private DistrictRepository districtRepository;

    @Resource
    private StartupRunner startupRunner;

    @Override
    public List<District> getDistrict() {
        return districtRepository.findAll();
    }

    @Override
    public List<District> list(Integer page, Integer pageSize) {
        return districtRepository.findAll(new PageRequest(page,pageSize)).getContent();
    }

    @Override
    public Long getCount() {
        return districtRepository.count();
    }

    @Override
    public void save(District district) {
         districtRepository.save(district);
         startupRunner.loadData();
    }

    @Override
    public void delete(Integer id) {
         districtRepository.deleteById(id);
         startupRunner.loadData();
    }
}
