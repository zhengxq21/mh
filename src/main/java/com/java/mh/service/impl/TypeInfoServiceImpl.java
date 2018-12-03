package com.java.mh.service.impl;

import com.java.mh.entity.Type;
import com.java.mh.entity.TypeInfo;
import com.java.mh.repository.TypeInfoRepository;
import com.java.mh.run.StartupRunner;
import com.java.mh.service.TypeInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class TypeInfoServiceImpl implements TypeInfoService {
    @Autowired
    private TypeInfoRepository typeInfoRepository;

    @Resource
    private StartupRunner startupRunner;

    @Override
    public int saveTypeInfos(String[] types, Integer cartoonId) {
        List<TypeInfo> typeInfoList = new ArrayList<TypeInfo>();
        for (int i=0;i<types.length;i++){
            TypeInfo typeInfo = new TypeInfo();
            typeInfo.setCartoonId(cartoonId);
            typeInfo.setTypeId(Integer.parseInt(types[i]));
            typeInfoList.add(typeInfo);
        }

        typeInfoRepository.saveAll(typeInfoList);
        startupRunner.loadData();
        return 0;
    }

    @Override
    public List<TypeInfo> findTypeInfoByCartoonId(Integer cartoonId) {
        return typeInfoRepository.findByCartoonId(cartoonId);
    }
}
