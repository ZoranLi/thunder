package com.tencent.open.web.security;

import com.tencent.open.a.b;
import com.tencent.open.a.f;

/* compiled from: ProGuard */
public class SecureJsInterface extends b {
    public static boolean isPWDEdit = false;
    private String a;

    public boolean customCallback() {
        return true;
    }

    public void curPosFromJS(String str) {
        StringBuilder stringBuilder = new StringBuilder("-->curPosFromJS: ");
        stringBuilder.append(str);
        f.b("openSDK_LOG.SecureJsInterface", stringBuilder.toString());
        try {
            str = Integer.parseInt(str);
        } catch (String str2) {
            f.b("openSDK_LOG.SecureJsInterface", "-->curPosFromJS number format exception.", str2);
            str2 = -1;
        }
        if (str2 < null) {
            throw new RuntimeException("position is illegal.");
        }
        boolean z = a.c;
        if (!a.b) {
            this.a = a.a;
            JniInterface.insetTextToArray(str2, this.a, this.a.length());
            StringBuilder stringBuilder2 = new StringBuilder("curPosFromJS mKey: ");
            stringBuilder2.append(this.a);
            f.a("openSDK_LOG.SecureJsInterface", stringBuilder2.toString());
        } else if (Boolean.valueOf(JniInterface.BackSpaceChar(a.b, str2)).booleanValue() != null) {
            a.b = null;
        }
    }

    public void isPasswordEdit(String str) {
        StringBuilder stringBuilder = new StringBuilder("-->is pswd edit, flag: ");
        stringBuilder.append(str);
        f.c("openSDK_LOG.SecureJsInterface", stringBuilder.toString());
        try {
            str = Integer.parseInt(str);
        } catch (String str2) {
            stringBuilder = new StringBuilder("-->is pswd edit exception: ");
            stringBuilder.append(str2.getMessage());
            f.e("openSDK_LOG.SecureJsInterface", stringBuilder.toString());
            str2 = -1;
        }
        if (str2 != null && str2 != 1) {
            throw new RuntimeException("is pswd edit flag is illegal.");
        } else if (str2 == null) {
            isPWDEdit = null;
        } else {
            if (str2 == 1) {
                isPWDEdit = true;
            }
        }
    }

    public void clearAllEdit() {
        f.c("openSDK_LOG.SecureJsInterface", "-->clear all edit.");
        try {
            JniInterface.clearAllPWD();
        } catch (Throwable e) {
            StringBuilder stringBuilder = new StringBuilder("-->clear all edit exception: ");
            stringBuilder.append(e.getMessage());
            f.e("openSDK_LOG.SecureJsInterface", stringBuilder.toString());
            throw new RuntimeException(e);
        }
    }

    public String getMD5FromNative() {
        f.c("openSDK_LOG.SecureJsInterface", "-->get md5 form native");
        StringBuilder stringBuilder;
        try {
            String pWDKeyToMD5 = JniInterface.getPWDKeyToMD5(null);
            stringBuilder = new StringBuilder("-->getMD5FromNative, MD5= ");
            stringBuilder.append(pWDKeyToMD5);
            f.a("openSDK_LOG.SecureJsInterface", stringBuilder.toString());
            return pWDKeyToMD5;
        } catch (Throwable e) {
            stringBuilder = new StringBuilder("-->get md5 form native exception: ");
            stringBuilder.append(e.getMessage());
            f.e("openSDK_LOG.SecureJsInterface", stringBuilder.toString());
            throw new RuntimeException(e);
        }
    }
}
