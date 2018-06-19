package com.xunlei.downloadprovider.download.assistant.clipboardmonitor;

import android.text.TextUtils;
import com.alipay.sdk.util.e;
import com.xunlei.downloadprovidershare.q$a;

/* compiled from: ClipTipViewController */
final class h implements q$a {
    final /* synthetic */ String a;
    final /* synthetic */ boolean b;
    final /* synthetic */ String c;
    final /* synthetic */ f d;

    h(f fVar, String str, boolean z, String str2) {
        this.d = fVar;
        this.a = str;
        this.b = z;
        this.c = str2;
    }

    public final void a(String str) {
        if (!TextUtils.isEmpty(str)) {
            if (!str.equals(e.b)) {
                f.b(this.d).post(new i(this, str));
            }
        }
    }
}
