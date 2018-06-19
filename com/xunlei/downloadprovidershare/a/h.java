package com.xunlei.downloadprovidershare.a;

import android.content.Context;
import com.xunlei.downloadprovidershare.ShareOperationType;
import com.xunlei.downloadprovidershare.a.a;
import com.xunlei.downloadprovidershare.y;

/* compiled from: SharePhotoArticleInfo */
public final class h extends f {
    private String a;

    public h(String str, String str2, String str3, String str4) {
        super(str, str2, str3);
        this.a = str4;
    }

    public final boolean a(Context context, ShareOperationType shareOperationType, a aVar) {
        context = f.c();
        shareOperationType = new StringBuilder();
        shareOperationType.append(this.f);
        shareOperationType.append("?id=");
        shareOperationType.append(this.a);
        this.f = y.a(shareOperationType.toString(), context);
        aVar.a(true, this);
        return null;
    }
}
