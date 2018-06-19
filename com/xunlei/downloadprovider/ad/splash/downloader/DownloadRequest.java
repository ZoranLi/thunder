package com.xunlei.downloadprovider.ad.splash.downloader;

import android.net.Uri;
import anet.channel.util.HttpConstant;
import java.util.HashMap;

public final class DownloadRequest implements Comparable<DownloadRequest> {
    int a;
    int b;
    Uri c;
    public Uri d;
    public j e;
    boolean f = false;
    public boolean g = true;
    d h;
    public i i;
    HashMap<String, String> j;
    private Priority k = Priority.NORMAL;

    public enum Priority {
        LOW,
        NORMAL,
        HIGH,
        IMMEDIATE
    }

    public final /* synthetic */ int compareTo(Object obj) {
        DownloadRequest downloadRequest = (DownloadRequest) obj;
        Priority priority = this.k;
        Priority priority2 = downloadRequest.k;
        if (priority == priority2) {
            return this.b - downloadRequest.b;
        }
        return priority2.ordinal() - priority.ordinal();
    }

    public DownloadRequest(Uri uri) {
        if (uri == null) {
            throw new NullPointerException();
        }
        String scheme = uri.getScheme();
        if (scheme != null) {
            if (scheme.equals(HttpConstant.HTTP) || scheme.equals("https")) {
                this.j = new HashMap();
                this.a = 1;
                this.c = uri;
                return;
            }
        }
        StringBuilder stringBuilder = new StringBuilder("Can only download HTTP/HTTPS URIs: ");
        stringBuilder.append(uri);
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    public final j a() {
        return this.e == null ? new a() : this.e;
    }

    final void b() {
        d dVar = this.h;
        if (dVar.a != null) {
            synchronized (dVar.a) {
                dVar.a.remove(this);
            }
        }
    }
}
