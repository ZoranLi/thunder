package com.xunlei.downloadprovider.web.browser.a;

import com.android.volley.n.b;
import java.io.FileOutputStream;

/* compiled from: BrowserInjectHack */
final class d implements b<String> {
    d() {
    }

    public final /* synthetic */ void onResponse(Object obj) {
        String str = (String) obj;
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(a.a());
            fileOutputStream.write(str.getBytes());
            fileOutputStream.close();
        } catch (Object obj2) {
            obj2.printStackTrace();
        }
    }
}
