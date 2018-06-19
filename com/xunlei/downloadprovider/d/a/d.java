package com.xunlei.downloadprovider.d.a;

import android.text.TextUtils;
import com.android.volley.n.b;
import com.xunlei.downloadprovider.app.e;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/* compiled from: AbsConfig */
final class d implements b<String> {
    final /* synthetic */ c a;

    d(c cVar) {
        this.a = cVar;
    }

    public final /* synthetic */ void onResponse(Object obj) {
        String str = (String) obj;
        if (!((TextUtils.isEmpty(this.a.a.v) ^ 1) == 0 || TextUtils.isEmpty(str))) {
            String b = this.a.a.v;
            e.a("You should not write file on main thread");
            if (!TextUtils.isEmpty(b)) {
                try {
                    FileOutputStream fileOutputStream = new FileOutputStream(new File(f.a(b)));
                    fileOutputStream.write(str.getBytes());
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        a.b(this.a.a, str);
    }
}
