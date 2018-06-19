package com.qihoo360.loader2;

import com.qihoo360.replugin.RePlugin;
import com.qihoo360.replugin.b.c;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/* compiled from: LaunchModeStates */
public final class k {
    private Map<String, HashMap<String, a>> a = new HashMap();

    public static boolean a(int i) {
        if (!(i == 16973839 || i == 16973835 || i == 16973840)) {
            if (i != 16973841) {
                return false;
            }
        }
        return true;
    }

    k() {
    }

    final void a(Map<String, a> map, HashSet<String> hashSet, String str, int i, boolean z, int i2) {
        i = a(i, z);
        z = (HashMap) this.a.get(i);
        if (z == null) {
            z = new HashMap();
            this.a.put(i, z);
        }
        for (int i3 = 0; i3 < i2; i3++) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append(i);
            stringBuilder.append(i3);
            String stringBuilder2 = stringBuilder.toString();
            if (RePlugin.getConfig().g) {
                StringBuilder stringBuilder3 = new StringBuilder("LaunchModeStates.add(");
                stringBuilder3.append(stringBuilder2);
                stringBuilder3.append(com.umeng.message.proguard.k.t);
                c.a("launchMode", stringBuilder3.toString());
            }
            a aVar = new a(stringBuilder2);
            z.put(stringBuilder2, aVar);
            map.put(stringBuilder2, aVar);
            hashSet.add(stringBuilder2);
        }
    }

    final HashMap<String, a> a(int i, int i2) {
        return (HashMap) this.a.get(a(i, a(i2)));
    }

    private static String a(int i, boolean z) {
        switch (i) {
            case 1:
                i = "STP";
                break;
            case 2:
                i = "ST";
                break;
            case 3:
                i = "SI";
                break;
            default:
                i = "NR";
                break;
        }
        if (z) {
            z = new StringBuilder();
            z.append(i);
            i = "TS";
        } else {
            z = new StringBuilder();
            z.append(i);
            i = "NTS";
        }
        z.append(i);
        return z.toString();
    }
}
