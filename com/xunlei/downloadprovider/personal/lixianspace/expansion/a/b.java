package com.xunlei.downloadprovider.personal.lixianspace.expansion.a;

import android.content.Context;
import android.text.TextUtils;
import com.xunlei.common.encrypt.AES;
import com.xunlei.common.encrypt.Base64;
import com.xunlei.downloadprovider.app.BrothersApplication;
import com.xunlei.downloadprovider.h.e;
import com.xunlei.downloadprovider.member.login.LoginHelper;
import com.xunlei.downloadprovider.member.login.b.l;
import com.xunlei.downloadprovider.personal.lixianspace.d.j;

/* compiled from: LXSpaceDownloadConfig */
public class b {
    private static String a = "b";
    private a b;
    private Context c;
    private boolean d;

    /* compiled from: LXSpaceDownloadConfig */
    public interface a {
        void a(boolean z);
    }

    public b(Context context, a aVar) {
        this.c = context;
        this.b = aVar;
    }

    private void a(boolean z) {
        if (this.b != null) {
            this.b.a(z);
        }
    }

    private static String b() {
        try {
            Object stringBuilder = e.a(c(), "UTF-8").toString();
            if (!TextUtils.isEmpty(stringBuilder)) {
                byte[] decode = Base64.decode(stringBuilder);
                if (decode != null) {
                    decode = AES.decrypt(decode, "lx-psw");
                    if (decode != null) {
                        return new String(decode);
                    }
                }
            }
        } catch (Exception e) {
            new StringBuilder("deSerialize faild=").append(e.getMessage());
        }
        return null;
    }

    private static String c() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(BrothersApplication.getApplicationInstance().getFilesDir().getPath());
        stringBuilder.append("/lx-download-config.ldc");
        return stringBuilder.toString();
    }

    public final void a(Object obj) {
        boolean z = false;
        this.d = false;
        String b = b();
        if (!TextUtils.isEmpty(b)) {
            this.d = true;
            a.a(b);
            a(true);
        }
        LoginHelper.a();
        if (l.c()) {
            com.xunlei.downloadprovider.personal.lixianspace.a.a a = a.a;
            long currentTimeMillis = System.currentTimeMillis();
            if (a.b <= 0) {
                a.b = a.a.getLong("LX_SP_KEY_DOWNLOAD_CONFIG_TIME", 0);
            }
            if (currentTimeMillis - a.b > 86400000) {
                z = true;
            }
            if (z) {
                new j(obj).a(new c(this));
                return;
            }
            return;
        }
        a(false);
    }

    static /* synthetic */ void a(String str) {
        try {
            str = AES.encrypt(str, "lx-psw");
            if (str != null) {
                str = Base64.encode(str);
                if (!TextUtils.isEmpty(str)) {
                    e.b(c(), str);
                }
            }
        } catch (String str2) {
            new StringBuilder("serialize faild=").append(str2.getLocalizedMessage());
        }
    }
}
