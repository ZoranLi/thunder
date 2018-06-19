package com.xunlei.downloadprovider.pushmessage.report;

import com.android.volley.Request;
import com.android.volley.d;
import com.tencent.smtt.sdk.TbsReaderView.ReaderCallback;
import com.xunlei.common.net.thunderserver.request.SigJsonObjectRequest;
import java.util.List;
import org.json.JSONObject;

/* compiled from: PushNetworkHelper */
final class c implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ String b;
    final /* synthetic */ String c;
    final /* synthetic */ String d;
    final /* synthetic */ String e;
    final /* synthetic */ List f;
    final /* synthetic */ String g;
    final /* synthetic */ String h;
    final /* synthetic */ boolean i;
    final /* synthetic */ boolean j;
    final /* synthetic */ b k;

    c(b bVar, String str, String str2, String str3, String str4, String str5, List list, String str6, String str7, boolean z, boolean z2) {
        this.k = bVar;
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = str4;
        this.e = str5;
        this.f = list;
        this.g = str6;
        this.h = str7;
        this.i = z;
        this.j = z2;
    }

    public final void run() {
        JSONObject a = b.a(this.a, this.b, this.c, this.d, this.e, this.f, this.g);
        StringBuilder stringBuilder = new StringBuilder("url=");
        stringBuilder.append(this.h);
        stringBuilder.append("  ,peerId =");
        stringBuilder.append(this.a);
        stringBuilder.append(",uid=");
        stringBuilder.append(this.b);
        stringBuilder.append(",registerId=");
        stringBuilder.append(this.c);
        stringBuilder.append(",status=");
        stringBuilder.append(this.d);
        stringBuilder.append(",details=");
        stringBuilder.append(this.e);
        Request sigJsonObjectRequest = new SigJsonObjectRequest(1, this.h, a, new d(this), new e(this));
        sigJsonObjectRequest.setShouldCache(false);
        sigJsonObjectRequest.setRetryPolicy(new d(ReaderCallback.GET_BAR_ANIMATING, 1, 1.0f));
        b.a(this.k, sigJsonObjectRequest);
    }
}
