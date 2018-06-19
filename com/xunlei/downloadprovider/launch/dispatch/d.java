package com.xunlei.downloadprovider.launch.dispatch;

import android.content.Context;
import android.content.Intent;

/* compiled from: BaseSchemeDispatch */
public abstract class d {
    protected abstract void a(Context context, Intent intent);

    protected abstract boolean a(Intent intent);

    public final boolean b(Context context, Intent intent) {
        if (!a(intent)) {
            return null;
        }
        a(context, intent);
        return true;
    }
}
