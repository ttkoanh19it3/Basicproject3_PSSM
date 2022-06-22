package com.example.doan.studentmanagerment_sever.Activity;

import android.content.Intent;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.FrameLayout;

import com.example.doan.studentmanagerment_sever.Contructor.utils;
import com.example.doan.studentmanagerment_sever.Fragment.Fragment_main_lichhoc;
import com.example.doan.studentmanagerment_sever.R;
public class Lichhoc_Activity extends AppCompatActivity {
    FrameLayout frameLayout ;
    FragmentManager fragmentManager ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lichhoc_);
        fragmentManager = getSupportFragmentManager();
        innit();
        // kiểm tra nếu frame rõng thì trả về fragment ds nganh
        if(savedInstanceState == null)
        {
            fragmentManager
                    .beginTransaction()
                    .replace(R.id.frame_lichhoc ,new Fragment_main_lichhoc() , utils.fragment_lichhoc_main).commit();
        }

    }
    void innit(){
        frameLayout = (FrameLayout) findViewById(R.id.frame_lichhoc);
    }

    @Override
    public void onBackPressed() {
        Fragment fragment_main_lichhoctag = fragmentManager
                .findFragmentByTag(utils.fragment_lichhoc_main);
        Fragment fragment_chitiet_lichhoctag = fragmentManager
                .findFragmentByTag(utils.fragment_lichhoc_chitiet);

        if (fragment_chitiet_lichhoctag != null)
        {
            fragmentManager
                    .beginTransaction()
                    .replace(R.id.frame_lichhoc ,new Fragment_main_lichhoc() ,utils.fragment_lichhoc_main).commit();
        }
        else
        {
            startActivity(new Intent(getApplicationContext(),MainApp_Activity.class));
        }


    }
}
