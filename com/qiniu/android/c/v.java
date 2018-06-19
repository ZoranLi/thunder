package com.qiniu.android.c;

import com.qiniu.android.a.b.a;
import com.qiniu.android.d.f;
import com.qiniu.android.http.o;
import com.xiaomi.mipush.sdk.Constants;

/* compiled from: UploadManager */
final class v extends a {
    final /* synthetic */ o a;
    final /* synthetic */ long b;
    final /* synthetic */ a c;

    v(a aVar, o oVar, long j) {
        this.c = aVar;
        this.a = oVar;
        this.b = j;
    }

    public final String a() {
        String[] strArr = new String[10];
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.a.a);
        strArr[0] = stringBuilder.toString();
        strArr[1] = this.a.b;
        strArr[2] = this.a.g;
        strArr[3] = this.a.h;
        stringBuilder = new StringBuilder();
        stringBuilder.append(this.a.i);
        strArr[4] = stringBuilder.toString();
        stringBuilder = new StringBuilder();
        stringBuilder.append(this.b - this.c.b);
        strArr[5] = stringBuilder.toString();
        stringBuilder = new StringBuilder();
        stringBuilder.append(this.a.l);
        strArr[6] = stringBuilder.toString();
        stringBuilder = new StringBuilder();
        stringBuilder.append(this.c.c);
        strArr[7] = stringBuilder.toString();
        strArr[8] = "block";
        stringBuilder = new StringBuilder();
        stringBuilder.append(this.c.c);
        strArr[9] = stringBuilder.toString();
        return f.a(strArr, Constants.ACCEPT_TIME_SEPARATOR_SP);
    }
}
