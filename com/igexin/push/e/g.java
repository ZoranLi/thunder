package com.igexin.push.e;

import android.content.ComponentName;
import android.content.ServiceConnection;
import com.igexin.push.core.d;
import com.igexin.push.core.f;
import com.igexin.push.d.c.e;
import com.igexin.push.d.c.n;
import java.util.List;

class g implements ServiceConnection {
    final /* synthetic */ b a;
    final /* synthetic */ String b;
    final /* synthetic */ c c;

    g(c cVar, b bVar, String str) {
        this.c = cVar;
        this.a = bVar;
        this.b = str;
    }

    public void onServiceConnected(android.content.ComponentName r7, android.os.IBinder r8) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r6 = this;
        r7 = r6.c;
        r7 = r7.b;
        r0 = com.igexin.push.core.d.active;
        if (r7 != r0) goto L_0x0062;
    L_0x000a:
        r7 = r6.a;	 Catch:{ Exception -> 0x0057 }
        r8 = com.igexin.sdk.aidl.a.a(r8);	 Catch:{ Exception -> 0x0057 }
        r7.a(r8);	 Catch:{ Exception -> 0x0057 }
        r7 = r6.c;	 Catch:{ Exception -> 0x0057 }
        r7 = r7.g;	 Catch:{ Exception -> 0x0057 }
        r8 = r6.b;	 Catch:{ Exception -> 0x0057 }
        r0 = r6.a;	 Catch:{ Exception -> 0x0057 }
        r7.put(r8, r0);	 Catch:{ Exception -> 0x0057 }
        r7 = r6.a;	 Catch:{ Exception -> 0x0057 }
        r0 = r7.c();	 Catch:{ Exception -> 0x0057 }
        r7 = r6.a;	 Catch:{ Exception -> 0x0057 }
        r1 = r7.a();	 Catch:{ Exception -> 0x0057 }
        r7 = r6.a;	 Catch:{ Exception -> 0x0057 }
        r2 = r7.b();	 Catch:{ Exception -> 0x0057 }
        r3 = r6.b;	 Catch:{ Exception -> 0x0057 }
        r4 = 0;	 Catch:{ Exception -> 0x0057 }
        r7 = r0.onASNLConnected(r1, r2, r3, r4);	 Catch:{ Exception -> 0x0057 }
        r8 = -1;	 Catch:{ Exception -> 0x0057 }
        if (r7 != r8) goto L_0x0049;	 Catch:{ Exception -> 0x0057 }
    L_0x003d:
        r7 = r6.c;	 Catch:{ Exception -> 0x0057 }
        r7 = r7.g;	 Catch:{ Exception -> 0x0057 }
        r8 = r6.b;	 Catch:{ Exception -> 0x0057 }
        r7.remove(r8);	 Catch:{ Exception -> 0x0057 }
        return;	 Catch:{ Exception -> 0x0057 }
    L_0x0049:
        r7 = com.igexin.push.core.g.l;	 Catch:{ Exception -> 0x0057 }
        if (r7 == 0) goto L_0x0056;	 Catch:{ Exception -> 0x0057 }
    L_0x004d:
        r7 = r6.a;	 Catch:{ Exception -> 0x0057 }
        r7 = r7.c();	 Catch:{ Exception -> 0x0057 }
        r7.onASNLNetworkConnected();	 Catch:{ Exception -> 0x0057 }
    L_0x0056:
        return;
    L_0x0057:
        r7 = r6.c;
        r7 = r7.g;
        r8 = r6.b;
        r7.remove(r8);
    L_0x0062:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.e.g.onServiceConnected(android.content.ComponentName, android.os.IBinder):void");
    }

    public void onServiceDisconnected(ComponentName componentName) {
        if (this.c.b == d.active) {
            b bVar = (b) this.c.g.get(this.b);
            this.c.g.remove(this.b);
            List a = this.c.c(bVar.e());
            if (a.size() != 0) {
                for (int i = 0; i < a.size(); i++) {
                    String str = (String) a.get(i);
                    if (str.startsWith("S-")) {
                        e nVar = new n();
                        nVar.a = Long.valueOf(str.substring(2)).longValue();
                        j g = f.a().g();
                        StringBuilder stringBuilder = new StringBuilder("S-");
                        stringBuilder.append(String.valueOf(nVar.a));
                        g.a(stringBuilder.toString(), nVar, true);
                    }
                    this.c.h.remove(str);
                }
            }
        }
    }
}
