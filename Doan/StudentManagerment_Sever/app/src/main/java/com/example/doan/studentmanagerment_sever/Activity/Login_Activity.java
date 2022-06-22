package com.example.doan.studentmanagerment_sever.Activity;

import android.content.Intent;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;

import com.example.doan.studentmanagerment_sever.Credentials;
import com.example.doan.studentmanagerment_sever.GlobalVar;
import com.example.doan.studentmanagerment_sever.QlsvApiHolder;
import com.example.doan.studentmanagerment_sever.R;

import java.net.CookieManager;
import java.net.CookiePolicy;

import okhttp3.JavaNetCookieJar;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

import static com.example.doan.studentmanagerment_sever.GlobalVar.cookieManager;

public class Login_Activity extends AppCompatActivity {
    EditText edtname, edtpass;
    Button btn_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // ẩn thanh bar ở trên ở activity này
        getWindow().requestFeature(Window.FEATURE_ACTION_BAR);
        getSupportActionBar().hide();
        //
        setContentView(R.layout.activity_login_);
        // anh xa
        innit();

        AlertDialog.Builder dialog = new AlertDialog.Builder(this);


        // onclick
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                InitRetrofitWithCookie(GlobalVar.baseBackendURLApi);
                GlobalVar.qlsvApiHolder.getCSRF().enqueue(new Callback<String>() {
                    @Override
                    public void onResponse(Call<String> call, Response<String> response) {
                        GlobalVar.csrfToken = response.body();
                        Credentials credentials = new Credentials(edtname.getText().toString(),edtpass.getText().toString());
                        GlobalVar.qlsvApiHolder.login(credentials).enqueue(new Callback<String>() {
                            @Override
                            public void onResponse(Call<String> call, Response<String> response) {
                                if (response.body().equals("error")) {
                                    dialog.setMessage("Sai tên đăng nhập hoặc mật khẩu");
                                    dialog.show();

                                }
                                else {
                                    GlobalVar.currentUserName = edtname.getText().toString();
                                    GlobalVar.currentUserID = Integer.parseInt(response.body());
                                    startActivity(new Intent(getApplicationContext(),MainApp_Activity.class));
                                }
                            }

                            @Override
                            public void onFailure(Call<String> call, Throwable t) {
                                dialog.setMessage(t.getMessage());
                                dialog.show();
                            }
                        });
                    }

                    @Override
                    public void onFailure(Call<String> call, Throwable t) {
                        dialog.setMessage(t.getMessage());
                        dialog.show();
                    }
                });


            }
        });
    }

    void InitRetrofitWithCookie(String baseUrl){
        cookieManager = new CookieManager();
        cookieManager.setCookiePolicy(CookiePolicy.ACCEPT_ALL);
        GlobalVar.oktHttpClient = new OkHttpClient.Builder();
        GlobalVar.oktHttpClient.cookieJar(new JavaNetCookieJar(cookieManager));
        GlobalVar.retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(GlobalVar.oktHttpClient.build())
                .build();
        GlobalVar.qlsvApiHolder = GlobalVar.retrofit.create(QlsvApiHolder.class);
    }
    void innit()
    {
        edtname = (EditText) findViewById(R.id.edt_user);
        edtpass = (EditText) findViewById(R.id.edt_pass);
        btn_login = (Button) findViewById(R.id.btn_login);
        //
    }
    // onback press phisics
    //Back press
    @Override
    public void onBackPressed() {
        //Khoi tao lai Activity muốn khởi tạo lại khi vào lần nữa
        Intent intent = new Intent(getApplicationContext(), Login_Activity.class);
        startActivity(intent);
        // kết thúc app
        Intent startMain = new Intent(Intent.ACTION_MAIN);
        startMain.addCategory(Intent.CATEGORY_HOME);
        startActivity(startMain);
        finish();
    }


}
