package com.java.mh.service.impl;

import com.java.mh.entity.Type;
import com.java.mh.entity.TypeInfo;
import com.java.mh.repository.TypeRepository;
import com.java.mh.service.TypeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service("typeService")
public class TypeServiceImpl implements TypeService {

    @Resource
    private TypeRepository typeRepository;

    @Override
    public List<Type> getTypes() {
        return typeRepository.findAll();
    }



}
