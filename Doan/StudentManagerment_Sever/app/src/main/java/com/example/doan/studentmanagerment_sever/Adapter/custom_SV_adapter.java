package com.example.doan.studentmanagerment_sever.Adapter;


import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.doan.studentmanagerment_sever.R;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.List;
import com.example.doan.studentmanagerment_sever.Contructor.student_pt11304;
public class custom_SV_adapter extends ArrayAdapter<student_pt11304> {
        ImageView img ;
    public custom_SV_adapter(Context context, int textViewResourceId) {
        super(context, textViewResourceId);
    }

    public custom_SV_adapter(Context context, int resource, List<student_pt11304> items) {
        super(context, resource, items);
    }
    @Override
    public View getView(int postion , View view , ViewGroup parent) {
        View v = view;
        if (v == null) {
            LayoutInflater vi;
            vi = LayoutInflater.from(getContext());
            v = vi.inflate(R.layout.custom_sv_adapter, null);
        }
        student_pt11304 item = getItem(postion);
        if (item != null) {
            // ánh xạ + giá trị
            img = v.findViewById(R.id.imgview);
            // hình ảnh từ link
            new AsyncTaskLoadImage(img).execute(item.link);
            // set Text View
            TextView tv_name = (TextView) v.findViewById(R.id.tv_item_name);
            TextView tv_age = (TextView) v.findViewById(R.id.tv_item_masv);
            TextView tv_id = (TextView) v.findViewById(R.id.tv_item_mark);
            // set text
            tv_name.setText(item.name);
            tv_age.setText(item.masv);
            tv_id.setText(item.DTB);
        }
        return v;
    }
    public class AsyncTaskLoadImage  extends AsyncTask<String, String, Bitmap> {
        private final static String TAG = "AsyncTaskLoadImage";
        private ImageView imageView;
        public AsyncTaskLoadImage(ImageView imageView) {
            this.imageView = imageView;
        }
        @Override
        protected Bitmap doInBackground(String... params) {
            Bitmap bitmap = null;
            try {
                URL url = new URL(params[0]);
                bitmap = BitmapFactory.decodeStream((InputStream)url.getContent());
            } catch (IOException e) {
                Log.e(TAG, e.getMessage());
            }
            return bitmap;
        }
        @Override
        protected void onPostExecute(Bitmap bitmap) {
            imageView.setImageBitmap(bitmap);
        }
   }
}
