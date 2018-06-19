package com.tencent.smtt.sdk;

import com.tencent.tbs.video.interfaces.IUserStateChangedListener;

class ay implements IUserStateChangedListener {
    final /* synthetic */ ax a;

    ay(ax axVar) {
        this.a = axVar;
    }

    public void onUserStateChanged() {
        this.a.a.c();
    }
}
