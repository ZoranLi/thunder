package com.xunlei.downloadprovidershare.a;

import android.content.Context;
import com.xunlei.downloadprovidershare.ShareOperationType;
import com.xunlei.downloadprovidershare.a.a;
import com.xunlei.downloadprovidershare.y;
import java.util.HashMap;

/* compiled from: SharePersonalInfo */
public final class g extends f {
    private String a;

    public g(String str, String str2, String str3, String str4) {
        super(str2, str3, str4);
        this.a = str;
    }

    public final boolean a(Context context, ShareOperationType shareOperationType, a aVar) {
        HashMap c = f.c();
        c.put("userId", this.a);
        this.f = y.a(this.f, c);
        return super.a(context, shareOperationType, aVar);
    }
}
