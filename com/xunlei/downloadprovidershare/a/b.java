package com.xunlei.downloadprovidershare.a;

import android.content.Context;
import com.xunlei.downloadprovidershare.ShareOperationType;
import com.xunlei.downloadprovidershare.a.a;
import com.xunlei.downloadprovidershare.y;
import org.android.agoo.common.AgooConstants;

/* compiled from: ShareCinecismInfo */
public final class b extends f {
    private String a;

    public b(String str, String str2, String str3, String str4) {
        super(str, str2, str3);
        this.a = str4;
    }

    public final boolean a(Context context, ShareOperationType shareOperationType, a aVar) {
        context = f.c();
        context.put(AgooConstants.MESSAGE_ID, this.a);
        this.f = y.a(this.f, context);
        aVar.a(true, this);
        return null;
    }
}
