package com.java.mh.service.impl;

import com.java.mh.entity.Cartoon;
import com.java.mh.repository.CartoonRepository;
import com.java.mh.run.StartupRunner;
import com.java.mh.service.CartoonService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.thymeleaf.util.StringUtils;

import javax.annotation.Resource;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.Optional;

@Service("cartoonService")
            public class CartoonServiceImpl implements CartoonService {

    @Resource
    private CartoonRepository cartoonRepository;

    @Resource
    private StartupRunner startupRunner;

    @Override
    public Cartoon save(Cartoon cartoon) {
        Cartoon result = cartoonRepository.save(cartoon);
        startupRunner.loadData();
        return result;
    }

    @Override
    public List<Cartoon> list(Cartoon cartoon, Integer page, Integer rows) {
        Pageable pageable = new PageRequest(page,rows);
        Page<Cartoon> cartoons = cartoonRepository.findAll(new Specification<Cartoon>(){

            @Override
            public Predicate toPredicate(Root<Cartoon> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                Predicate predicate = criteriaBuilder.conjunction();
                if (cartoon != null){
                    if (!StringUtils.isEmpty(cartoon.getName())){
                        predicate.getExpressions().add(criteriaBuilder.like(root.get("name"),
                                "%"+cartoon.getName().trim()+"%"));
                    }
                }
                return predicate ;
            }
        },pageable);
        return cartoons.getContent();
    }

    @Override
    public long getCount(Cartoon cartoon) {
        Long count = cartoonRepository.count(new Specification<Cartoon>() {
            @Override
            public Predicate toPredicate(Root<Cartoon> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                Predicate predicate = criteriaBuilder.conjunction();
                if (cartoon != null){
                    if (!StringUtils.isEmpty(cartoon.getName())){
                        predicate.getExpressions().add(criteriaBuilder.like(root.get("name"),
                                "%"+cartoon.getName().trim()+"%"));
                    }
                }
                return predicate;
            }
        });
        return count;
    }

    @Override
    public void deltete(Integer id) {
        cartoonRepository.deleteById(id);
        startupRunner.loadData();
    }

    @Override
    public Cartoon findById(Integer id) {
        Optional<Cartoon> cartoons = cartoonRepository.findById(id);
        return cartoons.get();
    }

    @Override
    public void updateCartoon(Cartoon cartoon) {
        cartoonRepository.save(cartoon);
        startupRunner.loadData();
    }
}
