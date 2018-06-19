package com.xunlei.downloadprovider.app;

import android.content.Context;
import android.content.Intent;

/* compiled from: BrothersApplication */
final class d extends com.qihoo360.replugin.d {
    final /* synthetic */ BrothersApplication b;

    d(BrothersApplication brothersApplication, Context context) {
        this.b = brothersApplication;
        super(context);
    }

    public final boolean a(String str, Intent intent) {
        BrothersApplication.TAG;
        StringBuilder stringBuilder = new StringBuilder("onPluginNotExistsForActivity, plugin : ");
        stringBuilder.append(str);
        stringBuilder.append(" ");
        stringBuilder.append(intent.getComponent() == null ? "" : intent.getComponent().getClassName());
        return true;
    }
}
