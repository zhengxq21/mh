package com.java.mh.repository;

import com.java.mh.entity.Cartoon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * 动漫repository接口
 */
public interface CartoonRepository extends JpaRepository<Cartoon,Integer>,JpaSpecificationExecutor<Cartoon> {

    /**
     * 获取上一条漫画
     * @param id
     * @return
     */
    @Query(value = "select * from t_cartoon where id < ?1 order by id desc limit 1",nativeQuery = true)
    public Cartoon getLast(Integer id);

    /**
     * 获取下一条漫画
     * @param id
     * @return
     */
    @Query(value = "select * from t_cartoon where id > ?1 order by id asc limit 1 ",nativeQuery = true)
    public Cartoon getNext(Integer id);


    /**
     * 随机获得n个漫画
     * @param n
     * @return
     */
    @Query(value = "select * from t_cartoon order by rand() limit ?1",nativeQuery = true)
    public List<Cartoon> randomList(Integer n);
}
