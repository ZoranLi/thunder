package com.qihoo360.replugin.component.process;

import android.util.SparseArray;
import com.qihoo360.replugin.a.b;
import com.qihoo360.replugin.component.provider.PluginPitProviderBase;
import java.util.HashMap;
import java.util.Map;

/* compiled from: PluginProcessHost */
public final class a {
    public static final Map<String, Integer> a = new HashMap();
    public static final Map<String, String> b = new HashMap();
    public static final SparseArray<String> c = new SparseArray();

    public static boolean a(int i) {
        return i >= -100 && i < -97;
    }

    static {
        for (int i = 0; i < 3; i++) {
            Map map = a;
            StringBuilder stringBuilder = new StringBuilder(":p");
            stringBuilder.append(i);
            int i2 = -100 + i;
            map.put(stringBuilder.toString(), Integer.valueOf(i2));
            map = b;
            stringBuilder = new StringBuilder("$p");
            stringBuilder.append(i);
            String stringBuilder2 = stringBuilder.toString();
            StringBuilder stringBuilder3 = new StringBuilder();
            stringBuilder3.append(b.c);
            stringBuilder3.append(":p");
            stringBuilder3.append(i);
            map.put(stringBuilder2, stringBuilder3.toString());
            SparseArray sparseArray = c;
            stringBuilder = new StringBuilder();
            stringBuilder.append(PluginPitProviderBase.AUTHORITY_PREFIX);
            stringBuilder.append(i);
            sparseArray.put(i2, stringBuilder.toString());
        }
    }

    public static String a(String str) {
        int indexOf = str.indexOf(58);
        return indexOf >= 0 ? str.toLowerCase().substring(indexOf) : str;
    }
}
