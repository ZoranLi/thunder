package com.xunlei.downloadprovider.personal.lixianspace.ui.fragment;

import android.os.Bundle;
import android.view.View;
import com.handmark.pulltorefresh.library.PullToRefreshBase.Mode;
import com.xunlei.downloadprovider.download.create.m;

public class LXDownloadRecordFragment extends PullToRefreshWebFragment {
    protected final void a() {
        if (this.c != null) {
            this.c.a("javascript:try{Android_XLClient_PullDownToRefresh();}catch(e){window.XLJSWebViewBridge.sendMessage('xlWebPageRefreshOver','',null);}");
            return;
        }
        super.a();
    }

    protected final void a(View view) {
        super.a(view);
        this.a.setMode(Mode.PULL_FROM_START);
    }

    public static LXDownloadRecordFragment b() {
        LXDownloadRecordFragment lXDownloadRecordFragment = new LXDownloadRecordFragment();
        Bundle bundle = new Bundle();
        bundle.putString("url", " http://lixian.xunlei.com/android/index.html?is_show_tab=false#/index");
        bundle.putString("from", "");
        bundle.putString("title", "");
        lXDownloadRecordFragment.setArguments(bundle);
        return lXDownloadRecordFragment;
    }

    public void onResume() {
        super.onResume();
        m.a().b = true;
    }
}
