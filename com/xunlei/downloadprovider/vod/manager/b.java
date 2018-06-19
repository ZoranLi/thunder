package com.xunlei.downloadprovider.vod.manager;

import com.xunlei.downloadprovider.member.payment.a.e.c;

/* compiled from: HotTopicManager */
public final class b implements c<String> {
    final /* synthetic */ com.xunlei.downloadprovider.vod.recordpublish.topicsearch.c a;
    final /* synthetic */ a b;

    public b(a aVar, com.xunlei.downloadprovider.vod.recordpublish.topicsearch.c cVar) {
        this.b = aVar;
        this.a = cVar;
    }

    public final /* synthetic */ void onSuccess(java.lang.Object r9) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r8 = this;
        r9 = (java.lang.String) r9;
        r0 = r8.a;
        r1 = android.text.TextUtils.isEmpty(r9);
        if (r1 == 0) goto L_0x0016;
    L_0x000a:
        r1 = new com.xunlei.downloadprovider.vod.recordpublish.topicsearch.b;
        r1.<init>();
        r2 = "empty result";
        r1.a = r2;
        com.xunlei.downloadprovider.vod.manager.a.a(r1, r0);
    L_0x0016:
        r1 = new java.util.ArrayList;	 Catch:{ Exception -> 0x0094 }
        r1.<init>();	 Catch:{ Exception -> 0x0094 }
        r2 = new org.json.JSONObject;	 Catch:{ Exception -> 0x0094 }
        r2.<init>(r9);	 Catch:{ Exception -> 0x0094 }
        r3 = "list";	 Catch:{ Exception -> 0x0094 }
        r2 = r2.optJSONArray(r3);	 Catch:{ Exception -> 0x0094 }
        if (r2 == 0) goto L_0x008e;	 Catch:{ Exception -> 0x0094 }
    L_0x0028:
        r3 = r2.length();	 Catch:{ Exception -> 0x0094 }
        if (r3 <= 0) goto L_0x008e;	 Catch:{ Exception -> 0x0094 }
    L_0x002e:
        r3 = 0;	 Catch:{ Exception -> 0x0094 }
    L_0x002f:
        r4 = r2.length();	 Catch:{ Exception -> 0x0094 }
        if (r3 >= r4) goto L_0x008e;	 Catch:{ Exception -> 0x0094 }
    L_0x0035:
        r4 = r2.optJSONObject(r3);	 Catch:{ Exception -> 0x0094 }
        if (r4 == 0) goto L_0x008b;	 Catch:{ Exception -> 0x0094 }
    L_0x003b:
        r5 = new com.xunlei.downloadprovider.vod.recordpublish.topicsearch.a;	 Catch:{ Exception -> 0x0094 }
        r5.<init>();	 Catch:{ Exception -> 0x0094 }
        r6 = "description";	 Catch:{ Exception -> 0x0094 }
        r6 = r4.optString(r6);	 Catch:{ Exception -> 0x0094 }
        r5.b = r6;	 Catch:{ Exception -> 0x0094 }
        r6 = "participantCount";	 Catch:{ Exception -> 0x0094 }
        r6 = r4.optLong(r6);	 Catch:{ Exception -> 0x0094 }
        r5.c = r6;	 Catch:{ Exception -> 0x0094 }
        r6 = "name";	 Catch:{ Exception -> 0x0094 }
        r6 = r4.optString(r6);	 Catch:{ Exception -> 0x0094 }
        r5.a = r6;	 Catch:{ Exception -> 0x0094 }
        r6 = "id";	 Catch:{ Exception -> 0x0094 }
        r6 = r4.optInt(r6);	 Catch:{ Exception -> 0x0094 }
        r5.d = r6;	 Catch:{ Exception -> 0x0094 }
        r6 = "ctime";	 Catch:{ Exception -> 0x0094 }
        r6 = r4.optLong(r6);	 Catch:{ Exception -> 0x0094 }
        r5.f = r6;	 Catch:{ Exception -> 0x0094 }
        r6 = "utime";	 Catch:{ Exception -> 0x0094 }
        r6 = r4.optLong(r6);	 Catch:{ Exception -> 0x0094 }
        r5.g = r6;	 Catch:{ Exception -> 0x0094 }
        r6 = "status";	 Catch:{ Exception -> 0x0094 }
        r6 = r4.optInt(r6);	 Catch:{ Exception -> 0x0094 }
        r5.h = r6;	 Catch:{ Exception -> 0x0094 }
        r6 = "icon";	 Catch:{ Exception -> 0x0094 }
        r6 = r4.optString(r6);	 Catch:{ Exception -> 0x0094 }
        r5.e = r6;	 Catch:{ Exception -> 0x0094 }
        r6 = "youliaoValue";	 Catch:{ Exception -> 0x0094 }
        r4 = r4.optInt(r6);	 Catch:{ Exception -> 0x0094 }
        r5.i = r4;	 Catch:{ Exception -> 0x0094 }
        r1.add(r5);	 Catch:{ Exception -> 0x0094 }
    L_0x008b:
        r3 = r3 + 1;	 Catch:{ Exception -> 0x0094 }
        goto L_0x002f;	 Catch:{ Exception -> 0x0094 }
    L_0x008e:
        if (r0 == 0) goto L_0x0093;	 Catch:{ Exception -> 0x0094 }
    L_0x0090:
        r0.a(r1);	 Catch:{ Exception -> 0x0094 }
    L_0x0093:
        return;
    L_0x0094:
        r1 = new com.xunlei.downloadprovider.vod.recordpublish.topicsearch.b;
        r1.<init>();
        r1.a = r9;
        com.xunlei.downloadprovider.vod.manager.a.a(r1, r0);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.downloadprovider.vod.manager.b.onSuccess(java.lang.Object):void");
    }

    public final void onFail(String str) {
        com.xunlei.downloadprovider.vod.recordpublish.topicsearch.b bVar = new com.xunlei.downloadprovider.vod.recordpublish.topicsearch.b();
        bVar.a = str;
        a.a(bVar, this.a);
    }
}
