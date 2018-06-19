package com.xunlei.downloadprovider.vod.player;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;

public final class PointerPopupWindow extends PopupWindow {
    public ImageView a;
    private LinearLayout b;
    private FrameLayout c;
    private int d;
    private AlignMode e;

    public enum AlignMode {
        DEFAULT,
        CENTER_FIX,
        AUTO_OFFSET
    }

    public PointerPopupWindow(Context context, int i) {
        this(context, i, (byte) 0);
    }

    private PointerPopupWindow(Context context, int i, byte b) {
        super(i, (byte) -2);
        this.e = AlignMode.DEFAULT;
        if (i < 0) {
            throw new RuntimeException("You must specify the window width explicitly(do not use WRAP_CONTENT or MATCH_PARENT)!!!");
        }
        this.b = new LinearLayout(context);
        this.b.setOrientation(1);
        this.a = new ImageView(context);
        this.c = new FrameLayout(context);
        setBackgroundDrawable(new ColorDrawable());
        setTouchable(true);
        setFocusable(null);
        setOutsideTouchable(true);
    }

    public final void setContentView(View view) {
        if (view != null) {
            this.b.removeAllViews();
            this.b.addView(this.a, -2, -2);
            this.b.addView(this.c, -1, -1);
            this.c.addView(view, -1, -1);
            super.setContentView(this.b);
        }
    }

    public final void setBackgroundDrawable(Drawable drawable) {
        this.c.setBackgroundDrawable(drawable);
        super.setBackgroundDrawable(new ColorDrawable());
    }

    public final void a(View view, int i, int i2) {
        Rect rect = new Rect();
        view.getWindowVisibleDisplayFrame(rect);
        int i3 = rect.right - rect.left;
        int[] iArr = new int[2];
        view.getLocationInWindow(iArr);
        if (this.e == AlignMode.AUTO_OFFSET) {
            i = (int) (((float) ((view.getWidth() - getWidth()) / 2)) + (((((float) (rect.centerX() - iArr[0])) / ((float) i3)) * ((float) getWidth())) / 1073741824));
        } else {
            AlignMode alignMode = this.e;
            AlignMode alignMode2 = AlignMode.AUTO_OFFSET;
            if (alignMode == AlignMode.CENTER_FIX) {
                i = (view.getWidth() - getWidth()) / 2;
            }
        }
        int i4 = iArr[0] + i;
        if (getWidth() + i4 > i3 - this.d) {
            i = ((i3 - this.d) - getWidth()) - iArr[0];
        }
        if (i4 < rect.left + this.d) {
            i = (rect.left + this.d) - iArr[0];
        }
        this.a.setPadding(((view.getWidth() - this.a.getDrawable().getIntrinsicWidth()) / 2) - i, 0, 0, 0);
        super.showAsDropDown(view, i, i2);
    }

    @Deprecated
    public final void setClippingEnabled(boolean z) {
        super.setClippingEnabled(z);
    }
}
