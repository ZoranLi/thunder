package com.xunlei.thunder.commonui.dialog;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;

public abstract class XLBaseDialog extends Dialog {
    protected Context mCtx;
    protected Object mTag;

    public XLBaseDialog(Context context, boolean z, OnCancelListener onCancelListener) {
        super(context, z, onCancelListener);
        this.mCtx = context;
        if (context instanceof Activity) {
            setOwnerActivity((Activity) context);
        }
    }

    public XLBaseDialog(Context context, int i) {
        super(context, i);
        this.mCtx = context;
        if ((context instanceof Activity) != 0) {
            setOwnerActivity((Activity) context);
        }
    }

    public XLBaseDialog(Context context) {
        super(context);
        this.mCtx = context;
        if (context instanceof Activity) {
            setOwnerActivity((Activity) context);
        }
    }

    public void dismiss() {
        try {
            if (this.mCtx instanceof Activity) {
                if (!((Activity) this.mCtx).isFinishing()) {
                    super.dismiss();
                }
                return;
            }
            if (isShowing()) {
                super.dismiss();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void show() {
        try {
            Activity ownerActivity = getOwnerActivity();
            if (this.mCtx instanceof Activity) {
                ownerActivity = (Activity) this.mCtx;
            }
            if (ownerActivity != null) {
                if (!(ownerActivity.isFinishing() || ownerActivity.getWindow() == null)) {
                    super.show();
                }
                return;
            }
            super.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Object getTag() {
        return this.mTag;
    }

    public void setTag(Object obj) {
        this.mTag = obj;
    }

    public boolean isOutOfBounds(Context context, MotionEvent motionEvent) {
        int x = (int) motionEvent.getX();
        motionEvent = (int) motionEvent.getY();
        context = ViewConfiguration.get(context).getScaledWindowTouchSlop();
        View decorView = getWindow().getDecorView();
        int i = -context;
        if (x >= i && motionEvent >= i && x <= decorView.getWidth() + context) {
            if (motionEvent <= decorView.getHeight() + context) {
                return null;
            }
        }
        return true;
    }
}
