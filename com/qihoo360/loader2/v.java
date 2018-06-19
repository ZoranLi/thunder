package com.qihoo360.loader2;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater.Factory;
import android.view.View;

/* compiled from: PluginContext */
final class v implements Factory {
    final /* synthetic */ u a;

    v(u uVar) {
        this.a = uVar;
    }

    public final View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return this.a.a(str, context, attributeSet);
    }
}
