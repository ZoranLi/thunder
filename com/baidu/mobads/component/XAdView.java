package com.baidu.mobads.component;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.KeyEvent;
import android.widget.RelativeLayout;

public class XAdView extends RelativeLayout {
    public static final String TAG = "BDAdView";
    private Listener mListener;

    public interface Listener {
        void onAttachedToWindow();

        @SuppressLint({"MissingSuperCall"})
        void onDetachedFromWindow();

        boolean onKeyDown(int i, KeyEvent keyEvent);

        void onLayoutComplete(int i, int i2);

        void onWindowFocusChanged(boolean z);

        void onWindowVisibilityChanged(int i);
    }

    public XAdView(Context context) {
        super(context);
    }

    public void setListener(Listener listener) {
        this.mListener = listener;
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z && this.mListener) {
            this.mListener.onLayoutComplete(getWidth(), getHeight());
        }
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.mListener != null) {
            this.mListener.onAttachedToWindow();
        }
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.mListener != null) {
            this.mListener.onDetachedFromWindow();
        }
    }

    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (this.mListener != null) {
            this.mListener.onWindowVisibilityChanged(i);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (this.mListener != null) {
            this.mListener.onWindowFocusChanged(z);
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.mListener != null) {
            return this.mListener.onKeyDown(i, keyEvent);
        }
        super.onKeyDown(i, keyEvent);
        return false;
    }
}
