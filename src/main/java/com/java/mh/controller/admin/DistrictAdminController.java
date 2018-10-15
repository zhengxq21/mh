package com.java.mh.controller.admin;

import com.java.mh.entity.District;
import com.java.mh.service.DistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/district")
public class DistrictAdminController {

    @Autowired
    private DistrictService districtService;

    @RequestMapping("/getDistricts")
    public List<District> getDistricts(){
        return districtService.getDistrict();
    }

}
