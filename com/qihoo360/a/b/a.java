package com.qihoo360.a.b;

import com.qihoo360.replugin.utils.e;
import java.lang.reflect.Method;

/* compiled from: FilePermissionUtils */
public final class a {
    private static Class<?> a;
    private static Method b;

    public static int a(String str, int i) {
        try {
            if (a == null) {
                a = Class.forName("android.os.FileUtils");
            }
            if (b == null) {
                b = e.a(a, "setPermissions", String.class, Integer.TYPE, Integer.TYPE, Integer.TYPE);
            }
            str = b.invoke(null, new Object[]{str, Integer.valueOf(i), Integer.valueOf(-1), Integer.valueOf(-1)});
            if (!(str == null || (str instanceof Integer) == 0)) {
                return ((Integer) str).intValue();
            }
        } catch (String str2) {
            str2.printStackTrace();
        } catch (String str22) {
            str22.printStackTrace();
        } catch (String str222) {
            str222.printStackTrace();
        }
        return -1;
    }
}
