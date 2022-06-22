package com.example.doan.studentmanagerment_sever.Fragment;


import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.doan.studentmanagerment_sever.Activity.Monhoc_Activity;
import com.example.doan.studentmanagerment_sever.Adapter.custom_monhoc_adapter;
import com.example.doan.studentmanagerment_sever.Contructor.monhoc;
import com.example.doan.studentmanagerment_sever.Contructor.utils;
import com.example.doan.studentmanagerment_sever.GlobalVar;
import com.example.doan.studentmanagerment_sever.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;

public class Fragment_monhoc_danhsachnganh extends Fragment implements AdapterView.OnItemClickListener {
    private  static  View view;
    private  static FragmentManager fragmentManager ;
    String urlgetmon = "Web/monhoc/monhoc_JSON.php";
   private static ArrayList<monhoc> Arrmonhocs ;
    private static custom_monhoc_adapter adapter ;
    String data="";
    ListView lv_dsmon;
    public Fragment_monhoc_danhsachnganh() {
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_fragment_monhoc_danhsachnganh, container, false);
        // innit
        inntit();
        Monhoc_Activity.txttile.setText("Danh sách môn học");
        //getjsonmon

        gẹtJSONDSmon(utils.http+urlgetmon);

        //listview onclick

        lv_dsmon.setOnItemClickListener(this);
        return view ;
    }
    // innit()
    void inntit()
    {
        fragmentManager = getActivity().getSupportFragmentManager();
        lv_dsmon = view.findViewById(R.id.listview_monhoc);
        Arrmonhocs = new ArrayList<monhoc>();
    }

    // getJSONDsachmonhoc
    private void gẹtJSONDSmon(String url)
    {


        GlobalVar.qlsvApiHolder.getMonHoc().enqueue(new Callback<List<monhoc>>() {
            @Override
            public void onResponse(Call<List<monhoc>> call, retrofit2.Response<List<monhoc>> response) {
                Arrmonhocs.addAll(response.body());
                adapter = new custom_monhoc_adapter(getActivity(),R.layout.custom_monhoc_adapter,Arrmonhocs);
                lv_dsmon.setAdapter(adapter);
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<List<monhoc>> call, Throwable t) {

            }
        });


    }

    void getViewFragment()
    {
        fragmentManager
                .beginTransaction()
                .replace(R.id.frame_monhoc ,new Fragment_monhoc_dsmon(), utils.fragment_monhoc_dsmon).commit();
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        String t = Arrmonhocs.get(i).getLinkpdf().toString();
        FragmentTransaction transection = getFragmentManager().beginTransaction();
        Fragment_monhoc_dsmon mfragment = new Fragment_monhoc_dsmon();
        //using Bundle to send data
        Bundle bundle = new Bundle();
        bundle.putString("link", t);
        mfragment.setArguments(bundle); //data being send to SecondFragment
        transection.replace(R.id.frame_monhoc, mfragment);
        transection.isAddToBackStackAllowed();
        transection.addToBackStack(null);
        transection.commit();
    }
}
