package com.xunlei.tdlive.base;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.util.SparseArray;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.xunlei.tdlive.sdk.R;
import java.util.HashSet;
import java.util.Timer;
import java.util.TimerTask;

/* compiled from: BaseFragment */
public class b extends Fragment implements com.xunlei.tdlive.base.BaseActivity.b {
    private static HashSet<a> l;
    protected View a;
    protected View b;
    protected View c;
    protected View d;
    protected TextView e;
    protected View f;
    protected TextView g;
    protected View h;
    protected TextView i;
    protected View j;
    protected TextView k;
    private SparseArray<Timer> m = new SparseArray();
    private boolean n = false;
    private boolean o;
    private boolean p;
    private Handler q = new Handler(this) {
        final /* synthetic */ b a;

        {
            this.a = r1;
        }

        public void handleMessage(Message message) {
            if (message.what == 6535) {
                this.a.e(message.arg1);
            }
        }
    };
    private Handler r = new Handler(this) {
        final /* synthetic */ b a;

        {
            this.a = r1;
        }

        public void handleMessage(Message message) {
            this.a.onMessage(message);
        }
    };

    /* compiled from: BaseFragment */
    public interface a {
        void a(Fragment fragment);

        void b(Fragment fragment);

        void c(Fragment fragment);

        void d(Fragment fragment);
    }

    /* compiled from: BaseFragment */
    private class b extends TimerTask {
        final /* synthetic */ b a;
        private int b = null;

        public b(b bVar, int i) {
            this.a = bVar;
            this.b = i;
        }

        public void run() {
            this.a.q.obtainMessage(6535, this.b, this.b).sendToTarget();
        }
    }

    public void d(boolean z) {
    }

    public void e(int i) {
    }

    protected void onMessage(Message message) {
    }

    public void a() {
        this.n = false;
        d(this.n);
    }

    public boolean b() {
        return this.n;
    }

    public View a(int i) {
        return getView() != null ? getView().findViewById(i) : 0;
    }

    public final View a(Object obj) {
        return getView() != null ? getView().findViewWithTag(obj) : null;
    }

    public long a(int r7, long r8, long r10) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r6 = this;
        r6.b(r7);
        r0 = new java.util.Timer;	 Catch:{ Throwable -> 0x0033 }
        r1 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x0033 }
        r1.<init>();	 Catch:{ Throwable -> 0x0033 }
        r2 = r6.getClass();	 Catch:{ Throwable -> 0x0033 }
        r2 = r2.getSimpleName();	 Catch:{ Throwable -> 0x0033 }
        r1.append(r2);	 Catch:{ Throwable -> 0x0033 }
        r2 = "_tid_";	 Catch:{ Throwable -> 0x0033 }
        r1.append(r2);	 Catch:{ Throwable -> 0x0033 }
        r1.append(r7);	 Catch:{ Throwable -> 0x0033 }
        r1 = r1.toString();	 Catch:{ Throwable -> 0x0033 }
        r0.<init>(r1);	 Catch:{ Throwable -> 0x0033 }
        r1 = r6.m;	 Catch:{ Throwable -> 0x0033 }
        r1.put(r7, r0);	 Catch:{ Throwable -> 0x0033 }
        r1 = new com.xunlei.tdlive.base.b$b;	 Catch:{ Throwable -> 0x0033 }
        r1.<init>(r6, r7);	 Catch:{ Throwable -> 0x0033 }
        r2 = r8;	 Catch:{ Throwable -> 0x0033 }
        r4 = r10;	 Catch:{ Throwable -> 0x0033 }
        r0.schedule(r1, r2, r4);	 Catch:{ Throwable -> 0x0033 }
    L_0x0033:
        r7 = (long) r7;
        return r7;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.tdlive.base.b.a(int, long, long):long");
    }

    public void b(int r3) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r2 = this;
        r0 = r2.m;
        r0 = r0.get(r3);
        r0 = (java.util.Timer) r0;
        if (r0 == 0) goto L_0x001a;
    L_0x000a:
        r0.cancel();	 Catch:{ Throwable -> 0x000d, all -> 0x0013 }
    L_0x000d:
        r0 = r2.m;
        r0.remove(r3);
        return;
    L_0x0013:
        r0 = move-exception;
        r1 = r2.m;
        r1.remove(r3);
        throw r0;
    L_0x001a:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.tdlive.base.b.b(int):void");
    }

    public void startActivity(Intent intent) {
        getActivity().startActivity(intent);
    }

    public void a(String str, int i) {
        PreferenceManager.getDefaultSharedPreferences(getActivity().getApplicationContext()).edit().putInt(str, i).apply();
    }

    public int b(String str, int i) {
        return PreferenceManager.getDefaultSharedPreferences(getActivity().getApplicationContext()).getInt(str, i);
    }

    public void a(boolean z) {
        if (c()) {
            this.a.setVisibility(z ? false : true);
        }
    }

    public void c(int r2) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r1 = this;
        r0 = r1.c();
        if (r0 == 0) goto L_0x000c;
    L_0x0006:
        r0 = r1.b;	 Catch:{ Exception -> 0x000c }
        r0.setBackgroundResource(r2);	 Catch:{ Exception -> 0x000c }
        return;
    L_0x000c:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.tdlive.base.b.c(int):void");
    }

    public void d(int r2) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r1 = this;
        r0 = r1.c();
        if (r0 == 0) goto L_0x000c;
    L_0x0006:
        r0 = r1.c;	 Catch:{ Exception -> 0x000c }
        r0.setBackgroundColor(r2);	 Catch:{ Exception -> 0x000c }
        return;
    L_0x000c:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.tdlive.base.b.d(int):void");
    }

    public void a(OnClickListener onClickListener) {
        if (c()) {
            this.a.setOnClickListener(onClickListener);
        }
    }

    public void a(String str, float f, int i) {
        if (c()) {
            this.g.setText(str);
            if (f != null) {
                this.g.setTextSize(f);
            }
            if (i != -1) {
                this.g.setTextColor(i);
            }
        }
    }

    public void b(boolean z) {
        if (c()) {
            this.d.setVisibility(z ? false : true);
        }
    }

    public void a(Drawable drawable) {
        if (c()) {
            this.e.setCompoundDrawablesWithIntrinsicBounds(drawable, null, null, null);
        }
    }

    public void b(OnClickListener onClickListener) {
        if (c()) {
            this.d.setOnClickListener(onClickListener);
        }
    }

    public void c(boolean z) {
        if (c()) {
            this.h.setVisibility(z ? false : true);
        }
    }

    public void b(Drawable drawable) {
        if (c()) {
            this.i.setCompoundDrawablesWithIntrinsicBounds(drawable, null, null, null);
        }
    }

    public void c(OnClickListener onClickListener) {
        if (c()) {
            this.h.setOnClickListener(onClickListener);
        }
    }

    protected boolean c() {
        if (this.a != null) {
            return true;
        }
        this.a = a(R.id.xllive_title_bar);
        if (this.a != null) {
            this.b = this.a.findViewById(R.id.background);
            this.c = this.a.findViewById(R.id.title_bar_sep_line);
            this.d = this.a.findViewById(R.id.left);
            this.e = (TextView) this.a.findViewById(R.id.ltext);
            this.f = this.a.findViewById(R.id.center);
            this.g = (TextView) this.a.findViewById(R.id.ctext);
            this.h = this.a.findViewById(R.id.right);
            this.i = (TextView) this.a.findViewById(R.id.rtext);
            this.j = this.a.findViewById(R.id.title_msg_bar);
            this.k = (TextView) this.j.findViewById(R.id.title_msg_text);
        }
        if (this.a != null) {
            return true;
        }
        return false;
    }

    public Context getContext() {
        Context activity = getActivity();
        if (activity != null) {
            return activity;
        }
        return super.getContext();
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.o = true;
        setUserVisibleHint(getUserVisibleHint());
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        com.xunlei.tdlive.util.a.a(activity);
        if (activity instanceof BaseActivity) {
            ((BaseActivity) activity).a((com.xunlei.tdlive.base.BaseActivity.b) this);
        }
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        com.xunlei.tdlive.util.a.a(context);
        if (context instanceof BaseActivity) {
            ((BaseActivity) context).a((com.xunlei.tdlive.base.BaseActivity.b) this);
        }
    }

    public void onDetach() {
        super.onDetach();
        FragmentActivity activity = getActivity();
        if (activity instanceof BaseActivity) {
            ((BaseActivity) activity).b(this);
        }
        this.o = false;
    }

    public void onDestroyView() {
        super.onDestroyView();
        setUserVisibleHint(false);
        this.a = null;
    }

    public void onCreate(android.os.Bundle r2) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r1 = this;
        super.onCreate(r2);
        r2 = l;	 Catch:{ Throwable -> 0x001e }
        if (r2 == 0) goto L_0x001d;	 Catch:{ Throwable -> 0x001e }
    L_0x0007:
        r2 = l;	 Catch:{ Throwable -> 0x001e }
        r2 = r2.iterator();	 Catch:{ Throwable -> 0x001e }
    L_0x000d:
        r0 = r2.hasNext();	 Catch:{ Throwable -> 0x001e }
        if (r0 == 0) goto L_0x001d;	 Catch:{ Throwable -> 0x001e }
    L_0x0013:
        r0 = r2.next();	 Catch:{ Throwable -> 0x001e }
        r0 = (com.xunlei.tdlive.base.b.a) r0;	 Catch:{ Throwable -> 0x001e }
        r0.a(r1);	 Catch:{ Throwable -> 0x001e }
        goto L_0x000d;
    L_0x001d:
        return;
    L_0x001e:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.tdlive.base.b.onCreate(android.os.Bundle):void");
    }

    public void onDestroy() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r2 = this;
        super.onDestroy();
        r0 = 0;
    L_0x0004:
        r1 = r2.m;
        r1 = r1.size();
        if (r0 >= r1) goto L_0x001a;
    L_0x000c:
        r1 = r2.m;	 Catch:{ Throwable -> 0x0017 }
        r1 = r1.valueAt(r0);	 Catch:{ Throwable -> 0x0017 }
        r1 = (java.util.Timer) r1;	 Catch:{ Throwable -> 0x0017 }
        r1.cancel();	 Catch:{ Throwable -> 0x0017 }
    L_0x0017:
        r0 = r0 + 1;
        goto L_0x0004;
    L_0x001a:
        r0 = r2.m;
        r0.clear();
        r0 = r2.r;
        r1 = 0;
        r0.removeCallbacksAndMessages(r1);
        r0 = r2.q;
        r0.removeCallbacksAndMessages(r1);
        r0 = l;	 Catch:{ Throwable -> 0x0045 }
        if (r0 == 0) goto L_0x0044;	 Catch:{ Throwable -> 0x0045 }
    L_0x002e:
        r0 = l;	 Catch:{ Throwable -> 0x0045 }
        r0 = r0.iterator();	 Catch:{ Throwable -> 0x0045 }
    L_0x0034:
        r1 = r0.hasNext();	 Catch:{ Throwable -> 0x0045 }
        if (r1 == 0) goto L_0x0044;	 Catch:{ Throwable -> 0x0045 }
    L_0x003a:
        r1 = r0.next();	 Catch:{ Throwable -> 0x0045 }
        r1 = (com.xunlei.tdlive.base.b.a) r1;	 Catch:{ Throwable -> 0x0045 }
        r1.b(r2);	 Catch:{ Throwable -> 0x0045 }
        goto L_0x0034;
    L_0x0044:
        return;
    L_0x0045:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.tdlive.base.b.onDestroy():void");
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        c();
    }

    public void onResume() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r2 = this;
        super.onResume();
        r0 = 0;
        r2.p = r0;
        r0 = r2.getClass();
        r0 = r0.getSimpleName();
        com.xunlei.tdlive.sdk.a.b(r0);
        r0 = l;	 Catch:{ Throwable -> 0x002c }
        if (r0 == 0) goto L_0x002b;	 Catch:{ Throwable -> 0x002c }
    L_0x0015:
        r0 = l;	 Catch:{ Throwable -> 0x002c }
        r0 = r0.iterator();	 Catch:{ Throwable -> 0x002c }
    L_0x001b:
        r1 = r0.hasNext();	 Catch:{ Throwable -> 0x002c }
        if (r1 == 0) goto L_0x002b;	 Catch:{ Throwable -> 0x002c }
    L_0x0021:
        r1 = r0.next();	 Catch:{ Throwable -> 0x002c }
        r1 = (com.xunlei.tdlive.base.b.a) r1;	 Catch:{ Throwable -> 0x002c }
        r1.c(r2);	 Catch:{ Throwable -> 0x002c }
        goto L_0x001b;
    L_0x002b:
        return;
    L_0x002c:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.tdlive.base.b.onResume():void");
    }

    public void onPause() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r2 = this;
        super.onPause();
        r0 = 1;
        r2.p = r0;
        r0 = r2.getClass();
        r0 = r0.getSimpleName();
        com.xunlei.tdlive.sdk.a.c(r0);
        r0 = l;	 Catch:{ Throwable -> 0x002c }
        if (r0 == 0) goto L_0x002b;	 Catch:{ Throwable -> 0x002c }
    L_0x0015:
        r0 = l;	 Catch:{ Throwable -> 0x002c }
        r0 = r0.iterator();	 Catch:{ Throwable -> 0x002c }
    L_0x001b:
        r1 = r0.hasNext();	 Catch:{ Throwable -> 0x002c }
        if (r1 == 0) goto L_0x002b;	 Catch:{ Throwable -> 0x002c }
    L_0x0021:
        r1 = r0.next();	 Catch:{ Throwable -> 0x002c }
        r1 = (com.xunlei.tdlive.base.b.a) r1;	 Catch:{ Throwable -> 0x002c }
        r1.d(r2);	 Catch:{ Throwable -> 0x002c }
        goto L_0x001b;
    L_0x002b:
        return;
    L_0x002c:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.tdlive.base.b.onPause():void");
    }

    public boolean a(int i, KeyEvent keyEvent) {
        if (b() == 0) {
            return false;
        }
        a();
        return true;
    }
}
