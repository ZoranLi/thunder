package com.xunlei.downloadprovider.homepage.choiceness.jointactivity;

import com.xunlei.downloadprovider.homepage.choiceness.jointactivity.JointActivityItemView.a;

/* compiled from: JointActivityHelper */
final class h implements a {
    final /* synthetic */ g a;

    h(g gVar) {
        this.a = gVar;
    }

    public final void a() {
        this.a.c();
        g gVar = this.a;
        gVar.a = true;
        gVar.b().edit().putBoolean("close_flag", true).apply();
    }
}
