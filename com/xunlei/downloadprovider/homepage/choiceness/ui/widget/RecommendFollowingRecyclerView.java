package com.xunlei.downloadprovider.homepage.choiceness.ui.widget;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewParent;

public class RecommendFollowingRecyclerView extends RecyclerView {
    private int a = 0;
    private int b = 0;

    public RecommendFollowingRecyclerView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public RecommendFollowingRecyclerView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        ViewParent parent = getParent();
        if (parent != null) {
            int x = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            if (Math.abs(x - this.a) > Math.abs(y - this.b)) {
                parent.requestDisallowInterceptTouchEvent(true);
            } else {
                parent.requestDisallowInterceptTouchEvent(false);
            }
            this.a = x;
            this.b = y;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }
}
