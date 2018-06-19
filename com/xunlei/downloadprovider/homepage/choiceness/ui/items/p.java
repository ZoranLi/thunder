package com.xunlei.downloadprovider.homepage.choiceness.ui.items;

import android.view.animation.LinearInterpolator;

/* compiled from: ChoicenessLiveStoryItemView */
final class p extends LinearInterpolator {
    final /* synthetic */ float a = 0.7f;
    final /* synthetic */ float b = 1.0f;
    final /* synthetic */ b c;

    p(b bVar) {
        this.c = bVar;
    }

    public final float getInterpolation(float f) {
        if (f != 0.0f) {
            if (f != 1.0f) {
                return (float) (((((double) this.b) * Math.pow(2.0d, (double) (-10.0f * f))) * Math.sin(((((double) f) - ((((double) this.a) / 6.283185307179586d) * Math.asin((double) (1.0f / this.b)))) * 6.283185307179586d) / ((double) this.a))) + 1.0d);
            }
        }
        return f;
    }
}
