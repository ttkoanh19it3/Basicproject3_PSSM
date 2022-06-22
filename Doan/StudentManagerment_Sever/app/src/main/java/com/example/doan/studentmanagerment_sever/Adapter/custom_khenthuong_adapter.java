package com.example.doan.studentmanagerment_sever.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.doan.studentmanagerment_sever.Contructor.khenthuong;
import com.example.doan.studentmanagerment_sever.R;

import java.util.List;

public class custom_khenthuong_adapter extends ArrayAdapter<khenthuong> {

    public custom_khenthuong_adapter(Context context, int textViewResourceId) {
        super(context, textViewResourceId);
    }
    public custom_khenthuong_adapter(Context context, int resource, List<khenthuong> items) {
        super(context, resource, items);
    }
    @Override
    public View getView(int postion , View view , ViewGroup parent) {
        View v = view;
        if (v == null) {
            LayoutInflater vi;
            vi = LayoutInflater.from(getContext());
            v = vi.inflate(R.layout.custom_khenthuong_adapter, null);

        }
        khenthuong itemm = getItem(postion);
        if (itemm != null) {


            // set Text View
            TextView tv_ten = (TextView) v.findViewById(R.id.tenongvangpolytxt);
            TextView tv_masv = (TextView) v.findViewById(R.id.masvongvang);
            TextView tv_diem = (TextView) v.findViewById(R.id.dtbongvang);

            // set text
            tv_ten.setText(itemm.getName());
            tv_masv.setText(itemm.getMasv());
            tv_diem.setText(itemm.getDTB());




        }
        return v;
    }

}
