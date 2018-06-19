package com.xunlei.downloadprovider.launch.dispatch;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.xunlei.downloadprovider.download.b;
import com.xunlei.downloadprovider.download.create.ad;
import com.xunlei.downloadprovider.launch.e.c;
import com.xunlei.downloadprovider.launch.f.a;
import java.util.Arrays;
import java.util.HashSet;

/* compiled from: ThunderUriDISP */
public final class r extends b {
    Intent a;
    private final HashSet<String> b = new HashSet(Arrays.asList(new String[]{"taylor", "kk", "xl"}));

    protected final boolean a(Intent intent) {
        Uri data = intent.getData();
        if (data == null || !a(data)) {
            return null;
        }
        this.a = intent;
        return true;
    }

    private boolean a(Uri uri) {
        return (uri == null || this.b.contains(uri.getScheme()) == null) ? null : true;
    }

    protected final void a(Context context) {
        Uri data = this.a.getData();
        if (a(data)) {
            if ("/downloadh5".equals(data.getPath())) {
                Object queryParameter = data.getQueryParameter("down");
                String queryParameter2 = data.getQueryParameter("ref");
                String queryParameter3 = data.getQueryParameter("transid");
                String queryParameter4 = data.getQueryParameter("transargs");
                String scheme = data.getScheme();
                if (!TextUtils.isEmpty(queryParameter)) {
                    ad adVar = new ad();
                    adVar.a(queryParameter);
                    adVar.b(queryParameter2);
                    adVar.e(queryParameter3);
                    adVar.f(queryParameter4);
                    adVar.g(scheme);
                    adVar.d("BHO/thunder");
                    b.a(context, adVar, "BHO");
                }
            }
            c.a(a.a(data), a.b(data));
            c.a("BHO/thunder", true);
        }
    }
}
