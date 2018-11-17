package com.java.mh.controller.admin;

import com.java.mh.entity.TypeInfo;
import com.java.mh.service.TypeInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/admin/typeInfo")
public class TypeInfoAdminController {
    @Autowired
    private TypeInfoService typeInfoService;
    @RequestMapping("/findByCartoonId")
    public List<TypeInfo> findByCartoonId(@RequestParam(value = "cartoonId",required = true)Integer cartoonId)throws Exception{
        return typeInfoService.findTypeInfoByCartoonId(cartoonId);
    }

}
