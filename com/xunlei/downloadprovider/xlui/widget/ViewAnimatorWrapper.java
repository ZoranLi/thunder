package com.xunlei.downloadprovider.xlui.widget;

import android.view.View;
import android.view.ViewParent;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;

public class ViewAnimatorWrapper {
    private static final String TAG = "ViewAnimatorWrapper";
    private View mTarget;

    public ViewAnimatorWrapper(View view) {
        this.mTarget = view;
    }

    public int getMarginRight() {
        ViewParent parent = this.mTarget.getParent();
        if (parent == null) {
            return 0;
        }
        if (parent instanceof RelativeLayout) {
            return ((LayoutParams) this.mTarget.getLayoutParams()).rightMargin;
        }
        if (parent instanceof LinearLayout) {
            return ((LinearLayout.LayoutParams) this.mTarget.getLayoutParams()).rightMargin;
        }
        return 0;
    }

    public void setMarginRight(int i) {
        ViewParent parent = this.mTarget.getParent();
        if (parent != null) {
            if (parent instanceof RelativeLayout) {
                ((LayoutParams) this.mTarget.getLayoutParams()).rightMargin = i;
                this.mTarget.requestLayout();
                return;
            }
            if (parent instanceof LinearLayout) {
                ((LinearLayout.LayoutParams) this.mTarget.getLayoutParams()).rightMargin = i;
                this.mTarget.requestLayout();
            }
        }
    }

    public int getWidth() {
        return this.mTarget.getLayoutParams().width;
    }

    public void setWidth(int i) {
        this.mTarget.getLayoutParams().width = i;
        this.mTarget.requestLayout();
    }

    public int getHeight() {
        return this.mTarget.getLayoutParams().height;
    }

    public void setHeight(int i) {
        this.mTarget.getLayoutParams().height = i;
        this.mTarget.requestLayout();
    }
}
