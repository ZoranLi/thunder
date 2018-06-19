package com.xunlei.downloadprovider.homepage;

import android.app.Activity;
import android.util.DisplayMetrics;
import android.view.GestureDetector;
import android.view.MotionEvent;

/* compiled from: GoBackGestureDetector */
public final class c {
    public a a;
    private GestureDetector b;

    /* compiled from: GoBackGestureDetector */
    public interface a {
        void a();
    }

    public c(Activity activity) {
        DisplayMetrics displayMetrics = activity.getResources().getDisplayMetrics();
        int i = displayMetrics.widthPixels;
        this.b = new GestureDetector(activity, new d(this, ((float) displayMetrics.heightPixels) * 0.15f, ((float) i) * 0.12f, activity));
    }

    public final boolean a(MotionEvent motionEvent) {
        return this.b.onTouchEvent(motionEvent);
    }
}
