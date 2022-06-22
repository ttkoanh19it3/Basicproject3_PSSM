package com.example.doan.studentmanagerment_sever.Adapter;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.doan.studentmanagerment_sever.Contructor.monhoc;
import com.example.doan.studentmanagerment_sever.R;

import java.util.List;
public class custom_monhoc_adapter extends ArrayAdapter<monhoc> {
    ImageView img ;
    public custom_monhoc_adapter(Context context, int textViewResourceId) {
        super(context, textViewResourceId);
    }
    public custom_monhoc_adapter(Context context, int resource, List<monhoc> items) {
        super(context, resource, items);
    }
    @Override
    public View getView(int postion , View view , ViewGroup parent) {
        View v = view;
        if (v == null) {
            LayoutInflater vi;
            vi = LayoutInflater.from(getContext());
            v = vi.inflate(R.layout.custom_monhoc_adapter, null);
        }
        monhoc itemm = getItem(postion);
        if (itemm != null) {
            // set Text View
            TextView tv_tenmon = (TextView) v.findViewById(R.id.tv_item_tenmon);
            TextView tv_nganh = (TextView) v.findViewById(R.id.tv_item_nganh);
            // set text
            tv_tenmon.setText(itemm.getTenmon());
            tv_nganh.setText(itemm.getThuocnganh());
        }
        return v;
    }
}
