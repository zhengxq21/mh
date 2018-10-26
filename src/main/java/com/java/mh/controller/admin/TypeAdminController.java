package com.java.mh.controller.admin;

import com.java.mh.entity.Type;
import com.java.mh.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/admin/type")
public class TypeAdminController {

    @Autowired
    private TypeService typeService;

    @RequestMapping("getTypes")
    public List<Type> getTypes(){
        return typeService.getTypes();
    }

    @RequestMapping("/list")
    public Map<String,Object> list(@RequestParam(value = "page",required = true)Integer page
            ,@RequestParam(value = "rows",required = true)Integer rows)throws Exception{
        List<Type> types = typeService.list(page-1,rows);
        long total = typeService.count();
        Map<String,Object> result = new HashMap<String,Object>();
        result.put("rows",types);
        result.put("total",total);
        return result;
    }

    @RequestMapping("/save")
    public Map<String,Object> save(Type type)throws  Exception{
        typeService.save(type);
        Map<String,Object> result = new HashMap<String,Object>();
        result.put("success",true);
        return result;
    }

    @RequestMapping("/delete")
    public Map<String,Object> delete(@RequestParam(value = "ids",required = true)String ids)throws Exception{
        String[] idsStr = ids.split(",");
        for (int i=0;i<idsStr.length;i++){
            typeService.delete(Integer.parseInt(idsStr[i]));
        }
        Map<String,Object> result = new HashMap<String,Object>();
        result.put("success",true);
        return result;
    }

}
