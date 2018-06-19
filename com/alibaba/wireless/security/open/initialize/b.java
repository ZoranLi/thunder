package com.alibaba.wireless.security.open.initialize;

import android.content.Context;
import com.alibaba.wireless.security.framework.b.a;
import com.alibaba.wireless.security.open.SecException;
import com.alibaba.wireless.security.open.initialize.IInitializeComponent.IInitFinishListener;
import java.util.HashSet;
import java.util.Set;

public class b {
    boolean a = false;
    private Set<IInitFinishListener> b = new HashSet();
    private Object c = new Object();

    private void a() {
        synchronized (this.c) {
            for (IInitFinishListener onSuccess : this.b) {
                onSuccess.onSuccess();
            }
        }
    }

    private void b() {
        synchronized (this.c) {
            for (IInitFinishListener onError : this.b) {
                onError.onError();
            }
        }
    }

    public synchronized int a(Context context, String str, boolean z) throws SecException {
        if (!this.a) {
            if (context == null) {
                throw new SecException(101);
            }
            long currentTimeMillis = System.currentTimeMillis();
            com.alibaba.wireless.security.framework.b a = com.alibaba.wireless.security.framework.b.a(context);
            a.a(z);
            a.a(str);
            a.c(a.a());
            this.a = true;
            StringBuilder stringBuilder = new StringBuilder("initialization used time: ");
            stringBuilder.append(System.currentTimeMillis() - currentTimeMillis);
            stringBuilder.append(" ms");
            a.b(stringBuilder.toString());
        }
        return this.a ? 0 : 1;
    }

    public void a(IInitFinishListener iInitFinishListener) throws SecException {
        if (iInitFinishListener != null) {
            synchronized (this.c) {
                this.b.add(iInitFinishListener);
            }
        }
    }

    public boolean a(Context context) throws SecException {
        return true;
    }

    public void b(Context context, String str, boolean z) throws SecException {
        if (context == null) {
            throw new SecException(101);
        }
        new Thread(new c(this, context, str, z)).start();
    }

    public void b(IInitFinishListener iInitFinishListener) throws SecException {
        if (iInitFinishListener != null) {
            synchronized (this.c) {
                this.b.remove(iInitFinishListener);
            }
        }
    }
}
