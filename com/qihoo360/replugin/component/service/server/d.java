package com.qihoo360.replugin.component.service.server;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.Intent.FilterComparison;
import android.os.Binder;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import com.qihoo360.i.Factory;
import com.qihoo360.i.IPluginManager;
import com.qihoo360.replugin.RePlugin;
import com.qihoo360.replugin.a.b;
import com.qihoo360.replugin.a.e;
import com.qihoo360.replugin.b.c;
import com.qihoo360.replugin.component.utils.PluginClientHelper;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Map.Entry;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: PluginServiceServer */
public final class d {
    private static final byte[] f = new byte[0];
    public final a a;
    final com.qihoo360.replugin.utils.a.a<Integer, h> b = new com.qihoo360.replugin.utils.a.a();
    final com.qihoo360.replugin.utils.a.a<IBinder, ArrayList<a>> c = new com.qihoo360.replugin.utils.a.a();
    final com.qihoo360.replugin.utils.a.a<ComponentName, i> d = new com.qihoo360.replugin.utils.a.a();
    Handler e = new e(this, Looper.getMainLooper());
    private final Context g;
    private Method h;
    private final com.qihoo360.replugin.utils.a.a<FilterComparison, i> i = new com.qihoo360.replugin.utils.a.a();

    /* compiled from: PluginServiceServer */
    class a extends com.qihoo360.replugin.component.service.server.b.a {
        final /* synthetic */ d a;

        a(d dVar) {
            this.a = dVar;
        }

        public final ComponentName a(Intent intent, Messenger messenger) throws RemoteException {
            ComponentName componentName;
            synchronized (d.f) {
                d dVar = this.a;
                intent = d.a(intent);
                ComponentName component = intent.getComponent();
                i b = dVar.b(intent);
                componentName = null;
                if (b != null) {
                    if (dVar.a(b)) {
                        b.h = true;
                        dVar.d.put(component, b);
                        if (c.a) {
                            StringBuilder stringBuilder = new StringBuilder("PSM.startService(): Start! in=");
                            stringBuilder.append(intent);
                            stringBuilder.append("; sr=");
                            stringBuilder.append(b);
                            c.b("ws001", stringBuilder.toString());
                        }
                        Message obtainMessage = dVar.e.obtainMessage(1);
                        Bundle bundle = new Bundle();
                        bundle.putParcelable("intent", intent);
                        obtainMessage.setData(bundle);
                        obtainMessage.obj = b;
                        dVar.e.sendMessage(obtainMessage);
                        componentName = component;
                    }
                }
            }
            return componentName;
        }

        public final int b(Intent intent, Messenger messenger) throws RemoteException {
            int i;
            synchronized (d.f) {
                d dVar = this.a;
                intent = d.a(intent);
                i iVar = (i) dVar.d.get(intent.getComponent());
                i = 0;
                if (iVar != null) {
                    iVar.h = false;
                    dVar.b(iVar);
                    if (c.a) {
                        StringBuilder stringBuilder = new StringBuilder("PSM.stopService(): Stop! in=");
                        stringBuilder.append(intent);
                        stringBuilder.append("; sr=");
                        stringBuilder.append(iVar);
                        c.b("ws001", stringBuilder.toString());
                    }
                    i = 1;
                }
            }
            return i;
        }

        public final int a(Intent intent, com.qihoo360.loader2.mgr.a aVar, int i, Messenger messenger) throws RemoteException {
            synchronized (d.f) {
                intent = this.a.a(intent, aVar, i, messenger);
            }
            return intent;
        }

        public final boolean a(com.qihoo360.loader2.mgr.a aVar) throws RemoteException {
            boolean z;
            synchronized (d.f) {
                d dVar = this.a;
                ArrayList arrayList = (ArrayList) dVar.c.get(aVar.asBinder());
                z = true;
                if (arrayList == null) {
                    if (c.a != null) {
                        c.b("ws001", "PSM.unbindService(): clist is null!");
                    }
                    z = false;
                } else {
                    while (arrayList.size() > 0) {
                        a aVar2 = (a) arrayList.get(0);
                        IBinder asBinder = aVar2.b.asBinder();
                        g gVar = aVar2.a;
                        i iVar = gVar.a;
                        ArrayList arrayList2 = (ArrayList) iVar.j.get(asBinder);
                        if (arrayList2 != null) {
                            arrayList2.remove(aVar2);
                            if (arrayList2.size() == 0) {
                                iVar.j.remove(asBinder);
                            }
                        }
                        gVar.d.remove(aVar2);
                        gVar.c.c.remove(aVar2);
                        arrayList2 = (ArrayList) dVar.c.get(asBinder);
                        if (arrayList2 != null) {
                            arrayList2.remove(aVar2);
                            if (arrayList2.size() == 0) {
                                dVar.c.remove(asBinder);
                            }
                        }
                        if (gVar.d.size() == 0) {
                            gVar.b.c.remove(gVar.c);
                        }
                        if (!aVar2.d) {
                            StringBuilder stringBuilder;
                            if (gVar.b.c.size() == 0 && gVar.b.e) {
                                gVar.b.e = false;
                                iVar.f.onUnbind(gVar.b.b.getIntent());
                                if (c.a) {
                                    stringBuilder = new StringBuilder("PSM.removeConnectionLocked(): boundRef is 0, call onUnbind(), sr=");
                                    stringBuilder.append(iVar);
                                    c.b("ws001", stringBuilder.toString());
                                }
                                if ((aVar2.c & 1) != 0) {
                                    dVar.b(iVar);
                                }
                            } else if (c.a) {
                                stringBuilder = new StringBuilder("PSM.removeConnectionLocked(): Not unbind, sr=");
                                stringBuilder.append(iVar);
                                c.b("ws001", stringBuilder.toString());
                            }
                        }
                        if (arrayList.size() > 0 && arrayList.get(0) == aVar2) {
                            arrayList.remove(0);
                        }
                    }
                }
            }
            return z;
        }

        public final String a() throws RemoteException {
            String a;
            synchronized (d.f) {
                a = d.a(this.a);
            }
            return a;
        }
    }

    public d(Context context) {
        this.g = context;
        this.a = new a(this);
    }

    final int a(Intent intent, com.qihoo360.loader2.mgr.a aVar, int i, Messenger messenger) {
        intent = a(intent);
        ComponentName component = intent.getComponent();
        int callingPid = Binder.getCallingPid();
        h hVar = (h) this.b.get(Integer.valueOf(callingPid));
        if (hVar == null) {
            hVar = new h(callingPid, messenger);
            this.b.put(Integer.valueOf(callingPid), hVar);
        }
        i b = b(intent);
        if (b == null || !a(b)) {
            return 0;
        }
        FilterComparison filterComparison = new FilterComparison(intent);
        c cVar = (c) b.i.get(filterComparison);
        if (cVar == null) {
            cVar = new c(b, filterComparison);
            b.i.put(filterComparison, cVar);
        }
        g gVar = (g) cVar.c.get(hVar);
        if (gVar == null) {
            gVar = new g(b, cVar, hVar);
            cVar.c.put(hVar, gVar);
        }
        a aVar2 = new a(gVar, aVar, i);
        IBinder asBinder = aVar.asBinder();
        ArrayList arrayList = (ArrayList) b.j.get(asBinder);
        if (arrayList == null) {
            arrayList = new ArrayList();
            b.j.put(asBinder, arrayList);
        }
        arrayList.add(aVar2);
        gVar.d.add(aVar2);
        gVar.c.c.add(aVar2);
        arrayList = (ArrayList) this.c.get(asBinder);
        if (arrayList == null) {
            arrayList = new ArrayList();
            this.c.put(asBinder, arrayList);
        }
        arrayList.add(aVar2);
        if (gVar.b.e) {
            a(aVar, component, gVar.b.d);
        } else if (gVar.b.c.size() > 0) {
            intent = b.f.onBind(intent);
            gVar.b.e = true;
            gVar.b.d = intent;
            if (intent != null) {
                a(aVar, component, intent);
            }
        }
        if (c.a != null) {
            aVar = new StringBuilder("PSM.bindService(): Bind! inb=");
            aVar.append(gVar);
            aVar.append("; fl=");
            aVar.append(i);
            aVar.append("; sr=");
            aVar.append(b);
            c.b("ws001", aVar.toString());
        }
        return 1;
    }

    static Intent a(Intent intent) {
        return new Intent(intent);
    }

    final i b(Intent intent) {
        ComponentName component = intent.getComponent();
        i iVar = (i) this.d.get(component);
        if (iVar != null) {
            return iVar;
        }
        FilterComparison filterComparison = new FilterComparison(intent);
        i iVar2 = (i) this.i.get(filterComparison);
        if (iVar2 != null) {
            return iVar2;
        }
        intent = component.getPackageName();
        component.getClassName();
        if (!RePlugin.isPluginInstalled(intent)) {
            return null;
        }
        intent = Factory.queryPluginComponentList(intent);
        if (intent == null) {
            intent = c.a;
            return null;
        }
        intent = intent.getService(component.getClassName());
        if (intent == null) {
            intent = c.a;
            return null;
        }
        i iVar3 = new i(component, filterComparison, intent);
        this.d.put(component, iVar3);
        this.i.put(filterComparison, iVar3);
        return iVar3;
    }

    final boolean a(i iVar) {
        if (iVar.f != null) {
            return true;
        }
        try {
            Boolean bool = (Boolean) e.a(new f(this, iVar), 6000);
            if (bool == null) {
                return false;
            }
            return bool.booleanValue();
        } catch (i iVar2) {
            if (c.a) {
                c.b("ws001", "pss.isinl e:", iVar2);
            }
            return false;
        }
    }

    private boolean c(com.qihoo360.replugin.component.service.server.i r9) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r8 = this;
        r0 = r9.b;
        r0 = com.qihoo360.i.Factory.queryPluginContext(r0);
        r1 = 0;
        if (r0 != 0) goto L_0x001a;
    L_0x0009:
        r0 = com.qihoo360.replugin.b.c.a;
        if (r0 == 0) goto L_0x0019;
    L_0x000d:
        r0 = new java.lang.StringBuilder;
        r2 = "installServiceLocked(): Fetch Context Error! pn=";
        r0.<init>(r2);
        r9 = r9.b;
        r0.append(r9);
    L_0x0019:
        return r1;
    L_0x001a:
        r2 = r0.getClassLoader();
        if (r2 != 0) goto L_0x002d;
    L_0x0020:
        r0 = new java.lang.StringBuilder;
        r2 = "psm.is: cl n ";
        r0.<init>(r2);
        r9 = r9.c;
        r0.append(r9);
        return r1;
    L_0x002d:
        r3 = r9.e;	 Catch:{ Throwable -> 0x00a8 }
        r3 = r3.name;	 Catch:{ Throwable -> 0x00a8 }
        r2 = r2.loadClass(r3);	 Catch:{ Throwable -> 0x00a8 }
        r2 = r2.newInstance();	 Catch:{ Throwable -> 0x00a8 }
        r2 = (android.app.Service) r2;	 Catch:{ Throwable -> 0x00a8 }
        r3 = r8.h;	 Catch:{ Throwable -> 0x00a7 }
        r4 = 1;	 Catch:{ Throwable -> 0x00a7 }
        if (r3 != 0) goto L_0x0055;	 Catch:{ Throwable -> 0x00a7 }
    L_0x0040:
        r3 = android.content.ContextWrapper.class;	 Catch:{ Throwable -> 0x00a7 }
        r5 = "attachBaseContext";	 Catch:{ Throwable -> 0x00a7 }
        r6 = new java.lang.Class[r4];	 Catch:{ Throwable -> 0x00a7 }
        r7 = android.content.Context.class;	 Catch:{ Throwable -> 0x00a7 }
        r6[r1] = r7;	 Catch:{ Throwable -> 0x00a7 }
        r3 = r3.getDeclaredMethod(r5, r6);	 Catch:{ Throwable -> 0x00a7 }
        r8.h = r3;	 Catch:{ Throwable -> 0x00a7 }
        r3 = r8.h;	 Catch:{ Throwable -> 0x00a7 }
        r3.setAccessible(r4);	 Catch:{ Throwable -> 0x00a7 }
    L_0x0055:
        r3 = r8.h;	 Catch:{ Throwable -> 0x00a7 }
        r5 = new java.lang.Object[r4];	 Catch:{ Throwable -> 0x00a7 }
        r5[r1] = r0;	 Catch:{ Throwable -> 0x00a7 }
        r3.invoke(r2, r5);	 Catch:{ Throwable -> 0x00a7 }
        r3 = android.app.Service.class;	 Catch:{ Throwable -> 0x00a7 }
        r5 = "mApplication";	 Catch:{ Throwable -> 0x00a7 }
        r3 = r3.getDeclaredField(r5);	 Catch:{ Throwable -> 0x00a7 }
        if (r3 == 0) goto L_0x0072;	 Catch:{ Throwable -> 0x00a7 }
    L_0x0068:
        r3.setAccessible(r4);	 Catch:{ Throwable -> 0x00a7 }
        r0 = r0.getApplicationContext();	 Catch:{ Throwable -> 0x00a7 }
        r3.set(r2, r0);	 Catch:{ Throwable -> 0x00a7 }
    L_0x0072:
        r2.onCreate();
        r9.f = r2;
        r0 = r8.b();
        r9.g = r0;
        r9 = com.qihoo360.replugin.b.c.a;
        if (r9 == 0) goto L_0x0094;
    L_0x0081:
        r9 = "PluginServiceServer";
        r1 = new java.lang.StringBuilder;
        r2 = "startPitService: Start ";
        r1.<init>(r2);
        r1.append(r0);
        r1 = r1.toString();
        com.qihoo360.replugin.b.c.a(r9, r1);
    L_0x0094:
        r9 = new android.content.Intent;
        r9.<init>();
        r9.setComponent(r0);
        r0 = r8.g;	 Catch:{ Exception -> 0x00a2 }
        r0.startService(r9);	 Catch:{ Exception -> 0x00a2 }
        goto L_0x00a6;
    L_0x00a2:
        r9 = move-exception;
        r9.printStackTrace();
    L_0x00a6:
        return r4;
    L_0x00a7:
        return r1;
    L_0x00a8:
        r0 = new java.lang.StringBuilder;
        r2 = "isl: ni f ";
        r0.<init>(r2);
        r9 = r9.b;
        r0.append(r9);
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qihoo360.replugin.component.service.server.d.c(com.qihoo360.replugin.component.service.server.i):boolean");
    }

    private static void a(com.qihoo360.loader2.mgr.a aVar, ComponentName componentName, IBinder iBinder) {
        try {
            aVar.a(componentName, iBinder);
        } catch (com.qihoo360.loader2.mgr.a aVar2) {
            if (com.qihoo360.mobilesafe.a.a.a != null) {
                aVar2.printStackTrace();
            }
        }
    }

    final void b(i iVar) {
        StringBuilder stringBuilder;
        if (iVar.h) {
            if (c.a) {
                stringBuilder = new StringBuilder("PSM.recycleServiceIfNeededLocked(): Not Recycle because startRequested is true! sr=");
                stringBuilder.append(iVar);
                c.b("ws001", stringBuilder.toString());
            }
        } else if (iVar.a()) {
            if (c.a) {
                stringBuilder = new StringBuilder("PSM.recycleServiceIfNeededLocked(): Not Recycle because bindingCount > 0! sr=");
                stringBuilder.append(iVar);
                c.b("ws001", stringBuilder.toString());
            }
        } else {
            d(iVar);
        }
    }

    private void d(i iVar) {
        if (c.a) {
            c.b("ws001", "PSM.recycleServiceLocked(): Recycle Now!");
        }
        for (int size = iVar.j.size() - 1; size >= 0; size--) {
            ArrayList arrayList = (ArrayList) iVar.j.b(size);
            for (int i = 0; i < arrayList.size(); i++) {
                a aVar = (a) arrayList.get(i);
                aVar.d = true;
                a(aVar.b, iVar.a, null);
            }
        }
        this.d.remove(iVar.a);
        this.i.remove(iVar.d);
        if (iVar.i.size() > 0) {
            iVar.i.clear();
        }
        iVar.f.onDestroy();
        ComponentName b = b();
        iVar.g = b;
        if (c.a != null) {
            StringBuilder stringBuilder = new StringBuilder("stopPitService: Stop ");
            stringBuilder.append(b);
            c.a("PluginServiceServer", stringBuilder.toString());
        }
        iVar = new Intent();
        iVar.setComponent(b);
        try {
            this.g.stopService(iVar);
        } catch (i iVar2) {
            iVar2.printStackTrace();
        }
    }

    private ComponentName b() {
        return PluginPitService.a(this.g, PluginClientHelper.a(b.a).intValue());
    }

    static /* synthetic */ String a(d dVar) {
        if (dVar.d != null) {
            if (!dVar.d.isEmpty()) {
                JSONArray jSONArray = new JSONArray();
                for (Entry entry : dVar.d.entrySet()) {
                    ComponentName componentName = (ComponentName) entry.getKey();
                    i iVar = (i) entry.getValue();
                    JSONObject jSONObject = new JSONObject();
                    com.qihoo360.replugin.b.b.a(jSONObject, "className", componentName.getClassName());
                    com.qihoo360.replugin.b.b.a(jSONObject, IPluginManager.KEY_PROCESS, iVar.e.processName);
                    com.qihoo360.replugin.b.b.a(jSONObject, IPluginManager.KEY_PLUGIN, iVar.b);
                    com.qihoo360.replugin.b.b.a(jSONObject, "pitClassName", iVar.g.getClassName());
                    jSONArray.put(jSONObject);
                }
                return jSONArray.toString();
            }
        }
        return null;
    }
}
