package com.alibaba.sdk.android.feedback.xblink.c;

import android.net.Uri;
import com.tencent.smtt.sdk.TbsReaderView.ReaderCallback;
import java.util.Map;

public class h {
    private Uri a;
    private byte[] b;
    private String c = "GET";
    private Map d = null;
    private boolean e = true;
    private int f = 1;
    private int g = ReaderCallback.GET_BAR_ANIMATING;
    private int h = ReaderCallback.GET_BAR_ANIMATING;
    private String i = "NONE";

    public h(String str) {
        if (str == null) {
            throw new NullPointerException("HttpRequest init error, url is null.");
        }
        this.a = Uri.parse(str);
    }

    public Uri a() {
        return this.a;
    }

    public void a(Uri uri) {
        if (uri != null) {
            this.a = uri;
        }
    }

    public void a(Map map) {
        this.d = map;
    }

    public void a(boolean z) {
        this.e = z;
    }

    public byte[] b() {
        return this.b;
    }

    public String c() {
        return this.c;
    }

    public Map d() {
        return this.d;
    }

    public int e() {
        return this.g;
    }

    public int f() {
        return this.h;
    }

    public boolean g() {
        return this.e;
    }

    public int h() {
        return this.f;
    }

    public String i() {
        return this.i;
    }
}
