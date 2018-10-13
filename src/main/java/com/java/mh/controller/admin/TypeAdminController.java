package com.java.mh.controller.admin;

import com.java.mh.entity.Type;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/type")
public class TypeAdminController {

    public List<Type> getTypes(){
        return null;
    }

}
