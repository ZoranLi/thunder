package com.xunlei.downloadprovider.download.assistant.clipboardmonitor;

import android.content.ClipboardManager;
import android.content.ClipboardManager.OnPrimaryClipChangedListener;
import com.xunlei.common.androidutil.ClipboardUtil;
import com.xunlei.downloadprovider.app.BrothersApplication;

/* compiled from: ClipboardService */
final class k implements Runnable {
    final /* synthetic */ ClipboardService a;

    k(ClipboardService clipboardService) {
        this.a = clipboardService;
    }

    public final void run() {
        this.a.c = ClipboardUtil.getClipboardText(BrothersApplication.getApplicationInstance());
        OnPrimaryClipChangedListener onPrimaryClipChangedListener = this.a;
        try {
            onPrimaryClipChangedListener.a = (ClipboardManager) BrothersApplication.getApplicationInstance().getSystemService("clipboard");
            if (onPrimaryClipChangedListener.a != null) {
                onPrimaryClipChangedListener.a.addPrimaryClipChangedListener(onPrimaryClipChangedListener);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
