package com.alibaba.sdk.android.feedback.util;

import android.content.Context;

final class l implements IUnreadCountCallback {
    final /* synthetic */ Context a;

    l(Context context) {
        this.a = context;
    }

    public final void onError(int i, String str) {
        k.a(false, this.a);
    }

    public final void onSuccess(int i) {
        k.a(i > 0, this.a);
    }
}
