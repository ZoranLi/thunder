package com.xunlei.downloadprovider.xlui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View.OnKeyListener;
import android.widget.LinearLayout;

public class KeyLinearLayout extends LinearLayout {
    private OnKeyListener a = null;

    public KeyLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void setKeyInterceptor(OnKeyListener onKeyListener) {
        this.a = onKeyListener;
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (this.a != null ? this.a.onKey(this, keyEvent.getKeyCode(), keyEvent) : false) {
            return true;
        }
        return super.dispatchKeyEvent(keyEvent);
    }
}
