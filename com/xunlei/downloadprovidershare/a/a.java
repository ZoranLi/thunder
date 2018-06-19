package com.xunlei.downloadprovidershare.a;

import android.content.Context;
import com.xunlei.downloadprovidershare.ShareOperationType;
import com.xunlei.downloadprovidershare.y;
import com.xunlei.xllib.b.k;
import java.util.HashMap;

/* compiled from: ShareBrowserInfo */
public final class a extends f {
    private String a;

    public a(String str, String str2, String str3, String str4) {
        super(str, str2, str3);
        this.a = str4;
    }

    public final boolean a(Context context, ShareOperationType shareOperationType, com.xunlei.downloadprovidershare.a.a aVar) {
        HashMap c = f.c();
        c.put("targetUrl", k.a(this.a, "UTF-8"));
        c.put("pictureUrl", k.a(this.h, "UTF-8"));
        c.put("title", k.a(a(), "UTF-8"));
        c.put("content", k.a(b(), "UTF-8"));
        this.f = y.a(this.f, c);
        return super.a(context, shareOperationType, aVar);
    }
}
