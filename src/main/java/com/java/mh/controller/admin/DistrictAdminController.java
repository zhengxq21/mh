package com.java.mh.controller.admin;

import com.java.mh.entity.District;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/district")
public class DistrictAdminController {

    @RequestMapping("/getDistricts")
    public List<District> getDistricts(){
        return null;
    }

}
