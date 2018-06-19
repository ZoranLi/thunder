package com.ut.mini.plugin;

import android.app.Activity;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import com.alibaba.mtl.log.b;
import com.alibaba.mtl.log.e.i;
import com.ut.mini.core.appstatus.UTMCAppStatusCallbacks;
import com.ut.mini.core.appstatus.UTMCAppStatusRegHelper;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class UTPluginMgr implements UTMCAppStatusCallbacks {
    public static final String PARTNERPLUGIN_UTPREF = "com.ut.mini.perf.UTPerfPlugin";
    private static UTPluginMgr a = new UTPluginMgr();
    private HandlerThread b = null;
    private Handler mHandler = null;
    private List<UTPlugin> n = new LinkedList();
    private List<String> o = new ArrayList();
    private List<String> p = new ArrayList<String>(this) {
        final /* synthetic */ UTPluginMgr b;

        {
            this.b = r1;
            add(UTPluginMgr.PARTNERPLUGIN_UTPREF);
        }
    };
    private List<UTPlugin> q = new LinkedList();

    private static class a {
        private int K;
        private UTPlugin a;
        private Object f;

        private a() {
            this.K = 0;
            this.f = null;
            this.a = null;
        }

        public int i() {
            return this.K;
        }

        public void g(int i) {
            this.K = i;
        }

        public Object getMsgObj() {
            return this.f;
        }

        public void c(Object obj) {
            this.f = obj;
        }

        public UTPlugin a() {
            return this.a;
        }

        public void a(UTPlugin uTPlugin) {
            this.a = uTPlugin;
        }
    }

    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    public void onActivityDestroyed(Activity activity) {
    }

    public void onActivityPaused(Activity activity) {
    }

    public void onActivityResumed(Activity activity) {
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public void onActivityStarted(Activity activity) {
    }

    public void onActivityStopped(Activity activity) {
    }

    private UTPluginMgr() {
        if (VERSION.SDK_INT >= 14) {
            UTMCAppStatusRegHelper.registerAppStatusCallbacks(this);
        }
    }

    public static UTPluginMgr getInstance() {
        return a;
    }

    private void O() {
        this.b = new HandlerThread("UT-PLUGIN-ASYNC");
        this.b.start();
        this.mHandler = new Handler(this, this.b.getLooper()) {
            final /* synthetic */ UTPluginMgr b;

            public void handleMessage(Message message) {
                if (message.what == 1 && (message.obj instanceof a)) {
                    a aVar = (a) message.obj;
                    UTPlugin a = aVar.a();
                    int i = aVar.i();
                    message = aVar.getMsgObj();
                    if (a != null) {
                        try {
                            if (message instanceof UTPluginMsgDispatchDelegate) {
                                UTPluginMsgDispatchDelegate uTPluginMsgDispatchDelegate = (UTPluginMsgDispatchDelegate) message;
                                if (uTPluginMsgDispatchDelegate.isMatchPlugin(a)) {
                                    a.onPluginMsgArrivedFromSDK(i, uTPluginMsgDispatchDelegate.getDispatchObject(a));
                                }
                                return;
                            }
                            a.onPluginMsgArrivedFromSDK(i, message);
                        } catch (Message message2) {
                            message2.printStackTrace();
                        }
                    }
                }
            }
        };
    }

    public boolean isPartnerPluginExist(String str) {
        return this.o.contains(str) != null ? true : null;
    }

    private synchronized void a(int i, UTPluginContextValueDispatchDelegate uTPluginContextValueDispatchDelegate) {
        if (uTPluginContextValueDispatchDelegate != null) {
            for (UTPlugin uTPlugin : this.q) {
                uTPluginContextValueDispatchDelegate.onPluginContextValueChange(uTPlugin.getPluginContext());
                uTPlugin.onPluginContextValueUpdate(i);
            }
        }
    }

    public void updatePluginContextValue(int i) {
        if (i == 1) {
            a(i, new UTPluginContextValueDispatchDelegate(this) {
                final /* synthetic */ UTPluginMgr b;

                {
                    this.b = r1;
                }

                public void onPluginContextValueChange(UTPluginContext uTPluginContext) {
                    uTPluginContext.setDebugLogFlag(i.a());
                }
            });
        }
    }

    public void runPartnerPlugin() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r4 = this;
        r0 = r4.p;
        if (r0 == 0) goto L_0x005a;
    L_0x0004:
        r0 = r4.p;
        r0 = r0.size();
        if (r0 <= 0) goto L_0x005a;
    L_0x000c:
        r0 = r4.p;
        r0 = r0.iterator();
    L_0x0012:
        r1 = r0.hasNext();
        if (r1 == 0) goto L_0x005a;
    L_0x0018:
        r1 = r0.next();
        r1 = (java.lang.String) r1;
        r2 = android.text.TextUtils.isEmpty(r1);
        if (r2 != 0) goto L_0x0012;
    L_0x0024:
        r2 = java.lang.Class.forName(r1);	 Catch:{ ClassNotFoundException -> 0x0012, InstantiationException -> 0x0055, IllegalAccessException -> 0x0050 }
        r2 = r2.newInstance();	 Catch:{ ClassNotFoundException -> 0x0012, InstantiationException -> 0x0055, IllegalAccessException -> 0x0050 }
        r3 = r2 instanceof com.ut.mini.plugin.UTPlugin;	 Catch:{ ClassNotFoundException -> 0x0012, InstantiationException -> 0x0055, IllegalAccessException -> 0x0050 }
        if (r3 == 0) goto L_0x0012;	 Catch:{ ClassNotFoundException -> 0x0012, InstantiationException -> 0x0055, IllegalAccessException -> 0x0050 }
    L_0x0030:
        r2 = (com.ut.mini.plugin.UTPlugin) r2;	 Catch:{ ClassNotFoundException -> 0x0012, InstantiationException -> 0x0055, IllegalAccessException -> 0x0050 }
        r3 = 1;	 Catch:{ ClassNotFoundException -> 0x0012, InstantiationException -> 0x0055, IllegalAccessException -> 0x0050 }
        r4.registerPlugin(r2, r3);	 Catch:{ ClassNotFoundException -> 0x0012, InstantiationException -> 0x0055, IllegalAccessException -> 0x0050 }
        r2 = new java.lang.StringBuilder;	 Catch:{ ClassNotFoundException -> 0x0012, InstantiationException -> 0x0055, IllegalAccessException -> 0x0050 }
        r3 = "runPartnerPlugin[OK]:";	 Catch:{ ClassNotFoundException -> 0x0012, InstantiationException -> 0x0055, IllegalAccessException -> 0x0050 }
        r2.<init>(r3);	 Catch:{ ClassNotFoundException -> 0x0012, InstantiationException -> 0x0055, IllegalAccessException -> 0x0050 }
        r2.append(r1);	 Catch:{ ClassNotFoundException -> 0x0012, InstantiationException -> 0x0055, IllegalAccessException -> 0x0050 }
        r2 = r2.toString();	 Catch:{ ClassNotFoundException -> 0x0012, InstantiationException -> 0x0055, IllegalAccessException -> 0x0050 }
        r3 = 0;	 Catch:{ ClassNotFoundException -> 0x0012, InstantiationException -> 0x0055, IllegalAccessException -> 0x0050 }
        r3 = new java.lang.String[r3];	 Catch:{ ClassNotFoundException -> 0x0012, InstantiationException -> 0x0055, IllegalAccessException -> 0x0050 }
        com.alibaba.mtl.log.e.i.a(r2, r3);	 Catch:{ ClassNotFoundException -> 0x0012, InstantiationException -> 0x0055, IllegalAccessException -> 0x0050 }
        r2 = r4.o;	 Catch:{ ClassNotFoundException -> 0x0012, InstantiationException -> 0x0055, IllegalAccessException -> 0x0050 }
        r2.add(r1);	 Catch:{ ClassNotFoundException -> 0x0012, InstantiationException -> 0x0055, IllegalAccessException -> 0x0050 }
        goto L_0x0012;
    L_0x0050:
        r1 = move-exception;
        r1.printStackTrace();
        goto L_0x0012;
    L_0x0055:
        r1 = move-exception;
        r1.printStackTrace();
        goto L_0x0012;
    L_0x005a:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ut.mini.plugin.UTPluginMgr.runPartnerPlugin():void");
    }

    private UTPluginContext a() {
        UTPluginContext uTPluginContext = new UTPluginContext();
        uTPluginContext.setContext(b.a().a);
        if (i.a()) {
            uTPluginContext.setDebugLogFlag(i.a());
        }
        return uTPluginContext;
    }

    public synchronized void registerPlugin(UTPlugin uTPlugin, boolean z) {
        if (uTPlugin != null) {
            if (!this.q.contains(uTPlugin)) {
                uTPlugin.a(a());
                this.q.add(uTPlugin);
                if (!z) {
                    this.n.add(uTPlugin);
                }
                uTPlugin.onRegistered();
            }
        }
    }

    public synchronized void unregisterPlugin(UTPlugin uTPlugin) {
        if (uTPlugin != null) {
            if (this.q.contains(uTPlugin)) {
                this.q.remove(uTPlugin);
                uTPlugin.onUnRegistered();
                uTPlugin.a(null);
            }
        }
        if (this.n != null && this.n.contains(uTPlugin)) {
            this.n.remove(uTPlugin);
        }
    }

    private boolean a(int i, int[] iArr) {
        int i2 = 0;
        if (iArr == null) {
            return false;
        }
        int length = iArr.length;
        boolean z = false;
        while (i2 < length) {
            if (iArr[i2] == i) {
                z = true;
            }
            i2++;
        }
        return z;
    }

    public synchronized boolean dispatchPluginMsg(int i, Object obj) {
        boolean z;
        if (this.mHandler == null) {
            O();
        }
        z = false;
        if (this.q.size() > 0) {
            for (UTPlugin uTPlugin : this.q) {
                int[] returnRequiredMsgIds = uTPlugin.returnRequiredMsgIds();
                if (returnRequiredMsgIds != null && a(i, returnRequiredMsgIds)) {
                    if (i != 1) {
                        if (this.n == null || !this.n.contains(uTPlugin)) {
                            a aVar = new a();
                            aVar.g(i);
                            aVar.c(obj);
                            aVar.a(uTPlugin);
                            Message obtain = Message.obtain();
                            obtain.what = 1;
                            obtain.obj = aVar;
                            this.mHandler.sendMessage(obtain);
                            z = true;
                        }
                    }
                    try {
                        if (obj instanceof UTPluginMsgDispatchDelegate) {
                            UTPluginMsgDispatchDelegate uTPluginMsgDispatchDelegate = (UTPluginMsgDispatchDelegate) obj;
                            if (uTPluginMsgDispatchDelegate.isMatchPlugin(uTPlugin)) {
                                uTPlugin.onPluginMsgArrivedFromSDK(i, uTPluginMsgDispatchDelegate.getDispatchObject(uTPlugin));
                            }
                        } else {
                            uTPlugin.onPluginMsgArrivedFromSDK(i, obj);
                        }
                        z = true;
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
            }
        }
        return z;
    }

    public void onSwitchBackground() {
        dispatchPluginMsg(2, null);
    }

    public void onSwitchForeground() {
        dispatchPluginMsg(8, null);
    }
}
