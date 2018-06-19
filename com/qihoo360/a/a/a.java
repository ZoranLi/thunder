package com.qihoo360.a.a;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import com.qihoo360.replugin.b.c;
import com.qihoo360.replugin.utils.e;
import java.io.File;
import java.lang.reflect.Constructor;

/* compiled from: PackageUtils */
public final class a {
    public static PackageInfo a(PackageManager packageManager, String str) {
        try {
            packageManager = packageManager.getPackageArchiveInfo(str, 64);
        } catch (PackageManager packageManager2) {
            if (c.a) {
                packageManager2.printStackTrace();
            }
            packageManager2 = null;
        }
        if (packageManager2 == null) {
            return null;
        }
        if (packageManager2.signatures == null && VERSION.SDK_INT < 14) {
            packageManager2.signatures = a(str);
        }
        return packageManager2;
    }

    private static final Signature[] a(String str) {
        try {
            Object newInstance;
            Object[] objArr = new Object[]{str};
            Constructor constructor = Class.forName("android.content.pm.PackageParser").getConstructor(new Class[]{String.class});
            if (constructor != null) {
                constructor.setAccessible(true);
                newInstance = constructor.newInstance(objArr);
            } else {
                newInstance = null;
            }
            new DisplayMetrics().setToDefaults();
            Object a = e.a(newInstance, "parsePackage", new Class[]{File.class, String.class, DisplayMetrics.class, Integer.TYPE}, new File(str), str, r3, Integer.valueOf(0));
            if (a == null) {
                if (c.a) {
                    StringBuilder stringBuilder = new StringBuilder("failed to parsePackage: f=");
                    stringBuilder.append(str);
                    c.a("ws002", stringBuilder.toString());
                }
                return null;
            }
            if (!((Boolean) e.a(newInstance, "collectCertificates", new Class[]{a.getClass(), Integer.TYPE}, a, Integer.valueOf(0))).booleanValue()) {
                return null;
            }
            Object[] objArr2 = (Object[]) e.a(a, "mSignatures");
            int length = objArr2.length;
            if (length <= 0 && c.a) {
                StringBuilder stringBuilder2 = new StringBuilder("not found signatures: f=");
                stringBuilder2.append(str);
                c.a("ws002", stringBuilder2.toString());
            }
            if (length > 0) {
                if (c.a != null) {
                    StringBuilder stringBuilder3 = new StringBuilder("found signatures for android 2.x: length=");
                    stringBuilder3.append(objArr2.length);
                    c.a("ws002", stringBuilder3.toString());
                }
                str = new Signature[length];
                System.arraycopy(objArr2, 0, str, 0, length);
                return str;
            }
            return null;
        } catch (String str2) {
            if (c.a) {
                c.a("ws002", str2.getMessage(), str2);
            }
        }
    }
}
