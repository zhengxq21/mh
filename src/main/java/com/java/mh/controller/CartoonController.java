package com.java.mh.controller;

import com.java.mh.entity.Cartoon;
import com.java.mh.service.CartoonService;
import com.java.mh.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/cartoon")
public class CartoonController {

    @Autowired
    private CartoonService cartoonService;

    @RequestMapping("/search")
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

    @RequestMapping("/list/{id}")
    public ModelAndView list(@PathVariable(value = "id",required = false)Integer page)throws Exception{
        ModelAndView mav = new ModelAndView();
        List<Cartoon> cartoonList = cartoonService.list(null,page-1,20,new Sort(Sort.Direction.DESC,"publishDate"));
        Long total = cartoonService.getCount(null);
        mav.addObject("cartoonList",cartoonList);
        mav.addObject("pageCode",PageUtil.genPagination("/cartoon/list",total,page,20));
        mav.addObject("title","漫画列表");
        mav.addObject("mainPage","cartoon/list");
        mav.addObject("mainPageKey","#f");
        mav.setViewName("index");
        return mav;
    }

    @RequestMapping("/{id}")
    public ModelAndView view(@PathVariable(value = "id",required = true)Integer id)throws Exception{
        ModelAndView mav = new ModelAndView();
        Cartoon cartoon = cartoonService.findById(id);
        mav.addObject("cartoon",cartoon);
        mav.addObject("title",cartoon.getTitle());
        mav.addObject("randomCartoonList",cartoonService.randomList(8));
        mav.addObject("pageCode",this.getUpAndDownPageCode(cartoonService.getLast(id),cartoonService.getNext(id)));
        mav.addObject("mainPage","cartoon/view");
        mav.addObject("mainPageKey","#f");
        mav.setViewName("index");
        return mav;
    }

    /**
     * 获取下一条漫画你和上一个漫画
     * @param
     * @param
     * @return
     */
    private String getUpAndDownPageCode(Cartoon lastCartoon,Cartoon nextCartoon){
        StringBuffer pageCode=new StringBuffer();
        if(lastCartoon==null || lastCartoon.getId()==null){
            pageCode.append("<p>上一篇：没有了</p>");
        }else{
            pageCode.append("<p>上一篇：<a href='/cartoon/"+lastCartoon.getId()+"'>"+lastCartoon.getTitle()+"</a></p>");
        }
        if(nextCartoon==null || nextCartoon.getId()==null){
            pageCode.append("<p>下一篇：没有了</p>");
        }else{
            pageCode.append("<p>下一篇：<a href='/cartoon/"+nextCartoon.getId()+"'>"+nextCartoon.getTitle()+"</a></p>");
        }
        return pageCode.toString();
    }



}
