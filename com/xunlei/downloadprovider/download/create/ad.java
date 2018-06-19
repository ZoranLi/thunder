package com.xunlei.downloadprovider.download.create;

import android.os.Bundle;
import com.alipay.sdk.cons.c;

/* compiled from: DownloadArguments */
public final class ad {
    public Bundle a = new Bundle(9);

    public ad(Bundle bundle) {
        this.a = bundle;
    }

    public final String a() {
        return this.a.getString("url");
    }

    public final void a(String str) {
        this.a.putString("url", str);
    }

    public final String b() {
        return this.a.getString("refurl");
    }

    public final void b(String str) {
        this.a.putString("refurl", str);
    }

    public final String c() {
        return this.a.getString(c.e);
    }

    public final String c(String str) {
        return this.a.getString("create_origin", str);
    }

    public final void d(String str) {
        this.a.putString("create_origin", str);
    }

    public final String d() {
        return this.a.getString("h5transid");
    }

    public final void e(String str) {
        this.a.putString("h5transid", str);
    }

    public final String e() {
        return this.a.getString("h5transargs");
    }

    public final void f(String str) {
        this.a.putString("h5transargs", str);
    }

    public final void g(String str) {
        this.a.putString("scheme", str);
    }

    public final String f() {
        return this.a.getString("scheme");
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("DownloadArguments{mArguments=");
        stringBuilder.append(this.a);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
