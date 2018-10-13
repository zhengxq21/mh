package com.java.mh.repository;

import com.java.mh.entity.Cartoon;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 动漫repository接口
 */
public interface CartoonRepository extends JpaRepository<Cartoon,Integer> {
}
