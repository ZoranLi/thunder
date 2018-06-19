package com.xunlei.downloadprovider.contentpublish.a;

import com.qiniu.android.c.h;
import java.io.File;

/* compiled from: QiniuUploadEnginer */
final class c implements h {
    final /* synthetic */ b a;

    c(b bVar) {
        this.a = bVar;
    }

    public final String a(String str, File file) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append("_._");
        stringBuilder.append(new StringBuffer(file.getAbsolutePath()).reverse());
        return stringBuilder.toString();
    }
}
