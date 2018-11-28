package com.java.mh.run;

import com.java.mh.service.CartoonService;
import com.java.mh.service.DistrictService;
import com.java.mh.service.TypeInfoService;
import com.java.mh.service.TypeService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

@Component("startupRunner")
public class StartupRunner implements CommandLineRunner,ServletContextListener {

    private ServletContext application = null;

    @Resource
    private CartoonService cartoonService;

    @Resource
    private TypeService typeAdminService;

    @Resource
    private TypeInfoService typeInfoService;

    @Resource
    private DistrictService districtService;

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        application=servletContextEvent.getServletContext();
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }

    @Override
    public void run(String... args) throws Exception {

    }

    /**
     * 加载数据到application中
     */
    public void loadData(){
        //漫画类别

        //漫画地区

        //最新10条漫画

        //最新32条漫画

    }

}
