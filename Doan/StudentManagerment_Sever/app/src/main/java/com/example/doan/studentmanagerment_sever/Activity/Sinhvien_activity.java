package com.example.doan.studentmanagerment_sever.Activity;
;
import android.content.Intent;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.FrameLayout;

import com.example.doan.studentmanagerment_sever.Contructor.utils;
import com.example.doan.studentmanagerment_sever.Fragment.Fragment_sv_main;
import com.example.doan.studentmanagerment_sever.R;

public class Sinhvien_activity extends AppCompatActivity {
    FrameLayout frameLayout ;
    FragmentManager fragmentManager ;

//    Fragment_sv_main fragment_main = new Fragment_sv_main();
//      Fragment_sv_11301class fragment_pt11301_class = new Fragment_sv_11301class();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sinhvien_activity);
        fragmentManager = getSupportFragmentManager();
        innit();

        // kiểm tra nếu frame rõng thì trả về fragment main
        if(savedInstanceState == null)
        {
            fragmentManager
                    .beginTransaction()
                    .replace(R.id.frame_sv ,new Fragment_sv_main() ,utils.fragment_sv_main).commit();

        }

    }

   void innit(){
       frameLayout = (FrameLayout) findViewById(R.id.frame_sv);
   }

    @Override
    public void onBackPressed() {
        Fragment fragment_main_tag = fragmentManager
                .findFragmentByTag(utils.fragment_sv_main);
        Fragment fragment_pt11301_tag = fragmentManager
                .findFragmentByTag(utils.fragment_Pt11031_class);
        Fragment fragment_pt11305_tag = fragmentManager
                .findFragmentByTag(utils.fragment_Pt11035_class);
        if (fragment_pt11301_tag != null)
        {
            fragmentManager
                    .beginTransaction()
                    .replace(R.id.frame_sv ,new Fragment_sv_main() ,utils.fragment_sv_main).commit();
        }
        else
        if (fragment_pt11305_tag != null)
        {
            fragmentManager
                    .beginTransaction()
                    .replace(R.id.frame_sv ,new Fragment_sv_main() ,utils.fragment_sv_main).commit();
        }
        else
        {
            startActivity(new Intent(getApplicationContext(),MainApp_Activity.class));
        }
    }


}
