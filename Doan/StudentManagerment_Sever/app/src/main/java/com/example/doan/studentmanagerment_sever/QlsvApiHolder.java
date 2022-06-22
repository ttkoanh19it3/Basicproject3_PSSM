package com.example.doan.studentmanagerment_sever;

import com.example.doan.studentmanagerment_sever.Activity.Emp2;
import com.example.doan.studentmanagerment_sever.Contructor.khenthuong;
import com.example.doan.studentmanagerment_sever.Contructor.lichhoc;
import com.example.doan.studentmanagerment_sever.Contructor.monhoc;
import com.example.doan.studentmanagerment_sever.Contructor.student_pt11304;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface QlsvApiHolder {
    @GET("csrfToken")
    Call<String> getCSRF();

    @POST("dangnhap")
    Call<String> login(@Body Credentials credentials);

    @GET("lop2")
    Call<List<student_pt11304>> getLop2();

    @GET("lop3")
    Call<List<student_pt11304>> getLop3();

    @GET("monhoc")
    Call<List<monhoc>> getMonHoc();

    @GET("lichhoc")
    Call<List<lichhoc>> getLichHoc();

    @GET("ongvang")
    Call<List<khenthuong>> getOngVang();

    @GET("xuatsac")
    Call<List<khenthuong>> getXuatSac();

    @GET("gioi")
    Call<List<khenthuong>> getGioi();

    @GET("getEmp1/{id}")
    Call<student_pt11304> getEmp1(@Path(value = "id", encoded = true) int id);

    @GET("getEmp2/{id}")
    Call<student_pt11304> getEmp2(@Path(value = "id", encoded = true) int id);

    @POST("addEmp1")
    Call<String> addEmp1(@Body Emp2 emp2);

    @POST("addEmp2")
    Call<String> addEmp2(@Body Emp2 emp2);


    @POST("editEmp1")
    Call<String> editEmp1(@Body Emp2 emp2);

    @POST("editEmp2")
    Call<String> editEmp2(@Body Emp2 emp2);

    @GET("xoalop1/{id_hs}")
    Call<String> xoalop1(@Path(value = "id_hs", encoded = true) int id);

    @GET("xoalop2/{id_hs}")
    Call<String> xoalop2(@Path(value = "id_hs", encoded = true) int id);

    @POST("doimatkhau")
    Call<String> doimatkhau(@Body ChangePassword changePassword);


}
