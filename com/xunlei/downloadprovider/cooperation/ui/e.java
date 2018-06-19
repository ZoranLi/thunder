package com.xunlei.downloadprovider.cooperation.ui;

import android.content.Context;
import com.xunlei.downloadprovider.cooperation.data.CooperationData;
import com.xunlei.downloadprovider.personal.settings.RoomCleanActivity;

/* compiled from: CooperationController */
final class e implements a {
    final /* synthetic */ Context a;
    final /* synthetic */ CooperationData b;
    final /* synthetic */ b c;

    public final void a() {
    }

    public final void onCancel() {
    }

    e(b bVar, Context context, CooperationData cooperationData) {
        this.c = bVar;
        this.a = context;
        this.b = cooperationData;
    }

    public final void b() {
        RoomCleanActivity.a(this.a, this.b.mCooperationScene.getLocation());
    }
}
