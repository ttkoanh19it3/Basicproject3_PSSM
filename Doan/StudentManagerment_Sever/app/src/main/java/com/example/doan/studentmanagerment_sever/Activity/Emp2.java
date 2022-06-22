package com.example.doan.studentmanagerment_sever.Activity;

import com.example.doan.studentmanagerment_sever.GlobalVar;

public class Emp2 {
    String _token = GlobalVar.csrfToken;
    int id;
    String name;
    String masv;
    String link;
    Double DTB;
    public Emp2 (int id , String name , String masv , String link , Double DTB) {
        this.id = id;
        this.name = name;
        this.masv = masv;
        this.link = link;
        this.DTB = DTB;
    }

}
