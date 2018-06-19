package com.qiniu.android.c;

import java.io.File;

/* compiled from: Configuration */
final class b implements h {
    final /* synthetic */ a a;

    b(a aVar) {
        this.a = aVar;
    }

    public final String a(String str, File file) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append("_._");
        stringBuilder.append(new StringBuffer(file.getAbsolutePath()).reverse());
        return stringBuilder.toString();
    }
}
