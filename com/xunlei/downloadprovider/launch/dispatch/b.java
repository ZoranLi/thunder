package com.xunlei.downloadprovider.launch.dispatch;

import android.content.Context;
import android.content.Intent;

/* compiled from: BaseDispatch */
public abstract class b {
    protected abstract void a(Context context);

    protected abstract boolean a(Intent intent);

    public boolean a(Context context, Intent intent) {
        if (a(intent) == null) {
            return null;
        }
        a(context);
        return true;
    }
}
