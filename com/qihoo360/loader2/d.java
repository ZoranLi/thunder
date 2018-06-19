package com.qihoo360.loader2;

import android.content.pm.PackageInfo;
import android.content.pm.Signature;
import android.text.TextUtils;
import com.qihoo360.replugin.b.c;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: CertUtils */
public final class d {
    public static final ArrayList<String> a = new ArrayList();

    public static final boolean a(PackageInfo packageInfo) {
        if (packageInfo == null) {
            if (c.a != null) {
                c.a("ws001", "info is null");
            }
            return false;
        } else if (packageInfo.signatures == null) {
            if (c.a != null) {
                c.a("ws001", "signatures is null");
            }
            return false;
        } else {
            String a;
            Signature[] signatureArr = packageInfo.signatures;
            int length = signatureArr.length;
            int i = 0;
            while (true) {
                boolean z = true;
                if (i < length) {
                    a = com.qihoo360.a.a.d.a(a(signatureArr[i].toByteArray()));
                    Iterator it = a.iterator();
                    while (it.hasNext()) {
                        if (TextUtils.equals(a, (String) it.next())) {
                            if (c.a) {
                                StringBuilder stringBuilder = new StringBuilder("isPluginSignatures: match. ");
                                stringBuilder.append(a);
                                stringBuilder.append(" package=");
                                stringBuilder.append(packageInfo.packageName);
                                c.b("ws001", stringBuilder.toString());
                            }
                            if (!z) {
                                break;
                            }
                            i++;
                        }
                    }
                    z = false;
                    if (!z) {
                        break;
                    }
                    i++;
                } else {
                    return true;
                }
            }
            if (c.a) {
                StringBuilder stringBuilder2 = new StringBuilder("isPluginSignatures: unknown signature: ");
                stringBuilder2.append(a);
                stringBuilder2.append(" package=");
                stringBuilder2.append(packageInfo.packageName);
                c.d("ws001", stringBuilder2.toString());
            }
            return false;
        }
    }

    private static byte[] a(byte[] bArr) {
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            instance.update(bArr, 0, bArr.length);
            return instance.digest();
        } catch (byte[] bArr2) {
            if (c.a) {
                c.a("ws001", bArr2.getMessage(), bArr2);
            }
            return new byte[0];
        }
    }
}
