package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.annotation.RestrictTo;
import android.support.annotation.RestrictTo.Scope;
import android.support.v7.appcompat.R;
import android.text.method.PasswordTransformationMethod;
import android.util.AttributeSet;
import android.widget.TextView;

@RequiresApi(9)
class AppCompatTextHelper {
    @NonNull
    private final AppCompatTextViewAutoSizeHelper mAutoSizeTextHelper;
    private TintInfo mDrawableBottomTint;
    private TintInfo mDrawableLeftTint;
    private TintInfo mDrawableRightTint;
    private TintInfo mDrawableTopTint;
    private Typeface mFontTypeface;
    private int mStyle = 0;
    final TextView mView;

    static AppCompatTextHelper create(TextView textView) {
        if (VERSION.SDK_INT >= 17) {
            return new AppCompatTextHelperV17(textView);
        }
        return new AppCompatTextHelper(textView);
    }

    AppCompatTextHelper(TextView textView) {
        this.mView = textView;
        this.mAutoSizeTextHelper = new AppCompatTextViewAutoSizeHelper(this.mView);
    }

    void loadFromAttributes(AttributeSet attributeSet, int i) {
        TintTypedArray obtainStyledAttributes;
        boolean z;
        boolean z2;
        ColorStateList colorStateList;
        ColorStateList colorStateList2;
        Context context = this.mView.getContext();
        AppCompatDrawableManager appCompatDrawableManager = AppCompatDrawableManager.get();
        TintTypedArray obtainStyledAttributes2 = TintTypedArray.obtainStyledAttributes(context, attributeSet, R.styleable.AppCompatTextHelper, i, 0);
        int resourceId = obtainStyledAttributes2.getResourceId(R.styleable.AppCompatTextHelper_android_textAppearance, -1);
        if (obtainStyledAttributes2.hasValue(R.styleable.AppCompatTextHelper_android_drawableLeft)) {
            this.mDrawableLeftTint = createTintInfo(context, appCompatDrawableManager, obtainStyledAttributes2.getResourceId(R.styleable.AppCompatTextHelper_android_drawableLeft, 0));
        }
        if (obtainStyledAttributes2.hasValue(R.styleable.AppCompatTextHelper_android_drawableTop)) {
            this.mDrawableTopTint = createTintInfo(context, appCompatDrawableManager, obtainStyledAttributes2.getResourceId(R.styleable.AppCompatTextHelper_android_drawableTop, 0));
        }
        if (obtainStyledAttributes2.hasValue(R.styleable.AppCompatTextHelper_android_drawableRight)) {
            this.mDrawableRightTint = createTintInfo(context, appCompatDrawableManager, obtainStyledAttributes2.getResourceId(R.styleable.AppCompatTextHelper_android_drawableRight, 0));
        }
        if (obtainStyledAttributes2.hasValue(R.styleable.AppCompatTextHelper_android_drawableBottom)) {
            this.mDrawableBottomTint = createTintInfo(context, appCompatDrawableManager, obtainStyledAttributes2.getResourceId(R.styleable.AppCompatTextHelper_android_drawableBottom, 0));
        }
        obtainStyledAttributes2.recycle();
        boolean z3 = this.mView.getTransformationMethod() instanceof PasswordTransformationMethod;
        ColorStateList colorStateList3 = null;
        if (resourceId != -1) {
            obtainStyledAttributes = TintTypedArray.obtainStyledAttributes(context, resourceId, R.styleable.TextAppearance);
            if (z3 || !obtainStyledAttributes.hasValue(R.styleable.TextAppearance_textAllCaps)) {
                z = false;
                z2 = z;
            } else {
                z2 = obtainStyledAttributes.getBoolean(R.styleable.TextAppearance_textAllCaps, false);
                z = true;
            }
            updateTypefaceAndStyle(context, obtainStyledAttributes);
            if (VERSION.SDK_INT < 23) {
                colorStateList = obtainStyledAttributes.hasValue(R.styleable.TextAppearance_android_textColor) ? obtainStyledAttributes.getColorStateList(R.styleable.TextAppearance_android_textColor) : null;
                colorStateList2 = obtainStyledAttributes.hasValue(R.styleable.TextAppearance_android_textColorHint) ? obtainStyledAttributes.getColorStateList(R.styleable.TextAppearance_android_textColorHint) : null;
                if (obtainStyledAttributes.hasValue(R.styleable.TextAppearance_android_textColorLink)) {
                    colorStateList3 = obtainStyledAttributes.getColorStateList(R.styleable.TextAppearance_android_textColorLink);
                }
                ColorStateList colorStateList4 = colorStateList;
                colorStateList = colorStateList3;
                colorStateList3 = colorStateList4;
            } else {
                colorStateList = null;
                colorStateList2 = colorStateList;
            }
            obtainStyledAttributes.recycle();
        } else {
            z = false;
            z2 = z;
            colorStateList = null;
            colorStateList2 = colorStateList;
        }
        obtainStyledAttributes = TintTypedArray.obtainStyledAttributes(context, attributeSet, R.styleable.TextAppearance, i, 0);
        if (!z3 && obtainStyledAttributes.hasValue(R.styleable.TextAppearance_textAllCaps)) {
            z2 = obtainStyledAttributes.getBoolean(R.styleable.TextAppearance_textAllCaps, false);
            z = true;
        }
        if (VERSION.SDK_INT < 23) {
            if (obtainStyledAttributes.hasValue(R.styleable.TextAppearance_android_textColor)) {
                colorStateList3 = obtainStyledAttributes.getColorStateList(R.styleable.TextAppearance_android_textColor);
            }
            if (obtainStyledAttributes.hasValue(R.styleable.TextAppearance_android_textColorHint)) {
                colorStateList2 = obtainStyledAttributes.getColorStateList(R.styleable.TextAppearance_android_textColorHint);
            }
            if (obtainStyledAttributes.hasValue(R.styleable.TextAppearance_android_textColorLink)) {
                colorStateList = obtainStyledAttributes.getColorStateList(R.styleable.TextAppearance_android_textColorLink);
            }
        }
        updateTypefaceAndStyle(context, obtainStyledAttributes);
        obtainStyledAttributes.recycle();
        if (colorStateList3 != null) {
            this.mView.setTextColor(colorStateList3);
        }
        if (colorStateList2 != null) {
            this.mView.setHintTextColor(colorStateList2);
        }
        if (colorStateList != null) {
            this.mView.setLinkTextColor(colorStateList);
        }
        if (!z3 && r5) {
            setAllCaps(z2);
        }
        if (this.mFontTypeface != null) {
            this.mView.setTypeface(this.mFontTypeface, this.mStyle);
        }
        this.mAutoSizeTextHelper.loadFromAttributes(attributeSet, i);
        if (VERSION.SDK_INT >= 26 && this.mAutoSizeTextHelper.getAutoSizeTextType() != null) {
            attributeSet = this.mAutoSizeTextHelper.getAutoSizeTextAvailableSizes();
            if (attributeSet.length > 0) {
                if (((float) this.mView.getAutoSizeStepGranularity()) != -1082130432) {
                    this.mView.setAutoSizeTextTypeUniformWithConfiguration(this.mAutoSizeTextHelper.getAutoSizeMinTextSize(), this.mAutoSizeTextHelper.getAutoSizeMaxTextSize(), this.mAutoSizeTextHelper.getAutoSizeStepGranularity(), 0);
                    return;
                }
                this.mView.setAutoSizeTextTypeUniformWithPresetSizes(attributeSet, 0);
            }
        }
    }

    private void updateTypefaceAndStyle(android.content.Context r3, android.support.v7.widget.TintTypedArray r4) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r2 = this;
        r0 = android.support.v7.appcompat.R.styleable.TextAppearance_android_textStyle;
        r1 = r2.mStyle;
        r0 = r4.getInt(r0, r1);
        r2.mStyle = r0;
        r0 = android.support.v7.appcompat.R.styleable.TextAppearance_android_fontFamily;
        r0 = r4.hasValue(r0);
        if (r0 != 0) goto L_0x001a;
    L_0x0012:
        r0 = android.support.v7.appcompat.R.styleable.TextAppearance_fontFamily;
        r0 = r4.hasValue(r0);
        if (r0 == 0) goto L_0x004a;
    L_0x001a:
        r0 = 0;
        r2.mFontTypeface = r0;
        r0 = android.support.v7.appcompat.R.styleable.TextAppearance_android_fontFamily;
        r0 = r4.hasValue(r0);
        if (r0 == 0) goto L_0x0028;
    L_0x0025:
        r0 = android.support.v7.appcompat.R.styleable.TextAppearance_android_fontFamily;
        goto L_0x002a;
    L_0x0028:
        r0 = android.support.v7.appcompat.R.styleable.TextAppearance_fontFamily;
    L_0x002a:
        r3 = r3.isRestricted();
        if (r3 != 0) goto L_0x003a;
    L_0x0030:
        r3 = r2.mStyle;	 Catch:{ UnsupportedOperationException -> 0x003a, UnsupportedOperationException -> 0x003a }
        r1 = r2.mView;	 Catch:{ UnsupportedOperationException -> 0x003a, UnsupportedOperationException -> 0x003a }
        r3 = r4.getFont(r0, r3, r1);	 Catch:{ UnsupportedOperationException -> 0x003a, UnsupportedOperationException -> 0x003a }
        r2.mFontTypeface = r3;	 Catch:{ UnsupportedOperationException -> 0x003a, UnsupportedOperationException -> 0x003a }
    L_0x003a:
        r3 = r2.mFontTypeface;
        if (r3 != 0) goto L_0x004a;
    L_0x003e:
        r3 = r4.getString(r0);
        r4 = r2.mStyle;
        r3 = android.graphics.Typeface.create(r3, r4);
        r2.mFontTypeface = r3;
    L_0x004a:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.AppCompatTextHelper.updateTypefaceAndStyle(android.content.Context, android.support.v7.widget.TintTypedArray):void");
    }

    void onSetTextAppearance(Context context, int i) {
        i = TintTypedArray.obtainStyledAttributes(context, i, R.styleable.TextAppearance);
        if (i.hasValue(R.styleable.TextAppearance_textAllCaps)) {
            setAllCaps(i.getBoolean(R.styleable.TextAppearance_textAllCaps, false));
        }
        if (VERSION.SDK_INT < 23 && i.hasValue(R.styleable.TextAppearance_android_textColor)) {
            ColorStateList colorStateList = i.getColorStateList(R.styleable.TextAppearance_android_textColor);
            if (colorStateList != null) {
                this.mView.setTextColor(colorStateList);
            }
        }
        updateTypefaceAndStyle(context, i);
        i.recycle();
        if (this.mFontTypeface != null) {
            this.mView.setTypeface(this.mFontTypeface, this.mStyle);
        }
    }

    void setAllCaps(boolean z) {
        this.mView.setAllCaps(z);
    }

    void applyCompoundDrawablesTints() {
        if (this.mDrawableLeftTint != null || this.mDrawableTopTint != null || this.mDrawableRightTint != null || this.mDrawableBottomTint != null) {
            Drawable[] compoundDrawables = this.mView.getCompoundDrawables();
            applyCompoundDrawableTint(compoundDrawables[0], this.mDrawableLeftTint);
            applyCompoundDrawableTint(compoundDrawables[1], this.mDrawableTopTint);
            applyCompoundDrawableTint(compoundDrawables[2], this.mDrawableRightTint);
            applyCompoundDrawableTint(compoundDrawables[3], this.mDrawableBottomTint);
        }
    }

    final void applyCompoundDrawableTint(Drawable drawable, TintInfo tintInfo) {
        if (drawable != null && tintInfo != null) {
            AppCompatDrawableManager.tintDrawable(drawable, tintInfo, this.mView.getDrawableState());
        }
    }

    protected static TintInfo createTintInfo(Context context, AppCompatDrawableManager appCompatDrawableManager, int i) {
        context = appCompatDrawableManager.getTintList(context, i);
        if (context == null) {
            return null;
        }
        appCompatDrawableManager = new TintInfo();
        appCompatDrawableManager.mHasTintList = true;
        appCompatDrawableManager.mTintList = context;
        return appCompatDrawableManager;
    }

    @RestrictTo({Scope.LIBRARY_GROUP})
    void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (VERSION.SDK_INT < true) {
            autoSizeText();
        }
    }

    @RestrictTo({Scope.LIBRARY_GROUP})
    void setTextSize(int i, float f) {
        if (VERSION.SDK_INT < 26 && !isAutoSizeEnabled()) {
            setTextSizeInternal(i, f);
        }
    }

    @RestrictTo({Scope.LIBRARY_GROUP})
    void autoSizeText() {
        this.mAutoSizeTextHelper.autoSizeText();
    }

    @RestrictTo({Scope.LIBRARY_GROUP})
    boolean isAutoSizeEnabled() {
        return this.mAutoSizeTextHelper.isAutoSizeEnabled();
    }

    private void setTextSizeInternal(int i, float f) {
        this.mAutoSizeTextHelper.setTextSizeInternal(i, f);
    }

    void setAutoSizeTextTypeWithDefaults(int i) {
        this.mAutoSizeTextHelper.setAutoSizeTextTypeWithDefaults(i);
    }

    void setAutoSizeTextTypeUniformWithConfiguration(int i, int i2, int i3, int i4) throws IllegalArgumentException {
        this.mAutoSizeTextHelper.setAutoSizeTextTypeUniformWithConfiguration(i, i2, i3, i4);
    }

    void setAutoSizeTextTypeUniformWithPresetSizes(@NonNull int[] iArr, int i) throws IllegalArgumentException {
        this.mAutoSizeTextHelper.setAutoSizeTextTypeUniformWithPresetSizes(iArr, i);
    }

    int getAutoSizeTextType() {
        return this.mAutoSizeTextHelper.getAutoSizeTextType();
    }

    int getAutoSizeStepGranularity() {
        return this.mAutoSizeTextHelper.getAutoSizeStepGranularity();
    }

    int getAutoSizeMinTextSize() {
        return this.mAutoSizeTextHelper.getAutoSizeMinTextSize();
    }

    int getAutoSizeMaxTextSize() {
        return this.mAutoSizeTextHelper.getAutoSizeMaxTextSize();
    }

    int[] getAutoSizeTextAvailableSizes() {
        return this.mAutoSizeTextHelper.getAutoSizeTextAvailableSizes();
    }
}
