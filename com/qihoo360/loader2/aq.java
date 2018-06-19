package com.qihoo360.loader2;

import android.content.pm.ActivityInfo;
import android.os.RemoteException;
import com.qihoo360.replugin.b.a;
import java.util.HashMap;
import java.util.HashSet;

/* compiled from: TaskAffinityStates */
final class aq {
    private static final int a = a.k;
    private k[] b = new k[a];

    aq() {
    }

    public final void a(String str, String str2, HashMap<String, a> hashMap, HashSet<String> hashSet) {
        for (int i = 0; i < a; i++) {
            if (this.b[i] == null) {
                this.b[i] = new k();
            }
            k kVar = this.b[i];
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append(str2);
            stringBuilder.append("TA");
            stringBuilder.append(i);
            HashSet<String> hashSet2 = hashSet;
            kVar.a(hashMap, hashSet2, stringBuilder.toString(), 0, true, a.c);
            stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append(str2);
            stringBuilder.append("TA");
            stringBuilder.append(i);
            kVar.a(hashMap, hashSet2, stringBuilder.toString(), 0, false, a.g);
            stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append(str2);
            stringBuilder.append("TA");
            stringBuilder.append(i);
            kVar.a(hashMap, hashSet2, stringBuilder.toString(), 1, true, a.d);
            stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append(str2);
            stringBuilder.append("TA");
            stringBuilder.append(i);
            kVar.a(hashMap, hashSet2, stringBuilder.toString(), 1, false, a.h);
            stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append(str2);
            stringBuilder.append("TA");
            stringBuilder.append(i);
            kVar.a(hashMap, hashSet2, stringBuilder.toString(), 2, true, a.e);
            stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append(str2);
            stringBuilder.append("TA");
            stringBuilder.append(i);
            kVar.a(hashMap, hashSet2, stringBuilder.toString(), 2, false, a.i);
            stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append(str2);
            stringBuilder.append("TA");
            stringBuilder.append(i);
            kVar.a(hashMap, hashSet2, stringBuilder.toString(), 3, true, a.f);
            stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append(str2);
            stringBuilder.append("TA");
            stringBuilder.append(i);
            kVar.a(hashMap, hashSet2, stringBuilder.toString(), 3, false, a.j);
        }
    }

    final HashMap<String, a> a(ActivityInfo activityInfo) {
        if (activityInfo != null) {
            int i = 0;
            try {
                i = ac.c().e(activityInfo.taskAffinity);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
            k kVar = this.b[i];
            if (kVar != null) {
                return kVar.a(activityInfo.launchMode, activityInfo.theme);
            }
        }
        return null;
    }
}
