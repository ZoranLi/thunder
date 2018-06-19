package com.taobao.accs.net;

import android.content.ComponentName;
import android.content.Context;
import android.os.Build.VERSION;
import com.taobao.accs.internal.AccsJobService;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.ALog.Level;
import com.taobao.accs.utl.i;

/* compiled from: Taobao */
public abstract class g {
    protected static volatile g b;
    private static final int[] c = new int[]{270, 360, 480};
    protected Context a;
    private int d;
    private long e;
    private boolean f = false;
    private int[] g = new int[]{0, 0, 0};
    private boolean h = true;

    protected abstract void a(int i);

    protected g(Context context) {
        try {
            this.a = context;
            this.d = 0;
            this.e = System.currentTimeMillis();
            this.h = i.b();
        } catch (Context context2) {
            ALog.e("HeartbeatManager", "HeartbeatManager", context2, new Object[0]);
        }
    }

    public static g a(Context context) {
        if (b == null) {
            synchronized (g.class) {
                if (b == null) {
                    if (VERSION.SDK_INT < 21 || !b(context)) {
                        ALog.i("HeartbeatManager", "hb use alarm", new Object[0]);
                        b = new a(context);
                    } else {
                        ALog.i("HeartbeatManager", "hb use job", new Object[0]);
                        b = new q(context);
                    }
                }
            }
        }
        return b;
    }

    private static boolean b(Context context) {
        try {
            return context.getPackageManager().getServiceInfo(new ComponentName(context.getPackageName(), AccsJobService.class.getName()), 0).isEnabled();
        } catch (Context context2) {
            ALog.e("HeartbeatManager", "isJobServiceExist", context2, new Object[0]);
            return false;
        }
    }

    public synchronized void a() {
        try {
            if (this.e < 0) {
                this.e = System.currentTimeMillis();
            }
            int b = b();
            if (ALog.isPrintLog(Level.D)) {
                StringBuilder stringBuilder = new StringBuilder("set ");
                stringBuilder.append(b);
                ALog.d("HeartbeatManager", stringBuilder.toString(), new Object[0]);
            }
            a(b);
        } catch (Throwable th) {
            ALog.e("HeartbeatManager", "set", th, new Object[0]);
        }
    }

    public int b() {
        int i = this.h ? c[this.d] : 270;
        this.h = i.b();
        return i;
    }

    public void c() {
        this.e = -1;
        if (this.f) {
            int[] iArr = this.g;
            int i = this.d;
            iArr[i] = iArr[i] + 1;
        }
        this.d = this.d > 0 ? this.d - 1 : 0;
        ALog.d("HeartbeatManager", "onNetworkTimeout", new Object[0]);
    }

    public void d() {
        this.e = -1;
        ALog.d("HeartbeatManager", "onNetworkFail", new Object[0]);
    }

    public void e() {
        ALog.d("HeartbeatManager", "onHeartbeatSucc", new Object[0]);
        if (System.currentTimeMillis() - this.e <= 7199000) {
            this.f = false;
            this.g[this.d] = 0;
        } else if (this.d < c.length - 1 && this.g[this.d] <= 2) {
            ALog.d("HeartbeatManager", "upgrade", new Object[0]);
            this.d++;
            this.f = true;
            this.e = System.currentTimeMillis();
        }
    }

    public void f() {
        this.d = 0;
        this.e = System.currentTimeMillis();
        ALog.d("HeartbeatManager", "resetLevel", new Object[0]);
    }
}
