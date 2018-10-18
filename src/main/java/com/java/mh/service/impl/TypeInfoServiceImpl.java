package com.java.mh.service.impl;

import com.java.mh.entity.Type;
import com.java.mh.entity.TypeInfo;
import com.java.mh.repository.TypeInfoRepository;
import com.java.mh.service.TypeInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TypeInfoServiceImpl implements TypeInfoService {
    @Autowired
    private TypeInfoRepository typeInfoRepository;

    @Override
    public int saveTypeInfos(List<Type> typeList, Integer cartoonId) {
        List<TypeInfo> typeInfoList = new ArrayList<TypeInfo>();
        for (Type type: typeList) {
            TypeInfo typeInfo = new TypeInfo();
            typeInfo.setCartoonId(cartoonId);
            typeInfo.setTypeId(type.getId());
        }
        typeInfoRepository.saveAll(typeInfoList);
        return 0;
    }
}
