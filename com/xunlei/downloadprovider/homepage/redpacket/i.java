package com.xunlei.downloadprovider.homepage.redpacket;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;

/* compiled from: RedPacketGuideDlg */
final class i implements AnimatorListener {
    final /* synthetic */ a a;

    public final void onAnimationCancel(Animator animator) {
    }

    public final void onAnimationRepeat(Animator animator) {
    }

    public final void onAnimationStart(Animator animator) {
    }

    i(a aVar) {
        this.a = aVar;
    }

    public final void onAnimationEnd(Animator animator) {
        this.a.h.setVisibility(0);
        this.a.e.setVisibility(4);
        this.a.f.setVisibility(0);
        this.a.f.a(true);
        this.a.f.a();
    }
}
