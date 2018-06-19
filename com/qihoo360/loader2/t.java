package com.qihoo360.loader2;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.text.TextUtils;
import com.alipay.sdk.util.h;
import com.qihoo360.mobilesafe.api.Pref;
import com.qihoo360.replugin.a.b;
import com.qihoo360.replugin.b.c;
import com.xiaomi.mipush.sdk.Constants;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

/* compiled from: PluginContainers */
public final class t {
    public final Object a = new Object();
    public HashMap<String, a> b = new HashMap();
    private aq c = new aq();
    private k d = new k();
    private final Map<String, ap> e = new HashMap();

    /* compiled from: PluginContainers */
    static final class a {
        public final String a;
        public int b;
        public String c;
        public String d;
        public long e;
        final ArrayList<WeakReference<Activity>> f;

        public static final String a(int i) {
            switch (i) {
                case 0:
                    return "none";
                case 1:
                    return "occupied";
                case 2:
                    return "restored";
                default:
                    return "unknown";
            }
        }

        a(String str) {
            this.a = str;
            this.f = new ArrayList();
        }

        public a(a aVar) {
            this.a = aVar.a;
            this.b = aVar.b;
            this.c = aVar.c;
            this.d = aVar.d;
            this.e = aVar.e;
            this.f = new ArrayList(aVar.f);
        }

        public final String toString() {
            if (!c.a) {
                return super.toString();
            }
            StringBuilder stringBuilder = new StringBuilder(" state=");
            stringBuilder.append(a(this.b));
            String stringBuilder2 = stringBuilder.toString();
            StringBuilder stringBuilder3 = new StringBuilder(" plugin=");
            stringBuilder3.append(this.c);
            String stringBuilder4 = stringBuilder3.toString();
            StringBuilder stringBuilder5 = new StringBuilder(" activity=");
            stringBuilder5.append(this.d);
            String stringBuilder6 = stringBuilder5.toString();
            StringBuilder stringBuilder7 = new StringBuilder(" size=");
            stringBuilder7.append(this.f.size());
            String stringBuilder8 = stringBuilder7.toString();
            StringBuilder stringBuilder9 = new StringBuilder("ActivityState {container=");
            stringBuilder9.append(this.a);
            stringBuilder9.append(stringBuilder2);
            stringBuilder9.append(stringBuilder4);
            stringBuilder9.append(stringBuilder6);
            stringBuilder9.append(stringBuilder8);
            stringBuilder9.append(h.d);
            return stringBuilder9.toString();
        }

        final void a() {
            if (c.a) {
                Iterator it = this.f.iterator();
                while (it.hasNext()) {
                    WeakReference weakReference = (WeakReference) it.next();
                    if (weakReference.get() != null) {
                        StringBuilder stringBuilder = new StringBuilder("PACM: clean refs: exist a=");
                        stringBuilder.append(weakReference.get());
                        c.c("ws001", stringBuilder.toString());
                    }
                }
            }
            this.f.clear();
        }

        public final void a(Activity activity) {
            Iterator it = this.f.iterator();
            while (it.hasNext()) {
                if (((WeakReference) it.next()).get() == activity) {
                    return;
                }
            }
            this.f.add(new WeakReference(activity));
        }

        public final void b(Activity activity) {
            for (int size = this.f.size() - 1; size >= 0; size--) {
                if (((WeakReference) this.f.get(size)).get() == activity) {
                    this.f.remove(size);
                    return;
                }
            }
        }

        final void b() {
            Iterator it = this.f.iterator();
            while (it.hasNext()) {
                Activity activity = (Activity) ((WeakReference) it.next()).get();
                if (activity != null) {
                    activity.finish();
                }
            }
        }

        static /* synthetic */ void a(a aVar, String str, String str2) {
            if (!TextUtils.isEmpty(str)) {
                if (!TextUtils.isEmpty(str2)) {
                    aVar.b = 1;
                    aVar.c = str;
                    aVar.d = str2;
                    aVar.a();
                    aVar.e = System.currentTimeMillis();
                    str = aVar.c;
                    str2 = aVar.d;
                    aVar = aVar.a;
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(str);
                    stringBuilder.append(Constants.COLON_SEPARATOR);
                    stringBuilder.append(str2);
                    stringBuilder.append(Constants.COLON_SEPARATOR);
                    stringBuilder.append(System.currentTimeMillis());
                    str = stringBuilder.toString();
                    if (c.a != null) {
                        stringBuilder = new StringBuilder("PACM: save 2 pref: k=");
                        stringBuilder.append(aVar);
                        stringBuilder.append(" v=");
                        stringBuilder.append(str);
                        c.a("ws001", stringBuilder.toString());
                    }
                    Pref.ipcSet(aVar, str);
                    return;
                }
            }
            if (c.a) {
                StringBuilder stringBuilder2 = new StringBuilder("PACM: occupy: invalid s=");
                stringBuilder2.append(a(aVar.b));
                stringBuilder2.append(" plugin=");
                stringBuilder2.append(str);
                stringBuilder2.append(" activity=");
                stringBuilder2.append(str2);
                c.c("ws001", stringBuilder2.toString());
            }
        }

        static /* synthetic */ boolean b(a aVar, String str, String str2) {
            return (TextUtils.equals(aVar.c, str) == null || TextUtils.equals(aVar.d, str2) == null) ? null : true;
        }

        static /* synthetic */ boolean a(a aVar) {
            for (int size = aVar.f.size() - 1; size >= 0; size--) {
                if (((WeakReference) aVar.f.get(size)).get() == null) {
                    aVar.f.remove(size);
                }
            }
            if (aVar.f.size() > null) {
                return true;
            }
            return null;
        }
    }

    final void a(int i, HashSet<String> hashSet) {
        if (i == -1 || com.qihoo360.replugin.component.process.a.a(i) || aa.a()) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(b.c);
            stringBuilder.append(".loader.a.Activity");
            String stringBuilder2 = stringBuilder.toString();
            if (i == -1 || com.qihoo360.replugin.component.process.a.a(i)) {
                String str = "N1";
                k kVar = this.d;
                Map map = this.b;
                stringBuilder = new StringBuilder();
                stringBuilder.append(stringBuilder2);
                stringBuilder.append(str);
                kVar.a(map, hashSet, stringBuilder.toString(), 0, true, com.qihoo360.replugin.b.a.c);
                kVar = this.d;
                map = this.b;
                stringBuilder = new StringBuilder();
                stringBuilder.append(stringBuilder2);
                stringBuilder.append(str);
                kVar.a(map, hashSet, stringBuilder.toString(), 0, false, com.qihoo360.replugin.b.a.g);
                kVar = this.d;
                map = this.b;
                stringBuilder = new StringBuilder();
                stringBuilder.append(stringBuilder2);
                stringBuilder.append(str);
                kVar.a(map, hashSet, stringBuilder.toString(), 1, true, com.qihoo360.replugin.b.a.d);
                kVar = this.d;
                map = this.b;
                stringBuilder = new StringBuilder();
                stringBuilder.append(stringBuilder2);
                stringBuilder.append(str);
                kVar.a(map, hashSet, stringBuilder.toString(), 1, false, com.qihoo360.replugin.b.a.h);
                kVar = this.d;
                map = this.b;
                stringBuilder = new StringBuilder();
                stringBuilder.append(stringBuilder2);
                stringBuilder.append(str);
                kVar.a(map, hashSet, stringBuilder.toString(), 2, true, com.qihoo360.replugin.b.a.e);
                kVar = this.d;
                map = this.b;
                stringBuilder = new StringBuilder();
                stringBuilder.append(stringBuilder2);
                stringBuilder.append(str);
                kVar.a(map, hashSet, stringBuilder.toString(), 2, false, com.qihoo360.replugin.b.a.i);
                kVar = this.d;
                map = this.b;
                stringBuilder = new StringBuilder();
                stringBuilder.append(stringBuilder2);
                stringBuilder.append(str);
                kVar.a(map, hashSet, stringBuilder.toString(), 3, true, com.qihoo360.replugin.b.a.f);
                kVar = this.d;
                map = this.b;
                stringBuilder = new StringBuilder();
                stringBuilder.append(stringBuilder2);
                stringBuilder.append(str);
                kVar.a(map, hashSet, stringBuilder.toString(), 3, false, com.qihoo360.replugin.b.a.j);
                this.c.a(stringBuilder2, str, this.b, hashSet);
                for (int i2 = 0; i2 < 3; i2++) {
                    ap apVar = new ap();
                    Map map2 = this.e;
                    StringBuilder stringBuilder3 = new StringBuilder(":p");
                    stringBuilder3.append(i2);
                    map2.put(stringBuilder3.toString(), apVar);
                    StringBuilder stringBuilder4 = new StringBuilder("p");
                    stringBuilder4.append(i2);
                    String toUpperCase = stringBuilder4.toString().toUpperCase();
                    kVar = apVar.b;
                    map = this.b;
                    stringBuilder = new StringBuilder();
                    stringBuilder.append(stringBuilder2);
                    stringBuilder.append(toUpperCase);
                    kVar.a(map, hashSet, stringBuilder.toString(), 0, true, com.qihoo360.replugin.b.a.c);
                    kVar = apVar.b;
                    map = this.b;
                    stringBuilder = new StringBuilder();
                    stringBuilder.append(stringBuilder2);
                    stringBuilder.append(toUpperCase);
                    kVar.a(map, hashSet, stringBuilder.toString(), 0, false, com.qihoo360.replugin.b.a.g);
                    kVar = apVar.b;
                    map = this.b;
                    stringBuilder = new StringBuilder();
                    stringBuilder.append(stringBuilder2);
                    stringBuilder.append(toUpperCase);
                    kVar.a(map, hashSet, stringBuilder.toString(), 1, true, com.qihoo360.replugin.b.a.d);
                    kVar = apVar.b;
                    map = this.b;
                    stringBuilder = new StringBuilder();
                    stringBuilder.append(stringBuilder2);
                    stringBuilder.append(toUpperCase);
                    kVar.a(map, hashSet, stringBuilder.toString(), 1, false, com.qihoo360.replugin.b.a.h);
                    kVar = apVar.b;
                    map = this.b;
                    stringBuilder = new StringBuilder();
                    stringBuilder.append(stringBuilder2);
                    stringBuilder.append(toUpperCase);
                    kVar.a(map, hashSet, stringBuilder.toString(), 2, true, com.qihoo360.replugin.b.a.e);
                    kVar = apVar.b;
                    map = this.b;
                    stringBuilder = new StringBuilder();
                    stringBuilder.append(stringBuilder2);
                    stringBuilder.append(toUpperCase);
                    kVar.a(map, hashSet, stringBuilder.toString(), 2, false, com.qihoo360.replugin.b.a.i);
                    kVar = apVar.b;
                    map = this.b;
                    stringBuilder = new StringBuilder();
                    stringBuilder.append(stringBuilder2);
                    stringBuilder.append(toUpperCase);
                    kVar.a(map, hashSet, stringBuilder.toString(), 3, true, com.qihoo360.replugin.b.a.f);
                    kVar = apVar.b;
                    map = this.b;
                    stringBuilder = new StringBuilder();
                    stringBuilder.append(stringBuilder2);
                    stringBuilder.append(toUpperCase);
                    kVar.a(map, hashSet, stringBuilder.toString(), 3, false, com.qihoo360.replugin.b.a.j);
                    apVar.a.a(stringBuilder2, toUpperCase, this.b, hashSet);
                }
                a();
            }
        }
    }

    private final void a() {
        try {
            Map ipcGetAll = Pref.ipcGetAll();
            if (c.a) {
                StringBuilder stringBuilder = new StringBuilder("PACM: restore table: size=");
                stringBuilder.append(ipcGetAll.size());
                c.a("ws001", stringBuilder.toString());
            }
            for (Entry entry : ipcGetAll.entrySet()) {
                String str = (String) entry.getKey();
                Object value = entry.getValue();
                a aVar = (a) this.b.get(str);
                String[] split = value.toString().split(Constants.COLON_SEPARATOR);
                StringBuilder stringBuilder2;
                if (aVar != null && split != null && split.length == 3) {
                    String str2 = split[0];
                    String str3 = split[1];
                    long parseLong = Long.parseLong(split[2]);
                    if (c.a) {
                        StringBuilder stringBuilder3 = new StringBuilder("PACM: restore table:  container=");
                        stringBuilder3.append(str);
                        stringBuilder3.append(" plugin=");
                        stringBuilder3.append(str2);
                        stringBuilder3.append(" activity=");
                        stringBuilder3.append(str3);
                        c.a("ws001", stringBuilder3.toString());
                    }
                    if (!(TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3))) {
                        if (!TextUtils.isEmpty(str2)) {
                            if (!TextUtils.isEmpty(str3)) {
                                aVar.b = 2;
                                aVar.c = str2;
                                aVar.d = str3;
                                aVar.a();
                                aVar.e = parseLong;
                            }
                        }
                        if (c.a) {
                            stringBuilder2 = new StringBuilder("PACM: restore: invalid s=");
                            stringBuilder2.append(a.a(aVar.b));
                            stringBuilder2.append(" plugin=");
                            stringBuilder2.append(str2);
                            stringBuilder2.append(" activity=");
                            stringBuilder2.append(str3);
                            c.c("ws001", stringBuilder2.toString());
                        }
                    }
                } else if (c.a) {
                    stringBuilder2 = new StringBuilder("PACM: invalid table: k=");
                    stringBuilder2.append(str);
                    stringBuilder2.append(" v=");
                    stringBuilder2.append(value);
                    c.c("ws001", stringBuilder2.toString());
                }
            }
        } catch (Throwable th) {
            new StringBuilder("PACM: init e=").append(th.getMessage());
        }
    }

    final String a(ActivityInfo activityInfo, String str, String str2) {
        String str3 = activityInfo.applicationInfo.packageName;
        if (c.a) {
            StringBuilder stringBuilder = new StringBuilder("originTaskAffinity is ");
            stringBuilder.append(activityInfo.taskAffinity);
            c.a("task-affinity", stringBuilder.toString());
        }
        if (activityInfo.launchMode == 3) {
            synchronized (this.a) {
                activityInfo = a(this.d.a(activityInfo.launchMode, activityInfo.theme), str, str2);
            }
        } else if (str3.equals(activityInfo.taskAffinity)) {
            synchronized (this.a) {
                activityInfo = a(this.d.a(activityInfo.launchMode, activityInfo.theme), str, str2);
            }
        } else {
            synchronized (this.a) {
                activityInfo = a(this.c.a(activityInfo), str, str2);
            }
        }
        return activityInfo != null ? activityInfo.a : null;
    }

    private static a a(HashMap<String, a> hashMap, String str, String str2) {
        if (hashMap == null) {
            if (c.a != null) {
                c.a("ws001", "PACM: alloc fail, map is null");
            }
            return null;
        }
        for (a aVar : hashMap.values()) {
            if (a.b(aVar, str, str2)) {
                if (c.a != null) {
                    str = new StringBuilder("PACM: alloc registered container=");
                    str.append(aVar.a);
                    c.a("ws001", str.toString());
                }
                return aVar;
            }
        }
        for (a aVar2 : hashMap.values()) {
            if (aVar2.b == 0) {
                if (c.a != null) {
                    StringBuilder stringBuilder = new StringBuilder("PACM: alloc empty container=");
                    stringBuilder.append(aVar2.a);
                    c.a("ws001", stringBuilder.toString());
                }
                a.a(aVar2, str, str2);
                return aVar2;
            }
        }
        a aVar22 = null;
        for (a aVar3 : hashMap.values()) {
            if (!a.a(aVar3)) {
                if (aVar22 != null) {
                    if (aVar3.e < aVar22.e) {
                    }
                }
                aVar22 = aVar3;
            }
        }
        if (aVar22 != null) {
            if (c.a != null) {
                stringBuilder = new StringBuilder("PACM: alloc recycled container=");
                stringBuilder.append(aVar22.a);
                c.a("ws001", stringBuilder.toString());
            }
            a.a(aVar22, str, str2);
            return aVar22;
        }
        hashMap = hashMap.values().iterator();
        a aVar4 = null;
        while (hashMap.hasNext()) {
            aVar22 = (a) hashMap.next();
            if (aVar4 != null) {
                if (aVar22.e < aVar4.e) {
                }
            }
            aVar4 = aVar22;
        }
        if (aVar4 != null) {
            if (c.a != null) {
                stringBuilder = new StringBuilder("PACM: force alloc container=");
                stringBuilder.append(aVar4.a);
                c.c("ws001", stringBuilder.toString());
            }
            aVar4.b();
            a.a(aVar4, str, str2);
            return aVar4;
        }
        if (c.a != null) {
            StringBuilder stringBuilder2 = new StringBuilder("PACM: alloc failed: plugin=");
            stringBuilder2.append(str);
            stringBuilder2.append(" activity=");
            stringBuilder2.append(str2);
            c.c("ws001", stringBuilder2.toString());
        }
        return null;
    }

    final String a(ActivityInfo activityInfo, String str, String str2, String str3) {
        ap apVar = (ap) this.e.get(str3);
        String str4 = activityInfo.applicationInfo.packageName;
        if (c.a) {
            c.a("task-affinity", String.format("插件 %s 默认 TaskAffinity 为 %s", new Object[]{str, str4}));
            c.a("task-affinity", String.format("%s 的 TaskAffinity 为 %s", new Object[]{str2, activityInfo.taskAffinity}));
        }
        if (activityInfo.launchMode == 3) {
            synchronized (this.a) {
                activityInfo = a(apVar.b.a(activityInfo.launchMode, activityInfo.theme), str, str2);
            }
        } else if (str4.equals(activityInfo.taskAffinity)) {
            synchronized (this.a) {
                activityInfo = a(apVar.b.a(activityInfo.launchMode, activityInfo.theme), str, str2);
            }
        } else {
            synchronized (this.a) {
                activityInfo = a(apVar.a.a(activityInfo), str, str2);
            }
        }
        return activityInfo != null ? activityInfo.a : null;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.qihoo360.loader2.t.a a(java.lang.String r6) {
        /*
        r5 = this;
        r0 = 0;
        if (r6 != 0) goto L_0x0004;
    L_0x0003:
        return r0;
    L_0x0004:
        r1 = r5.a;
        monitor-enter(r1);
        r2 = r5.b;	 Catch:{ all -> 0x004e }
        r2 = r2.get(r6);	 Catch:{ all -> 0x004e }
        r2 = (com.qihoo360.loader2.t.a) r2;	 Catch:{ all -> 0x004e }
        if (r2 == 0) goto L_0x0033;
    L_0x0011:
        r3 = r2.b;	 Catch:{ all -> 0x004e }
        if (r3 == 0) goto L_0x0033;
    L_0x0015:
        r6 = com.qihoo360.replugin.b.c.a;	 Catch:{ all -> 0x004e }
        if (r6 == 0) goto L_0x002c;
    L_0x0019:
        r6 = "ws001";
        r0 = new java.lang.StringBuilder;	 Catch:{ all -> 0x004e }
        r3 = "found: ";
        r0.<init>(r3);	 Catch:{ all -> 0x004e }
        r0.append(r2);	 Catch:{ all -> 0x004e }
        r0 = r0.toString();	 Catch:{ all -> 0x004e }
        com.qihoo360.replugin.b.c.a(r6, r0);	 Catch:{ all -> 0x004e }
    L_0x002c:
        r6 = new com.qihoo360.loader2.t$a;	 Catch:{ all -> 0x004e }
        r6.<init>(r2);	 Catch:{ all -> 0x004e }
        monitor-exit(r1);	 Catch:{ all -> 0x004e }
        return r6;
    L_0x0033:
        monitor-exit(r1);	 Catch:{ all -> 0x004e }
        r1 = r5.b;
        r1 = r1.size();
        r1 = (long) r1;
        r3 = new java.lang.StringBuilder;
        r4 = "not found: c=";
        r3.<init>(r4);
        r3.append(r6);
        r6 = " pool=";
        r3.append(r6);
        r3.append(r1);
        return r0;
    L_0x004e:
        r6 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x004e }
        throw r6;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qihoo360.loader2.t.a(java.lang.String):com.qihoo360.loader2.t$a");
    }
}
