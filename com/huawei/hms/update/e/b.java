package com.huawei.hms.update.e;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.os.Build.VERSION;
import com.huawei.hms.support.log.a;

/* compiled from: AbstractDialog */
public abstract class b {
    private AlertDialog a;
    private a b;

    protected abstract AlertDialog a();

    public void a(a aVar) {
        this.b = aVar;
        if (f() != null) {
            if (f().isFinishing() == null) {
                this.a = a();
                this.a.setCanceledOnTouchOutside(false);
                this.a.setOnCancelListener(new c(this));
                this.a.show();
                return;
            }
        }
        a.d("AbstractDialog", "In show, The activity is null or finishing.");
    }

    public void b() {
        if (this.a != null) {
            this.a.cancel();
        }
    }

    public void c() {
        if (this.a != null) {
            this.a.dismiss();
        }
    }

    protected void d() {
        if (this.b != null) {
            this.b.a(this);
        }
    }

    protected void e() {
        if (this.b != null) {
            this.b.b(this);
        }
    }

    protected Activity f() {
        return this.b != null ? this.b.c() : null;
    }

    protected int g() {
        return (a(f()) == 0 || VERSION.SDK_INT < 16) ? 3 : 0;
    }

    private static int a(Context context) {
        return context == null ? null : context.getResources().getIdentifier("androidhwext:style/Theme.Emui", null, null);
    }
}
