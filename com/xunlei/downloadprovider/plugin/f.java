package com.xunlei.downloadprovider.plugin;

import android.app.Activity;
import com.xunlei.common.commonview.XLToast;
import com.xunlei.downloadprovider.plugin.q.a;

/* compiled from: XLPluginDownloadManager */
final class f implements a {
    final /* synthetic */ Activity a;
    final /* synthetic */ boolean b = true;
    final /* synthetic */ a c;
    final /* synthetic */ a d;

    f(a aVar, Activity activity, a aVar2) {
        this.d = aVar;
        this.a = activity;
        this.c = aVar2;
    }

    public final void onPluginProgressUpdate(int i) {
        a.a(this.d, this.a, i, this.b);
        this.c.onPluginProgressUpdate(i);
    }

    public final void onPluginPrepared() {
        a.d(this.d);
        this.c.onPluginPrepared();
    }

    public final void onPluginFail(int i) {
        a.d(this.d);
        if (i != -1) {
            switch (i) {
                case 1:
                    XLToast.showNoNetworkToast(this.a);
                    break;
                case 2:
                case 3:
                    break;
                case 4:
                    XLToast.showToast(this.a, "下载插件失败");
                    break;
                case 5:
                    XLToast.showToast(this.a, "安装插件失败");
                    break;
                case 6:
                    XLToast.showToast(this.a, "插件来自非法来源，请点击重新下载安装");
                    break;
                case 7:
                    break;
                default:
                    XLToast.showNoNetworkToast(this.a);
                    break;
            }
        }
        XLToast.showToast(this.a, "获取插件失败");
        this.c.onPluginFail(i);
    }
}
