package com.tencent.smtt.sdk;

import android.content.Context;
import com.tencent.smtt.sdk.QbSdk.PreInitCallback;

final class h implements TbsListener {
    final /* synthetic */ Context a;
    final /* synthetic */ PreInitCallback b;

    h(Context context, PreInitCallback preInitCallback) {
        this.a = context;
        this.b = preInitCallback;
    }

    public final void onDownloadFinish(int i) {
    }

    public final void onDownloadProgress(int i) {
    }

    public final void onInstallFinish(int i) {
        QbSdk.preInit(this.a, this.b);
    }
}
