package com.example.doan.studentmanagerment_sever.Activity;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.doan.studentmanagerment_sever.GlobalVar;
import com.example.doan.studentmanagerment_sever.R;
import com.example.doan.studentmanagerment_sever.Util.Configpt11304;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
public class ThemSV04_Activity extends AppCompatActivity implements View.OnClickListener {
    //Defining views
    private EditText editTextName;
    private EditText editTextMasv;
    private EditText editTextLink;
    private EditText editTextDTB;

    private Button buttonAdd;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_them_sv04_);

        // innit()
        innit();

        // onclick

        buttonAdd.setOnClickListener(this);

    }

    private void innit()
    {
//Initializing views
        editTextName = (EditText) findViewById(R.id.edt_addsv_name);
        editTextMasv = (EditText) findViewById(R.id.edt_addsv_masv);
        editTextLink = (EditText) findViewById(R.id.edt_addsv_link);
        editTextDTB = (EditText) findViewById(R.id.edt_addsv_dtb);

        buttonAdd = (Button) findViewById(R.id.buttonAdd);


    }

    // ADD SV
    //Adding an employee
    private void addSV04(String url){
        GlobalVar.qlsvApiHolder.addEmp2(new Emp2(0,editTextName.getText().toString().trim(),editTextMasv.getText().toString().trim(),editTextLink.getText().toString().trim(),Double.parseDouble(editTextDTB.getText().toString().trim()))).enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                System.out.println(response.body().toString());
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                System.out.println(t.getMessage());

            }
        });


    }

// onclick

    @Override
    public void onClick(View view) {
        if(view == buttonAdd){
            if (editTextName.getText().toString().equals("") || editTextMasv.getText().toString().equals("") || editTextLink.getText().toString().equals("")
                    || editTextDTB.getText().toString().equals(""))
            {
                Toast.makeText(this, "Xin mời nhập đầy đủ thông tin", Toast.LENGTH_SHORT).show();
            }
            else {
                    addSV04(Configpt11304.URL_ADD);
                super.onBackPressed();

            }
        }
    }
}
