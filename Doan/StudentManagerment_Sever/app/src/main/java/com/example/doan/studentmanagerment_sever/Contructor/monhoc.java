package com.example.doan.studentmanagerment_sever.Contructor;

import com.google.gson.annotations.SerializedName;
public class monhoc {
    @SerializedName("tenmon")
    String tenmon ;
    @SerializedName("thuocnganh")
    String thuocnganh;
    @SerializedName("linkpdf")
    String linkpdf ;
    public monhoc() {
    }
    public monhoc(String tenmon, String thuocnganh, String linkpdf) {
        this.tenmon = tenmon;
        this.thuocnganh = thuocnganh;
        this.linkpdf = linkpdf;
    }
    public String getTenmon() {
        return tenmon;
    }
    public void setTenmon(String tenmon) {
        this.tenmon = tenmon;
    }
    public String getThuocnganh() {
        return thuocnganh;
    }
    public void setThuocnganh(String thuocnganh) {
        this.thuocnganh = thuocnganh;
    }
    public String getLinkpdf() {
        return linkpdf;
    }
    public void setLinkpdf(String linkpdf) {
        this.linkpdf = linkpdf;
    }
    @Override
    public String toString() {
        return tenmon+"-"+thuocnganh+"\n";
    }
}
