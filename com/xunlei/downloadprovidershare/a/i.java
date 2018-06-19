package com.xunlei.downloadprovidershare.a;

import android.content.Context;
import android.view.View;
import anet.channel.strategy.dispatch.DispatchConstants;
import com.umeng.socialize.common.SocializeConstants;
import com.xunlei.downloadprovidershare.ShareOperationType;
import com.xunlei.downloadprovidershare.b.d;
import com.xunlei.downloadprovidershare.y;
import com.xunlei.downloadprovidershare.z;
import java.util.HashMap;
import org.android.agoo.common.AgooConstants;
import org.json.JSONObject;

/* compiled from: ShareVideoInfo */
public final class i extends f {
    public String a;
    public String b;
    public a m;
    private String n;

    /* compiled from: ShareVideoInfo */
    public static class a {
        public String a;
        public boolean b;
        public String c;
        public String d;
        public String e;
        public String f;
        public String g;
        public String h;
        public long i;
        public int j;
        public String k;
        public View l;
        public boolean m;
    }

    public i(String str, String str2, String str3, String str4, String str5, String str6) {
        super(str, str2, str4);
        this.h = str3;
        this.a = str5;
        this.n = str6;
    }

    private boolean e() {
        return this.m != null;
    }

    public final boolean d() {
        return this.m != null && this.m.m;
    }

    public final boolean a(Context context, ShareOperationType shareOperationType, com.xunlei.downloadprovidershare.a.a aVar) {
        shareOperationType = new StringBuilder();
        shareOperationType.append(this.h);
        shareOperationType.append("?imageMogr2/thumbnail/!200p/gravity/Center/crop/400x400");
        this.h = shareOperationType.toString();
        shareOperationType = new HashMap();
        shareOperationType.put("url", this.a);
        shareOperationType.put("userId", this.n);
        shareOperationType.put("movieId", this.a);
        shareOperationType.put("origin", "a_sl_app_v5.60.2.5510");
        shareOperationType.put("appVersion", "11100");
        shareOperationType.put("appType", DispatchConstants.ANDROID);
        shareOperationType.put("share_from", this.j);
        shareOperationType.put("type", "video");
        z.a(new JSONObject(shareOperationType), new j(this, aVar, context));
        return true;
    }

    public final void a(d dVar) {
        if (e() && this.m != null && this.m.l != null) {
            View view = this.m.l;
            if (dVar.a == null) {
                throw new IllegalStateException("SharePlatformDialog is not init, should call this method after show()");
            }
            dVar.a.addView(view, 0);
        }
    }

    static /* synthetic */ String a(i iVar, String str) {
        HashMap c = f.c();
        c.put("_t", String.valueOf(System.currentTimeMillis() / 300000));
        c.put("origin", "a_sl_app_v5.60.2.5510");
        c.put(AgooConstants.MESSAGE_ID, iVar.a);
        Object obj = "link";
        if (iVar.d()) {
            obj = SocializeConstants.KEY_PIC;
        }
        c.put("entry", obj);
        if (iVar.e() && iVar.m.b) {
            c.put("inviter", iVar.b);
        }
        c.put("storid", str);
        return y.a(iVar.f, c);
    }
}
