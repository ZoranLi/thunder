package com.xunlei.downloadprovider.ad.cache.b;

import android.os.Handler;
import android.os.Message;
import com.xunlei.downloadprovider.ad.common.adget.ADConst.THUNDER_AD_INFO.STYLES_INFO;
import com.xunlei.downloadprovider.ad.common.adget.l;
import com.xunlei.downloadprovider.ad.common.h.a;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/* compiled from: RequestHandler */
final class j implements a {
    final /* synthetic */ int a;
    final /* synthetic */ STYLES_INFO b;
    final /* synthetic */ Handler c;
    final /* synthetic */ String d;
    final /* synthetic */ int e;
    final /* synthetic */ int f;
    final /* synthetic */ i g;

    j(i iVar, int i, STYLES_INFO styles_info, Handler handler, String str, int i2, int i3) {
        this.g = iVar;
        this.a = i;
        this.b = styles_info;
        this.c = handler;
        this.d = str;
        this.e = i2;
        this.f = i3;
    }

    public final void a(List<l> list) {
        StringBuilder stringBuilder = new StringBuilder("startCache onLoadComplete result: ");
        stringBuilder.append(Arrays.toString(list.toArray()));
        stringBuilder.append(" retryTimes: ");
        stringBuilder.append(this.a);
        if (!list.isEmpty()) {
            STYLES_INFO styles_info = this.b;
            Handler handler = this.c;
            Message obtainMessage = handler.obtainMessage(1000);
            Map hashMap = new HashMap();
            hashMap.put(styles_info, list);
            obtainMessage.obj = hashMap;
            handler.sendMessage(obtainMessage);
        }
    }

    public final void a(int i, String str) {
        String.format(Locale.CHINA, "startCache onLoadFail errorCode: %d errorInfo: %s, currentRetryTimes: %d", new Object[]{Integer.valueOf(i), str, Integer.valueOf(this.a)});
        i iVar = this.g;
        i = this.a;
        String str2 = this.d;
        STYLES_INFO styles_info = this.b;
        int i2 = this.e;
        int i3 = this.f;
        Handler handler = this.c;
        if (i > 0) {
            iVar.a(str2, styles_info, i2, i3, i - 1, handler);
        }
    }
}
