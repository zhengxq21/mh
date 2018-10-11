package com.java.mh.controller.admin;

import com.java.mh.util.DateUtil;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

@RestController
@RequestMapping("/admin/cartoon")
public class CartoonAdminController {

    @Value("${imageFilePath}")
    private String imageFilePath;

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

}
