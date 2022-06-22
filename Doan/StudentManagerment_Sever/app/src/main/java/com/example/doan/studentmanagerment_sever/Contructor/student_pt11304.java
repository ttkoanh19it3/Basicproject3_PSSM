package com.example.doan.studentmanagerment_sever.Contructor;

import com.google.gson.annotations.SerializedName;

public class student_pt11304 {

    @SerializedName("id")
    public String ma ;
    @SerializedName("name")
    public String name;
    @SerializedName("masv")
    public String masv ;
    @SerializedName("link")
    public String link;
    @SerializedName("DTB")
    public String DTB ;

    public student_pt11304() {
    }
    public student_pt11304(String ma, String name, String masv, String link, String DTB) {
        this.ma = ma;
        this.name = name;
        this.masv = masv;
        this.link = link;
        this.DTB = DTB;
    }

    public String getMa() {
        return ma;
    }
    public void setMa(String ma) {
        this.ma = ma;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getMasv() {
        return masv;
    }
    public void setMasv(String masv) {
        this.masv = masv;
    }
    public String getLink() {
        return link;
    }
    public void setLink(String link) {
        this.link = link;
    }
    public String getDTB() {
        return DTB;
    }
    public void setDTB(String DTB) {
        this.DTB = DTB;
    }
    @Override
    public String toString() {
        return ma+"-"+name+"-"+masv+"-"+link+"-"+DTB;
    }
}
