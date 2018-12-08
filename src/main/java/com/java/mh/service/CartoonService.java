package com.java.mh.service;

import com.java.mh.entity.Cartoon;
import org.springframework.data.domain.Sort;

import java.util.List;

/**
 * 漫画service接口
 */
public interface CartoonService {
    /**
     * 添加或修改漫画
     */
    public Cartoon save(Cartoon cartoon);

    public List<Cartoon> list(Cartoon cartoon,Integer page,Integer rows,Sort sort);

    public long getCount(Cartoon cartoon);

    public void deltete(Integer id);

    public Cartoon findById(Integer id);

    public void updateCartoon(Cartoon cartoon);
}
