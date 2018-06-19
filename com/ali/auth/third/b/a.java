package com.ali.auth.third.b;

import com.ali.auth.third.core.exception.SecRuntimeException;
import com.ali.auth.third.core.h.d;
import com.alibaba.wireless.security.open.SecException;
import com.alibaba.wireless.security.open.SecurityGuardManager;

public class a implements d {
    private static SecurityGuardManager b() {
        try {
            return SecurityGuardManager.getInstance(com.ali.auth.third.core.c.a.c);
        } catch (Throwable e) {
            throw new SecRuntimeException(e.getErrorCode(), e);
        }
    }

    public final String a() {
        try {
            return b().getStaticDataStoreComp().getAppKeyByIndex(com.ali.auth.third.core.config.a.b(), com.ali.auth.third.core.config.a.j);
        } catch (Throwable e) {
            throw new SecRuntimeException(e.getErrorCode(), e);
        }
    }

    public final java.lang.String a(java.lang.String r2) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r1 = this;
        r0 = b();	 Catch:{ SecException -> 0x000d }
        r0 = r0.getDynamicDataStoreComp();	 Catch:{ SecException -> 0x000d }
        r2 = r0.getString(r2);	 Catch:{ SecException -> 0x000d }
        return r2;
    L_0x000d:
        r2 = 0;
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ali.auth.third.b.a.a(java.lang.String):java.lang.String");
    }

    public final void a(String str, String str2) {
        try {
            b().getDynamicDataStoreComp().putString(str, str2);
        } catch (SecException e) {
            e.printStackTrace();
        }
    }

    public final void b(String str) {
        try {
            b().getDynamicDataStoreComp().removeString(str);
        } catch (SecException e) {
            e.printStackTrace();
        }
    }
}
