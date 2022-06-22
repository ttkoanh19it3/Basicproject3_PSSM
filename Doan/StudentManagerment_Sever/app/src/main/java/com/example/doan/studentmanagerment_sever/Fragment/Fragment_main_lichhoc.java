package com.example.doan.studentmanagerment_sever.Fragment;


import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.doan.studentmanagerment_sever.Adapter.custom_lichhoc_adapter;
import com.example.doan.studentmanagerment_sever.Contructor.lichhoc;
import com.example.doan.studentmanagerment_sever.Contructor.utils;
import com.example.doan.studentmanagerment_sever.GlobalVar;
import com.example.doan.studentmanagerment_sever.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;

public class Fragment_main_lichhoc extends Fragment implements AdapterView.OnItemClickListener {
    private  static  View view;
    private  static FragmentManager fragmentManager ;
    ArrayList<lichhoc> Arrlichhoc;
    private static custom_lichhoc_adapter adapter;
    private String urlget = utils.http+"Web/lichhoc/lichhoc_JSON.php";
    ListView lv_lichhoc ;
    public Fragment_main_lichhoc() {
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_main_lichhoc, container, false);

        // innit
        inntit();
        // getlichhoc
        getlichhoc();
        //listview onclick
        return view ;
        //listview onclick

        // Inflate the layout for this fragment
      //  getlichhoc(urlget);
        // Inflate the layout for this fragment
    }
    // innit()
    void inntit()
    {
        fragmentManager = getActivity().getSupportFragmentManager();
        lv_lichhoc = view.findViewById(R.id.lv_lichhoc);
        Arrlichhoc = new ArrayList<lichhoc>();
    }
    // getLichhoc
    private void getlichhoc()
    {


        GlobalVar.qlsvApiHolder.getLichHoc().enqueue(new Callback<List<lichhoc>>() {
            @Override
            public void onResponse(Call<List<lichhoc>> call, retrofit2.Response<List<lichhoc>> response) {
                System.out.println(response.body().toString());
                Arrlichhoc.addAll(response.body());
                adapter = new custom_lichhoc_adapter(getActivity(),R.layout.custom_lichhoc_adapter,Arrlichhoc);
                lv_lichhoc.setAdapter(adapter);
                adapter.notifyDataSetChanged();
            }
            @Override
            public void onFailure(Call<List<lichhoc>> call, Throwable t) {
            }
        });
    }
    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

    }
}
