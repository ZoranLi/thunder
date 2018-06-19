package com.tencent.smtt.sdk;

import android.webkit.ValueCallback;
import java.util.Map;

public class WebStorage {
    private static WebStorage a;

    @Deprecated
    public interface QuotaUpdater {
        void updateQuota(long j);
    }

    private static synchronized WebStorage a() {
        WebStorage webStorage;
        synchronized (WebStorage.class) {
            if (a == null) {
                a = new WebStorage();
            }
            webStorage = a;
        }
        return webStorage;
    }

    public static WebStorage getInstance() {
        return a();
    }

    public void deleteAllData() {
        bk b = bk.b();
        if (b == null || !b.c()) {
            android.webkit.WebStorage.getInstance().deleteAllData();
        } else {
            b.d().n();
        }
    }

    public void deleteOrigin(String str) {
        bk b = bk.b();
        if (b == null || !b.c()) {
            android.webkit.WebStorage.getInstance().deleteOrigin(str);
        } else {
            b.d().e(str);
        }
    }

    public void getOrigins(ValueCallback<Map> valueCallback) {
        bk b = bk.b();
        if (b == null || !b.c()) {
            android.webkit.WebStorage.getInstance().getOrigins(valueCallback);
        } else {
            b.d().a((ValueCallback) valueCallback);
        }
    }

    public void getQuotaForOrigin(String str, ValueCallback<Long> valueCallback) {
        bk b = bk.b();
        if (b == null || !b.c()) {
            android.webkit.WebStorage.getInstance().getQuotaForOrigin(str, valueCallback);
        } else {
            b.d().b(str, valueCallback);
        }
    }

    public void getUsageForOrigin(String str, ValueCallback<Long> valueCallback) {
        bk b = bk.b();
        if (b == null || !b.c()) {
            android.webkit.WebStorage.getInstance().getUsageForOrigin(str, valueCallback);
        } else {
            b.d().a(str, (ValueCallback) valueCallback);
        }
    }

    @Deprecated
    public void setQuotaForOrigin(String str, long j) {
        bk b = bk.b();
        if (b == null || !b.c()) {
            android.webkit.WebStorage.getInstance().setQuotaForOrigin(str, j);
        } else {
            b.d().a(str, j);
        }
    }
}
