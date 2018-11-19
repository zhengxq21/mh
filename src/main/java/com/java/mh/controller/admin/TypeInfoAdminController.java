package com.java.mh.controller.admin;

import com.java.mh.entity.TypeInfo;
import com.java.mh.service.TypeInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/admin/typeInfo")
public class TypeInfoAdminController {
    @Autowired
    private TypeInfoService tyypeInfoService;
    @RequestMapping("/findByCartoonId")
    public List<TypeInfo> findByCartoonId(@RequestParam(value = "cartoonId",required = true)Integer cartoonId)throws Exception{
        return tyypeInfoService.findTypeInfoByCartoonId(cartoonId);
    }

    @RequestMapping("/saveTypeInfos")
    public Map<String,Object> saveTypeInfo(@RequestParam(value = "ids")String ids
            ,@RequestParam(value = "cartoonId",required = true)Integer cartoonId)throws Exception{
        String []idsStr = ids.split(",");
        tyypeInfoService.saveTypeInfos(idsStr,cartoonId);
        Map<String,Object> resultMap = new HashMap<String,Object>();
        resultMap.put("success",true);
        return resultMap;
    }

}
