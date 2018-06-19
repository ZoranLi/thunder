package com.xunlei.downloadprovider.download.taskdetails;

import android.support.v4.app.Fragment;
import com.xunlei.downloadprovider.download.tasklist.task.DownloadTaskInfo;
import com.xunlei.downloadprovider.download.tasklist.task.s;
import com.xunlei.downloadprovider.download.util.n;

public class DownloadDetailBasicFragment extends Fragment {
    protected DownloadTaskInfo h;
    protected s i;
    protected String j;

    protected final void g() {
        if (this.h != null) {
            String str = "download_detail_top";
            if ("home_collect_card".equals(this.j)) {
                str = "home_collect_detailtop";
            }
            n.a(getActivity(), str, this.h, "", "", null, "download_detail_top");
        }
    }
}
