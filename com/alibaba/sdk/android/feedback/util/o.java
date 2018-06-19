package com.alibaba.sdk.android.feedback.util;

import java.util.regex.Pattern;

public class o {
    public static String a = "^https?:\\/\\/(([^/\\?#]+\\.)*((taobao|tmall|juhuasuan|xiami|amap|taobaocdn|alipay|etao|alibaba|aliyun|alimama|weibo|tanx|laiwang|alicdn|mmstat|yunos|alibaba-inc|alitrip|aliloan|kanbox|wirlesshare|dingtalk|alimei|cnzz|kuaidadi|autonavi|m\\.yintai|polyinno|spdyidea|h5util|h5tool|5945i|miaostreet|1688)\\.com|(tb|tbcdn|weibo|mashort|mybank|ba\\.ugame\\.uc|game\\.uc)\\.cn|(fastidea|juzone)\\.(me|cc)|lwurl\\.to|taobao\\.net|tdd\\.la|yao\\.95095\\.com|tmall\\.hk|ahd\\.so|atb\\.so|mshare\\.cc|juhs\\.me|xianyu\\.mobi)([\\?|#|/].*)?|go(/.*)?)$";
    public static Pattern b;

    public static boolean a(java.lang.String r5) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r0 = android.text.TextUtils.isEmpty(r5);
        r1 = 0;
        if (r0 != 0) goto L_0x0051;
    L_0x0007:
        r0 = b;
        if (r0 != 0) goto L_0x0042;
    L_0x000b:
        r0 = a;	 Catch:{ PatternSyntaxException -> 0x002a }
        r2 = 2;	 Catch:{ PatternSyntaxException -> 0x002a }
        r0 = java.util.regex.Pattern.compile(r0, r2);	 Catch:{ PatternSyntaxException -> 0x002a }
        b = r0;	 Catch:{ PatternSyntaxException -> 0x002a }
        r0 = "WVServerConfig";	 Catch:{ PatternSyntaxException -> 0x002a }
        r2 = new java.lang.StringBuilder;	 Catch:{ PatternSyntaxException -> 0x002a }
        r3 = "compile pattern domainPat rule, ";	 Catch:{ PatternSyntaxException -> 0x002a }
        r2.<init>(r3);	 Catch:{ PatternSyntaxException -> 0x002a }
        r3 = a;	 Catch:{ PatternSyntaxException -> 0x002a }
        r2.append(r3);	 Catch:{ PatternSyntaxException -> 0x002a }
        r2 = r2.toString();	 Catch:{ PatternSyntaxException -> 0x002a }
        com.alibaba.sdk.android.feedback.xblink.i.g.a(r0, r2);	 Catch:{ PatternSyntaxException -> 0x002a }
        goto L_0x0042;
    L_0x002a:
        r0 = move-exception;
        r2 = "WVServerConfig";
        r3 = new java.lang.StringBuilder;
        r4 = " PatternSyntaxException pattern:";
        r3.<init>(r4);
        r0 = r0.getMessage();
        r3.append(r0);
        r0 = r3.toString();
        com.alibaba.sdk.android.feedback.xblink.i.g.b(r2, r0);
    L_0x0042:
        r0 = b;	 Catch:{ Exception -> 0x0051 }
        if (r0 == 0) goto L_0x0051;	 Catch:{ Exception -> 0x0051 }
    L_0x0046:
        r0 = b;	 Catch:{ Exception -> 0x0051 }
        r5 = r0.matcher(r5);	 Catch:{ Exception -> 0x0051 }
        r5 = r5.matches();	 Catch:{ Exception -> 0x0051 }
        r1 = r5;
    L_0x0051:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.sdk.android.feedback.util.o.a(java.lang.String):boolean");
    }
}
