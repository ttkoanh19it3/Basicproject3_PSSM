package com.example.doan.studentmanagerment_sever.Activity;

import android.content.Intent;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.example.doan.studentmanagerment_sever.Contructor.utils;
import com.example.doan.studentmanagerment_sever.Fragment.Fragment_monhoc_danhsachnganh;
import com.example.doan.studentmanagerment_sever.R;

public class Monhoc_Activity extends AppCompatActivity {
    FrameLayout frameLayout ;
    FragmentManager fragmentManager ;
    public static TextView txttile ;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_monhoc_);
        fragmentManager = getSupportFragmentManager();
        innit();

        // kiểm tra nếu frame rõng thì trả về fragment ds nganh
        if(savedInstanceState == null)
        {
            fragmentManager
                    .beginTransaction()
                    .replace(R.id.frame_monhoc ,new Fragment_monhoc_danhsachnganh() ,utils.fragment_monhoc_dsnganh).commit();

        }

    }

    void innit(){
        frameLayout = (FrameLayout) findViewById(R.id.frame_monhoc);
        txttile = (TextView) findViewById(R.id.txt_monhoc);
    }

    @Override
    public void onBackPressed() {
        Fragment fragment_dsnganh_tag = fragmentManager
                .findFragmentByTag(utils.fragment_monhoc_dsnganh);
        Fragment fragment_dsmon_tag = fragmentManager
                .findFragmentByTag(utils.fragment_monhoc_dsmon);


        if (fragment_dsmon_tag != null)
        {
            fragmentManager
                    .beginTransaction()
                    .replace(R.id.frame_monhoc ,new Fragment_monhoc_danhsachnganh() ,utils.fragment_monhoc_dsnganh).commit();
        }
        else
        {
            startActivity(new Intent(getApplicationContext(),MainApp_Activity.class));
        }


}
}
