package com.xunlei.downloadprovider.download.control;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

public class DownloadListControl extends Fragment {
    String a;

    public static DownloadListControl a(String str) {
        Bundle bundle = new Bundle(9);
        bundle.putString("control_name", str);
        str = new DownloadListControl();
        str.setArguments(bundle);
        return str;
    }

    public void onAttach(Context context) {
        super.onAttach(context);
    }

    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        bundle = getArguments();
        if (bundle != null) {
            this.a = bundle.getString("control_name");
        }
    }

    public void onStart() {
        super.onStart();
    }

    public void onResume() {
        super.onResume();
    }

    public void onPause() {
        super.onPause();
    }

    public void onStop() {
        super.onStop();
    }

    public void onDestroy() {
        super.onDestroy();
    }

    public void onDetach() {
        super.onDetach();
    }
}
