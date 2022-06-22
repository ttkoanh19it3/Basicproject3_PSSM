package com.example.doan.studentmanagerment_sever.Fragment;


import android.app.ProgressDialog;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import com.example.doan.studentmanagerment_sever.Activity.Monhoc_Activity;
import com.example.doan.studentmanagerment_sever.R;
public class Fragment_monhoc_dsmon extends Fragment {
    private static View view;
    private WebView webview ;
    private ProgressDialog progDailog;  // loader
    String GoogleDocs="http://docs.google.com/gview?embedded=true&url=";
    // google docs support url.
  private   String urlPDf= "";

    public Fragment_monhoc_dsmon() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_fragment_monhoc_dsmon, container, false);
        Bundle bundle=getArguments();
      String linkk = bundle.getString("link");
        urlPDf = linkk;
        Toast.makeText(getActivity(), linkk, Toast.LENGTH_SHORT).show();
        Monhoc_Activity.txttile.setText("Giới thiệu về môn học");
        // anhxa
         webview = (WebView) view.findViewById(R.id.webview);
        // progess
        progDailog = ProgressDialog.show(getActivity(), "Loading","Please wait...", true);
        progDailog.setCancelable(false);
        // set webview
        webview.getSettings().setJavaScriptEnabled(true);
        webview.getSettings().setLoadWithOverviewMode(true);
        webview.getSettings().setUseWideViewPort(true);
        //following lines are to show the loader untile downloading the pdf file for view.
        webview.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                progDailog.show();
                view.loadUrl(url);
                return true;
            }
            @Override
            public void onPageFinished(WebView view, final String url) {
                progDailog.dismiss();
            }
        });
        webview.loadUrl(urlPDf);   // webview loader to load the URL of file
        // Inflate the layout for this fragment
        return view;
    }

}

