package com.xunlei.common.businessutil;

import android.content.Context;
import com.xunlei.xllib.android.e;

final class DownloadConfig$1 implements Runnable {
    final /* synthetic */ Context val$appContext;

    DownloadConfig$1(Context context) {
        this.val$appContext = context;
    }

    public final void run() {
        String storagePath = DownloadConfig.getStoragePath(this.val$appContext);
        DownloadConfig.access$100().mStorageAvailableSize = e.a(storagePath);
        DownloadConfig.access$100().mStorageTotalSize = e.b(storagePath);
    }
}
