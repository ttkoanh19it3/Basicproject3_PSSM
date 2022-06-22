package com.example.doan.studentmanagerment_sever;

public class ChangePassword{
    String _token = GlobalVar.csrfToken;
    int id = GlobalVar.currentUserID;
    String oldPassword;
    String newPassword;
    public ChangePassword(String oldPassword , String newPassword) {
        this.oldPassword = oldPassword;
        this.newPassword = newPassword;
    }
}