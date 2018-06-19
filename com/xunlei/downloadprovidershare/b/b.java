package com.xunlei.downloadprovidershare.b;

import android.support.annotation.NonNull;
import com.xunlei.downloadprovidershare.ShareOperationType;

/* compiled from: SharePlatformItem */
public final class b implements Comparable<b> {
    String a;
    int b;
    String c;
    ShareOperationType d;

    public final /* bridge */ /* synthetic */ int compareTo(@NonNull Object obj) {
        return ((b) obj).d == this.d ? null : 1;
    }

    public b(String str, String str2, ShareOperationType shareOperationType) {
        this.a = str;
        this.c = str2;
        this.d = shareOperationType;
    }

    public b(String str, int i, ShareOperationType shareOperationType) {
        this.a = str;
        this.b = i;
        this.d = shareOperationType;
    }
}
