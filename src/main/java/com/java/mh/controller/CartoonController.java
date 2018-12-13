package com.java.mh.controller;

import com.java.mh.entity.Cartoon;
import com.java.mh.service.CartoonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/cartoon")
public class CartoonController {

    @Autowired
    private CartoonService cartoonService;

    public ModelAndView search(@Valid Cartoon s_carton, BindingResult bindingResult)throws Exception{
        ModelAndView mav = new ModelAndView();
        if (bindingResult.hasErrors()){
            mav.addObject("error",bindingResult.getFieldError().getDefaultMessage());
            mav.addObject("title","首页");
            mav.addObject("mainPage","cartoon/indexCartoon");
            mav.addObject("mainPageKey","#f");
            mav.setViewName("index");
        }else{
            List<Cartoon> list = cartoonService.list(s_carton,0,32,new Sort(Sort.Direction.DESC,"publishDate"));
            mav.addObject("cartoonList",list);
            mav.addObject("title",s_carton.getName());
            mav.addObject("mainPage","cartoon/result");
            mav.addObject("mainPageKey","#f");
            mav.addObject("s_cartoon",s_carton);
            mav.addObject("total",cartoonService.getCount(s_carton));
            mav.setViewName("index");
        }
        return mav;
    }

}
