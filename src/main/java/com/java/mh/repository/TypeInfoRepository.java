package com.java.mh.repository;

import com.java.mh.entity.TypeInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * 漫画类型详情repository
 */
public interface TypeInfoRepository extends JpaRepository<TypeInfo,Integer> {
    List<TypeInfo> findByCartoonId(Integer cartoonId);
}
