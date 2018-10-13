package com.java.mh.repository;

import com.java.mh.entity.District;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 动漫发行地区repository
 */
public interface DistrictRepository extends JpaRepository<District,Integer> {
}
