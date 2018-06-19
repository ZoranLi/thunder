package com.xunlei.downloadprovider.download.center;

import android.content.Context;
import android.support.v4.app.Fragment;

public abstract class DownloadCenterTabBaseFragment extends Fragment {
    public abstract void a();

    public abstract void b();

    public void onAttach(Context context) {
        super.onAttach(context);
    }

    public void onDestroy() {
        super.onDestroy();
    }

    public void onDetach() {
        super.onDetach();
    }
}
