package com.qihoo360.loader2;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.os.Binder;
import android.os.IBinder;
import android.os.IBinder.DeathRecipient;
import android.os.RemoteException;
import android.support.v4.content.LocalBroadcastManager;
import android.text.TextUtils;
import com.qihoo360.replugin.RePlugin;
import com.qihoo360.replugin.RePluginEventCallbacks.InstallResult;
import com.qihoo360.replugin.a.b;
import com.qihoo360.replugin.b.c;
import com.qihoo360.replugin.component.ComponentList;
import com.qihoo360.replugin.component.receiver.PluginReceiverProxy;
import com.qihoo360.replugin.component.service.server.d;
import com.qihoo360.replugin.g;
import com.qihoo360.replugin.model.PluginInfo;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/* compiled from: PmHostSvc */
final class an extends com.qihoo360.loader2.j.a {
    private static final int i = com.qihoo360.replugin.b.a.k;
    private static Map<String, Integer> j = new HashMap();
    Context a;
    aj b;
    d c;
    com.qihoo360.replugin.packages.d d;
    PluginReceiverProxy e;
    private boolean f;
    private HashMap<String, BroadcastReceiver> g = new HashMap();
    private final HashMap<String, HashMap<String, List<String>>> h = new HashMap();

    /* compiled from: PmHostSvc */
    private static final class a implements DeathRecipient {
        String a;
        IBinder b;

        a(String str, IBinder iBinder) {
            this.a = str;
            this.b = iBinder;
        }

        public final void binderDied() {
            if (c.a) {
                StringBuilder stringBuilder = new StringBuilder("binder died: n=");
                stringBuilder.append(this.a);
                stringBuilder.append(" b=");
                stringBuilder.append(this.b);
                c.a("ws001", stringBuilder.toString());
            }
            synchronized (ac.a) {
                ac.a.remove(this.a);
            }
        }
    }

    an(Context context, aj ajVar) {
        this.a = context;
        this.b = ajVar;
        this.c = new d(context);
        this.d = new com.qihoo360.replugin.packages.d(context);
    }

    public final void a(String str, IBinder iBinder) throws RemoteException {
        if (c.a) {
            StringBuilder stringBuilder = new StringBuilder("install binder: n=");
            stringBuilder.append(str);
            stringBuilder.append(" b=");
            stringBuilder.append(iBinder);
            c.a("ws001", stringBuilder.toString());
        }
        synchronized (ac.a) {
            if (iBinder != null) {
                ac.a.put(str, iBinder);
                iBinder.linkToDeath(new a(str, iBinder), null);
            } else {
                ac.a.remove(str);
            }
        }
    }

    public final IBinder a(String str) throws RemoteException {
        IBinder iBinder;
        synchronized (ac.a) {
            iBinder = (IBinder) ac.a.get(str);
        }
        if (c.a) {
            StringBuilder stringBuilder = new StringBuilder("fetch binder: n=");
            stringBuilder.append(str);
            stringBuilder.append(str);
            stringBuilder.append(" b=");
            stringBuilder.append(iBinder);
            c.a("ws001", stringBuilder.toString());
        }
        return iBinder;
    }

    public final long a() throws RemoteException {
        return ac.d();
    }

    public final i a(String str, int i, PluginBinderInfo pluginBinderInfo) throws RemoteException {
        synchronized (this) {
            str = this.b.a(str, i, pluginBinderInfo);
        }
        return str;
    }

    public final String a(String str, int i, IBinder iBinder, String str2) throws RemoteException {
        i a;
        int callingPid = Binder.getCallingPid();
        try {
            a = com.qihoo360.loader2.i.a.a(iBinder);
        } catch (Throwable th) {
            new StringBuilder("a.p.p pc.s.ai: ").append(th.getMessage());
            a = null;
        }
        if (a == null) {
            return null;
        }
        return ac.a(callingPid, str, i, iBinder, a, str2, this.d);
    }

    public final List<PluginInfo> b() throws RemoteException {
        return ai.a();
    }

    public final void a(int i, String str, String str2, String str3) throws RemoteException {
        ac.a(Binder.getCallingPid(), i, str, str3, str2);
    }

    public final void b(int i, String str, String str2, String str3) throws RemoteException {
        ac.b(Binder.getCallingPid(), i, str, str3, str2);
    }

    public final void a(int i, String str, String str2) throws RemoteException {
        ac.a(Binder.getCallingPid(), i, str, str2);
    }

    public final void b(int i, String str, String str2) throws RemoteException {
        ac.b(Binder.getCallingPid(), i, str, str2);
    }

    public final void a(PluginBinderInfo pluginBinderInfo, IBinder iBinder) throws RemoteException {
        ac.a(pluginBinderInfo.b, iBinder);
    }

    public final void b(PluginBinderInfo pluginBinderInfo, IBinder iBinder) throws RemoteException {
        ac.b(pluginBinderInfo.b, iBinder);
        pluginBinderInfo = ac.a(pluginBinderInfo.b, pluginBinderInfo);
        if (pluginBinderInfo == null) {
            if (c.a != null) {
                c.a("ws001", "unregPluginBinder ... client is null");
            }
            return;
        }
        pluginBinderInfo.a();
    }

    public final void a(String str, Map map) throws RemoteException {
        PluginInfo a = m.a(str, false);
        if (a != null) {
            if (a.getFrameworkVersion() >= 4) {
                if (map != null) {
                    for (Entry entry : ((HashMap) map).entrySet()) {
                        if (this.e == null) {
                            this.e = new PluginReceiverProxy();
                            this.e.a = this.h;
                        }
                        String str2 = (String) entry.getKey();
                        List<IntentFilter> list = (List) entry.getValue();
                        if (list != null) {
                            for (IntentFilter intentFilter : list) {
                                for (int countActions = intentFilter.countActions(); countActions > 0; countActions--) {
                                    String action = intentFilter.getAction(countActions - 1);
                                    HashMap hashMap = (HashMap) this.h.get(action);
                                    if (hashMap == null) {
                                        hashMap = new HashMap();
                                        this.h.put(action, hashMap);
                                    }
                                    List list2 = (List) hashMap.get(str);
                                    if (list2 == null) {
                                        list2 = new ArrayList();
                                        hashMap.put(str, list2);
                                    }
                                    if (!list2.contains(str2)) {
                                        list2.add(str2);
                                        if (c.a) {
                                            c.a("ms-receiver", String.format("保存 Receiver (%s, %s, %s)", new Object[]{action, str, str2}));
                                        }
                                    }
                                }
                                this.a.registerReceiver(this.e, intentFilter);
                            }
                        }
                    }
                }
            }
        }
    }

    public final void c() throws RemoteException {
        try {
            this.a.unregisterReceiver(this.e);
        } catch (Throwable th) {
            if (c.a) {
                StringBuilder stringBuilder = new StringBuilder("unregProxyReceiver failed, ");
                stringBuilder.append(th.toString());
                c.a("ms-receiver", stringBuilder.toString());
            }
        }
    }

    public final void a(String str, String str2, Intent intent) {
        com.qihoo360.replugin.component.receiver.a.a(str, str2, this.g, intent);
    }

    public final int a(int i) throws RemoteException {
        return ac.a(i);
    }

    public final void a(PluginInfo pluginInfo) throws RemoteException {
        o c = this.b.c(pluginInfo.getName());
        if (c != null) {
            boolean z = false;
            if (c.h.canReplaceForPn(pluginInfo)) {
                c.h = pluginInfo;
                z = true;
            }
            if (c.a) {
                StringBuilder stringBuilder = new StringBuilder("replace plugin info: info=");
                stringBuilder.append(pluginInfo);
                stringBuilder.append(" rc=");
                stringBuilder.append(z);
                c.a("ws001", stringBuilder.toString());
            }
        }
        ai.b(pluginInfo);
    }

    public final PluginInfo b(String str) throws RemoteException {
        PluginInfo parentInfo;
        if (c.a) {
            StringBuilder stringBuilder = new StringBuilder("pluginDownloaded： path=");
            stringBuilder.append(str);
            c.a("ws001", stringBuilder.toString());
        }
        String name = new File(str).getName();
        if (!(name.startsWith("p-n-") || name.startsWith("v-plugin-") || name.startsWith("plugin-s-"))) {
            if (!name.startsWith("p-m-")) {
                str = this.d.c.a(str);
                if (str != null) {
                    parentInfo = str.getParentInfo();
                    if (parentInfo == null) {
                        parentInfo = str;
                    }
                    this.b.a(parentInfo, false);
                    Intent intent = new Intent("ACTION_NEW_PLUGIN");
                    intent.putExtra("persist_need_restart", this.f);
                    intent.putExtra("obj", parentInfo);
                    b.b(intent);
                    if (c.a) {
                        StringBuilder stringBuilder2 = new StringBuilder("syncInstalledPluginInfo2All: Sync complete! syncPi=");
                        stringBuilder2.append(parentInfo);
                        c.a("task-affinity", stringBuilder2.toString());
                    }
                }
                return str;
            }
        }
        File file = new File(str);
        ar a = ar.a(file, 1);
        if (a == null) {
            a = ar.a(file, 3);
            if (a == null) {
                if (c.a) {
                    stringBuilder = new StringBuilder("pluginDownloaded: unknown v5 plugin file: ");
                    stringBuilder.append(str);
                    c.a("ws001", stringBuilder.toString());
                }
                RePlugin.getConfig();
                str = InstallResult.V5_FILE_BUILD_FAIL;
                str = null;
                if (str != null) {
                    parentInfo = str.getParentInfo();
                    if (parentInfo == null) {
                        parentInfo = str;
                    }
                    this.b.a(parentInfo, false);
                    Intent intent2 = new Intent("ACTION_NEW_PLUGIN");
                    intent2.putExtra("persist_need_restart", this.f);
                    intent2.putExtra("obj", parentInfo);
                    b.b(intent2);
                    if (c.a) {
                        StringBuilder stringBuilder22 = new StringBuilder("syncInstalledPluginInfo2All: Sync complete! syncPi=");
                        stringBuilder22.append(parentInfo);
                        c.a("task-affinity", stringBuilder22.toString());
                    }
                }
                return str;
            }
        }
        parentInfo = a.a(this.a, this.a.getDir("plugins_v3", 0), false);
        if (parentInfo == null) {
            if (c.a) {
                stringBuilder = new StringBuilder("pluginDownloaded: failed to update v5 plugin: ");
                stringBuilder.append(str);
                c.a("ws001", stringBuilder.toString());
            }
            RePlugin.getConfig();
            str = InstallResult.V5_FILE_UPDATE_FAIL;
            str = null;
            if (str != null) {
                parentInfo = str.getParentInfo();
                if (parentInfo == null) {
                    parentInfo = str;
                }
                this.b.a(parentInfo, false);
                Intent intent22 = new Intent("ACTION_NEW_PLUGIN");
                intent22.putExtra("persist_need_restart", this.f);
                intent22.putExtra("obj", parentInfo);
                b.b(intent22);
                if (c.a) {
                    StringBuilder stringBuilder222 = new StringBuilder("syncInstalledPluginInfo2All: Sync complete! syncPi=");
                    stringBuilder222.append(parentInfo);
                    c.a("task-affinity", stringBuilder222.toString());
                }
            }
            return str;
        }
        str = parentInfo;
        if (str != null) {
            parentInfo = str.getParentInfo();
            if (parentInfo == null) {
                parentInfo = str;
            }
            this.b.a(parentInfo, false);
            Intent intent222 = new Intent("ACTION_NEW_PLUGIN");
            intent222.putExtra("persist_need_restart", this.f);
            intent222.putExtra("obj", parentInfo);
            b.b(intent222);
            if (c.a) {
                StringBuilder stringBuilder2222 = new StringBuilder("syncInstalledPluginInfo2All: Sync complete! syncPi=");
                stringBuilder2222.append(parentInfo);
                c.a("task-affinity", stringBuilder2222.toString());
            }
        }
        return str;
    }

    public final boolean b(PluginInfo pluginInfo) throws RemoteException {
        if (c.a) {
            StringBuilder stringBuilder = new StringBuilder("pluginUninstalled： pn=");
            stringBuilder.append(pluginInfo.getName());
            c.a("ws001", stringBuilder.toString());
        }
        boolean a = this.d.c.a(pluginInfo);
        if (a) {
            this.b.a(pluginInfo);
            Intent intent = new Intent("ACTION_UNINSTALL_PLUGIN");
            intent.putExtra("obj", pluginInfo);
            if (g.a().getApplicationContext() != null) {
                g.a();
                b.b(intent);
            } else {
                com.qihoo360.mobilesafe.api.b.a(new ao(this, intent));
            }
        }
        return a;
    }

    public final boolean c(String str) throws RemoteException {
        if (c.a) {
            StringBuilder stringBuilder = new StringBuilder("pluginExtracted： path=");
            stringBuilder.append(str);
            c.a("ws001", stringBuilder.toString());
        }
        PluginInfo build = PluginInfo.build(new File(str));
        if (build == null) {
            return false;
        }
        this.b.a(build, false);
        Intent intent = new Intent("ACTION_NEW_PLUGIN");
        intent.putExtra("persist_need_restart", this.f);
        intent.putExtra("obj", build);
        b.b(intent);
        return true;
    }

    public final void a(String str, Intent intent) throws RemoteException {
        a(str, intent, false);
    }

    public final void c(String str, Intent intent) throws RemoteException {
        a(str, intent, true);
    }

    private void a(String str, Intent intent, boolean z) throws RemoteException {
        if (c.a) {
            StringBuilder stringBuilder = new StringBuilder("sendIntent2Process target=");
            stringBuilder.append(str);
            stringBuilder.append(" intent=");
            stringBuilder.append(intent);
            c.a("ws001", stringBuilder.toString());
        }
        if (TextUtils.equals(str, b.d)) {
            intent.setExtrasClassLoader(getClass().getClassLoader());
            if (z) {
                com.qihoo360.replugin.a.c.a(this.a, intent);
                return;
            } else {
                LocalBroadcastManager.getInstance(this.a).sendBroadcast(intent);
                return;
            }
        }
        if (TextUtils.isEmpty(str)) {
            intent.setExtrasClassLoader(getClass().getClassLoader());
            if (z) {
                com.qihoo360.replugin.a.c.a(this.a, intent);
            } else {
                LocalBroadcastManager.getInstance(this.a).sendBroadcast(intent);
            }
        }
        ac.a(str, intent, z);
    }

    public final void b(String str, Intent intent) throws RemoteException {
        b(str, intent, false);
    }

    public final void d(String str, Intent intent) throws RemoteException {
        b(str, intent, true);
    }

    private static void b(String str, Intent intent, boolean z) throws RemoteException {
        if (c.a) {
            StringBuilder stringBuilder = new StringBuilder("sendIntent2Plugin target=");
            stringBuilder.append(str);
            stringBuilder.append(" intent=");
            stringBuilder.append(intent);
            c.a("ws001", stringBuilder.toString());
        }
        if (!TextUtils.equals(str, "ui")) {
            ac.b(str, intent, z);
        }
        ac.b("ui", intent, z);
    }

    public final boolean d(String str) throws RemoteException {
        return ac.a(str);
    }

    public final IBinder a(String str, String str2) throws RemoteException {
        return this.b.n.a(str, str2);
    }

    public final com.qihoo360.replugin.component.service.server.b d() throws RemoteException {
        return this.c.a;
    }

    public final List<ActivityInfo> a(Intent intent) {
        List<ActivityInfo> arrayList = new ArrayList();
        if (intent == null) {
            return arrayList;
        }
        intent = intent.getAction();
        if (TextUtils.isEmpty(intent)) {
            return arrayList;
        }
        Map map = (Map) this.h.get(intent);
        if (map.isEmpty()) {
            return arrayList;
        }
        for (Entry key : map.entrySet()) {
            ComponentList b = this.b.n.b((String) key.getKey());
            if (b != null) {
                Map receiverMap = b.getReceiverMap();
                if (receiverMap != null) {
                    arrayList.addAll(receiverMap.values());
                }
            }
        }
        return arrayList;
    }

    public final com.qihoo360.replugin.packages.a e() throws RemoteException {
        return this.d.c;
    }

    public final int e(String str) {
        int intValue;
        if (j.containsKey(str)) {
            intValue = ((Integer) j.get(str)).intValue();
        } else {
            intValue = 0;
            while (intValue < i) {
                if (!j.containsValue(Integer.valueOf(intValue))) {
                    break;
                }
                intValue++;
            }
            intValue = -1;
            if (intValue == -1) {
                if (c.a != null) {
                    c.a("task-affinity", "Get groupID fail, not enough TaskAffinity group");
                }
                return -1;
            }
            j.put(str, Integer.valueOf(intValue));
        }
        return intValue;
    }

    public final int f(String str) throws RemoteException {
        return ac.b(str);
    }

    public final String b(int i) throws RemoteException {
        return ac.b(i);
    }

    public final String f() {
        return ac.a();
    }
}
