package com.xunlei.downloadprovider.homepage.cinecism;

import com.xunlei.downloadprovider.web.base.core.ag;

/* compiled from: CinecismDetailActivity */
final class n extends ag {
    final /* synthetic */ CinecismDetailActivity a;

    n(CinecismDetailActivity cinecismDetailActivity) {
        this.a = cinecismDetailActivity;
    }

    protected final boolean a(com.xunlei.downloadprovider.web.base.core.MethodName r10, org.json.JSONObject r11, java.lang.String r12) throws org.json.JSONException {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r9 = this;
        r12 = com.xunlei.downloadprovider.homepage.cinecism.r.a;
        r10 = r10.ordinal();
        r10 = r12[r10];
        r12 = 0;
        r0 = 0;
        r1 = 1;
        switch(r10) {
            case 1: goto L_0x009f;
            case 2: goto L_0x008a;
            case 3: goto L_0x0074;
            case 4: goto L_0x006e;
            case 5: goto L_0x0045;
            case 6: goto L_0x0031;
            case 7: goto L_0x000f;
            default: goto L_0x000e;
        };
    L_0x000e:
        return r0;
    L_0x000f:
        if (r11 == 0) goto L_0x0030;
    L_0x0011:
        r10 = "userid";	 Catch:{ Exception -> 0x0030 }
        r10 = r11.optString(r10);	 Catch:{ Exception -> 0x0030 }
        r3 = java.lang.Long.parseLong(r10);	 Catch:{ Exception -> 0x0030 }
        r10 = "name";
        r6 = r11.optString(r10);
        r10 = "avatar";
        r7 = r11.optString(r10);
        r2 = r9.a;
        r5 = "per";
        r8 = com.xunlei.downloadprovider.publiser.per.PublisherActivity.From.CINECISM_DETAIL;
        com.xunlei.downloadprovider.personal.user.account.m.a(r2, r3, r5, r6, r7, r8);
    L_0x0030:
        return r1;
    L_0x0031:
        r10 = "process";
        r10 = r11.optInt(r10);
        r11 = r9.a;
        r11 = r11.v;
        if (r10 < r11) goto L_0x0044;
    L_0x003f:
        r11 = r9.a;
        r11.v = r10;
    L_0x0044:
        return r1;
    L_0x0045:
        r10 = r9.a;
        r10 = r10.g;
        if (r10 == 0) goto L_0x006d;
    L_0x004d:
        com.xunlei.downloadprovider.member.login.LoginHelper.a();
        r10 = com.xunlei.downloadprovider.member.login.b.l.c();
        if (r10 == 0) goto L_0x0062;
    L_0x0056:
        r10 = r9.a;
        r11 = r9.a;
        r11 = r11.g;
        com.xunlei.downloadprovider.homepage.cinecism.CinecismDetailActivity.b(r10, r11);
        goto L_0x006d;
    L_0x0062:
        r10 = r9.a;
        r11 = r9.a;
        r11 = r11.g;
        com.xunlei.downloadprovider.member.login.LoginHelper.a().a(r10, new com.xunlei.downloadprovider.homepage.cinecism.p(r10, r11.getUid(), r11), com.xunlei.downloadprovider.member.login.ui.LoginFrom.CINECISM_DETAIL_FOLLOW, null);
    L_0x006d:
        return r1;
    L_0x006e:
        r10 = r9.a;
        com.xunlei.downloadprovider.homepage.cinecism.CinecismDetailActivity.y(r10);
        return r1;
    L_0x0074:
        r10 = "clickid";
        r10 = r11.optInt(r10);
        r12 = "commentinfo";
        r11 = r11.optJSONObject(r12);
        r11 = com.xunlei.downloadprovider.comment.entity.CommentInfo.parseFrom(r11);
        r12 = r9.a;
        com.xunlei.downloadprovider.homepage.cinecism.CinecismDetailActivity.a(r12, r10, r11);
        return r1;
    L_0x008a:
        r10 = "cinecismid";
        r10 = r11.optString(r10);
        r11 = new com.xunlei.downloadprovider.homepage.cinecism.data.CinecismInfo;
        r11.<init>();
        r11.a = r10;
        r10 = r9.a;
        r2 = "cinecism_detail";
        com.xunlei.downloadprovider.homepage.cinecism.CinecismDetailActivity.a(r10, r2, r11, r12, r0);
        return r1;
    L_0x009f:
        r10 = "cinecismid";
        r10 = r11.optString(r10);
        r2 = "likecount";
        r11 = r11.optInt(r2);
        r2 = new com.xunlei.downloadprovider.e.a.d;
        r2.<init>(r10, r10, r11);
        r10 = 8;
        r2.a = r10;
        r2.e = r0;
        r10 = com.xunlei.downloadprovider.e.a.f.a();
        r11 = r9.a;
        r10.a(r11, r2, r12);
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.downloadprovider.homepage.cinecism.n.a(com.xunlei.downloadprovider.web.base.core.MethodName, org.json.JSONObject, java.lang.String):boolean");
    }
}
