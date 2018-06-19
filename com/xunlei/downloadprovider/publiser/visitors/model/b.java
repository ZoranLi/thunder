package com.xunlei.downloadprovider.publiser.visitors.model;

import android.text.TextUtils;
import com.xunlei.downloadprovider.shortvideo.entity.VideoUserInfo;

/* compiled from: VisitInfo */
public final class b {
    public String a;
    public int b;
    public String c;
    public String d;
    public String e;
    public long f;
    public long g;
    public String h;
    public a i;
    public VideoUserInfo j;

    /* compiled from: VisitInfo */
    private static class a {
        public String a;
        public String b;
        public int c;

        private a() {
        }

        public static com.xunlei.downloadprovider.publiser.visitors.model.b.a a(org.json.JSONObject r2) {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
            /*
            r0 = new com.xunlei.downloadprovider.publiser.visitors.model.b$a;
            r0.<init>();
            r1 = "play_url";
            r1 = r2.optString(r1);
            r0.a = r1;
            r1 = "cover_url";
            r1 = r2.optString(r1);
            r0.b = r1;
            r1 = "status";	 Catch:{ JSONException -> 0x001e }
            r2 = r2.getInt(r1);	 Catch:{ JSONException -> 0x001e }
            r0.c = r2;	 Catch:{ JSONException -> 0x001e }
            goto L_0x002b;
        L_0x001e:
            r2 = r0.a;
            r2 = android.text.TextUtils.isEmpty(r2);
            if (r2 == 0) goto L_0x0028;
        L_0x0026:
            r2 = 2;
            goto L_0x0029;
        L_0x0028:
            r2 = 1;
        L_0x0029:
            r0.c = r2;
        L_0x002b:
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.xunlei.downloadprovider.publiser.visitors.model.b.a.a(org.json.JSONObject):com.xunlei.downloadprovider.publiser.visitors.model.b$a");
        }
    }

    public final String a() {
        return this.j == null ? "" : this.j.getPortraitUrl();
    }

    public final String b() {
        if (this.j != null) {
            if (!TextUtils.isEmpty(this.j.getNickname())) {
                return this.j.getNickname();
            }
        }
        return "迅雷用户";
    }
}
