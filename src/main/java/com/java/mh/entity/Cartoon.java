package com.java.mh.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * 漫画实体
 */
@Entity(name="t_cartoon")
public class Cartoon {
    @Id
    @GeneratedValue
    private Integer id;  //编号

    @Column(length = 200)
    private String name; //漫画名称

    @Column(length = 500)
    private String title; //帖子名称

    @Lob
    @Column(columnDefinition = "TEXT")
    private String content; //帖子内容

    @Column(length = 300)
    private String imageName; //漫画图片

    @Column(length = 400)
    private String panUrl;  //百度网盘链接

    private Date publishDate; //发布日期

    private Integer districtId;  //地区分类

    private Integer typeId;  //电影类型

    private Integer click;  //点击率

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    public Integer getDistrictId() {
        return districtId;
    }

    public void setDistrictId(Integer districtId) {
        this.districtId = districtId;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public Integer getClick() {
        return click;
    }

    public void setClick(Integer click) {
        this.click = click;
    }

    public String getPanUrl() {
        return panUrl;
    }

    public void setPanUrl(String panUrl) {
        this.panUrl = panUrl;
    }
}
