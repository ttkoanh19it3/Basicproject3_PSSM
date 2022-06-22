package com.example.doan.studentmanagerment_sever.Fragment;


import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.appcompat.app.AlertDialog;

import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.example.doan.studentmanagerment_sever.Activity.Chinhsua_sv05_Activity;
import com.example.doan.studentmanagerment_sever.Activity.Them_sv05_Activity;
import com.example.doan.studentmanagerment_sever.Adapter.custom_SV_adapter;
import com.example.doan.studentmanagerment_sever.Contructor.student_pt11304;
import com.example.doan.studentmanagerment_sever.Contructor.utils;
import com.example.doan.studentmanagerment_sever.GlobalVar;
import com.example.doan.studentmanagerment_sever.R;
import com.example.doan.studentmanagerment_sever.Util.Configpt11305;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
public class Fragment_sv_11305class extends Fragment implements View.OnClickListener {
    private static ListView listview_PT11305;
    private static View view;
    // URL
    String Json_url = utils.http+"Web/parseJSON_QLSV.php";
    String data = "" ;
    RequestQueue requestQueue;
    // get id theo listview
    String id_sv;
    //
    public static ArrayList<student_pt11304> studentpt11305ArrayList = null ;
    private static custom_SV_adapter adapter ;
    //
    com.github.clans.fab.FloatingActionButton fab_add , fab_refresh ;
    //
    FrameLayout frameLayout ;
    FragmentManager fragmentManager ;
    public Fragment_sv_11305class() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_fragment_sv_11305class, container, false);
        innit();
        // get json 11305
        Get11305student();
        // onclick fab
        fab_add.setOnClickListener(this);
        fab_refresh.setOnClickListener(this);
        // onclick listview
        registerForContextMenu(listview_PT11305);
        listview_PT11305.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                id_sv = studentpt11305ArrayList.get(i).getMa();
                Toast.makeText(getActivity(), id_sv, Toast.LENGTH_SHORT).show();

                return false;
            }
        });
        // reload
        // Inflate the layout for this fragment
        return view;
    }
    private void innit()
    {
        studentpt11305ArrayList = new ArrayList<student_pt11304>();
        listview_PT11305 = (ListView) view.findViewById(R.id.Listview_sv_PT11305);
        //fab
        fab_add = view.findViewById(R.id.menu_item_addsv);
        fab_refresh = view.findViewById(R.id.menu_item_refresh);
        frameLayout = view.findViewById(R.id.frame_sv);
    }
    // Context menu (sua , xoa)
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo)
    {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.setHeaderTitle("Tùy Chọn");
        menu.add(0, v.getId(), 0, "Chỉnh Sửa");//groupId, itemId, order, title
        menu.add(0, v.getId(), 0, "Xóa");
    }
    // context click
    @Override
    public boolean onContextItemSelected(MenuItem item){
        if(item.getTitle()=="Chỉnh Sửa"){
            Intent intent = new Intent(getActivity(), Chinhsua_sv05_Activity.class);
            intent.putExtra(Configpt11305.EMP_ID,id_sv);
            startActivity(intent);
        }
        else if(item.getTitle()=="Xóa"){
            confirmDeleteEmployee();
        }else{
            return false;
        }
        return true;
    }
    private void Get11305student()
    {
        GlobalVar.qlsvApiHolder.getLop3().enqueue(new Callback<List<student_pt11304>>() {
            @Override
            public void onResponse(Call<List<student_pt11304>> call, retrofit2.Response<List<student_pt11304>> response) {
                studentpt11305ArrayList.addAll(response.body());
                adapter = new custom_SV_adapter(getActivity(),R.layout.custom_sv_adapter, studentpt11305ArrayList);
                listview_PT11305.setAdapter(adapter);
                adapter.notifyDataSetChanged();
            }
            @Override
            public void onFailure(Call<List<student_pt11304>> call, Throwable t) {
            }
        });
    }
    // void xóa sv
    private void deleteEmployee(String url){
        GlobalVar.qlsvApiHolder.xoalop1(Integer.parseInt(id_sv)).enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, retrofit2.Response<String> response) {
                Toast.makeText(getActivity(), "Xóa thành công SV", Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onFailure(Call<String> call, Throwable t) {
                Toast.makeText(getActivity(), "Lỗi xóa", Toast.LENGTH_SHORT).show();
            }
        });
    }
    // confilm delete
    private void confirmDeleteEmployee(){
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(getActivity());
        alertDialogBuilder.setMessage("Bạn có muốn xóa sv này?");
        alertDialogBuilder.setPositiveButton("Yes",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface arg0, int arg1) {
                        deleteEmployee(Configpt11305.URL_DELETE_EMP);
                        reload();
                    }
                });

        alertDialogBuilder.setNegativeButton("No",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface arg0, int arg1) {
                    }
                });
        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }
    private void reload(){
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.detach(this).attach(this).commit();
    }
    // onclick fab
    @Override
    public void onClick(View view) {
        int t = view.getId();
        if(t == R.id.menu_item_addsv)
        {
            startActivity(new Intent(getActivity(), Them_sv05_Activity.class));
        }
        if(t == R.id.menu_item_refresh)
        {
            reload();
        }
    }
}
