package com.qiniu.android.c;

import java.util.HashMap;
import java.util.Map;

/* compiled from: UploadOptions */
public final class x {
    final Map<String, String> a;
    final String b;
    final boolean c;
    final r d;
    final p e;
    final i f;

    public x(String str, boolean z, r rVar, p pVar) {
        this(str, z, rVar, pVar, (byte) 0);
    }

    private x(String str, boolean z, r rVar, p pVar, byte b) {
        this.a = new HashMap();
        if (str == null || str.equals("") != (byte) 0) {
            str = "application/octet-stream";
        }
        this.b = str;
        this.c = z;
        if (rVar == null) {
            rVar = new y(this);
        }
        this.d = rVar;
        if (pVar == null) {
            pVar = new z(this);
        }
        this.e = pVar;
        this.f = new aa(this);
    }

    static x a() {
        return new x(null, false, null, null);
    }
}
