package com.xunlei.downloadprovider.pushmessage.umeng;

import android.text.TextUtils;
import com.umeng.message.IUmengRegisterCallback;
import com.xunlei.downloadprovider.pushmessage.e;

/* compiled from: UmengPushManager */
final class b implements IUmengRegisterCallback {
    final /* synthetic */ a a;

    public final void onFailure(String str, String str2) {
    }

    b(a aVar) {
        this.a = aVar;
    }

    public final void onSuccess(String str) {
        String str2 = e.a;
        if (!TextUtils.isEmpty(str)) {
            e.a(str);
            this.a.e();
        }
    }
}
