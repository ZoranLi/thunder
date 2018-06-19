package com.xunlei.downloadprovider.personal.settings.a;

import com.alibaba.sdk.android.feedback.util.IUnreadCountCallback;
import com.xunlei.downloadprovider.app.BrothersApplication;
import com.xunlei.downloadprovider.h.f;

/* compiled from: AliFeedbackHelper */
final class e implements IUnreadCountCallback {
    public final void onError(int i, String str) {
    }

    e() {
    }

    public final void onSuccess(int i) {
        int b = f.b(BrothersApplication.getApplicationInstance(), a.a, 0);
        StringBuilder stringBuilder = new StringBuilder("last unread: ");
        stringBuilder.append(b);
        stringBuilder.append("  count: ");
        stringBuilder.append(i);
        stringBuilder.append(" hasDisplayUnread");
        stringBuilder.append(a.c);
        if (b != i && !a.c) {
            a.c = true;
            a.c(i);
            a.b(i);
        }
    }
}
