package com.xunlei.downloadprovider.member.login.ui;

import android.view.View.OnClickListener;

/* compiled from: LoginActivity */
final class p implements OnClickListener {
    final /* synthetic */ LoginActivity a;

    p(LoginActivity loginActivity) {
        this.a = loginActivity;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onClick(android.view.View r8) {
        /*
        r7 = this;
        r0 = r7.a;
        r0 = com.xunlei.downloadprovider.member.login.ui.LoginActivity.y(r0);
        r0 = r0.b;
        r0 = r0.b;
        if (r0 == 0) goto L_0x000d;
    L_0x000c:
        return;
    L_0x000d:
        r0 = "";
        r1 = r8.getId();
        r2 = 2131888316; // 0x7f1208bc float:1.9411264E38 double:1.0532927777E-314;
        r3 = 2131887938; // 0x7f120742 float:1.9410497E38 double:1.053292591E-314;
        if (r1 == r3) goto L_0x0027;
    L_0x001b:
        if (r1 == r2) goto L_0x0024;
    L_0x001d:
        switch(r1) {
            case 2131887934: goto L_0x0027;
            case 2131887935: goto L_0x0027;
            case 2131887936: goto L_0x0027;
            default: goto L_0x0020;
        };
    L_0x0020:
        switch(r1) {
            case 2131888312: goto L_0x0024;
            case 2131888313: goto L_0x0024;
            case 2131888314: goto L_0x0024;
            default: goto L_0x0023;
        };
    L_0x0023:
        goto L_0x0029;
    L_0x0024:
        r0 = "register";
        goto L_0x0029;
    L_0x0027:
        r0 = "user_login";
    L_0x0029:
        r1 = r8.getId();
        if (r1 == r3) goto L_0x0070;
    L_0x002f:
        if (r1 == r2) goto L_0x0068;
    L_0x0031:
        switch(r1) {
            case 2131887934: goto L_0x0060;
            case 2131887935: goto L_0x0058;
            case 2131887936: goto L_0x0050;
            default: goto L_0x0034;
        };
    L_0x0034:
        switch(r1) {
            case 2131888312: goto L_0x0048;
            case 2131888313: goto L_0x0040;
            case 2131888314: goto L_0x0038;
            default: goto L_0x0037;
        };
    L_0x0037:
        goto L_0x0077;
    L_0x0038:
        r1 = "weibo";
        r4 = "register";
        com.xunlei.downloadprovider.member.register.a.a(r1, r4);
        goto L_0x0077;
    L_0x0040:
        r1 = "QQ";
        r4 = "register";
        com.xunlei.downloadprovider.member.register.a.a(r1, r4);
        goto L_0x0077;
    L_0x0048:
        r1 = "wechat";
        r4 = "register";
        com.xunlei.downloadprovider.member.register.a.a(r1, r4);
        goto L_0x0077;
    L_0x0050:
        r1 = "weibo";
        r4 = "user_login";
        com.xunlei.downloadprovider.member.register.a.a(r1, r4);
        goto L_0x0077;
    L_0x0058:
        r1 = "QQ";
        r4 = "user_login";
        com.xunlei.downloadprovider.member.register.a.a(r1, r4);
        goto L_0x0077;
    L_0x0060:
        r1 = "wechat";
        r4 = "user_login";
        com.xunlei.downloadprovider.member.register.a.a(r1, r4);
        goto L_0x0077;
    L_0x0068:
        r1 = "xiaomi";
        r4 = "register";
        com.xunlei.downloadprovider.member.register.a.a(r1, r4);
        goto L_0x0077;
    L_0x0070:
        r1 = "xiaomi";
        r4 = "user_login";
        com.xunlei.downloadprovider.member.register.a.a(r1, r4);
    L_0x0077:
        r8 = r8.getId();
        r1 = 0;
        r4 = 1;
        if (r8 == r3) goto L_0x00e8;
    L_0x007f:
        if (r8 == r2) goto L_0x00e8;
    L_0x0081:
        switch(r8) {
            case 2131887934: goto L_0x00d3;
            case 2131887935: goto L_0x00be;
            case 2131887936: goto L_0x0089;
            default: goto L_0x0084;
        };
    L_0x0084:
        switch(r8) {
            case 2131888312: goto L_0x00d3;
            case 2131888313: goto L_0x00be;
            case 2131888314: goto L_0x0089;
            default: goto L_0x0087;
        };
    L_0x0087:
        goto L_0x012b;
    L_0x0089:
        r8 = r7.a;
        r8 = com.xunlei.downloadprovider.member.login.ui.LoginActivity.y(r8);
        r2 = r7.a;
        r2 = com.xunlei.downloadprovider.member.login.ui.LoginActivity.a(r2);
        r3 = r8.b;
        r3.b = r4;
        r3 = r8.f;
        r3 = r8.q;
        r5 = new com.xunlei.common.new_ptl.member.act.XLSinaParam;
        r5.<init>();
        r6 = "4286195229";
        r5.mSinaAppId = r6;
        r6 = "http://m.xunlei.com";
        r5.mRedirectUrl = r6;
        r0 = com.xunlei.downloadprovider.member.login.b.l.a(r2, r0);
        com.xunlei.downloadprovider.member.login.b.l.a(r4, r5, r3, r0);
        r0 = r8.f;
        r8 = r8.k;
        r0.a(r8);
        r8 = r7.a;
        r8.a(r4, r1);
        return;
    L_0x00be:
        r8 = r7.a;
        r8 = com.xunlei.downloadprovider.member.login.ui.LoginActivity.y(r8);
        r1 = new com.xunlei.downloadprovider.member.login.ui.r;
        r1.<init>(r7);
        r2 = r7.a;
        r2 = com.xunlei.downloadprovider.member.login.ui.LoginActivity.a(r2);
        r8.b(r1, r2, r0);
        return;
    L_0x00d3:
        r8 = r7.a;
        r8 = com.xunlei.downloadprovider.member.login.ui.LoginActivity.y(r8);
        r1 = new com.xunlei.downloadprovider.member.login.ui.q;
        r1.<init>(r7);
        r2 = r7.a;
        r2 = com.xunlei.downloadprovider.member.login.ui.LoginActivity.a(r2);
        r8.a(r1, r2, r0);
        return;
    L_0x00e8:
        r8 = r7.a;
        r8 = com.xunlei.xllib.android.b.a(r8);
        if (r8 == 0) goto L_0x0123;
    L_0x00f0:
        r8 = r7.a;
        r8 = com.xunlei.downloadprovider.member.login.ui.LoginActivity.y(r8);
        r2 = r7.a;
        r2 = com.xunlei.downloadprovider.member.login.ui.LoginActivity.a(r2);
        r3 = r8.b;
        r3.b = r4;
        r3 = r8.f;
        r3 = r8.q;
        r5 = new com.xunlei.common.new_ptl.member.act.XLXmParam;
        r5.<init>();
        r6 = "shoulei_miui";
        r5.mLoginReqFrom = r6;
        r6 = 8;
        r0 = com.xunlei.downloadprovider.member.login.b.l.a(r2, r0);
        com.xunlei.downloadprovider.member.login.b.l.a(r6, r5, r3, r0);
        r0 = r8.f;
        r8 = r8.k;
        r0.a(r8);
        r8 = r7.a;
        r8.a(r4, r1);
        return;
    L_0x0123:
        r8 = r7.a;
        r0 = 2131362509; // 0x7f0a02cd float:1.83448E38 double:1.0530329945E-314;
        com.xunlei.downloadprovider.member.login.ui.LoginActivity.c(r8, r0);
    L_0x012b:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.downloadprovider.member.login.ui.p.onClick(android.view.View):void");
    }
}
