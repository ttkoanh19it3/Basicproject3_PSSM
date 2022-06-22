package com.example.doan.studentmanagerment_sever.Activity;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.doan.studentmanagerment_sever.ChangePassword;
import com.example.doan.studentmanagerment_sever.GlobalVar;
import com.example.doan.studentmanagerment_sever.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AccountActivity extends AppCompatActivity {

    private TextView lbUserName;
    private Button btnResetPassword;
    private EditText txtOldPassword;
    private EditText txtNewPassword;
    private EditText txtReNewPassword;
    private AlertDialog changePasswordDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.account_setting);

        changePasswordDialog = new AlertDialog.Builder(AccountActivity.this).setPositiveButton("OK", null).create();
        lbUserName = findViewById(R.id.lbUserName);
        btnResetPassword = findViewById(R.id.btnResetPassword);
        txtOldPassword = findViewById(R.id.txtOldPassword);
        txtNewPassword = findViewById(R.id.txtNewPassword);
        txtReNewPassword = findViewById(R.id.txtReNewPassword);



        lbUserName.setText(GlobalVar.currentUserName);
        btnResetPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (txtReNewPassword.getText().toString().equals(txtNewPassword.getText().toString())) {
                    GlobalVar.qlsvApiHolder.doimatkhau(new ChangePassword(txtOldPassword.getText().toString(),txtNewPassword.getText().toString())).enqueue(new Callback<String>() {
                        @Override
                        public void onResponse(Call<String> call, Response<String> response) {
                            if (response.body().equals("Success")) {
                                changePasswordDialog.setMessage("Đổi mật khẩu thành công");
                            }
                            else {
                                changePasswordDialog.setMessage(response.body());
                            }

                            changePasswordDialog.show();
                        }

                        @Override
                        public void onFailure(Call<String> call, Throwable t) {
                            changePasswordDialog.setMessage(t.getMessage());
                            changePasswordDialog.show();
                        }
                    });
                }
                else {
                    changePasswordDialog.setMessage("Mật khẩu mới không trùng khớp");
                    changePasswordDialog.show();
                }

            }
        });

    }

}
