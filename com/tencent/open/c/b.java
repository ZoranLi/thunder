package com.tencent.open.c;

import android.content.Context;
import android.webkit.WebView;

/* compiled from: ProGuard */
public class b extends WebView {
    public b(Context context) {
        super(context);
    }

    protected void onAttachedToWindow() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r6 = this;
        super.onAttachedToWindow();
        r0 = r6.getSettings();
        if (r0 != 0) goto L_0x000a;
    L_0x0009:
        return;
    L_0x000a:
        r0 = r0.getClass();
        r1 = "removeJavascriptInterface";	 Catch:{ Exception -> 0x0028 }
        r2 = 1;	 Catch:{ Exception -> 0x0028 }
        r3 = new java.lang.Class[r2];	 Catch:{ Exception -> 0x0028 }
        r4 = java.lang.String.class;	 Catch:{ Exception -> 0x0028 }
        r5 = 0;	 Catch:{ Exception -> 0x0028 }
        r3[r5] = r4;	 Catch:{ Exception -> 0x0028 }
        r0 = r0.getMethod(r1, r3);	 Catch:{ Exception -> 0x0028 }
        if (r0 == 0) goto L_0x0027;	 Catch:{ Exception -> 0x0028 }
    L_0x001e:
        r1 = new java.lang.Object[r2];	 Catch:{ Exception -> 0x0028 }
        r2 = "searchBoxJavaBridge_";	 Catch:{ Exception -> 0x0028 }
        r1[r5] = r2;	 Catch:{ Exception -> 0x0028 }
        r0.invoke(r6, r1);	 Catch:{ Exception -> 0x0028 }
    L_0x0027:
        return;
    L_0x0028:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.open.c.b.onAttachedToWindow():void");
    }
}
