package anet.channel.security;

import android.content.Context;
import android.text.TextUtils;
import anet.channel.util.ALog;
import com.alibaba.wireless.security.open.SecurityGuardManager;
import com.alibaba.wireless.security.open.SecurityGuardParamContext;
import com.alibaba.wireless.security.open.securesignature.SecureSignatureDefine;
import java.util.Map;

/* compiled from: Taobao */
class b implements ISecurity {
    private static String a = "awcn.DefaultSecurityGuard";
    private static boolean b = false;
    private static Map<String, Integer> c;
    private String d = null;

    public boolean isSecOff() {
        return false;
    }

    static {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = "com.alibaba.wireless.security.open.SecurityGuardManager";	 Catch:{ Throwable -> 0x0027 }
        java.lang.Class.forName(r0);	 Catch:{ Throwable -> 0x0027 }
        r0 = 1;	 Catch:{ Throwable -> 0x0027 }
        b = r0;	 Catch:{ Throwable -> 0x0027 }
        r0 = new java.util.HashMap;	 Catch:{ Throwable -> 0x0027 }
        r0.<init>();	 Catch:{ Throwable -> 0x0027 }
        c = r0;	 Catch:{ Throwable -> 0x0027 }
        r1 = "HMAC_SHA1";	 Catch:{ Throwable -> 0x0027 }
        r2 = 3;	 Catch:{ Throwable -> 0x0027 }
        r2 = java.lang.Integer.valueOf(r2);	 Catch:{ Throwable -> 0x0027 }
        r0.put(r1, r2);	 Catch:{ Throwable -> 0x0027 }
        r0 = c;	 Catch:{ Throwable -> 0x0027 }
        r1 = "ASE128";	 Catch:{ Throwable -> 0x0027 }
        r2 = 16;	 Catch:{ Throwable -> 0x0027 }
        r2 = java.lang.Integer.valueOf(r2);	 Catch:{ Throwable -> 0x0027 }
        r0.put(r1, r2);	 Catch:{ Throwable -> 0x0027 }
        return;
    L_0x0027:
        r0 = 0;
        b = r0;
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: anet.channel.security.b.<clinit>():void");
    }

    b(String str) {
        this.d = str;
    }

    public String sign(Context context, String str, String str2, String str3) {
        if (!(!b || context == null || TextUtils.isEmpty(str2))) {
            if (c.containsKey(str)) {
                try {
                    context = SecurityGuardManager.getInstance(context).getSecureSignatureComp();
                    if (context != null) {
                        SecurityGuardParamContext securityGuardParamContext = new SecurityGuardParamContext();
                        securityGuardParamContext.appKey = str2;
                        securityGuardParamContext.paramMap.put(SecureSignatureDefine.OPEN_KEY_SIGN_INPUT, str3);
                        securityGuardParamContext.requestType = ((Integer) c.get(str)).intValue();
                        return context.signRequest(securityGuardParamContext, this.d);
                    }
                } catch (Context context2) {
                    ALog.e(a, "Securityguard sign request failed.", null, context2, new Object[null]);
                }
                return null;
            }
        }
        return null;
    }

    public byte[] decrypt(Context context, String str, String str2, byte[] bArr) {
        if (!(!b || context == null || bArr == null || TextUtils.isEmpty(str2))) {
            if (c.containsKey(str)) {
                Integer num = (Integer) c.get(str);
                if (num == null) {
                    return null;
                }
                try {
                    context = SecurityGuardManager.getInstance(context);
                    if (context != null) {
                        context = context.getStaticDataEncryptComp();
                        if (context != null) {
                            return context.staticBinarySafeDecryptNoB64(num.intValue(), str2, bArr, this.d);
                        }
                    }
                } catch (Context context2) {
                    ALog.e(a, "staticBinarySafeDecryptNoB64", null, context2, new Object[null]);
                }
                return null;
            }
        }
        return null;
    }

    public boolean saveBytes(Context context, String str, byte[] bArr) {
        boolean z = false;
        if (!(context == null || bArr == null)) {
            if (!TextUtils.isEmpty(str)) {
                try {
                    context = SecurityGuardManager.getInstance(context);
                    if (context != null) {
                        context = context.getDynamicDataStoreComp();
                        if (!(context == null || context.putByteArray(str, bArr) == null)) {
                            z = true;
                        }
                    }
                } catch (Context context2) {
                    ALog.e(a, "saveBytes", null, context2, new Object[0]);
                }
                return z;
            }
        }
        return false;
    }

    public byte[] getBytes(Context context, String str) {
        byte[] bArr = null;
        if (context != null) {
            if (!TextUtils.isEmpty(str)) {
                try {
                    context = SecurityGuardManager.getInstance(context);
                    if (context != null) {
                        context = context.getDynamicDataStoreComp();
                        if (context != null) {
                            bArr = context.getByteArray(str);
                        }
                    }
                } catch (Context context2) {
                    ALog.e(a, "getBytes", null, context2, new Object[0]);
                }
                return bArr;
            }
        }
        return null;
    }
}
