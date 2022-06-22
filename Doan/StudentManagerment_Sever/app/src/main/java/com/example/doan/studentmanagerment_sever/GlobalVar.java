package com.example.doan.studentmanagerment_sever;

import java.net.CookieManager;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

public class GlobalVar {
    public static int currentUserID;
    public static String currentUserName;
    public static String baseBackendURL = "http://192.168.1.6";
    public static String baseBackendURLApi = "http://192.168.1.6/api/";
    public static String csrfToken;
    public static QlsvApiHolder qlsvApiHolder;
    public static Retrofit retrofit;
    public static CookieManager cookieManager;
    public static OkHttpClient.Builder oktHttpClient;
}
