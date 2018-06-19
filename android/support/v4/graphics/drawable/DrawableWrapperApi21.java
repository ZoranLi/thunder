package android.support.v4.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Outline;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import java.lang.reflect.Method;

@RequiresApi(21)
class DrawableWrapperApi21 extends DrawableWrapperApi19 {
    private static final String TAG = "DrawableWrapperApi21";
    private static Method sIsProjectedDrawableMethod;

    private static class DrawableWrapperStateLollipop extends DrawableWrapperState {
        DrawableWrapperStateLollipop(@Nullable DrawableWrapperState drawableWrapperState, @Nullable Resources resources) {
            super(drawableWrapperState, resources);
        }

        public Drawable newDrawable(@Nullable Resources resources) {
            return new DrawableWrapperApi21(this, resources);
        }
    }

    DrawableWrapperApi21(Drawable drawable) {
        super(drawable);
        findAndCacheIsProjectedDrawableMethod();
    }

    DrawableWrapperApi21(DrawableWrapperState drawableWrapperState, Resources resources) {
        super(drawableWrapperState, resources);
        findAndCacheIsProjectedDrawableMethod();
    }

    public void setHotspot(float f, float f2) {
        this.mDrawable.setHotspot(f, f2);
    }

    public void setHotspotBounds(int i, int i2, int i3, int i4) {
        this.mDrawable.setHotspotBounds(i, i2, i3, i4);
    }

    public void getOutline(Outline outline) {
        this.mDrawable.getOutline(outline);
    }

    public Rect getDirtyBounds() {
        return this.mDrawable.getDirtyBounds();
    }

    public void setTintList(ColorStateList colorStateList) {
        if (isCompatTintEnabled()) {
            super.setTintList(colorStateList);
        } else {
            this.mDrawable.setTintList(colorStateList);
        }
    }

    public void setTint(int i) {
        if (isCompatTintEnabled()) {
            super.setTint(i);
        } else {
            this.mDrawable.setTint(i);
        }
    }

    public void setTintMode(Mode mode) {
        if (isCompatTintEnabled()) {
            super.setTintMode(mode);
        } else {
            this.mDrawable.setTintMode(mode);
        }
    }

    public boolean setState(int[] iArr) {
        if (super.setState(iArr) == null) {
            return null;
        }
        invalidateSelf();
        return 1;
    }

    protected boolean isCompatTintEnabled() {
        if (VERSION.SDK_INT != 21) {
            return false;
        }
        Drawable drawable = this.mDrawable;
        if (!((drawable instanceof GradientDrawable) || (drawable instanceof DrawableContainer) || (drawable instanceof InsetDrawable))) {
            if (!(drawable instanceof RippleDrawable)) {
                return false;
            }
        }
        return true;
    }

    @android.support.annotation.RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
    public boolean isProjected() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r4 = this;
        r0 = r4.mDrawable;
        r1 = 0;
        if (r0 == 0) goto L_0x001a;
    L_0x0005:
        r0 = sIsProjectedDrawableMethod;
        if (r0 == 0) goto L_0x001a;
    L_0x0009:
        r0 = sIsProjectedDrawableMethod;	 Catch:{ Exception -> 0x001a }
        r2 = r4.mDrawable;	 Catch:{ Exception -> 0x001a }
        r3 = new java.lang.Object[r1];	 Catch:{ Exception -> 0x001a }
        r0 = r0.invoke(r2, r3);	 Catch:{ Exception -> 0x001a }
        r0 = (java.lang.Boolean) r0;	 Catch:{ Exception -> 0x001a }
        r0 = r0.booleanValue();	 Catch:{ Exception -> 0x001a }
        return r0;
    L_0x001a:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.graphics.drawable.DrawableWrapperApi21.isProjected():boolean");
    }

    @NonNull
    DrawableWrapperState mutateConstantState() {
        return new DrawableWrapperStateLollipop(this.mState, null);
    }

    private void findAndCacheIsProjectedDrawableMethod() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r3 = this;
        r0 = sIsProjectedDrawableMethod;
        if (r0 != 0) goto L_0x0012;
    L_0x0004:
        r0 = android.graphics.drawable.Drawable.class;	 Catch:{ Exception -> 0x0012 }
        r1 = "isProjected";	 Catch:{ Exception -> 0x0012 }
        r2 = 0;	 Catch:{ Exception -> 0x0012 }
        r2 = new java.lang.Class[r2];	 Catch:{ Exception -> 0x0012 }
        r0 = r0.getDeclaredMethod(r1, r2);	 Catch:{ Exception -> 0x0012 }
        sIsProjectedDrawableMethod = r0;	 Catch:{ Exception -> 0x0012 }
        return;
    L_0x0012:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.graphics.drawable.DrawableWrapperApi21.findAndCacheIsProjectedDrawableMethod():void");
    }
}
