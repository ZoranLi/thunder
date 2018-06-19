package com.xunlei.downloadprovidershare.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import anet.channel.strategy.dispatch.DispatchConstants;
import com.xunlei.downloadprovidershare.R;
import com.xunlei.downloadprovidershare.ShareOperationType;
import com.xunlei.downloadprovidershare.a.a;
import com.xunlei.downloadprovidershare.b.d;
import java.util.HashMap;

/* compiled from: ShareInfo */
public class f {
    private String a;
    public String c;
    public String d;
    String e = "看尽无限精彩，上迅雷APP！";
    public String f;
    public Bitmap g;
    public String h;
    public int i = R.drawable.ic_website_share_default;
    public String j;
    public String k;
    public int l = 1;

    public void a(d dVar) {
    }

    public f(String str, String str2, String str3) {
        this.c = str3;
        this.f = str2;
        this.j = str;
    }

    public final String a() {
        if (TextUtils.isEmpty(this.c)) {
            return this.a;
        }
        return this.c;
    }

    public final String b() {
        if (TextUtils.isEmpty(this.d)) {
            return this.e;
        }
        return this.d;
    }

    protected static HashMap<String, String> c() {
        HashMap<String, String> hashMap = new HashMap();
        hashMap.put("origin", "a_sl_app_v5.60.2.5510");
        hashMap.put("appVersion", "11100");
        hashMap.put("appType", DispatchConstants.ANDROID);
        return hashMap;
    }

    public boolean a(Context context, ShareOperationType shareOperationType, a aVar) {
        if (aVar != null) {
            aVar.a(true, this);
        }
        return null;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("ShareInfo{mTitle='");
        stringBuilder.append(this.c);
        stringBuilder.append('\'');
        stringBuilder.append(", mFrom='");
        stringBuilder.append(this.j);
        stringBuilder.append('\'');
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
