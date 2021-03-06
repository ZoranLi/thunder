package com.xunlei.downloadprovider.download.util;

import android.content.ClipboardManager;
import android.content.ClipboardManager.OnPrimaryClipChangedListener;
import android.content.Context;
import com.xunlei.common.commonview.XLToast;
import com.xunlei.downloadprovider.R;

/* compiled from: DownloadCenterTaskUtil */
final class b implements OnPrimaryClipChangedListener {
    final /* synthetic */ ClipboardManager a;
    final /* synthetic */ Context b;

    b(ClipboardManager clipboardManager, Context context) {
        this.a = clipboardManager;
        this.b = context;
    }

    public final void onPrimaryClipChanged() {
        try {
            this.a.removePrimaryClipChangedListener(this);
        } catch (Exception e) {
            e.printStackTrace();
        }
        XLToast.showToast(this.b, this.b.getString(R.string.copy_to_clipboard_success));
    }
}
