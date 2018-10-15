package com.java.mh.controller.admin;

import com.java.mh.entity.Type;
import com.java.mh.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/type")
public class TypeAdminController {

    @Autowired
    private TypeService typeService;

    @RequestMapping("getTypes")
    public List<Type> getTypes(){
        return typeService.getTypes();

    }

}
