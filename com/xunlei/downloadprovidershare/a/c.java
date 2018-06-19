package com.xunlei.downloadprovidershare.a;

import android.content.Context;
import android.text.TextUtils;
import anet.channel.strategy.dispatch.DispatchConstants;
import com.xunlei.common.concurrent.XLThreadPool;
import com.xunlei.downloadprovidershare.ShareOperationType;
import com.xunlei.downloadprovidershare.b.b;
import com.xunlei.downloadprovidershare.s;
import com.xunlei.downloadprovidershare.y;
import com.xunlei.downloadprovidershare.z;
import java.net.URLEncoder;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: ShareDownloadTaskInfo */
public final class c extends f {
    private long A;
    public String a;
    public a b;
    private String m;
    private long n;
    private long o;
    private String p;
    private String q;
    private String r;
    private String s;
    private String t;
    private boolean u;
    private String v;
    private boolean w;
    private String x;
    private long y;
    private long z;

    /* compiled from: ShareDownloadTaskInfo */
    public static class a {
        public b a;
        public Object b;

        public a(b bVar, Object obj) {
            this.a = bVar;
            this.b = obj;
        }
    }

    private static String a(String str) {
        return str == null ? "" : str;
    }

    public c(String str, String str2, int i, String str3, String str4, long j, long j2, String str5, String str6, String str7, String str8, String str9, String str10, boolean z, String str11, boolean z2, String str12, long j3, long j4, long j5) {
        super(str, str2, str3);
        this.i = i;
        this.m = str4;
        this.n = j;
        this.o = j2;
        this.p = str5;
        this.q = str6;
        this.r = str7;
        this.s = str8;
        this.a = str9;
        this.t = str10;
        this.u = z;
        this.v = str11;
        this.w = z2;
        this.x = str12;
        this.y = j3;
        this.z = j4;
        this.A = j5;
    }

    public final boolean a(Context context, ShareOperationType shareOperationType, com.xunlei.downloadprovidershare.a.a aVar) {
        if (this.o <= 0) {
            return super.a(context, shareOperationType, aVar);
        }
        if (shareOperationType == ShareOperationType.THUNDER_COMMAND) {
            XLThreadPool.execute(new s(this.r, new d(this, aVar)));
            return true;
        }
        z.a(d(), new e(this, aVar));
        return true;
    }

    private JSONObject d() {
        String str = this.m;
        if (!TextUtils.isEmpty(this.p)) {
            str = this.p;
        }
        try {
            str = URLEncoder.encode(str, "UTF-8");
        } catch (Exception e) {
            e.printStackTrace();
        }
        long j = this.n;
        if (j < 0) {
            j = 0;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("title", a(str));
            jSONObject.put("type", "download");
            jSONObject.put("fileSize", String.valueOf(j));
            jSONObject.put("url", b(this.r));
            jSONObject.put("cid", a(this.s));
            jSONObject.put("gcid", a(this.a));
            jSONObject.put("refUrl", a(this.t));
            jSONObject.put("appVersion", 11100);
            jSONObject.put("appType", DispatchConstants.ANDROID);
            jSONObject.put("share_from", this.j);
            if (this.u) {
                jSONObject.put("share_user_icon", this.v);
                jSONObject.put("share_user_nickname", this.x);
                jSONObject.put("share_user_is_vip", this.w);
            }
            jSONObject.put("max_download_speed", this.y);
            jSONObject.put("avg_download_speed", this.z);
            jSONObject.put("download_duration", this.A);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject;
    }

    private static String b(String str) {
        String str2 = "";
        try {
            return new String(str.getBytes("UTF-8"));
        } catch (String str3) {
            str3.printStackTrace();
            return str2;
        }
    }

    static /* synthetic */ String a(c cVar, String str) {
        HashMap c = f.c();
        c.put("storid", str);
        return y.a(cVar.f, c);
    }
}
