package com.xunlei.downloadprovider.player.xmp.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;

/* compiled from: PlayerGestureViewDefault */
final class ah extends AnimatorListenerAdapter {
    final /* synthetic */ View a;
    final /* synthetic */ PlayerGestureViewDefault b;

    ah(PlayerGestureViewDefault playerGestureViewDefault, View view) {
        this.b = playerGestureViewDefault;
        this.a = view;
    }

    public final void onAnimationEnd(Animator animator) {
        this.a.setVisibility(8);
    }
}
