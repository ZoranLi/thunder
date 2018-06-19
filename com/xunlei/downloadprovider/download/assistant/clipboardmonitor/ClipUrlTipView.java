package com.xunlei.downloadprovider.download.assistant.clipboardmonitor;

import android.annotation.TargetApi;
import android.content.Context;
import android.support.annotation.AttrRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.StyleRes;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View.OnKeyListener;
import android.widget.FrameLayout;

public class ClipUrlTipView extends FrameLayout {
    private OnKeyListener a = null;

    public ClipUrlTipView(@NonNull Context context) {
        super(context);
    }

    public ClipUrlTipView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ClipUrlTipView(@NonNull Context context, @Nullable AttributeSet attributeSet, @AttrRes int i) {
        super(context, attributeSet, i);
    }

    @TargetApi(21)
    public ClipUrlTipView(@NonNull Context context, @Nullable AttributeSet attributeSet, @AttrRes int i, @StyleRes int i2) {
        super(context, attributeSet, i, i2);
    }

    public void setKeyEventHandler(OnKeyListener onKeyListener) {
        this.a = onKeyListener;
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (this.a != null) {
            this.a.onKey(this, keyEvent.getKeyCode(), keyEvent);
        }
        return super.dispatchKeyEvent(keyEvent);
    }
}
