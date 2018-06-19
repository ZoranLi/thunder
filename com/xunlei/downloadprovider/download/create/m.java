package com.xunlei.downloadprovider.download.create;

import android.content.ClipboardManager;
import android.content.ClipboardManager.OnPrimaryClipChangedListener;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.xunlei.common.androidutil.ClipboardUtil;
import com.xunlei.downloadprovider.app.AppStatusChgObserver;
import com.xunlei.downloadprovider.app.AppStatusChgObserver.a;
import com.xunlei.downloadprovider.app.BrothersApplication;
import com.xunlei.downloadprovider.h.k;
import com.xunlei.downloadprovider.h.k.b;
import com.xunlei.downloadprovidershare.q;

/* compiled from: ClipboardHandler */
public final class m implements OnPrimaryClipChangedListener {
    private static m e = new m();
    public boolean a = false;
    public boolean b = false;
    private ClipboardManager c;
    private SharedPreferences d;
    private a f = new n(this);

    public static m a() {
        return e;
    }

    private m() {
        AppStatusChgObserver.b().a(this.f);
        this.c = (ClipboardManager) BrothersApplication.getApplicationInstance().getSystemService("clipboard");
        this.c.addPrimaryClipChangedListener(this);
        this.d = BrothersApplication.getApplicationInstance().getSharedPreferences("shared_save_url_from_clip_board", 0);
    }

    public final void b() {
        b a = k.a.a(ClipboardUtil.getClipboardText(BrothersApplication.getApplicationInstance()));
        a(a.a != null ? a.a.trim() : null);
    }

    public final void onPrimaryClipChanged() {
        c();
    }

    public final void c() {
        if (this.a) {
            b a = k.a.a(ClipboardUtil.getClipboardText(BrothersApplication.getApplicationInstance()));
            String trim = a.a != null ? a.a.trim() : null;
            if (!TextUtils.isEmpty(trim)) {
                if (!this.d.getString("last_copy_text", "").equals(trim)) {
                    a(trim);
                    if (k.h(trim) != 1 || k.c(trim)) {
                        if (q.a(trim)) {
                            q.a(trim, new o(this, trim));
                        }
                        return;
                    }
                    ClipboardHandlerActivity.a(trim, "download_link");
                }
            }
        }
    }

    public final void a(String str) {
        this.d.edit().putString("last_copy_text", str).apply();
    }
}
