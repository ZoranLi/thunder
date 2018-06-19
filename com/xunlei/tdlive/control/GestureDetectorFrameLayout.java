package com.xunlei.tdlive.control;

import android.content.Context;
import android.support.v4.view.GestureDetectorCompat;
import android.util.AttributeSet;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;

public class GestureDetectorFrameLayout extends FrameLayout {
    private GestureDetectorCompat a;
    private View b;
    private boolean c;

    public GestureDetectorFrameLayout(Context context) {
        super(context);
    }

    public GestureDetectorFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public GestureDetectorFrameLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void setOnGestureListener(OnGestureListener onGestureListener) {
        this.a = new GestureDetectorCompat(getContext(), onGestureListener);
    }

    public void detourView(View view) {
        this.b = view;
    }

    public void enableDetour(boolean z) {
        this.c = z;
    }

    public boolean isDetourEnabled() {
        return this.c;
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.a != null) {
            this.a.onTouchEvent(motionEvent);
        }
        if (this.c && this.b != null) {
            this.b.dispatchTouchEvent(motionEvent);
        }
        if (!this.c) {
            if (super.dispatchTouchEvent(motionEvent) == null) {
                return null;
            }
        }
        return true;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        return super.onTouchEvent(motionEvent);
    }
}
