package com.alipay.apmobilesecuritysdk.face;

import android.content.Context;
import com.alipay.apmobilesecuritysdk.a.a;
import com.alipay.apmobilesecuritysdk.f.d;
import com.alipay.apmobilesecuritysdk.f.g;
import com.alipay.apmobilesecuritysdk.f.h;
import com.alipay.apmobilesecuritysdk.f.i;
import com.alipay.sdk.cons.b;
import java.util.HashMap;
import java.util.Map;

public class APSecuritySdk {
    private static APSecuritySdk a;
    private static Object c = new Object();
    private Context b;

    public interface InitResultListener {
        void onResult(TokenResult tokenResult);
    }

    public class TokenResult {
        final /* synthetic */ APSecuritySdk a;
        public String apdid;
        public String apdidToken;
        public String clientKey;
        public String umidToken;

        public TokenResult(APSecuritySdk aPSecuritySdk) {
            this.a = aPSecuritySdk;
        }
    }

    private APSecuritySdk(Context context) {
        this.b = context;
    }

    public static APSecuritySdk getInstance(Context context) {
        if (a == null) {
            synchronized (c) {
                if (a == null) {
                    a = new APSecuritySdk(context);
                }
            }
        }
        return a;
    }

    public static String getUtdid(Context context) {
        return "";
    }

    public String getApdidToken() {
        return a.a(this.b, "");
    }

    public String getSdkName() {
        return "security-sdk-token";
    }

    public String getSdkVersion() {
        return "3.2.0-20160621";
    }

    public synchronized com.alipay.apmobilesecuritysdk.face.APSecuritySdk.TokenResult getTokenResult() {
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
        r3 = this;
        monitor-enter(r3);
        r0 = new com.alipay.apmobilesecuritysdk.face.APSecuritySdk$TokenResult;	 Catch:{ all -> 0x0028 }
        r0.<init>(r3);	 Catch:{ all -> 0x0028 }
        r1 = r3.b;	 Catch:{ Throwable -> 0x0026 }
        r2 = "";	 Catch:{ Throwable -> 0x0026 }
        r1 = com.alipay.apmobilesecuritysdk.a.a.a(r1, r2);	 Catch:{ Throwable -> 0x0026 }
        r0.apdidToken = r1;	 Catch:{ Throwable -> 0x0026 }
        r1 = r3.b;	 Catch:{ Throwable -> 0x0026 }
        r1 = com.alipay.apmobilesecuritysdk.f.h.c(r1);	 Catch:{ Throwable -> 0x0026 }
        r0.clientKey = r1;	 Catch:{ Throwable -> 0x0026 }
        r1 = r3.b;	 Catch:{ Throwable -> 0x0026 }
        r1 = com.alipay.apmobilesecuritysdk.a.a.a(r1);	 Catch:{ Throwable -> 0x0026 }
        r0.apdid = r1;	 Catch:{ Throwable -> 0x0026 }
        r1 = com.alipay.apmobilesecuritysdk.e.a.a();	 Catch:{ Throwable -> 0x0026 }
        r0.umidToken = r1;	 Catch:{ Throwable -> 0x0026 }
    L_0x0026:
        monitor-exit(r3);
        return r0;
    L_0x0028:
        r0 = move-exception;
        monitor-exit(r3);
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.apmobilesecuritysdk.face.APSecuritySdk.getTokenResult():com.alipay.apmobilesecuritysdk.face.APSecuritySdk$TokenResult");
    }

    public void initToken(int i, Map<String, String> map, final InitResultListener initResultListener) {
        com.alipay.apmobilesecuritysdk.b.a.a().a(i);
        String a = h.a(this.b);
        String c = com.alipay.apmobilesecuritysdk.b.a.a().c();
        if (com.alipay.b.a.a.a.a.b(a) && !com.alipay.b.a.a.a.a.a(a, c)) {
            com.alipay.apmobilesecuritysdk.f.a.a(this.b);
            d.a(this.b);
            g.a(this.b);
            i.h();
        }
        if (!com.alipay.b.a.a.a.a.a(a, c)) {
            h.a(this.b, c);
        }
        Object a2 = com.alipay.b.a.a.a.a.a(map, "utdid", "");
        c = com.alipay.b.a.a.a.a.a(map, b.c, "");
        String a3 = com.alipay.b.a.a.a.a.a(map, "userId", "");
        if (com.alipay.b.a.a.a.a.a((String) a2)) {
            a2 = "";
        }
        final Map hashMap = new HashMap();
        hashMap.put("utdid", a2);
        hashMap.put(b.c, c);
        hashMap.put("userId", a3);
        hashMap.put("appName", "");
        hashMap.put("appKeyClient", "");
        hashMap.put("appchannel", "");
        hashMap.put("rpcVersion", "3");
        com.alipay.apmobilesecuritysdk.g.b.a().a(new Runnable(this) {
            final /* synthetic */ APSecuritySdk c;

            public void run() {
                new a(this.c.b).a(hashMap);
                if (initResultListener != null) {
                    initResultListener.onResult(this.c.getTokenResult());
                }
            }
        });
    }
}
