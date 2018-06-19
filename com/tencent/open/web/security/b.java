package com.tencent.open.web.security;

import com.tencent.open.a;
import com.tencent.open.a.f;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.List;

/* compiled from: ProGuard */
public class b extends a {
    public void a(String str, String str2, List<String> list, a.a aVar) {
        StringBuilder stringBuilder = new StringBuilder("-->getResult, objectName: ");
        stringBuilder.append(str);
        stringBuilder.append(" | methodName: ");
        stringBuilder.append(str2);
        f.a("openSDK_LOG.SecureJsBridge", stringBuilder.toString());
        int size = list.size();
        for (int i = 0; i < size; i++) {
            try {
                list.set(i, URLDecoder.decode((String) list.get(i), "UTF-8"));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        com.tencent.open.a.b bVar = (com.tencent.open.a.b) this.a.get(str);
        if (bVar != null) {
            f.b("openSDK_LOG.SecureJsBridge", "-->handler != null");
            bVar.call(str2, list, aVar);
            return;
        }
        f.b("openSDK_LOG.SecureJsBridge", "-->handler == null");
        if (aVar != null) {
            aVar.a();
        }
    }

    public boolean a(android.webkit.WebView r13, java.lang.String r14) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r12 = this;
        r0 = "openSDK_LOG.SecureJsBridge";
        r1 = new java.lang.StringBuilder;
        r2 = "-->canHandleUrl---url = ";
        r1.<init>(r2);
        r1.append(r14);
        r1 = r1.toString();
        com.tencent.open.a.f.a(r0, r1);
        r0 = 0;
        if (r14 != 0) goto L_0x0017;
    L_0x0016:
        return r0;
    L_0x0017:
        r1 = android.net.Uri.parse(r14);
        r1 = r1.getScheme();
        r2 = "jsbridge";
        r1 = r1.equals(r2);
        if (r1 != 0) goto L_0x0028;
    L_0x0027:
        return r0;
    L_0x0028:
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r1.append(r14);
        r2 = "/#";
        r1.append(r2);
        r1 = r1.toString();
        r2 = "/";
        r1 = r1.split(r2);
        r2 = new java.util.ArrayList;
        r1 = java.util.Arrays.asList(r1);
        r2.<init>(r1);
        r1 = r2.size();
        r3 = 7;
        if (r1 >= r3) goto L_0x0050;
    L_0x004f:
        return r0;
    L_0x0050:
        r1 = 2;
        r1 = r2.get(r1);
        r1 = (java.lang.String) r1;
        r3 = 3;
        r3 = r2.get(r3);
        r3 = (java.lang.String) r3;
        r4 = 4;
        r4 = r2.get(r4);
        r4 = (java.lang.String) r4;
        r5 = 5;
        r5 = r2.get(r5);
        r11 = r5;
        r11 = (java.lang.String) r11;
        r5 = "openSDK_LOG.SecureJsBridge";
        r6 = new java.lang.StringBuilder;
        r7 = "-->canHandleUrl, objectName: ";
        r6.<init>(r7);
        r6.append(r1);
        r7 = " | methodName: ";
        r6.append(r7);
        r6.append(r3);
        r7 = " | snStr: ";
        r6.append(r7);
        r6.append(r4);
        r6 = r6.toString();
        com.tencent.open.a.f.a(r5, r6);
        r5 = android.text.TextUtils.isEmpty(r1);
        if (r5 != 0) goto L_0x00bf;
    L_0x0096:
        r5 = android.text.TextUtils.isEmpty(r3);
        if (r5 != 0) goto L_0x00bf;
    L_0x009c:
        r5 = android.text.TextUtils.isEmpty(r4);
        if (r5 == 0) goto L_0x00a3;
    L_0x00a2:
        goto L_0x00bf;
    L_0x00a3:
        r8 = java.lang.Long.parseLong(r4);	 Catch:{ Exception -> 0x00be }
        r0 = new com.tencent.open.web.security.c;
        r6 = r0;
        r7 = r13;
        r10 = r14;
        r6.<init>(r7, r8, r10, r11);
        r13 = 6;
        r14 = r2.size();
        r4 = 1;
        r14 = r14 - r4;
        r13 = r2.subList(r13, r14);
        r12.a(r1, r3, r13, r0);
        return r4;
    L_0x00be:
        return r0;
    L_0x00bf:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.open.web.security.b.a(android.webkit.WebView, java.lang.String):boolean");
    }
}
