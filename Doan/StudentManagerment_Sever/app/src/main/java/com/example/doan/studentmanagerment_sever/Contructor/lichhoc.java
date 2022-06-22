package com.example.doan.studentmanagerment_sever.Contructor;

import com.google.gson.annotations.SerializedName;
public class lichhoc {
    @SerializedName("thu")
    String thu ;
    @SerializedName("monhoc")
    String monhoc;
    @SerializedName("giaovien")
    String giaovien ;
    public lichhoc() {
    }
    public lichhoc(String thu, String monhoc, String giaovien) {
        this.thu = thu;
        this.monhoc = monhoc;
        this.giaovien = giaovien;
    }
    public String getThu() {
        return thu;
    }
    public void setThu(String thu) {
        this.thu = thu;
    }
    public String getMonhoc() {
        return monhoc;
    }
    public void setMonhoc(String monhoc) {
        this.monhoc = monhoc;
    }
    public String getGiaovien() {
        return giaovien;
    }
    public void setGiaovien(String giaovien) {
        this.giaovien = giaovien;
    }
    @Override
    public String toString() {
        return thu+"-"+monhoc+"-"+giaovien;
    }
}
