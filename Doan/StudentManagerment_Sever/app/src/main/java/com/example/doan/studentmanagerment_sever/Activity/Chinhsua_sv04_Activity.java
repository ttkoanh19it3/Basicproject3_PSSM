package com.example.doan.studentmanagerment_sever.Activity;

import android.content.Intent;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.example.doan.studentmanagerment_sever.Contructor.student_pt11304;
import com.example.doan.studentmanagerment_sever.GlobalVar;
import com.example.doan.studentmanagerment_sever.R;
import com.example.doan.studentmanagerment_sever.Util.Configpt11304;

import retrofit2.Call;
import retrofit2.Callback;

public class Chinhsua_sv04_Activity extends AppCompatActivity implements View.OnClickListener {
    private  EditText editTextId;
    private EditText editTextName;
    private EditText editTextMASV;
    private EditText editTextLink;
    private EditText editTextDTB;

    private Button buttonUpdate;

    RequestQueue requestQueue;


    private static String id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chinhsua_sv04_);

        innit();

        Intent intent = getIntent();

        id = intent.getStringExtra(Configpt11304.EMP_ID);



        buttonUpdate.setOnClickListener(this);


        editTextId.setText(id);

        //
        getstudentbyid();
       // getEmployee();
    }

    private void innit()
    {
        editTextId = (EditText) findViewById(R.id.edt_update_id);
        editTextName = (EditText) findViewById(R.id.edt_update_name);
        editTextMASV = (EditText) findViewById(R.id.edt_update_masv);
        editTextLink = (EditText) findViewById(R.id.edt_update_link);
        editTextDTB = (EditText) findViewById(R.id.edt_update_dtb);

        buttonUpdate = (Button) findViewById(R.id.button_update);

    }



    // getSV theo id
    private void getstudentbyid()
    {

        GlobalVar.qlsvApiHolder.getEmp2(Integer.parseInt(id)).enqueue(new Callback<student_pt11304>() {
            @Override
            public void onResponse(Call<student_pt11304> call, retrofit2.Response<student_pt11304> response) {
                editTextName.setText(response.body().name);
                editTextMASV.setText(response.body().masv);
                editTextLink.setText(response.body().link);
                editTextDTB.setText(response.body().DTB);
            }

            @Override
            public void onFailure(Call<student_pt11304> call, Throwable t) {

            }
        });


    }

    // update SV
    private void updateEmployee(String url)

    {
        GlobalVar.qlsvApiHolder.editEmp2(new Emp2(Integer.parseInt(editTextId.getText().toString().trim()),editTextName.getText().toString().trim(),editTextMASV.getText().toString().trim(),editTextLink.getText().toString().trim(),Double.parseDouble(editTextDTB.getText().toString().trim()))).enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, retrofit2.Response<String> response) {
                Toast.makeText(Chinhsua_sv04_Activity.this, "Cập nhật thành công SV", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                Toast.makeText(Chinhsua_sv04_Activity.this, "Xảy ra lỗi", Toast.LENGTH_SHORT).show();
            }
        });


    }


    @Override
    public void onClick(View view) {
        updateEmployee(Configpt11304.URL_UPDATE_EMP);
        super.onBackPressed();
    }
}
