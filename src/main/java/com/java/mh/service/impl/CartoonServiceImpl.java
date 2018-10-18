package com.java.mh.service.impl;

import com.java.mh.entity.Cartoon;
import com.java.mh.repository.CartoonRepository;
import com.java.mh.service.CartoonService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("cartoonService")
public class CartoonServiceImpl implements CartoonService {

    @Resource
    private CartoonRepository cartoonRepository;

    @Override
    public Cartoon save(Cartoon cartoon) {
         return cartoonRepository.save(cartoon);
    }
}
