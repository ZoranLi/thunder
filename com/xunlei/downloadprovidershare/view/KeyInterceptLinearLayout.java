package com.xunlei.downloadprovidershare.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View.OnKeyListener;
import android.widget.LinearLayout;

public class KeyInterceptLinearLayout extends LinearLayout {
    private OnKeyListener a = null;

    public KeyInterceptLinearLayout(Context context) {
        super(context);
    }

    public KeyInterceptLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public KeyInterceptLinearLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
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
