package com.tencent.smtt.sdk;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.tbs.video.interfaces.IUserStateChangedListener;
import com.tencent.tbs.video.interfaces.a;

class ax {
    private static ax e;
    az a = null;
    Context b;
    a c;
    IUserStateChangedListener d;

    private ax(Context context) {
        this.b = context.getApplicationContext();
        this.a = new az(this.b);
    }

    public static synchronized ax a(Context context) {
        ax axVar;
        synchronized (ax.class) {
            if (e == null) {
                e = new ax(context);
            }
            axVar = e;
        }
        return axVar;
    }

    public void a(int i, int i2, Intent intent) {
        if (this.c != null) {
            this.c.a(i, i2, intent);
        }
    }

    void a(Activity activity, int i) {
        this.a.a(activity, i);
    }

    public boolean a() {
        this.a.a();
        return this.a.b();
    }

    public boolean a(String str, Bundle bundle, a aVar) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        if (!TextUtils.isEmpty(str)) {
            bundle.putString("videoUrl", str);
        }
        if (aVar != null) {
            this.a.a();
            if (!this.a.b()) {
                return false;
            }
            this.c = aVar;
            this.d = new ay(this);
            this.c.a(this.d);
            bundle.putInt("callMode", 3);
        } else {
            bundle.putInt("callMode", 1);
        }
        this.a.a(bundle, aVar == null ? null : this);
        return true;
    }
}
