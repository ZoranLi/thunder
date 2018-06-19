package com.igexin.sdk;

import android.app.Activity;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.Message;
import android.os.Process;
import android.text.TextUtils;
import com.igexin.b.a.c.a;
import com.igexin.push.config.m;
import com.igexin.push.config.n;
import com.igexin.push.core.f;
import com.igexin.push.core.g;
import com.igexin.push.util.EncryptUtils;
import com.igexin.push.util.b;
import com.igexin.push.util.e;
import com.igexin.push.util.p;
import com.igexin.sdk.a.d;
import java.util.concurrent.atomic.AtomicBoolean;

public class GTServiceManager {
    public static final String TAG = "com.igexin.sdk.GTServiceManager";
    public static Context context;
    private IPushCore a;
    private final AtomicBoolean b;

    private GTServiceManager() {
        this.b = new AtomicBoolean(false);
    }

    private int a(Service service) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(TAG);
        stringBuilder.append("|start by system ####");
        a.b(stringBuilder.toString());
        if (a((Context) service, false)) {
            stringBuilder = new StringBuilder();
            stringBuilder.append(TAG);
            stringBuilder.append("|intent = null");
            a.b(stringBuilder.toString());
            if (!this.b.getAndSet(true)) {
                a(service, null);
            }
            return 1;
        }
        stringBuilder = new StringBuilder();
        stringBuilder.append(TAG);
        stringBuilder.append("|start by system, needLook = ");
        stringBuilder.append(m.w);
        stringBuilder.append(", firstInit = true or (ss = 1 switchOn = false), stop");
        a.b(stringBuilder.toString());
        service.stopSelf();
        return 2;
    }

    private int a(Service service, Intent intent, int i, int i2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(TAG);
        stringBuilder.append("|start from initialize...");
        a.b(stringBuilder.toString());
        a(service, intent);
        return this.a != null ? this.a.onServiceStartCommand(intent, i, i2) : 1;
    }

    private int a(Intent intent, int i, int i2) {
        if (this.a == null) {
            return 1;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(TAG);
        stringBuilder.append("|inInit = true, call onServiceStartCommand...");
        a.b(stringBuilder.toString());
        return this.a.onServiceStartCommand(intent, i, i2);
    }

    private java.lang.reflect.Method a(java.lang.String r2, java.lang.Class<?>... r3) {
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
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r1 = this;
        r0 = "com.igexin.dms.DMSManager";	 Catch:{ Exception -> 0x000d }
        r0 = java.lang.Class.forName(r0);	 Catch:{ Exception -> 0x000d }
        if (r0 == 0) goto L_0x0023;	 Catch:{ Exception -> 0x000d }
    L_0x0008:
        r2 = r0.getMethod(r2, r3);	 Catch:{ Exception -> 0x000d }
        return r2;
    L_0x000d:
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r3 = TAG;
        r2.append(r3);
        r3 = "invokeMethod error";
        r2.append(r3);
        r2 = r2.toString();
        com.igexin.b.a.c.a.b(r2);
    L_0x0023:
        r2 = 0;
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.sdk.GTServiceManager.a(java.lang.String, java.lang.Class[]):java.lang.reflect.Method");
    }

    private void a(Service service, Intent intent) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(TAG);
        stringBuilder.append("|startPushCore ++++");
        a.b(stringBuilder.toString());
        if (EncryptUtils.isLoadSuccess()) {
            com.igexin.sdk.a.a.a().a((Context) service);
            this.a = com.igexin.sdk.a.a.a().b();
            if (this.a != null) {
                this.a.start(service);
            }
            try {
                Object invoke = a("getInstance", new Class[0]).invoke(null, new Object[0]);
                if (invoke != null) {
                    a("start", Context.class, String.class).invoke(invoke, new Object[]{service, e.b()});
                }
                return;
            } catch (Throwable th) {
                stringBuilder = new StringBuilder();
                stringBuilder.append(TAG);
                stringBuilder.append("|");
                stringBuilder.append(th.toString());
                a.b(stringBuilder.toString());
                return;
            }
        }
        b.a(new a(this, service), service);
    }

    private void a(Intent intent) {
        try {
            if (!TextUtils.isEmpty(intent.getStringExtra("from"))) {
                Message obtain = Message.obtain();
                obtain.what = com.igexin.push.core.a.j;
                obtain.obj = intent;
                f.a().a(obtain);
            }
        } catch (Throwable th) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(TAG);
            stringBuilder.append("|");
            stringBuilder.append(th.toString());
            a.b(stringBuilder.toString());
        }
    }

    private boolean a(Context context, boolean z) {
        if (e.a(context)) {
            return false;
        }
        if (z) {
            n.b(context);
            if (!m.w) {
                return false;
            }
        }
        n.a(context);
        return !"1".equals(g.b().get("ss")) || new d(context).c();
    }

    private int b(Service service, Intent intent, int i, int i2) {
        if (a((Context) service, true)) {
            a(intent);
            a(service, intent);
            if (this.a != null) {
                return this.a.onServiceStartCommand(intent, i, i2);
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(TAG);
        stringBuilder.append("|start by guard, needLook = ");
        stringBuilder.append(m.w);
        stringBuilder.append(", firstInit = true or (ss = 1 switchOn = false), stop");
        a.b(stringBuilder.toString());
        service.stopSelf();
        return 2;
    }

    public static GTServiceManager getInstance() {
        return b.a;
    }

    public String getUserActivtiy(Context context) {
        return (String) p.b(context, "ua", "");
    }

    public Class getUserIntentService(Context context) {
        try {
            String str = (String) p.b(context, "uis", "");
            if (!TextUtils.isEmpty(str)) {
                return Class.forName(str);
            }
        } catch (Throwable th) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(TAG);
            stringBuilder.append("|");
            stringBuilder.append(th.toString());
            a.b(stringBuilder.toString());
        }
        return null;
    }

    public Class getUserPushService(Context context) {
        try {
            String str = (String) p.b(context, "us", "");
            return TextUtils.isEmpty(str) ? PushService.class : Class.forName(str);
        } catch (Throwable th) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(TAG);
            stringBuilder.append("|");
            stringBuilder.append(th.toString());
            a.b(stringBuilder.toString());
            return PushService.class;
        }
    }

    public boolean isUserPushServiceSet(Context context) {
        try {
            String str = (String) p.b(context, "us", "");
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            Class.forName(str);
            return true;
        } catch (Exception e) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(TAG);
            stringBuilder.append("|");
            stringBuilder.append(e.toString());
            a.b(stringBuilder.toString());
            return false;
        }
    }

    public void onActivityCreate(Activity activity) {
        Intent intent;
        try {
            Intent intent2 = activity.getIntent();
            intent = new Intent(activity, com.igexin.push.core.a.f.a().a((Context) activity));
            if (intent2 != null) {
                if (intent2.hasExtra("action") && intent2.hasExtra("isSlave")) {
                    intent.putExtra("action", intent2.getStringExtra("action"));
                    intent.putExtra("isSlave", intent2.getBooleanExtra("isSlave", false));
                    if (intent2.hasExtra("op_app")) {
                        intent.putExtra("op_app", intent2.getStringExtra("op_app"));
                    }
                    StringBuilder stringBuilder = new StringBuilder("Dynamic Activity action = ");
                    stringBuilder.append(intent2.getStringExtra("action"));
                    stringBuilder.append(", isSlave = ");
                    stringBuilder.append(intent2.getBooleanExtra("isSlave", false));
                    a.b(stringBuilder.toString());
                }
            }
        } catch (Exception e) {
            stringBuilder = new StringBuilder();
            stringBuilder.append(TAG);
            stringBuilder.append("|put extra exception");
            stringBuilder.append(e.toString());
            a.b(stringBuilder.toString());
        } catch (Throwable th) {
            try {
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append(TAG);
                stringBuilder2.append(th.toString());
                a.b(stringBuilder2.toString());
                return;
            } finally {
                activity.finish();
            }
        }
        activity.startService(intent);
        StringBuilder stringBuilder3 = new StringBuilder();
        stringBuilder3.append(TAG);
        stringBuilder3.append("|start PushService from Dynamic Activity");
        a.b(stringBuilder3.toString());
        activity.finish();
    }

    public IBinder onBind(Intent intent) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(TAG);
        stringBuilder.append("|onBind...");
        a.b(stringBuilder.toString());
        return this.a != null ? this.a.onServiceBind(intent) : null;
    }

    public void onCreate(Context context) {
        context = context;
    }

    public void onDestroy() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(TAG);
        stringBuilder.append("|onDestroy...");
        a.b(stringBuilder.toString());
        if (this.a != null) {
            this.a.onServiceDestroy();
        }
        Process.killProcess(Process.myPid());
    }

    public void onLowMemory() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(TAG);
        stringBuilder.append("|onLowMemory...");
        a.b(stringBuilder.toString());
    }

    public int onStartCommand(Service service, Intent intent, int i, int i2) {
        if (intent == null) {
            try {
                return a(service);
            } catch (Throwable th) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(TAG);
                stringBuilder.append("|");
                stringBuilder.append(th.toString());
                a.b(stringBuilder.toString());
                return 2;
            }
        }
        p.a(service, intent);
        String stringExtra = intent.getStringExtra("action");
        if (PushConsts.ACTION_SERVICE_INITIALIZE.equals(stringExtra)) {
            e.b((Context) service);
        }
        if (this.b.get()) {
            return a(intent, i, i2);
        }
        this.b.set(true);
        return PushConsts.ACTION_SERVICE_INITIALIZE.equals(stringExtra) ? a(service, intent, i, i2) : b(service, intent, i, i2);
    }
}
