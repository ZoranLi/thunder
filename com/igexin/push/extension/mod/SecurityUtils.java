package com.igexin.push.extension.mod;

import com.igexin.a.c;
import com.igexin.b.a.c.a;
import com.igexin.sdk.GTServiceManager;

public class SecurityUtils {
    public static final String a = "com.igexin.push.extension.mod.SecurityUtils";
    public static boolean b = false;
    public static String c = "";

    static {
        StringBuilder stringBuilder;
        try {
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append(a);
            stringBuilder2.append("|load so by system start #######");
            a.b(stringBuilder2.toString());
            System.loadLibrary("getuiext2");
            b = true;
            stringBuilder2 = new StringBuilder();
            stringBuilder2.append(a);
            stringBuilder2.append("|load so by system success ^_^");
            a.b(stringBuilder2.toString());
        } catch (UnsatisfiedLinkError e) {
            stringBuilder = new StringBuilder();
            stringBuilder.append(a);
            stringBuilder.append("|load so by system error = ");
            stringBuilder.append(e.toString());
            a.b(stringBuilder.toString());
            stringBuilder = new StringBuilder();
            stringBuilder.append(e.getMessage());
            stringBuilder.append(" + ");
            c = stringBuilder.toString();
            stringBuilder = new StringBuilder();
            stringBuilder.append(a);
            stringBuilder.append("|load so by new start !!");
            a.b(stringBuilder.toString());
            if (GTServiceManager.context == null) {
                stringBuilder = new StringBuilder();
                stringBuilder.append(a);
                stringBuilder.append("|load so by new context = null ~~~~");
                a.b(stringBuilder.toString());
                b = false;
                c = e.getMessage();
                return;
            }
            c.a(null).a().b().a(GTServiceManager.context, "getuiext2", null, new a());
        } catch (Throwable th) {
            stringBuilder = new StringBuilder();
            stringBuilder.append(a);
            stringBuilder.append("|load so error not UnsatisfiedLinkError");
            a.b(stringBuilder.toString());
            stringBuilder = new StringBuilder();
            stringBuilder.append(a);
            stringBuilder.append("|load so error e = ");
            stringBuilder.append(th.toString());
            a.b(stringBuilder.toString());
            b = false;
            StringBuilder stringBuilder3 = new StringBuilder();
            stringBuilder3.append(c);
            stringBuilder3.append(th.toString());
            stringBuilder3.append(" + ");
            stringBuilder3.append(th.getMessage());
            c = stringBuilder3.toString();
        }
    }

    public static native byte[] a();

    public static native byte[] b(byte[] bArr, byte[] bArr2, byte[] bArr3);

    public static native byte[] c(byte[] bArr, byte[] bArr2, byte[] bArr3);

    public static native byte[] d(byte[] bArr);

    public static native byte[] e();

    public static native byte[] f(byte[] bArr, byte[] bArr2, byte[] bArr3);

    public static native byte[] g(byte[] bArr, byte[] bArr2, byte[] bArr3);

    public static native byte[] h(byte[] bArr);

    public static native byte[] i(byte[] bArr);

    public static native byte[] j();

    public static native byte[] k();

    public static native byte[] l(byte[] bArr, byte[] bArr2);

    public static native byte[] m(byte[] bArr, byte[] bArr2);
}
