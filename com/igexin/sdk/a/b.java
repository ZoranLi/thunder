package com.igexin.sdk.a;

import android.content.Context;
import java.io.File;

public class b {
    private String a;

    public b(Context context) {
        if (context != null) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(context.getFilesDir().getPath());
            stringBuilder.append("/init.pid");
            this.a = stringBuilder.toString();
        }
    }

    public void a() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r2 = this;
        r0 = r2.b();
        if (r0 != 0) goto L_0x0014;
    L_0x0006:
        r0 = r2.a;
        if (r0 == 0) goto L_0x0014;
    L_0x000a:
        r0 = new java.io.File;
        r1 = r2.a;
        r0.<init>(r1);
        r0.createNewFile();	 Catch:{ IOException -> 0x0014 }
    L_0x0014:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.sdk.a.b.a():void");
    }

    public boolean b() {
        return this.a != null ? new File(this.a).exists() : false;
    }
}
