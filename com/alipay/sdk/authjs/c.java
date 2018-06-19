package com.alipay.sdk.authjs;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.widget.Toast;
import com.alipay.sdk.authjs.a.a;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import java.util.Timer;
import org.json.JSONException;
import org.json.JSONObject;

public final class c {
    b a;
    Context b;

    private static /* synthetic */ int a(c cVar, a aVar) {
        if (aVar != null && "toast".equals(aVar.k)) {
            JSONObject jSONObject = aVar.m;
            CharSequence optString = jSONObject.optString("content");
            int i = 1;
            if (jSONObject.optInt(SocializeProtocolConstants.DURATION) < 2500) {
                i = 0;
            }
            Toast.makeText(cVar.b, optString, i).show();
            new Timer().schedule(new e(cVar, aVar), (long) i);
        }
        return a.a;
    }

    public c(Context context, b bVar) {
        this.b = context;
        this.a = bVar;
    }

    private void a(java.lang.String r6) {
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
        r5 = this;
        r0 = 0;
        r1 = new org.json.JSONObject;	 Catch:{ Exception -> 0x003f }
        r1.<init>(r6);	 Catch:{ Exception -> 0x003f }
        r6 = "clientId";	 Catch:{ Exception -> 0x003f }
        r6 = r1.getString(r6);	 Catch:{ Exception -> 0x003f }
        r2 = android.text.TextUtils.isEmpty(r6);	 Catch:{ Exception -> 0x0040 }
        if (r2 == 0) goto L_0x0013;	 Catch:{ Exception -> 0x0040 }
    L_0x0012:
        return;	 Catch:{ Exception -> 0x0040 }
    L_0x0013:
        r2 = "param";	 Catch:{ Exception -> 0x0040 }
        r2 = r1.getJSONObject(r2);	 Catch:{ Exception -> 0x0040 }
        r3 = r2 instanceof org.json.JSONObject;	 Catch:{ Exception -> 0x0040 }
        if (r3 == 0) goto L_0x0020;	 Catch:{ Exception -> 0x0040 }
    L_0x001d:
        r0 = r2;	 Catch:{ Exception -> 0x0040 }
        r0 = (org.json.JSONObject) r0;	 Catch:{ Exception -> 0x0040 }
    L_0x0020:
        r2 = "func";	 Catch:{ Exception -> 0x0040 }
        r2 = r1.getString(r2);	 Catch:{ Exception -> 0x0040 }
        r3 = "bundleName";	 Catch:{ Exception -> 0x0040 }
        r1 = r1.getString(r3);	 Catch:{ Exception -> 0x0040 }
        r3 = new com.alipay.sdk.authjs.a;	 Catch:{ Exception -> 0x0040 }
        r4 = "call";	 Catch:{ Exception -> 0x0040 }
        r3.<init>(r4);	 Catch:{ Exception -> 0x0040 }
        r3.j = r1;	 Catch:{ Exception -> 0x0040 }
        r3.k = r2;	 Catch:{ Exception -> 0x0040 }
        r3.m = r0;	 Catch:{ Exception -> 0x0040 }
        r3.i = r6;	 Catch:{ Exception -> 0x0040 }
        r5.a(r3);	 Catch:{ Exception -> 0x0040 }
        return;
    L_0x003f:
        r6 = r0;
    L_0x0040:
        r0 = android.text.TextUtils.isEmpty(r6);
        if (r0 != 0) goto L_0x004c;
    L_0x0046:
        r0 = com.alipay.sdk.authjs.a.a.d;	 Catch:{ JSONException -> 0x004c }
        r5.a(r6, r0);	 Catch:{ JSONException -> 0x004c }
        return;
    L_0x004c:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.sdk.authjs.c.a(java.lang.String):void");
    }

    public final void a(a aVar) throws JSONException {
        if (TextUtils.isEmpty(aVar.k)) {
            a(aVar.i, a.c);
            return;
        }
        Runnable dVar = new d(this, aVar);
        if ((Looper.getMainLooper() == Looper.myLooper() ? true : null) != null) {
            dVar.run();
        } else {
            new Handler(Looper.getMainLooper()).post(dVar);
        }
    }

    public final void a(String str, int i) throws JSONException {
        if (!TextUtils.isEmpty(str)) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("error", i - 1);
            i = new a(a.c);
            i.m = jSONObject;
            i.i = str;
            this.a.a(i);
        }
    }

    private static void a(Runnable runnable) {
        if ((Looper.getMainLooper() == Looper.myLooper() ? 1 : null) != null) {
            runnable.run();
        } else {
            new Handler(Looper.getMainLooper()).post(runnable);
        }
    }

    private int b(a aVar) {
        if (aVar != null && "toast".equals(aVar.k)) {
            JSONObject jSONObject = aVar.m;
            CharSequence optString = jSONObject.optString("content");
            int i = 1;
            if (jSONObject.optInt(SocializeProtocolConstants.DURATION) < 2500) {
                i = 0;
            }
            Toast.makeText(this.b, optString, i).show();
            new Timer().schedule(new e(this, aVar), (long) i);
        }
        return a.a;
    }

    private void c(a aVar) {
        JSONObject jSONObject = aVar.m;
        CharSequence optString = jSONObject.optString("content");
        int i = jSONObject.optInt(SocializeProtocolConstants.DURATION) < 2500 ? 0 : 1;
        Toast.makeText(this.b, optString, i).show();
        new Timer().schedule(new e(this, aVar), (long) i);
    }
}
