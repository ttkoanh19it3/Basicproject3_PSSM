 package com.example.doan.studentmanagerment_sever.Fragment;


import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.android.volley.RequestQueue;
import com.example.doan.studentmanagerment_sever.Contructor.utils;
import com.example.doan.studentmanagerment_sever.R;

import java.util.ArrayList;
public class Fragment_sv_main extends Fragment implements View.OnClickListener {
    private  static  View view;
    private  static FragmentManager fragmentManager ;
    // URL
    String Json_url = "https://192.168.1.100/Web/parseJSON_QLSV.php";
    String data = "" ;
    RequestQueue requestQueue;
     public static ArrayList Arr_DsLop = null ;
     private  static ArrayAdapter adapter_dsLop = null ;
    //
   ListView listview_dslop;
    public Fragment_sv_main() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_fragment_sinhvien_main, container, false);
        // innit
        inntit();
        // getDslop
        GetDSachLop();
        adapter_dsLop = new ArrayAdapter(getActivity(),android.R.layout.select_dialog_multichoice,Arr_DsLop);
        listview_dslop.setAdapter(adapter_dsLop);
        // Listview Onclick
         listview_dslop.setOnItemClickListener(new AdapterView.OnItemClickListener() {
             @Override
             public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if(i == 0)
                {
                    fragmentManager
                            .beginTransaction()
                            .replace(R.id.frame_sv ,new Fragment_sv_11301class(), utils.fragment_Pt11031_class)
                            .commit();
                }
                if(i ==1)
                {
                    fragmentManager
                            .beginTransaction()
                            .replace(R.id.frame_sv ,new Fragment_sv_11305class(), utils.fragment_Pt11035_class)
                            .commit();
                }
             }
         });
        // Inflate the layout for this fragment
        return view ;
    }
    // innit()
    void inntit()
    {
        fragmentManager = getActivity().getSupportFragmentManager();
       listview_dslop = view.findViewById(R.id.Listview_DsachLop);
        Arr_DsLop = new ArrayList();
    }
     private void GetDSachLop()
     {
         Arr_DsLop.add("Lớp 1A");
         Arr_DsLop.add("Lớp 2B");
     }
    // su kien btn
    @Override
    public void onClick(View view) {
    }
    // onback press
}

