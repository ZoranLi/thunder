package com.xunlei.downloadprovider.personal.message.chat.chatkit.commons;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.annotation.ColorRes;
import android.support.annotation.DimenRes;
import android.support.annotation.DrawableRes;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.util.TypedValue;
import com.xunlei.downloadprovider.R;

/* compiled from: Style */
public abstract class b {
    protected Context a;
    protected Resources b;
    protected AttributeSet c;

    protected b(Context context, AttributeSet attributeSet) {
        this.a = context;
        this.b = context.getResources();
        this.c = attributeSet;
    }

    protected final int a(@DimenRes int i) {
        return this.b.getDimensionPixelSize(i);
    }

    protected final int b(@ColorRes int i) {
        return ContextCompat.getColor(this.a, i);
    }

    protected final Drawable c(@DrawableRes int i) {
        return ContextCompat.getDrawable(this.a, i);
    }

    protected final Drawable d(@DrawableRes int i) {
        return ContextCompat.getDrawable(this.a, i);
    }

    protected final int a() {
        TypedValue typedValue = new TypedValue();
        TypedArray obtainStyledAttributes = this.a.obtainStyledAttributes(typedValue.data, new int[]{R.attr.colorAccent});
        int color = obtainStyledAttributes.getColor(0, 0);
        obtainStyledAttributes.recycle();
        return color;
    }
}
