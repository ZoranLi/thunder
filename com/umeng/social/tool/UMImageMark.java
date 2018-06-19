package com.umeng.social.tool;

import android.content.Context;
import android.graphics.Bitmap;

public class UMImageMark extends UMWaterMark {
    private Bitmap mMarkBitmap;

    public /* bridge */ /* synthetic */ void bringToFront() {
        super.bringToFront();
    }

    public /* bridge */ /* synthetic */ Bitmap compound(Bitmap bitmap) {
        return super.compound(bitmap);
    }

    public /* bridge */ /* synthetic */ void setAlpha(float f) {
        super.setAlpha(f);
    }

    public /* bridge */ /* synthetic */ void setContext(Context context) {
        super.setContext(context);
    }

    public /* bridge */ /* synthetic */ void setGravity(int i) {
        super.setGravity(i);
    }

    public /* bridge */ /* synthetic */ void setMargins(int i, int i2, int i3, int i4) {
        super.setMargins(i, i2, i3, i4);
    }

    public /* bridge */ /* synthetic */ void setRotate(int i) {
        super.setRotate(i);
    }

    public /* bridge */ /* synthetic */ void setScale(float f) {
        super.setScale(f);
    }

    public /* bridge */ /* synthetic */ void setTransparent() {
        super.setTransparent();
    }

    public void setMarkBitmap(Bitmap bitmap) {
        this.mMarkBitmap = bitmap;
    }

    Bitmap getMarkBitmap() {
        return this.mMarkBitmap;
    }
}
