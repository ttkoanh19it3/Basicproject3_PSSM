package com.example.doan.studentmanagerment_sever.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.doan.studentmanagerment_sever.Contructor.lichhoc;
import com.example.doan.studentmanagerment_sever.R;

import java.util.List;
public class custom_lichhoc_adapter extends ArrayAdapter<lichhoc> {

    public custom_lichhoc_adapter(Context context, int textViewResourceId) {
        super(context, textViewResourceId);
    }
    public custom_lichhoc_adapter(Context context, int resource, List<lichhoc> items) {
        super(context, resource, items);
    }
    @Override
    public View getView(int postion , View view , ViewGroup parent) {
        View v = view;
        if (v == null) {
            LayoutInflater vi;
            vi = LayoutInflater.from(getContext());
            v = vi.inflate(R.layout.custom_lichhoc_adapter, null);
        }
        lichhoc itemm = getItem(postion);
        if (itemm != null) {
            // set Text View
            TextView tv_thu = (TextView) v.findViewById(R.id.tv_item_thu);
            TextView tv_mon = (TextView) v.findViewById(R.id.tv_item_monhoc);
            TextView tv_giaovien = (TextView) v.findViewById(R.id.tv_item_giaovien);
            // set text
            tv_thu.setText(itemm.getThu());
            tv_mon.setText(itemm.getMonhoc());
            tv_giaovien.setText(itemm.getGiaovien());
        }
        return v;
    }

}
