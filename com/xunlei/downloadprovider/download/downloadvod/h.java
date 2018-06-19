package com.xunlei.downloadprovider.download.downloadvod;

import android.os.Bundle;
import com.xunlei.downloadprovider.app.BrothersApplication;
import com.xunlei.downloadprovider.h.c;

/* compiled from: PluginObtainDownloadVodInfoListener */
public final class h implements g {
    private String a;

    public h(String str) {
        this.a = str;
    }

    public final void a(int i, DownloadVodInfo downloadVodInfo) {
        Bundle bundle = new Bundle(12);
        bundle.putInt("result", i);
        bundle.putString("errMsg", null);
        bundle.putString("callbackKey", this.a);
        if (downloadVodInfo != null) {
            downloadVodInfo.toBundle(bundle);
        }
        c.a(BrothersApplication.getApplicationInstance(), "com.xunlei.downloadprovider.ACTION_OBTAIN_DOWNLOADVODINFO", bundle);
    }
}
