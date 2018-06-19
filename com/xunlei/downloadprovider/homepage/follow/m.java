package com.xunlei.downloadprovider.homepage.follow;

import com.xunlei.downloadprovider.member.payment.a.e.c;

/* compiled from: FollowManager */
public final class m implements Runnable {
    final /* synthetic */ c a;
    final /* synthetic */ b b;

    public m(b bVar, c cVar) {
        this.b = bVar;
        this.a = cVar;
    }

    public final void run() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r9 = this;
        r0 = r9.b;
        r0 = r0.e;
        r1 = r0.getReadableDatabase();
        r0 = com.xunlei.downloadprovider.member.login.LoginHelper.a();
        r0 = r0.g;
        r0.c();
        r2 = "following_video_feed";
        r3 = 0;
        r4 = 0;
        r5 = 0;
        r6 = 0;
        r7 = 0;
        r8 = 0;
        r0 = r1.query(r2, r3, r4, r5, r6, r7, r8);
        r1 = "feed_id";
        r1 = r0.getColumnIndex(r1);
        r2 = "user_info";
        r2 = r0.getColumnIndex(r2);
        r3 = "video_info";
        r3 = r0.getColumnIndex(r3);
        r4 = new java.util.ArrayList;
        r4.<init>();
    L_0x0034:
        r5 = r0.moveToNext();
        if (r5 == 0) goto L_0x0079;
    L_0x003a:
        r5 = new com.xunlei.downloadprovider.homepage.follow.b.d;
        r5.<init>();
        r6 = r0.getString(r1);
        r5.a = r6;
        r6 = r0.getString(r2);
        r5.e = r6;
        if (r6 == 0) goto L_0x005d;
    L_0x004d:
        r7 = new com.xunlei.downloadprovider.shortvideo.entity.VideoUserInfo;	 Catch:{ JSONException -> 0x005d }
        r7.<init>();	 Catch:{ JSONException -> 0x005d }
        r8 = new org.json.JSONObject;	 Catch:{ JSONException -> 0x005d }
        r8.<init>(r6);	 Catch:{ JSONException -> 0x005d }
        r6 = com.xunlei.downloadprovider.shortvideo.entity.VideoUserInfo.parseFrom(r7, r8);	 Catch:{ JSONException -> 0x005d }
        r5.c = r6;	 Catch:{ JSONException -> 0x005d }
    L_0x005d:
        r6 = r0.getString(r3);
        r5.d = r6;
        if (r6 == 0) goto L_0x0075;
    L_0x0065:
        r7 = new com.xunlei.downloadprovider.shortvideo.entity.BaseVideoInfo;	 Catch:{ JSONException -> 0x0075 }
        r7.<init>();	 Catch:{ JSONException -> 0x0075 }
        r8 = new org.json.JSONObject;	 Catch:{ JSONException -> 0x0075 }
        r8.<init>(r6);	 Catch:{ JSONException -> 0x0075 }
        r6 = com.xunlei.downloadprovider.shortvideo.entity.BaseVideoInfo.parseFrom(r7, r8);	 Catch:{ JSONException -> 0x0075 }
        r5.b = r6;	 Catch:{ JSONException -> 0x0075 }
    L_0x0075:
        r4.add(r5);
        goto L_0x0034;
    L_0x0079:
        r0.close();
        r0 = r4.size();
        if (r0 <= 0) goto L_0x00a1;
    L_0x0082:
        r0 = r9.b;
        r1 = 0;
        r1 = r4.get(r1);
        r1 = (com.xunlei.downloadprovider.homepage.follow.b.d) r1;
        r1 = r1.a;
        r0.l = r1;
        r0 = r9.b;
        r1 = r4.size();
        r1 = r1 + -1;
        r1 = r4.get(r1);
        r1 = (com.xunlei.downloadprovider.homepage.follow.b.d) r1;
        r1 = r1.a;
        r0.m = r1;
    L_0x00a1:
        r0 = r9.b;
        r1 = new com.xunlei.downloadprovider.homepage.follow.n;
        r1.<init>(r9, r4);
        r0 = r0.a;
        r0.post(r1);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.downloadprovider.homepage.follow.m.run():void");
    }
}
