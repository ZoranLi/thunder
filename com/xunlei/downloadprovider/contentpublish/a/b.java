package com.xunlei.downloadprovider.contentpublish.a;

import android.os.Environment;
import com.qiniu.android.b.c;
import com.qiniu.android.b.d;
import com.qiniu.android.c.a.a;
import com.qiniu.android.c.h;
import com.qiniu.android.c.j;
import com.qiniu.android.c.t;
import java.io.File;
import java.io.IOException;

/* compiled from: QiniuUploadEnginer */
public class b {
    private static final String b = "b";
    private static final String c;
    public t a;

    static {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(Environment.getExternalStorageDirectory());
        stringBuilder.append("/.fileexplorer/");
        c = stringBuilder.toString();
    }

    public b() {
        this.a = a(c.c);
    }

    public b(d dVar) {
        this.a = a(dVar);
    }

    private t a(d dVar) {
        File file = new File(c);
        if (!file.exists()) {
            file.mkdir();
        }
        j jVar = null;
        try {
            jVar = new a(c);
        } catch (IOException e) {
            new StringBuilder("create upload recorder failed:").append(e.getMessage());
        }
        h cVar = new c(this);
        com.qiniu.android.c.a.a aVar = new com.qiniu.android.c.a.a();
        aVar.f = 262144;
        aVar.g = 524288;
        aVar.h = 10;
        aVar.i = 60;
        aVar.b = jVar;
        aVar.b = jVar;
        aVar.c = cVar;
        aVar.a = dVar;
        return new t(aVar.a());
    }
}
