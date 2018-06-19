package com.xunlei.downloadprovider.publiser.common;

import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;

/* compiled from: AvatarActivity */
final class a extends SimpleOnGestureListener {
    final /* synthetic */ AvatarActivity a;

    a(AvatarActivity avatarActivity) {
        this.a = avatarActivity;
    }

    public final boolean onDoubleTap(MotionEvent motionEvent) {
        if (this.a.h <= 300) {
            return null;
        }
        AvatarActivity.a(this.a, motionEvent);
        return true;
    }

    public final boolean onSingleTapConfirmed(MotionEvent motionEvent) {
        this.a.onBackPressed();
        return true;
    }
}
