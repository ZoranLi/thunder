package com.xunlei.downloadprovider.dialog;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface.OnShowListener;
import android.support.annotation.Nullable;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import com.xunlei.downloadprovider.R;
import com.xunlei.thunder.commonui.dialog.XLBaseDialog;

/* compiled from: XLManagedBaseDialog */
public class i extends XLBaseDialog {
    private OnShowListener a;
    protected Context i;
    protected Object j;
    public int k = -1;

    public void a() {
    }

    public i(Context context) {
        super(context, R.style.ThunderTheme.Dialog);
        this.i = context;
        super.setOnShowListener(new j(this));
    }

    public int b() {
        return this.k;
    }

    public void dismiss() {
        a.a().a(b(), false);
        try {
            if (this.i instanceof Activity) {
                if (!((Activity) this.i).isFinishing()) {
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
            if (a.a().a(b())) {
                Activity ownerActivity = getOwnerActivity();
                if (this.i instanceof Activity) {
                    ownerActivity = (Activity) this.i;
                }
                if (ownerActivity != null) {
                    if (!(ownerActivity.isFinishing() || ownerActivity.getWindow() == null)) {
                        super.show();
                    }
                    return;
                }
                super.show();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setTag(Object obj) {
        this.j = obj;
    }

    public Object getTag() {
        return this.j;
    }

    protected boolean isOutOfBounds(Context context, MotionEvent motionEvent) {
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

    public void setOnShowListener(@Nullable OnShowListener onShowListener) {
        this.a = onShowListener;
    }
}
