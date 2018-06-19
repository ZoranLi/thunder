package com.xunlei.downloadprovider.personal.settings.a;

import com.alibaba.sdk.android.feedback.util.IUnreadCountCallback;

/* compiled from: AliFeedbackHelper */
final class d implements IUnreadCountCallback {
    final /* synthetic */ c a;

    public final void onError(int i, String str) {
    }

    d(c cVar) {
        this.a = cVar;
    }

    public final void onSuccess(int i) {
        a.c(i);
    }
}
