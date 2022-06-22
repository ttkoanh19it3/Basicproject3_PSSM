package com.example.doan.studentmanagerment_sever.Activity;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import com.example.doan.studentmanagerment_sever.Adapter.custom_khenthuong_adapter;
import com.example.doan.studentmanagerment_sever.Contructor.khenthuong;
import com.example.doan.studentmanagerment_sever.Contructor.utils;
import com.example.doan.studentmanagerment_sever.GlobalVar;
import com.example.doan.studentmanagerment_sever.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;

public class Diem_Activity extends AppCompatActivity {

    ListView listxuatsac , listgioi ;
    TextView txtname_ov , txtmasv_ov , txtdtb_ov ;
    String urlget = utils.http+"Web/khenthuong/Json_diem.php";

    ArrayList <khenthuong> arrxuatsac ;
    ArrayList <khenthuong> arrgioi ;
    private static custom_khenthuong_adapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diem_);
        init();
        // getongvang
        getOngvang(urlget);
        // getxuatsac
        getXuatsac(urlget);
        //getgioi
        getgioi(urlget);
    }
// anh xa
    private void init()
    {
        arrxuatsac = new ArrayList<>();
        arrgioi = new ArrayList<>();
        listxuatsac = (ListView) findViewById(R.id.listview_sv_xuatsac);
        listgioi = (ListView) findViewById(R.id.listview_sv_gioi);
        txtname_ov = (TextView) findViewById(R.id.tenongvangpolytxt);
        txtmasv_ov = (TextView) findViewById(R.id.masvongvang);
        txtdtb_ov = (TextView) findViewById(R.id.dtbongvang);
    }
    // get ong vang
    private void getOngvang(String url)
    {


    }
    // get xuatsac

    private void getXuatsac(String url)
    {

        GlobalVar.qlsvApiHolder.getXuatSac().enqueue(new Callback<List<khenthuong>>() {
            @Override
            public void onResponse(Call<List<khenthuong>> call, retrofit2.Response<List<khenthuong>> response) {
                arrxuatsac.addAll(response.body());
                adapter = new custom_khenthuong_adapter(Diem_Activity.this,R.layout.custom_khenthuong_adapter,arrxuatsac);
                listxuatsac.setAdapter(adapter);
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<List<khenthuong>> call, Throwable t) {

            }
        });

    }
    private void getgioi(String url)
    {


        GlobalVar.qlsvApiHolder.getGioi().enqueue(new Callback<List<khenthuong>>() {
            @Override
            public void onResponse(Call<List<khenthuong>> call, retrofit2.Response<List<khenthuong>> response) {
                arrgioi.addAll(response.body());
                adapter = new custom_khenthuong_adapter(Diem_Activity.this,R.layout.custom_khenthuong_adapter,arrgioi);
                listgioi.setAdapter(adapter);
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<List<khenthuong>> call, Throwable t) {

            }
        });

    }
}
