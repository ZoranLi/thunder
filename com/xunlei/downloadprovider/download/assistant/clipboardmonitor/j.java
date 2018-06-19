package com.xunlei.downloadprovider.download.assistant.clipboardmonitor;

import android.content.ClipData;
import android.content.ClipData.Item;
import android.content.ClipboardManager;
import android.content.ClipboardManager.OnPrimaryClipChangedListener;
import android.text.TextUtils;
import com.alipay.sdk.util.h;
import com.xunlei.common.androidutil.ClipboardUtil;
import com.xunlei.downloadprovider.app.BrothersApplication;
import com.xunlei.downloadprovider.h.k;
import com.xunlei.downloadprovider.h.k.a;
import com.xunlei.downloadprovider.h.k.b;
import com.xunlei.downloadprovidershare.q;

/* compiled from: ClipboardMonitor */
public final class j implements OnPrimaryClipChangedListener {
    private static j c = new j();
    public ClipboardManager a;
    public String b = ClipboardUtil.getClipboardText(BrothersApplication.getApplicationInstance());

    public static j a() {
        return c;
    }

    private j() {
    }

    public final void onPrimaryClipChanged() {
        b();
    }

    public final synchronized void b() {
        String trim;
        StringBuilder stringBuilder;
        b a;
        boolean z;
        int i;
        ClipboardManager clipboardManager = this.a;
        String str = null;
        if (clipboardManager != null) {
            ClipData primaryClip;
            try {
                primaryClip = clipboardManager.getPrimaryClip();
            } catch (Throwable th) {
                th.printStackTrace();
                primaryClip = null;
            }
            if (primaryClip != null && primaryClip.getItemCount() > 0) {
                Item itemAt = primaryClip.getItemAt(0);
                if (itemAt.getText() != null) {
                    trim = itemAt.getText().toString().trim();
                    if (!(TextUtils.isEmpty(trim) || trim.equals(this.b))) {
                        this.b = trim;
                        stringBuilder = new StringBuilder("onPrimaryClipChanged - Text{");
                        stringBuilder.append(trim);
                        stringBuilder.append(h.d);
                        a = a.a(trim);
                        if (a.a != null) {
                            str = a.a.trim();
                        }
                        z = a.b;
                        i = 1;
                        if (!TextUtils.isEmpty(str)) {
                            if (1 == k.h(str)) {
                                if (a.d(str)) {
                                    i = 2;
                                } else if (q.a(str)) {
                                    i = 4;
                                }
                                f.b().a(str, z, i, "shoulei");
                            } else if (!k.c(str)) {
                                f.b().a(str, z, i, "shoulei");
                            }
                        }
                        i = 3;
                        f.b().a(str, z, i, "shoulei");
                    }
                }
            }
        }
        trim = null;
        this.b = trim;
        stringBuilder = new StringBuilder("onPrimaryClipChanged - Text{");
        stringBuilder.append(trim);
        stringBuilder.append(h.d);
        a = a.a(trim);
        if (a.a != null) {
            str = a.a.trim();
        }
        z = a.b;
        i = 1;
        if (TextUtils.isEmpty(str)) {
            if (1 == k.h(str)) {
                if (a.d(str)) {
                    i = 2;
                } else if (q.a(str)) {
                    i = 4;
                }
                f.b().a(str, z, i, "shoulei");
            } else if (k.c(str)) {
                f.b().a(str, z, i, "shoulei");
            }
        }
        i = 3;
        f.b().a(str, z, i, "shoulei");
    }
}
