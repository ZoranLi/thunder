package com.xunlei.tdlive.base;

import android.app.Dialog;
import android.content.DialogInterface.OnClickListener;
import android.view.View;
import com.xunlei.tdlive.util.XLog;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;

/* compiled from: BaseDialog */
public class a extends Dialog {
    private static ConcurrentLinkedQueue<WeakReference<a>> c;
    protected OnClickListener a;
    protected boolean b;
    private Runnable d;

    protected void a() {
    }

    protected void b() {
    }

    public final void show() {
        a(0);
    }

    public final void a(int i) {
        if (!this.b || c() <= 0) {
            try {
                super.show();
                if (this.d != null) {
                    getWindow().getDecorView().removeCallbacks(this.d);
                    this.d = null;
                }
                if (i > 0) {
                    View decorView = getWindow().getDecorView();
                    Runnable anonymousClass1 = new Runnable(this) {
                        final /* synthetic */ a a;

                        {
                            this.a = r1;
                        }

                        public void run() {
                            this.a.dismiss();
                        }
                    };
                    this.d = anonymousClass1;
                    decorView.postDelayed(anonymousClass1, (long) i);
                }
            } catch (int i2) {
                XLog.e("BaseDialog", i2.toString());
                i2.printStackTrace();
            }
            try {
                a();
            } catch (int i22) {
                XLog.e("BaseDialog", i22.toString());
                i22.printStackTrace();
            }
            a(this);
        }
    }

    public final void dismiss() {
        try {
            super.dismiss();
            getWindow().getDecorView().removeCallbacks(this.d);
            this.d = null;
        } catch (Throwable th) {
            XLog.e("BaseDialog", th.toString());
            th.printStackTrace();
        }
        try {
            b();
        } catch (Throwable th2) {
            XLog.e("BaseDialog", th2.toString());
            th2.printStackTrace();
        }
        b(this);
    }

    protected void onStart() {
        super.onStart();
    }

    protected void onStop() {
        super.onStop();
    }

    public static int c() {
        if (c == null) {
            return 0;
        }
        return c.size();
    }

    private static void a(a aVar) {
        if (c == null) {
            c = new ConcurrentLinkedQueue();
        }
        if (aVar != null) {
            c.add(new WeakReference(aVar));
        }
    }

    private static void b(a aVar) {
        if (c != null) {
            Iterator it = c.iterator();
            while (it.hasNext()) {
                WeakReference weakReference = (WeakReference) it.next();
                if (weakReference != null && weakReference.get() == aVar) {
                    c.remove(weakReference);
                    return;
                }
            }
        }
    }
}
