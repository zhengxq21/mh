package com.java.mh.repository;

import com.java.mh.entity.TypeInfo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 漫画类型详情repository
 */
public interface TypeInfoRepository extends JpaRepository<TypeInfo,Integer> {

}
