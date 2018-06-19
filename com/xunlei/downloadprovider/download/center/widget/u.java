package com.xunlei.downloadprovider.download.center.widget;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import com.qihoo360.replugin.RePlugin;
import com.xunlei.downloadprovider.plugin.q;
import com.xunlei.downloadprovider.plugin.q.a;
import com.xunlei.xllib.android.XLIntent;

/* compiled from: DownloadCreateMoreTaskDialog */
final class u implements a {
    final /* synthetic */ p a;

    public final void onPluginFail(int i) {
    }

    public final void onPluginProgressUpdate(int i) {
    }

    u(p pVar) {
        this.a = pVar;
    }

    public final void onPluginPrepared() {
        q.a();
        Context context = this.a.getContext();
        if (q.b()) {
            Intent xLIntent = new XLIntent();
            xLIntent.setComponent(new ComponentName("com.xunlei.plugin.qrcode", "com.xunlei.plugin.qrcode.CameraActivity"));
            xLIntent.putExtra("fromWhere", 2);
            RePlugin.startActivity(context, xLIntent);
        }
    }
}
