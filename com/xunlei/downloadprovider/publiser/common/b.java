package com.xunlei.downloadprovider.publiser.common;

import android.view.animation.DecelerateInterpolator;

/* compiled from: AvatarActivity */
final class b implements a {
    final /* synthetic */ AvatarActivity a;

    b(AvatarActivity avatarActivity) {
        this.a = avatarActivity;
    }

    public final boolean a() {
        AvatarActivity.a;
        return true;
    }

    public final boolean b() {
        AvatarActivity.a;
        return false;
    }

    public final boolean c() {
        AvatarActivity.a;
        return false;
    }

    public final boolean a(float f) {
        AvatarActivity.a;
        float x = this.a.b.getX();
        float measuredWidth = ((float) this.a.b.getMeasuredWidth()) + x;
        float translationX = this.a.b.getTranslationX() + f;
        float width = ((float) this.a.j.getWidth()) * 0.2f;
        if (f > 0.0f && x > 0.0f && x < width) {
            translationX = (f * ((width - x) / width)) + this.a.b.getTranslationX();
        } else if (f < 0.0f && measuredWidth < ((float) this.a.j.getWidth()) && measuredWidth > ((float) this.a.j.getWidth()) - width) {
            translationX = (f * (1.0f - ((((float) this.a.j.getWidth()) - measuredWidth) / width))) + this.a.b.getTranslationX();
        }
        this.a.b.setTranslationX(translationX);
        return true;
    }

    public final boolean d() {
        AvatarActivity.a;
        float x = this.a.b.getX();
        float measuredWidth = ((float) this.a.b.getMeasuredWidth()) + x;
        float f = 0.0f;
        if (x > 0.0f) {
            f = -x;
        } else if (measuredWidth < ((float) this.a.j.getWidth())) {
            f = ((float) this.a.j.getWidth()) - measuredWidth;
        }
        this.a.b.animate().translationXBy(f).setDuration(200).setInterpolator(new DecelerateInterpolator());
        return true;
    }
}
