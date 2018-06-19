package com.xunlei.thunder.commonui.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.util.AttributeSet;
import android.widget.ImageView;

public class RecycleImageView extends ImageView {
    public RecycleImageView(Context context) {
        super(context);
    }

    public RecycleImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public RecycleImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    public void setImageDrawable(Drawable drawable) {
        Drawable drawable2 = getDrawable();
        super.setImageDrawable(drawable);
        a(drawable, true);
        a(drawable2, null);
    }

    public void setBackgroundDrawable(Drawable drawable) {
        Drawable background = getBackground();
        super.setBackgroundDrawable(drawable);
        a(drawable, true);
        a(background, null);
    }

    public void setBackground(Drawable drawable) {
        Drawable background = getBackground();
        super.setBackground(drawable);
        a(drawable, true);
        a(background, null);
    }

    private static void a(Drawable drawable, boolean z) {
        if (drawable instanceof a) {
            ((a) drawable).a(z);
        } else if (drawable instanceof LayerDrawable) {
            LayerDrawable layerDrawable = (LayerDrawable) drawable;
            int numberOfLayers = layerDrawable.getNumberOfLayers();
            for (int i = 0; i < numberOfLayers; i++) {
                a(layerDrawable.getDrawable(i), z);
            }
        } else {
            if (drawable instanceof b) {
                ((b) drawable).a(z);
            }
        }
    }

    protected void onDraw(android.graphics.Canvas r1) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = this;
        super.onDraw(r1);	 Catch:{ Exception -> 0x0004 }
        return;
    L_0x0004:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.thunder.commonui.widget.RecycleImageView.onDraw(android.graphics.Canvas):void");
    }
}
