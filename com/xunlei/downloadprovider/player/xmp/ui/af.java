package com.xunlei.downloadprovider.player.xmp.ui;

import android.app.Activity;
import android.view.ViewGroup;
import com.xunlei.downloadprovider.player.xmp.ThunderXmpPlayer;

/* compiled from: PlayerFullScreenContainer */
public final class af implements PlayerContainer {
    private Activity a;

    public final void a(ThunderXmpPlayer thunderXmpPlayer) {
    }

    public final void b(ThunderXmpPlayer thunderXmpPlayer) {
    }

    public af(Activity activity) {
        this.a = activity;
    }

    public final ViewGroup getContainerLayout() {
        return (ViewGroup) this.a.getWindow().getDecorView();
    }
}
