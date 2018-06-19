package com.xunlei.downloadprovider.search.ui.search;

import android.text.TextUtils;
import com.alipay.sdk.util.e;
import com.xunlei.common.androidutil.ClipboardUtil;
import com.xunlei.downloadprovider.app.BrothersApplication;
import com.xunlei.downloadprovider.h.k.a;
import com.xunlei.downloadprovider.h.k.b;
import com.xunlei.downloadprovidershare.q$a;

/* compiled from: SearchOperateActivity */
final class bg implements q$a {
    final /* synthetic */ String a;
    final /* synthetic */ SearchOperateActivity b;

    bg(SearchOperateActivity searchOperateActivity, String str) {
        this.b = searchOperateActivity;
        this.a = str;
    }

    public final void a(String str) {
        if (!TextUtils.isEmpty(str)) {
            if (!str.equals(e.b)) {
                b a = a.a(ClipboardUtil.getClipboardText(BrothersApplication.getApplicationInstance()));
                if (this.a.equals(a.a != null ? a.a.trim() : null)) {
                    this.b.runOnUiThread(new bh(this, str));
                }
            }
        }
    }
}
