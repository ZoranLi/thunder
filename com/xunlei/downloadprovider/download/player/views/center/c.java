package com.xunlei.downloadprovider.download.player.views.center;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;

/* compiled from: PlayerGestureCenterPopView */
final class c extends AnimatorListenerAdapter {
    final /* synthetic */ View a;
    final /* synthetic */ PlayerGestureCenterPopView b;

    c(PlayerGestureCenterPopView playerGestureCenterPopView, View view) {
        this.b = playerGestureCenterPopView;
        this.a = view;
    }

    public final void onAnimationEnd(Animator animator) {
        this.a.setVisibility(8);
    }
}
