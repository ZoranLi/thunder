package com.xunlei.tdlive.base;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.SparseArray;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;
import com.xunlei.tdlive.sdk.R;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Timer;

public class BaseActivity extends BaseSwipeBackActivity {
    private static HashSet<a> m;
    private static WeakReference<BaseActivity> n;
    protected View a;
    protected View b;
    protected View c;
    protected View d;
    protected TextView e;
    protected TextView f;
    protected View g;
    protected TextView h;
    protected View i;
    protected TextView j;
    protected View k;
    protected TextView l;
    private HashSet<b> o;
    private SparseArray<Timer> p;
    private boolean q;
    private boolean r;
    private boolean s;
    private boolean t;
    private boolean u;
    private Handler v;
    private Handler w;

    public interface a {
        void a(Activity activity);

        void a(Activity activity, int i, int i2, Intent intent);

        void a(Activity activity, int i, String[] strArr, int[] iArr);

        void b(Activity activity);

        void c(Activity activity);

        void d(Activity activity);
    }

    public interface b {
        boolean a(int i, KeyEvent keyEvent);
    }

    protected void a(int i) {
    }

    public void a(boolean z) {
    }

    protected void onMessage(Message message) {
    }

    public BaseActivity() {
        this(false, false);
    }

    public BaseActivity(boolean z, boolean z2) {
        this.o = new HashSet();
        this.p = new SparseArray();
        this.r = false;
        this.s = false;
        this.t = false;
        this.u = false;
        this.v = new Handler(this) {
            final /* synthetic */ BaseActivity a;

            {
                this.a = r1;
            }

            public void handleMessage(Message message) {
                if (message.what == 6535) {
                    this.a.a(message.arg1);
                }
            }
        };
        this.w = new Handler(this) {
            final /* synthetic */ BaseActivity a;

            {
                this.a = r1;
            }

            public void handleMessage(Message message) {
                this.a.onMessage(message);
            }
        };
        this.q = z;
        this.r = z2;
    }

    public void a(b bVar) {
        this.o.add(bVar);
    }

    public void b(b bVar) {
        this.o.remove(bVar);
    }

    public void a() {
        this.s = false;
        a(this.s);
    }

    public boolean b() {
        return this.s;
    }

    public boolean isDestroyed() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r1 = this;
        r0 = super.isDestroyed();	 Catch:{ Throwable -> 0x0005 }
        return r0;
    L_0x0005:
        r0 = r1.t;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.tdlive.base.BaseActivity.isDestroyed():boolean");
    }

    protected boolean c() {
        if (this.a != null) {
            return true;
        }
        this.a = findViewById(R.id.xllive_title_bar);
        if (this.a != null) {
            this.b = this.a.findViewById(R.id.background);
            this.c = this.a.findViewById(R.id.title_bar_sep_line);
            this.d = this.a.findViewById(R.id.left);
            this.e = (TextView) this.a.findViewById(R.id.ltext);
            this.f = (TextView) this.a.findViewById(R.id.ltext2);
            this.g = this.a.findViewById(R.id.center);
            this.h = (TextView) this.a.findViewById(R.id.ctext);
            this.i = this.a.findViewById(R.id.right);
            this.j = (TextView) this.a.findViewById(R.id.rtext);
            this.k = this.a.findViewById(R.id.title_msg_bar);
            this.l = (TextView) this.k.findViewById(R.id.title_msg_text);
        }
        if (this.a != null) {
            return true;
        }
        return false;
    }

    protected boolean d() {
        if (super.d() && !this.q) {
            return true;
        }
        return false;
    }

    public void setContentView(int i) {
        super.setContentView(i);
        c();
    }

    public void setContentView(View view) {
        super.setContentView(view);
        c();
    }

    public void setContentView(View view, LayoutParams layoutParams) {
        super.setContentView(view, layoutParams);
        c();
    }

    protected void attachBaseContext(Context context) {
        super.attachBaseContext(new ContextWrapper(this, context) {
            final /* synthetic */ BaseActivity a;
            private Resources b;

            public Resources getResources() {
                if (this.b == null) {
                    this.b = super.getResources();
                    Configuration configuration = new Configuration();
                    configuration.setToDefaults();
                    if (VERSION.SDK_INT >= 24) {
                        configuration.setLocales(this.b.getConfiguration().getLocales());
                    } else {
                        configuration.locale = this.b.getConfiguration().locale;
                    }
                    this.b.updateConfiguration(configuration, this.b.getDisplayMetrics());
                }
                return this.b;
            }
        });
        com.xunlei.tdlive.util.a.a(this);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            if (m != null) {
                bundle = m.iterator();
                while (bundle.hasNext()) {
                    ((a) bundle.next()).a(this);
                }
            }
        } catch (Bundle bundle2) {
            bundle2.printStackTrace();
        }
    }

    protected void onResume() {
        super.onResume();
        c();
        this.u = false;
        try {
            n = new WeakReference(this);
            if (m != null) {
                Iterator it = m.iterator();
                while (it.hasNext()) {
                    ((a) it.next()).c(this);
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        if (!this.r) {
            com.xunlei.tdlive.sdk.a.b(getClass().getSimpleName());
        }
        com.xunlei.tdlive.sdk.a.a();
    }

    protected void onPause() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r2 = this;
        super.onPause();
        r0 = 1;
        r2.u = r0;
        r0 = r2.r;
        if (r0 != 0) goto L_0x0015;
    L_0x000a:
        r0 = r2.getClass();
        r0 = r0.getSimpleName();
        com.xunlei.tdlive.sdk.a.c(r0);
    L_0x0015:
        com.xunlei.tdlive.sdk.a.b();
        r0 = m;	 Catch:{ Throwable -> 0x0033 }
        if (r0 == 0) goto L_0x0032;	 Catch:{ Throwable -> 0x0033 }
    L_0x001c:
        r0 = m;	 Catch:{ Throwable -> 0x0033 }
        r0 = r0.iterator();	 Catch:{ Throwable -> 0x0033 }
    L_0x0022:
        r1 = r0.hasNext();	 Catch:{ Throwable -> 0x0033 }
        if (r1 == 0) goto L_0x0032;	 Catch:{ Throwable -> 0x0033 }
    L_0x0028:
        r1 = r0.next();	 Catch:{ Throwable -> 0x0033 }
        r1 = (com.xunlei.tdlive.base.BaseActivity.a) r1;	 Catch:{ Throwable -> 0x0033 }
        r1.d(r2);	 Catch:{ Throwable -> 0x0033 }
        goto L_0x0022;
    L_0x0032:
        return;
    L_0x0033:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.tdlive.base.BaseActivity.onPause():void");
    }

    public void finish() {
        super.finish();
        c.d();
    }

    protected void onDestroy() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r2 = this;
        super.onDestroy();	 Catch:{ Throwable -> 0x0003 }
    L_0x0003:
        r0 = 0;
    L_0x0004:
        r1 = r2.p;
        r1 = r1.size();
        if (r0 >= r1) goto L_0x001a;
    L_0x000c:
        r1 = r2.p;	 Catch:{ Throwable -> 0x0017 }
        r1 = r1.valueAt(r0);	 Catch:{ Throwable -> 0x0017 }
        r1 = (java.util.Timer) r1;	 Catch:{ Throwable -> 0x0017 }
        r1.cancel();	 Catch:{ Throwable -> 0x0017 }
    L_0x0017:
        r0 = r0 + 1;
        goto L_0x0004;
    L_0x001a:
        r0 = r2.w;
        r1 = 0;
        r0.removeCallbacksAndMessages(r1);
        r0 = r2.v;
        r0.removeCallbacksAndMessages(r1);
        r0 = r2.o;
        r0.clear();
        r0 = r2.p;
        r0.clear();
        r0 = 1;
        r2.t = r0;
        r0 = m;	 Catch:{ Throwable -> 0x004d }
        if (r0 == 0) goto L_0x004c;	 Catch:{ Throwable -> 0x004d }
    L_0x0036:
        r0 = m;	 Catch:{ Throwable -> 0x004d }
        r0 = r0.iterator();	 Catch:{ Throwable -> 0x004d }
    L_0x003c:
        r1 = r0.hasNext();	 Catch:{ Throwable -> 0x004d }
        if (r1 == 0) goto L_0x004c;	 Catch:{ Throwable -> 0x004d }
    L_0x0042:
        r1 = r0.next();	 Catch:{ Throwable -> 0x004d }
        r1 = (com.xunlei.tdlive.base.BaseActivity.a) r1;	 Catch:{ Throwable -> 0x004d }
        r1.b(r2);	 Catch:{ Throwable -> 0x004d }
        goto L_0x003c;
    L_0x004c:
        return;
    L_0x004d:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.tdlive.base.BaseActivity.onDestroy():void");
    }

    public void onRequestPermissionsResult(int r3, java.lang.String[] r4, int[] r5) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r2 = this;
        super.onRequestPermissionsResult(r3, r4, r5);
        r0 = m;	 Catch:{ Throwable -> 0x001e }
        if (r0 == 0) goto L_0x001d;	 Catch:{ Throwable -> 0x001e }
    L_0x0007:
        r0 = m;	 Catch:{ Throwable -> 0x001e }
        r0 = r0.iterator();	 Catch:{ Throwable -> 0x001e }
    L_0x000d:
        r1 = r0.hasNext();	 Catch:{ Throwable -> 0x001e }
        if (r1 == 0) goto L_0x001d;	 Catch:{ Throwable -> 0x001e }
    L_0x0013:
        r1 = r0.next();	 Catch:{ Throwable -> 0x001e }
        r1 = (com.xunlei.tdlive.base.BaseActivity.a) r1;	 Catch:{ Throwable -> 0x001e }
        r1.a(r2, r3, r4, r5);	 Catch:{ Throwable -> 0x001e }
        goto L_0x000d;
    L_0x001d:
        return;
    L_0x001e:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.tdlive.base.BaseActivity.onRequestPermissionsResult(int, java.lang.String[], int[]):void");
    }

    protected void onActivityResult(int r3, int r4, android.content.Intent r5) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r2 = this;
        super.onActivityResult(r3, r4, r5);
        r0 = m;	 Catch:{ Throwable -> 0x001e }
        if (r0 == 0) goto L_0x001d;	 Catch:{ Throwable -> 0x001e }
    L_0x0007:
        r0 = m;	 Catch:{ Throwable -> 0x001e }
        r0 = r0.iterator();	 Catch:{ Throwable -> 0x001e }
    L_0x000d:
        r1 = r0.hasNext();	 Catch:{ Throwable -> 0x001e }
        if (r1 == 0) goto L_0x001d;	 Catch:{ Throwable -> 0x001e }
    L_0x0013:
        r1 = r0.next();	 Catch:{ Throwable -> 0x001e }
        r1 = (com.xunlei.tdlive.base.BaseActivity.a) r1;	 Catch:{ Throwable -> 0x001e }
        r1.a(r2, r3, r4, r5);	 Catch:{ Throwable -> 0x001e }
        goto L_0x000d;
    L_0x001d:
        return;
    L_0x001e:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.tdlive.base.BaseActivity.onActivityResult(int, int, android.content.Intent):void");
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (b()) {
            a();
            return true;
        }
        Iterator it = this.o.iterator();
        while (it.hasNext()) {
            if (((b) it.next()).a(i, keyEvent)) {
                return true;
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    protected void onResumeFragments() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = this;
        super.onResumeFragments();	 Catch:{ Exception -> 0x0004 }
        return;
    L_0x0004:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.tdlive.base.BaseActivity.onResumeFragments():void");
    }
}
