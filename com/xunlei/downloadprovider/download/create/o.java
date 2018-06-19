package com.xunlei.downloadprovider.download.create;

import android.os.Handler;
import android.text.TextUtils;
import com.alipay.sdk.util.e;
import com.xunlei.common.androidutil.ClipboardUtil;
import com.xunlei.downloadprovider.app.AppStatusChgObserver;
import com.xunlei.downloadprovider.app.BrothersApplication;
import com.xunlei.downloadprovider.h.k.a;
import com.xunlei.downloadprovider.h.k.b;
import com.xunlei.downloadprovidershare.q$a;

/* compiled from: ClipboardHandler */
final class o implements q$a {
    final /* synthetic */ String a;
    final /* synthetic */ m b;

    o(m mVar, String str) {
        this.b = mVar;
        this.a = str;
    }

    public final void a(String str) {
        if (e.b.equals(str)) {
            new Handler().post(new p(this));
            return;
        }
        if (!TextUtils.isEmpty(str)) {
            if (!AppStatusChgObserver.b().a()) {
                b a = a.a(ClipboardUtil.getClipboardText(BrothersApplication.getApplicationInstance()));
                if (this.a.equals(a.a != null ? a.a.trim() : null)) {
                    ClipboardHandlerActivity.a(str, "thunder_command");
                }
            }
        }
    }
}
