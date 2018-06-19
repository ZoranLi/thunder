package com.xunlei.downloadprovider.web.browser.transcode;

import com.xunlei.downloadprovider.app.BrothersApplication;
import com.xunlei.downloadprovider.h.e;
import com.xunlei.downloadprovider.plugin.q;
import java.io.File;

/* compiled from: BrowserTranscodeDataLoader */
class b {
    String a;
    a b;
    private final String c = b.class.getSimpleName();

    /* compiled from: BrowserTranscodeDataLoader */
    public interface a {
        void a(boolean z, a aVar);
    }

    b() {
    }

    final void a(boolean z) {
        q.a().a("com.xunlei.plugin.transcode", new d(this, z), false);
    }

    private void a() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r6 = this;
        r0 = 0;
        r1 = 0;
        r2 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0077 }
        r2.<init>();	 Catch:{ Exception -> 0x0077 }
        r3 = r6.a;	 Catch:{ Exception -> 0x0077 }
        r2.append(r3);	 Catch:{ Exception -> 0x0077 }
        r3 = com.xunlei.downloadprovider.web.browser.transcode.a.a;	 Catch:{ Exception -> 0x0077 }
        r2.append(r3);	 Catch:{ Exception -> 0x0077 }
        r2 = r2.toString();	 Catch:{ Exception -> 0x0077 }
        r3 = "utf-8";	 Catch:{ Exception -> 0x0077 }
        r2 = com.xunlei.downloadprovider.h.e.a(r2, r3);	 Catch:{ Exception -> 0x0077 }
        r3 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0077 }
        r3.<init>();	 Catch:{ Exception -> 0x0077 }
        r4 = r6.a;	 Catch:{ Exception -> 0x0077 }
        r3.append(r4);	 Catch:{ Exception -> 0x0077 }
        r4 = com.xunlei.downloadprovider.web.browser.transcode.a.b;	 Catch:{ Exception -> 0x0077 }
        r3.append(r4);	 Catch:{ Exception -> 0x0077 }
        r3 = r3.toString();	 Catch:{ Exception -> 0x0077 }
        r4 = "utf-8";	 Catch:{ Exception -> 0x0077 }
        r3 = com.xunlei.downloadprovider.h.e.a(r3, r4);	 Catch:{ Exception -> 0x0077 }
        r4 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0077 }
        r4.<init>();	 Catch:{ Exception -> 0x0077 }
        r5 = r6.a;	 Catch:{ Exception -> 0x0077 }
        r4.append(r5);	 Catch:{ Exception -> 0x0077 }
        r5 = com.xunlei.downloadprovider.web.browser.transcode.a.c;	 Catch:{ Exception -> 0x0077 }
        r4.append(r5);	 Catch:{ Exception -> 0x0077 }
        r4 = r4.toString();	 Catch:{ Exception -> 0x0077 }
        r5 = "utf-8";	 Catch:{ Exception -> 0x0077 }
        r4 = com.xunlei.downloadprovider.h.e.a(r4, r5);	 Catch:{ Exception -> 0x0077 }
        if (r2 == 0) goto L_0x0071;	 Catch:{ Exception -> 0x0077 }
    L_0x004f:
        if (r3 == 0) goto L_0x0071;	 Catch:{ Exception -> 0x0077 }
    L_0x0051:
        if (r4 == 0) goto L_0x0071;	 Catch:{ Exception -> 0x0077 }
    L_0x0053:
        r5 = new com.xunlei.downloadprovider.web.browser.transcode.a;	 Catch:{ Exception -> 0x0077 }
        r5.<init>();	 Catch:{ Exception -> 0x0077 }
        r2 = r2.toString();	 Catch:{ Exception -> 0x0077 }
        r5.d = r2;	 Catch:{ Exception -> 0x0077 }
        r2 = r3.toString();	 Catch:{ Exception -> 0x0077 }
        r5.e = r2;	 Catch:{ Exception -> 0x0077 }
        r2 = r4.toString();	 Catch:{ Exception -> 0x0077 }
        r5.f = r2;	 Catch:{ Exception -> 0x0077 }
        r2 = r6.b;	 Catch:{ Exception -> 0x0077 }
        r3 = 1;	 Catch:{ Exception -> 0x0077 }
        r2.a(r3, r5);	 Catch:{ Exception -> 0x0077 }
        return;
    L_0x0071:
        r2 = r6.b;
        r2.a(r1, r0);
        return;
    L_0x0077:
        r2 = r6.b;
        r2.a(r1, r0);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.downloadprovider.web.browser.transcode.b.a():void");
    }

    static /* synthetic */ void a(b bVar, boolean z) {
        String a = q.a(BrothersApplication.getApplicationInstance(), "com.xunlei.plugin.transcode");
        File file = new File(a);
        StringBuilder stringBuilder = new StringBuilder();
        int i = 0;
        stringBuilder.append(a.substring(0, a.lastIndexOf(".")));
        stringBuilder.append(".zip");
        File file2 = new File(stringBuilder.toString());
        if ((!file2.exists() || file2.delete()) && file.exists() && file.renameTo(file2)) {
            i = 1;
        }
        if (i != 0) {
            z = new StringBuilder();
            z.append(bVar.a);
            z.append("com.xunlei.plugin.transcode".replace(".", "_"));
            z.append(".zip");
            e.d(z.toString(), bVar.a);
            bVar.a();
            return;
        }
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append(bVar.c);
        stringBuilder2.append(" - unzipJavascriptFile");
        if (z) {
            bVar.a();
        }
    }
}
