package com.xunlei.downloadprovider.launch.dispatch;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.xunlei.common.androidutil.ClipboardUtil;
import com.xunlei.downloadprovider.app.BrothersApplication;
import com.xunlei.downloadprovider.bho.BHOActivity;
import com.xunlei.downloadprovider.download.assistant.clipboardmonitor.j;
import com.xunlei.downloadprovider.download.b;
import com.xunlei.downloadprovider.download.create.ad;
import com.xunlei.downloadprovider.download.create.m;
import com.xunlei.downloadprovider.launch.e.c;
import com.xunlei.downloadprovider.launch.f.a;
import java.net.URLDecoder;

/* compiled from: BhoDISP */
public final class e extends b {
    private Intent a;

    protected final boolean a(Intent intent) {
        this.a = intent;
        boolean z = false;
        if (this.a != null) {
            if (this.a.getIntExtra("dispatch_from_key", -1) == 1100) {
                z = true;
            }
            if (z) {
                return true;
            }
            intent = this.a.getData();
            if (intent != null && "xunleiapp".equals(intent.getScheme()) && "xunlei.com".equals(intent.getHost()) && "/sharePage".equals(intent.getPath()) != null) {
                z = true;
            }
        }
        return z;
    }

    protected final void a(Context context) {
        new StringBuilder("enterConcreateActivity ").append(getClass().getSimpleName());
        boolean z = true;
        c.a("BHO", true);
        Intent intent = this.a;
        Uri data = intent.getData();
        if (data != null) {
            String dataString = intent.getDataString();
            ad adVar = new ad();
            if ("xunleiapp".equals(data.getScheme()) && "xunlei.com".equals(data.getHost()) && "/sharePage".equals(data.getPath())) {
                a(data, adVar, "BHO/thunder");
            } else {
                boolean z2;
                if (dataString != null) {
                    if (!dataString.startsWith("magnet")) {
                        if (!dataString.startsWith("thunder")) {
                            if (!dataString.startsWith("ed2k")) {
                                if (dataString.startsWith("ftp://") && !dataString.endsWith("/")) {
                                }
                            }
                        }
                    }
                    z2 = true;
                    if (z2) {
                        adVar.a(dataString);
                        adVar.d("BHO/other");
                    }
                }
                z2 = false;
                if (z2) {
                    adVar.a(dataString);
                    adVar.d("BHO/other");
                }
            }
            if (!TextUtils.isEmpty(adVar.a())) {
                if ("xunleiapp".equals(data.getScheme())) {
                    c.a(a.a(data), a.b(data));
                }
                b.a(context, adVar, "BHO");
                if (z) {
                    this.a.setClass(context, BHOActivity.class);
                    this.a.putExtra("dispatch_from_key", 0);
                    context.startActivity(this.a);
                }
            }
        }
        z = false;
        if (z) {
            this.a.setClass(context, BHOActivity.class);
            this.a.putExtra("dispatch_from_key", 0);
            context.startActivity(this.a);
        }
    }

    public static void a(Uri uri, ad adVar, String str) {
        String queryParameter = uri.getQueryParameter("taskDownload");
        String queryParameter2 = uri.getQueryParameter("fileNameDetail");
        if (queryParameter2 != null) {
            try {
                queryParameter2 = URLDecoder.decode(queryParameter2, "utf-8");
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            queryParameter2 = "";
        }
        String queryParameter3 = uri.getQueryParameter("ref");
        if (TextUtils.isEmpty(queryParameter3)) {
            queryParameter3 = uri.getQueryParameter("rel");
        }
        adVar.a(queryParameter);
        adVar.b(queryParameter3);
        adVar.a.putString(com.alipay.sdk.cons.c.e, queryParameter2);
        adVar.g(uri.getScheme());
        adVar.e(uri.getQueryParameter("transid"));
        adVar.f(uri.getQueryParameter("transargs"));
        if (TextUtils.isEmpty(adVar.d()) && TextUtils.isEmpty(adVar.e())) {
            if (TextUtils.isEmpty(uri.getQueryParameter("thunderPid")) != null) {
                adVar.d("manual/share_h5");
                ClipboardUtil.copyToClipboard(BrothersApplication.getApplicationInstance(), queryParameter, "text");
                m.a().a(queryParameter);
                m.a().b = true;
                j.a().b = queryParameter;
            }
        }
        if (TextUtils.isEmpty(str) != null) {
            str = "BHO/thunder";
        }
        adVar.d(str);
        ClipboardUtil.copyToClipboard(BrothersApplication.getApplicationInstance(), queryParameter, "text");
        m.a().a(queryParameter);
        m.a().b = true;
        j.a().b = queryParameter;
    }
}
