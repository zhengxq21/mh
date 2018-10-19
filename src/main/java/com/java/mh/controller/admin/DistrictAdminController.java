package com.java.mh.controller.admin;

import com.java.mh.entity.District;
import com.java.mh.service.DistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/district")
public class DistrictAdminController {

    @Autowired
    private DistrictService districtService;

    @RequestMapping("/getDistricts")
    public List<District> getDistricts(){
        return districtService.getDistrict();
    }

    @RequestMapping("/list")
    public Map<String,Object> list(@RequestParam(value = "page",required = false)Integer page
            ,@RequestParam(value = "rows",required = false)Integer rows){
        List<District> districts = districtService.list(page-1,rows);
        Long total = districtService.getCount();
        Map<String,Object> resultMap = new HashMap<String,Object>();
        resultMap.put("rows",districts);
        resultMap.put("total",total);
        return resultMap;
    }

}
