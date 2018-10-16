package com.java.mh.controller.admin;

import com.java.mh.entity.Cartoon;
import com.java.mh.service.CartoonService;
import com.java.mh.util.DateUtil;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/admin/cartoon")
public class CartoonAdminController {

    @Value("${imageFilePath}")
    private String imageFilePath;

    @Autowired
    private CartoonService cartoonService;

    @RequestMapping("/ckeditorUpload")
    public String ckeditorUpload(@RequestParam("upload")MultipartFile file,String CKEditorFuncNum)throws  Exception{
        String fileName = file.getOriginalFilename();
        String suffixName = fileName.substring(fileName.lastIndexOf("."));
        String newFileName = DateUtil.getCurrentDateStr()+suffixName;
        FileUtils.copyInputStreamToFile(file.getInputStream(), new File(imageFilePath+newFileName));

        StringBuffer sb=new StringBuffer();
        sb.append("<script type=\"text/javascript\">");
        sb.append("window.parent.CKEDITOR.tools.callFunction("+ CKEditorFuncNum + ",'" +"/static/cartoonImage/"+ newFileName + "','')");
        sb.append("</script>");

        return sb.toString();

    }

    @RequestMapping("/save")
    public Map<String,Object> saveCartoon(Cartoon cartoon,@RequestParam("imageFile")MultipartFile file,@RequestParam("type") String type)throws Exception{
        if (!file.isEmpty()){
            String fileName = file.getOriginalFilename(); //获取文件名
            String suffixName = fileName.substring(fileName.lastIndexOf('.'));  //获取文件后缀
            String newFileName = DateUtil.getCurrentDateStr()+suffixName;
            cartoon.setImageName(newFileName);
        }
        cartoon.setPublishDate(new Date());
        cartoon.setClick(0);
        Map<String,Object> resultMap = new HashMap<String,Object>();
        cartoonService.save(cartoon);
        resultMap.put("success",true);
        return resultMap;
    }

}
