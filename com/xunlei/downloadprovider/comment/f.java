package com.xunlei.downloadprovider.comment;

import com.android.volley.n.b;
import org.json.JSONObject;

/* compiled from: CommentManager */
final class f implements b<JSONObject> {
    final /* synthetic */ e a;

    f(e eVar) {
        this.a = eVar;
    }

    public final /* synthetic */ void onResponse(java.lang.Object r4) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r3 = this;
        r4 = (org.json.JSONObject) r4;
        com.xunlei.downloadprovider.comment.a.a;
        r0 = new java.lang.StringBuilder;
        r1 = "send comment response=>";
        r0.<init>(r1);
        r0.append(r4);
        r0 = "result";	 Catch:{ JSONException -> 0x001c }
        r0 = r4.getInt(r0);	 Catch:{ JSONException -> 0x001c }
        r1 = "cid";	 Catch:{ JSONException -> 0x001c }
        r1 = r4.optLong(r1);	 Catch:{ JSONException -> 0x001c }
        goto L_0x0024;
    L_0x001c:
        r0 = "code";
        r0 = r4.optInt(r0);
        r1 = -1;
    L_0x0024:
        r4 = r3.a;
        r4 = r4.b;
        if (r4 == 0) goto L_0x0062;
    L_0x002a:
        if (r0 != 0) goto L_0x0038;
    L_0x002c:
        r4 = r3.a;
        r4 = r4.b;
        r0 = java.lang.Long.valueOf(r1);
        r4.a(r0);
        return;
    L_0x0038:
        r4 = new com.xunlei.downloadprovider.comment.a$b;
        r4.<init>();
        r4.a = r0;
        r1 = "failed";
        r4.b = r1;
        r1 = 70012; // 0x1117c float:9.8108E-41 double:3.45905E-319;
        if (r0 != r1) goto L_0x0052;
    L_0x0048:
        r0 = com.xunlei.downloadprovider.app.BrothersApplication.getApplicationInstance();
        r1 = "您当前操作太频繁啦，请稍后再试";
        com.xunlei.common.commonview.XLToast.showToast(r0, r1);
        goto L_0x005b;
    L_0x0052:
        r0 = com.xunlei.downloadprovider.app.BrothersApplication.getApplicationInstance();
        r1 = "发送评论失败";
        com.xunlei.common.commonview.XLToast.showToast(r0, r1);
    L_0x005b:
        r0 = r3.a;
        r0 = r0.b;
        r0.a(r4);
    L_0x0062:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.downloadprovider.comment.f.onResponse(java.lang.Object):void");
    }
}
