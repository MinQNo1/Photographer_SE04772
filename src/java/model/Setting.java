/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author QuyenNV
 */
public class Setting {
    
    private String src;
    
    private String desc;
    
    private String title;
    
    private String subTitle;

    public Setting() {
    }

    public Setting(String src, String desc, String title, String subTitle) {
        this.src = src;
        this.desc = desc;
        this.title = title;
        this.subTitle = subTitle;
    }


    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }
    
    
}
