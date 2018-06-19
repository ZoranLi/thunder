package com.android.volley.toolbox;

import java.util.Comparator;

/* compiled from: ByteArrayPool */
final class h implements Comparator<byte[]> {
    h() {
    }

    public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
        return ((byte[]) obj).length - ((byte[]) obj2).length;
    }
}
