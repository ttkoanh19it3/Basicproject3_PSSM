package com.example.doan.studentmanagerment_sever.Activity;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;

import com.example.doan.studentmanagerment_sever.R;

import java.util.Timer;
import java.util.TimerTask;
public class Waiting_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // ẩn thanh bar ở trên ở activity này
        getWindow().requestFeature(Window.FEATURE_ACTION_BAR);
        getSupportActionBar().hide();

        // setComtent

        setContentView(R.layout.activity_waiting_);

        // waitAtivity => Login_activity
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                Intent itIntent = new Intent(getApplicationContext(), Login_Activity.class);
                startActivity(itIntent);

            }
        },2000);
    }

    }

