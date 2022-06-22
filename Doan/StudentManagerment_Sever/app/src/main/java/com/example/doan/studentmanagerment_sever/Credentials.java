package com.example.doan.studentmanagerment_sever;

public class Credentials {
    String _token = GlobalVar.csrfToken;
    String user_name;
    String user_password;
    public Credentials(String username , String password){
        this.user_name = username;
        this.user_password = password;
    }
}
