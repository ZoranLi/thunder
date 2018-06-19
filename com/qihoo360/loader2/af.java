package com.qihoo360.loader2;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.v4.content.LocalBroadcastManager;
import android.text.TextUtils;
import com.qihoo360.i.IPluginManager;
import com.qihoo360.loader2.i.a;
import com.qihoo360.replugin.RePlugin;
import com.qihoo360.replugin.a.b;
import com.qihoo360.replugin.b.c;
import com.qihoo360.replugin.component.dummy.ForwardActivity;
import com.qihoo360.replugin.component.service.server.d;
import com.xiaomi.account.openauth.XiaomiOAuthConstants;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map.Entry;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: PluginProcessPer */
public final class af extends a {
    final d a;
    public final t b;
    o c;
    private final Context d;
    private final aj e;
    private HashMap<String, BroadcastReceiver> f = new HashMap();

    af(Context context, aj ajVar, int i, HashSet<String> hashSet) {
        this.d = context;
        this.e = ajVar;
        this.a = new d(context);
        this.b = new t();
        this.b.a(i, hashSet);
    }

    final Class<?> a(String str) {
        a a = this.b.a(str);
        if (a == null) {
            return ForwardActivity.class;
        }
        String str2 = a.c;
        String str3 = a.d;
        if (c.a) {
            StringBuilder stringBuilder = new StringBuilder("PACM: loadActivityClass in=");
            stringBuilder.append(str);
            stringBuilder.append(" target=");
            stringBuilder.append(str3);
            stringBuilder.append(" plugin=");
            stringBuilder.append(str2);
            c.a("ws001", stringBuilder.toString());
        }
        o d = this.e.d(str2);
        if (d == null) {
            StringBuilder stringBuilder2 = new StringBuilder("load fail: c=");
            stringBuilder2.append(str);
            stringBuilder2.append(" p=");
            stringBuilder2.append(str2);
            stringBuilder2.append(" t=");
            stringBuilder2.append(str3);
            return null;
        }
        ClassLoader a2 = d.a();
        if (c.a) {
            StringBuilder stringBuilder3 = new StringBuilder("PACM: loadActivityClass, plugin activity loader: in=");
            stringBuilder3.append(str);
            stringBuilder3.append(" activity=");
            stringBuilder3.append(str3);
            c.a("ws001", stringBuilder3.toString());
        }
        try {
            str = a2.loadClass(str3);
        } catch (String str4) {
            str4.getMessage();
            str4 = null;
        }
        if (c.a) {
            stringBuilder2 = new StringBuilder("PACM: loadActivityClass, plugin activity loader: c=");
            stringBuilder2.append(str4);
            stringBuilder2.append(", loader=");
            stringBuilder2.append(a2);
            c.a("ws001", stringBuilder2.toString());
        }
        return str4;
    }

    public final String a(String str, int i, String str2, Intent intent) throws RemoteException {
        RePlugin.getConfig();
        if (TextUtils.isEmpty(str) != 0) {
            if (this.c == null) {
                return null;
            }
            str = this.c.h.getName();
        }
        i = b(str, str2);
        if (c.a != null) {
            StringBuilder stringBuilder = new StringBuilder("PACM: eval plugin ");
            stringBuilder.append(str);
            stringBuilder.append(", target=");
            stringBuilder.append(str2);
            stringBuilder.append(", container=");
            stringBuilder.append(i);
            c.a("ws001", stringBuilder.toString());
        }
        return i;
    }

    public final IBinder a(String str, String str2) throws RemoteException {
        if (TextUtils.isEmpty(str)) {
            str = this.c;
        } else {
            str = this.e.d(str);
        }
        if (str == null || str.n == null || str.n.m == null || str.n.m.a == null) {
            return null;
        }
        IBinder a = str.n.m.a.a(str2);
        if (c.a) {
            StringBuilder stringBuilder = new StringBuilder("PluginImpl.query: call plugin aidl: plugin=");
            stringBuilder.append(str.h.getName());
            stringBuilder.append(" binder.name=");
            stringBuilder.append(str2);
            stringBuilder.append(" binder.object=");
            stringBuilder.append(a);
            c.a("ws001", stringBuilder.toString());
        }
        return a;
    }

    public final void a() throws RemoteException {
        if (c.a) {
            c.a("ws001", "PluginImpl.releaseBinder");
        }
        RePlugin.getConfig();
    }

    public final void a(Intent intent) throws RemoteException {
        a(intent, false);
    }

    public final void b(Intent intent) throws RemoteException {
        a(intent, true);
    }

    private void a(Intent intent, boolean z) throws RemoteException {
        if (c.a) {
            StringBuilder stringBuilder = new StringBuilder("sendIntent pr=");
            stringBuilder.append(b.a);
            stringBuilder.append(" intent=");
            stringBuilder.append(intent);
            c.a("ws001", stringBuilder.toString());
        }
        intent.setExtrasClassLoader(getClass().getClassLoader());
        if (z) {
            com.qihoo360.replugin.a.c.a(this.d, intent);
        } else {
            LocalBroadcastManager.getInstance(this.d).sendBroadcast(intent);
        }
    }

    public final com.qihoo360.replugin.component.service.server.b c() throws RemoteException {
        return this.a.a;
    }

    private String b(String str, String str2) {
        o d = this.e.d(str);
        if (d == null) {
            if (c.a != null) {
                StringBuilder stringBuilder = new StringBuilder("PACM: bindActivity: may be invalid plugin name or load plugin failed: plugin=");
                stringBuilder.append(str);
                c.c("ws001", stringBuilder.toString());
            }
            return null;
        }
        ActivityInfo activity = d.n.h.getActivity(str2);
        if (activity == null) {
            if (c.a != null) {
                stringBuilder = new StringBuilder("PACM: bindActivity: activity not found: activity=");
                stringBuilder.append(str2);
                c.a("ws001", stringBuilder.toString());
            }
            return null;
        }
        if (activity.processName == null) {
            activity.processName = activity.applicationInfo.processName;
        }
        if (activity.processName == null) {
            activity.processName = activity.packageName;
        }
        if (activity.processName.contains(":p")) {
            str = this.b.a(activity, str, str2, com.qihoo360.replugin.component.process.a.a(activity.processName));
        } else {
            str = this.b.a(activity, str, str2);
        }
        if (TextUtils.isEmpty(str)) {
            if (c.a != null) {
                c.c("ws001", "PACM: bindActivity: activity container is empty");
            }
            return null;
        }
        Class loadClass;
        if (c.a) {
            StringBuilder stringBuilder2 = new StringBuilder("PACM: bindActivity: lookup activity container: container=");
            stringBuilder2.append(str);
            c.a("ws001", stringBuilder2.toString());
        }
        try {
            loadClass = d.n.g.loadClass(str2);
        } catch (Throwable th) {
            th.getMessage();
            loadClass = null;
        }
        if (loadClass != null) {
            return str;
        }
        if (c.a != null) {
            stringBuilder = new StringBuilder("PACM: bindActivity: plugin activity class not found: c=");
            stringBuilder.append(str2);
            c.c("ws001", stringBuilder.toString());
        }
        return null;
    }

    public final void a(String str, String str2, Intent intent) {
        com.qihoo360.replugin.component.receiver.a.a(str, str2, this.f, intent);
    }

    public final java.lang.String d() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r1 = this;
        r0 = r1.c();	 Catch:{ RemoteException -> 0x000b }
        if (r0 == 0) goto L_0x000f;
    L_0x0006:
        r0 = r0.a();	 Catch:{ Throwable -> 0x000f }
        return r0;
    L_0x000b:
        r0 = move-exception;
        r0.printStackTrace();
    L_0x000f:
        r0 = 0;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qihoo360.loader2.af.d():java.lang.String");
    }

    public final String e() {
        t tVar = this.b;
        JSONArray jSONArray = new JSONArray();
        for (Entry entry : tVar.b.entrySet()) {
            String str = (String) entry.getKey();
            a aVar = (a) entry.getValue();
            if (!(TextUtils.isEmpty(aVar.c) || TextUtils.isEmpty(aVar.d))) {
                JSONObject jSONObject = new JSONObject();
                com.qihoo360.replugin.b.b.a(jSONObject, IPluginManager.KEY_PROCESS, b.a);
                com.qihoo360.replugin.b.b.a(jSONObject, "className", str);
                com.qihoo360.replugin.b.b.a(jSONObject, IPluginManager.KEY_PLUGIN, aVar.c);
                com.qihoo360.replugin.b.b.a(jSONObject, "realClassName", aVar.d);
                com.qihoo360.replugin.b.b.a(jSONObject, XiaomiOAuthConstants.EXTRA_STATE_2, a.a(aVar.b));
                com.qihoo360.replugin.b.b.a(jSONObject, "refs", Integer.valueOf(aVar.f != null ? aVar.f.size() : 0));
                jSONArray.put(jSONObject);
            }
        }
        return jSONArray.toString();
    }

    public final int b() throws RemoteException {
        int size = com.qihoo360.loader2.a.a.b != null ? com.qihoo360.loader2.a.a.b.size() : com.qihoo360.loader2.a.a.a != null ? com.qihoo360.loader2.a.a.a.size() : -1;
        if (c.a) {
            StringBuilder stringBuilder = new StringBuilder("process sumActivities = ");
            stringBuilder.append(size);
            c.a("ws000", stringBuilder.toString());
        }
        return size;
    }
}
