package com.xunlei.downloadprovider.download.tasklist.list.feed;

import android.content.SharedPreferences;
import com.xunlei.downloadprovider.app.BrothersApplication;

/* compiled from: PageHelper */
final class e implements Runnable {
    final /* synthetic */ d a;

    e(d dVar) {
        this.a = dVar;
    }

    public final void run() {
        d.d;
        StringBuilder stringBuilder = new StringBuilder("sync 0");
        stringBuilder.append(this.a.a.get(Integer.valueOf(0)));
        stringBuilder.append(" 1");
        stringBuilder.append(this.a.a.get(Integer.valueOf(1)));
        stringBuilder.append(" 2");
        stringBuilder.append(this.a.a.get(Integer.valueOf(2)));
        SharedPreferences sharedPreferences = BrothersApplication.getApplicationInstance().getSharedPreferences("page_sp_name", 0);
        if (sharedPreferences != null) {
            sharedPreferences.edit().putInt("DOWNLOAD_PAGE_1", d.a(this.a, 0)).putInt("DOWNLOAD_PAGE_2", d.a(this.a, 1)).putInt("DOWNLOAD_PAGE_3", d.a(this.a, 2)).commit();
        }
    }
}
