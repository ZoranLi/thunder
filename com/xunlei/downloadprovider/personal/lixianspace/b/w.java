package com.xunlei.downloadprovider.personal.lixianspace.b;

import org.json.JSONObject;

/* compiled from: LXSpaceRequestMgr */
final class w implements Runnable {
    final /* synthetic */ JSONObject a;
    final /* synthetic */ Object b;
    final /* synthetic */ v c;

    w(v vVar, JSONObject jSONObject, Object obj) {
        this.c = vVar;
        this.a = jSONObject;
        this.b = obj;
    }

    public final void run() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r9 = this;
        r0 = new com.xunlei.downloadlib.parameter.TorrentInfo;	 Catch:{ Exception -> 0x006b }
        r0.<init>();	 Catch:{ Exception -> 0x006b }
        r1 = r9.a;	 Catch:{ Exception -> 0x006b }
        r2 = "infohash";	 Catch:{ Exception -> 0x006b }
        r1 = r1.getString(r2);	 Catch:{ Exception -> 0x006b }
        r0.mInfoHash = r1;	 Catch:{ Exception -> 0x006b }
        r1 = r9.a;	 Catch:{ Exception -> 0x006b }
        r2 = "info";	 Catch:{ Exception -> 0x006b }
        r1 = r1.getJSONObject(r2);	 Catch:{ Exception -> 0x006b }
        r2 = "files";	 Catch:{ Exception -> 0x006b }
        r1 = r1.getJSONArray(r2);	 Catch:{ Exception -> 0x006b }
        r2 = r1.length();	 Catch:{ Exception -> 0x006b }
        r2 = new com.xunlei.downloadlib.parameter.TorrentFileInfo[r2];	 Catch:{ Exception -> 0x006b }
        r0.mSubFileInfo = r2;	 Catch:{ Exception -> 0x006b }
        r2 = r1.length();	 Catch:{ Exception -> 0x006b }
        r3 = 0;	 Catch:{ Exception -> 0x006b }
        r4 = r3;	 Catch:{ Exception -> 0x006b }
    L_0x002b:
        if (r4 >= r2) goto L_0x0061;	 Catch:{ Exception -> 0x006b }
    L_0x002d:
        r5 = r1.getJSONObject(r4);	 Catch:{ Exception -> 0x006b }
        r6 = new com.xunlei.downloadlib.parameter.TorrentFileInfo;	 Catch:{ Exception -> 0x006b }
        r6.<init>();	 Catch:{ Exception -> 0x006b }
        r7 = "name";	 Catch:{ Exception -> 0x006b }
        r7 = r5.optString(r7);	 Catch:{ Exception -> 0x006b }
        r6.mFileName = r7;	 Catch:{ Exception -> 0x006b }
        r7 = "length";	 Catch:{ Exception -> 0x006b }
        r7 = r5.optLong(r7);	 Catch:{ Exception -> 0x006b }
        r6.mFileSize = r7;	 Catch:{ Exception -> 0x006b }
        r7 = "index";	 Catch:{ Exception -> 0x006b }
        r7 = r5.optInt(r7);	 Catch:{ Exception -> 0x006b }
        r6.mFileIndex = r7;	 Catch:{ Exception -> 0x006b }
        r7 = "path";	 Catch:{ Exception -> 0x006b }
        r5 = r5.optString(r7);	 Catch:{ Exception -> 0x006b }
        r6.mSubPath = r5;	 Catch:{ Exception -> 0x006b }
        r5 = r6.mFileIndex;	 Catch:{ Exception -> 0x006b }
        r6.mRealIndex = r5;	 Catch:{ Exception -> 0x006b }
        r5 = r0.mSubFileInfo;	 Catch:{ Exception -> 0x006b }
        r5[r4] = r6;	 Catch:{ Exception -> 0x006b }
        r4 = r4 + 1;	 Catch:{ Exception -> 0x006b }
        goto L_0x002b;	 Catch:{ Exception -> 0x006b }
    L_0x0061:
        r1 = com.xunlei.downloadprovider.personal.lixianspace.b.c.a.a;	 Catch:{ Exception -> 0x006b }
        r2 = "";	 Catch:{ Exception -> 0x006b }
        r1.a(r3, r2, r0);	 Catch:{ Exception -> 0x006b }
        return;
    L_0x006b:
        r0 = r9.c;
        r1 = -20000; // 0xffffffffffffb1e0 float:NaN double:NaN;
        r2 = com.xunlei.downloadprovider.personal.lixianspace.d.p.a(r1);
        r0.a(r1, r2);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.downloadprovider.personal.lixianspace.b.w.run():void");
    }
}
