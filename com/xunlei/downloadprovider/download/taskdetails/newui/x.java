package com.xunlei.downloadprovider.download.taskdetails.newui;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.ViewGroup.LayoutParams;

/* compiled from: DownloadDetailsActivityFragment */
final class x implements AnimatorUpdateListener {
    final /* synthetic */ int a;
    final /* synthetic */ int b;
    final /* synthetic */ LayoutParams c;
    final /* synthetic */ DownloadDetailsActivityFragment d;

    x(DownloadDetailsActivityFragment downloadDetailsActivityFragment, int i, int i2, LayoutParams layoutParams) {
        this.d = downloadDetailsActivityFragment;
        this.a = i;
        this.b = i2;
        this.c = layoutParams;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.c.height = this.a + ((int) (((float) (this.b - this.a)) * valueAnimator.getAnimatedFraction()));
        DownloadDetailsActivityFragment.q;
        this.d.k.setLayoutParams(this.c);
    }
}
