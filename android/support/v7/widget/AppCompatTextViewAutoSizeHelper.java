package android.support.v7.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.support.annotation.RestrictTo;
import android.support.annotation.RestrictTo.Scope;
import android.support.v7.appcompat.R;
import android.text.Layout.Alignment;
import android.text.StaticLayout;
import android.text.StaticLayout.Builder;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.widget.TextView;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Hashtable;
import java.util.List;

class AppCompatTextViewAutoSizeHelper {
    private static final int DEFAULT_AUTO_SIZE_GRANULARITY_IN_PX = 1;
    private static final int DEFAULT_AUTO_SIZE_MAX_TEXT_SIZE_IN_SP = 112;
    private static final int DEFAULT_AUTO_SIZE_MIN_TEXT_SIZE_IN_SP = 12;
    private static final String TAG = "ACTVAutoSizeHelper";
    private static final RectF TEMP_RECTF = new RectF();
    static final float UNSET_AUTO_SIZE_UNIFORM_CONFIGURATION_VALUE = -1.0f;
    private static final int VERY_WIDE = 1048576;
    private static Hashtable<String, Method> sTextViewMethodByNameCache = new Hashtable();
    private float mAutoSizeMaxTextSizeInPx = UNSET_AUTO_SIZE_UNIFORM_CONFIGURATION_VALUE;
    private float mAutoSizeMinTextSizeInPx = UNSET_AUTO_SIZE_UNIFORM_CONFIGURATION_VALUE;
    private float mAutoSizeStepGranularityInPx = UNSET_AUTO_SIZE_UNIFORM_CONFIGURATION_VALUE;
    private int[] mAutoSizeTextSizesInPx = new int[0];
    private int mAutoSizeTextType = 0;
    private final Context mContext;
    private boolean mHasPresetAutoSizeValues = false;
    private boolean mNeedsAutoSizeText = false;
    private TextPaint mTempTextPaint;
    private final TextView mTextView;

    AppCompatTextViewAutoSizeHelper(TextView textView) {
        this.mTextView = textView;
        this.mContext = this.mTextView.getContext();
    }

    void loadFromAttributes(AttributeSet attributeSet, int i) {
        attributeSet = this.mContext.obtainStyledAttributes(attributeSet, R.styleable.AppCompatTextView, i, 0);
        if (attributeSet.hasValue(R.styleable.AppCompatTextView_autoSizeTextType) != 0) {
            this.mAutoSizeTextType = attributeSet.getInt(R.styleable.AppCompatTextView_autoSizeTextType, 0);
        }
        i = attributeSet.hasValue(R.styleable.AppCompatTextView_autoSizeStepGranularity) != 0 ? attributeSet.getDimension(R.styleable.AppCompatTextView_autoSizeStepGranularity, UNSET_AUTO_SIZE_UNIFORM_CONFIGURATION_VALUE) : -1082130432;
        float dimension = attributeSet.hasValue(R.styleable.AppCompatTextView_autoSizeMinTextSize) ? attributeSet.getDimension(R.styleable.AppCompatTextView_autoSizeMinTextSize, UNSET_AUTO_SIZE_UNIFORM_CONFIGURATION_VALUE) : UNSET_AUTO_SIZE_UNIFORM_CONFIGURATION_VALUE;
        float dimension2 = attributeSet.hasValue(R.styleable.AppCompatTextView_autoSizeMaxTextSize) ? attributeSet.getDimension(R.styleable.AppCompatTextView_autoSizeMaxTextSize, UNSET_AUTO_SIZE_UNIFORM_CONFIGURATION_VALUE) : UNSET_AUTO_SIZE_UNIFORM_CONFIGURATION_VALUE;
        if (attributeSet.hasValue(R.styleable.AppCompatTextView_autoSizePresetSizes)) {
            int resourceId = attributeSet.getResourceId(R.styleable.AppCompatTextView_autoSizePresetSizes, 0);
            if (resourceId > 0) {
                TypedArray obtainTypedArray = attributeSet.getResources().obtainTypedArray(resourceId);
                setupAutoSizeUniformPresetSizes(obtainTypedArray);
                obtainTypedArray.recycle();
            }
        }
        attributeSet.recycle();
        if (supportsAutoSizeText() == null) {
            this.mAutoSizeTextType = 0;
        } else if (this.mAutoSizeTextType == 1) {
            if (this.mHasPresetAutoSizeValues == null) {
                attributeSet = this.mContext.getResources().getDisplayMetrics();
                if (dimension == UNSET_AUTO_SIZE_UNIFORM_CONFIGURATION_VALUE) {
                    dimension = TypedValue.applyDimension(2, 12.0f, attributeSet);
                }
                if (dimension2 == UNSET_AUTO_SIZE_UNIFORM_CONFIGURATION_VALUE) {
                    dimension2 = TypedValue.applyDimension(2, 112.0f, attributeSet);
                }
                if (i == -1082130432) {
                    i = 1065353216;
                }
                validateAndSetAutoSizeTextTypeUniformConfiguration(dimension, dimension2, i);
            }
            setupAutoSizeText();
        }
    }

    @RestrictTo({Scope.LIBRARY_GROUP})
    void setAutoSizeTextTypeWithDefaults(int i) {
        if (supportsAutoSizeText()) {
            switch (i) {
                case 0:
                    clearAutoSizeConfiguration();
                    return;
                case 1:
                    i = this.mContext.getResources().getDisplayMetrics();
                    validateAndSetAutoSizeTextTypeUniformConfiguration(TypedValue.applyDimension(2, 12.0f, i), TypedValue.applyDimension(2, 112.0f, i), 1.0f);
                    if (setupAutoSizeText() != 0) {
                        autoSizeText();
                        return;
                    }
                    break;
                default:
                    StringBuilder stringBuilder = new StringBuilder("Unknown auto-size text type: ");
                    stringBuilder.append(i);
                    throw new IllegalArgumentException(stringBuilder.toString());
            }
        }
    }

    @RestrictTo({Scope.LIBRARY_GROUP})
    void setAutoSizeTextTypeUniformWithConfiguration(int i, int i2, int i3, int i4) throws IllegalArgumentException {
        if (supportsAutoSizeText()) {
            DisplayMetrics displayMetrics = this.mContext.getResources().getDisplayMetrics();
            validateAndSetAutoSizeTextTypeUniformConfiguration(TypedValue.applyDimension(i4, (float) i, displayMetrics), TypedValue.applyDimension(i4, (float) i2, displayMetrics), TypedValue.applyDimension(i4, (float) i3, displayMetrics));
            if (setupAutoSizeText() != 0) {
                autoSizeText();
            }
        }
    }

    @RestrictTo({Scope.LIBRARY_GROUP})
    void setAutoSizeTextTypeUniformWithPresetSizes(@NonNull int[] iArr, int i) throws IllegalArgumentException {
        if (supportsAutoSizeText()) {
            int i2 = 0;
            int length = iArr.length;
            if (length > 0) {
                int[] iArr2 = new int[length];
                if (i == 0) {
                    iArr2 = Arrays.copyOf(iArr, length);
                } else {
                    DisplayMetrics displayMetrics = this.mContext.getResources().getDisplayMetrics();
                    while (i2 < length) {
                        iArr2[i2] = Math.round(TypedValue.applyDimension(i, (float) iArr[i2], displayMetrics));
                        i2++;
                    }
                }
                this.mAutoSizeTextSizesInPx = cleanupAutoSizePresetSizes(iArr2);
                if (setupAutoSizeUniformPresetSizesConfiguration() == 0) {
                    StringBuilder stringBuilder = new StringBuilder("None of the preset sizes is valid: ");
                    stringBuilder.append(Arrays.toString(iArr));
                    throw new IllegalArgumentException(stringBuilder.toString());
                }
            }
            this.mHasPresetAutoSizeValues = false;
            if (setupAutoSizeText() != null) {
                autoSizeText();
            }
        }
    }

    @RestrictTo({Scope.LIBRARY_GROUP})
    int getAutoSizeTextType() {
        return this.mAutoSizeTextType;
    }

    @RestrictTo({Scope.LIBRARY_GROUP})
    int getAutoSizeStepGranularity() {
        return Math.round(this.mAutoSizeStepGranularityInPx);
    }

    @RestrictTo({Scope.LIBRARY_GROUP})
    int getAutoSizeMinTextSize() {
        return Math.round(this.mAutoSizeMinTextSizeInPx);
    }

    @RestrictTo({Scope.LIBRARY_GROUP})
    int getAutoSizeMaxTextSize() {
        return Math.round(this.mAutoSizeMaxTextSizeInPx);
    }

    @RestrictTo({Scope.LIBRARY_GROUP})
    int[] getAutoSizeTextAvailableSizes() {
        return this.mAutoSizeTextSizesInPx;
    }

    private void setupAutoSizeUniformPresetSizes(TypedArray typedArray) {
        int length = typedArray.length();
        int[] iArr = new int[length];
        if (length > 0) {
            for (int i = 0; i < length; i++) {
                iArr[i] = typedArray.getDimensionPixelSize(i, -1);
            }
            this.mAutoSizeTextSizesInPx = cleanupAutoSizePresetSizes(iArr);
            setupAutoSizeUniformPresetSizesConfiguration();
        }
    }

    private boolean setupAutoSizeUniformPresetSizesConfiguration() {
        int length = this.mAutoSizeTextSizesInPx.length;
        this.mHasPresetAutoSizeValues = length > 0;
        if (this.mHasPresetAutoSizeValues) {
            this.mAutoSizeTextType = 1;
            this.mAutoSizeMinTextSizeInPx = (float) this.mAutoSizeTextSizesInPx[0];
            this.mAutoSizeMaxTextSizeInPx = (float) this.mAutoSizeTextSizesInPx[length - 1];
            this.mAutoSizeStepGranularityInPx = UNSET_AUTO_SIZE_UNIFORM_CONFIGURATION_VALUE;
        }
        return this.mHasPresetAutoSizeValues;
    }

    private int[] cleanupAutoSizePresetSizes(int[] iArr) {
        if (r0 == 0) {
            return iArr;
        }
        Arrays.sort(iArr);
        List arrayList = new ArrayList();
        int i = 0;
        for (int i2 : iArr) {
            if (i2 > 0 && Collections.binarySearch(arrayList, Integer.valueOf(i2)) < 0) {
                arrayList.add(Integer.valueOf(i2));
            }
        }
        if (r0 == arrayList.size()) {
            return iArr;
        }
        iArr = arrayList.size();
        int[] iArr2 = new int[iArr];
        while (i < iArr) {
            iArr2[i] = ((Integer) arrayList.get(i)).intValue();
            i++;
        }
        return iArr2;
    }

    private void validateAndSetAutoSizeTextTypeUniformConfiguration(float f, float f2, float f3) throws IllegalArgumentException {
        if (f <= 0.0f) {
            f3 = new StringBuilder("Minimum auto-size text size (");
            f3.append(f);
            f3.append("px) is less or equal to (0px)");
            throw new IllegalArgumentException(f3.toString());
        } else if (f2 <= f) {
            StringBuilder stringBuilder = new StringBuilder("Maximum auto-size text size (");
            stringBuilder.append(f2);
            stringBuilder.append("px) is less or equal to minimum auto-size text size (");
            stringBuilder.append(f);
            stringBuilder.append("px)");
            throw new IllegalArgumentException(stringBuilder.toString());
        } else if (f3 <= 0.0f) {
            f2 = new StringBuilder("The auto-size step granularity (");
            f2.append(f3);
            f2.append("px) is less or equal to (0px)");
            throw new IllegalArgumentException(f2.toString());
        } else {
            this.mAutoSizeTextType = 1;
            this.mAutoSizeMinTextSizeInPx = f;
            this.mAutoSizeMaxTextSizeInPx = f2;
            this.mAutoSizeStepGranularityInPx = f3;
            this.mHasPresetAutoSizeValues = false;
        }
    }

    private boolean setupAutoSizeText() {
        int i = 0;
        if (supportsAutoSizeText() && this.mAutoSizeTextType == 1) {
            if (!this.mHasPresetAutoSizeValues || this.mAutoSizeTextSizesInPx.length == 0) {
                float round = (float) Math.round(this.mAutoSizeMinTextSizeInPx);
                int i2 = 1;
                while (Math.round(this.mAutoSizeStepGranularityInPx + round) <= Math.round(this.mAutoSizeMaxTextSizeInPx)) {
                    i2++;
                    round += this.mAutoSizeStepGranularityInPx;
                }
                int[] iArr = new int[i2];
                float f = this.mAutoSizeMinTextSizeInPx;
                while (i < i2) {
                    iArr[i] = Math.round(f);
                    f += this.mAutoSizeStepGranularityInPx;
                    i++;
                }
                this.mAutoSizeTextSizesInPx = cleanupAutoSizePresetSizes(iArr);
            }
            this.mNeedsAutoSizeText = true;
        } else {
            this.mNeedsAutoSizeText = false;
        }
        return this.mNeedsAutoSizeText;
    }

    @RestrictTo({Scope.LIBRARY_GROUP})
    void autoSizeText() {
        if (isAutoSizeEnabled()) {
            if (this.mNeedsAutoSizeText) {
                if (this.mTextView.getMeasuredHeight() > 0) {
                    if (this.mTextView.getMeasuredWidth() > 0) {
                        int i;
                        if (((Boolean) invokeAndReturnWithDefault(this.mTextView, "getHorizontallyScrolling", Boolean.valueOf(false))).booleanValue()) {
                            i = 1048576;
                        } else {
                            i = (this.mTextView.getMeasuredWidth() - this.mTextView.getTotalPaddingLeft()) - this.mTextView.getTotalPaddingRight();
                        }
                        int height = (this.mTextView.getHeight() - this.mTextView.getCompoundPaddingBottom()) - this.mTextView.getCompoundPaddingTop();
                        if (i > 0) {
                            if (height > 0) {
                                synchronized (TEMP_RECTF) {
                                    TEMP_RECTF.setEmpty();
                                    TEMP_RECTF.right = (float) i;
                                    TEMP_RECTF.bottom = (float) height;
                                    float findLargestTextSizeWhichFits = (float) findLargestTextSizeWhichFits(TEMP_RECTF);
                                    if (findLargestTextSizeWhichFits != this.mTextView.getTextSize()) {
                                        setTextSizeInternal(0, findLargestTextSizeWhichFits);
                                    }
                                }
                            }
                        }
                        return;
                    }
                }
                return;
            }
            this.mNeedsAutoSizeText = true;
        }
    }

    private void clearAutoSizeConfiguration() {
        this.mAutoSizeTextType = 0;
        this.mAutoSizeMinTextSizeInPx = UNSET_AUTO_SIZE_UNIFORM_CONFIGURATION_VALUE;
        this.mAutoSizeMaxTextSizeInPx = UNSET_AUTO_SIZE_UNIFORM_CONFIGURATION_VALUE;
        this.mAutoSizeStepGranularityInPx = UNSET_AUTO_SIZE_UNIFORM_CONFIGURATION_VALUE;
        this.mAutoSizeTextSizesInPx = new int[0];
        this.mNeedsAutoSizeText = false;
    }

    @RestrictTo({Scope.LIBRARY_GROUP})
    void setTextSizeInternal(int i, float f) {
        Resources system;
        if (this.mContext == null) {
            system = Resources.getSystem();
        } else {
            system = this.mContext.getResources();
        }
        setRawTextSize(TypedValue.applyDimension(i, f, system.getDisplayMetrics()));
    }

    private void setRawTextSize(float r4) {
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
        r3 = this;
        r0 = r3.mTextView;
        r0 = r0.getPaint();
        r0 = r0.getTextSize();
        r0 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1));
        if (r0 == 0) goto L_0x0051;
    L_0x000e:
        r0 = r3.mTextView;
        r0 = r0.getPaint();
        r0.setTextSize(r4);
        r4 = android.os.Build.VERSION.SDK_INT;
        r0 = 18;
        r1 = 0;
        if (r4 < r0) goto L_0x0025;
    L_0x001e:
        r4 = r3.mTextView;
        r4 = r4.isInLayout();
        goto L_0x0026;
    L_0x0025:
        r4 = r1;
    L_0x0026:
        r0 = r3.mTextView;
        r0 = r0.getLayout();
        if (r0 == 0) goto L_0x0051;
    L_0x002e:
        r3.mNeedsAutoSizeText = r1;
        r0 = "nullLayouts";	 Catch:{ Exception -> 0x003f }
        r0 = r3.getTextViewMethod(r0);	 Catch:{ Exception -> 0x003f }
        if (r0 == 0) goto L_0x003f;	 Catch:{ Exception -> 0x003f }
    L_0x0038:
        r2 = r3.mTextView;	 Catch:{ Exception -> 0x003f }
        r1 = new java.lang.Object[r1];	 Catch:{ Exception -> 0x003f }
        r0.invoke(r2, r1);	 Catch:{ Exception -> 0x003f }
    L_0x003f:
        if (r4 != 0) goto L_0x0047;
    L_0x0041:
        r4 = r3.mTextView;
        r4.requestLayout();
        goto L_0x004c;
    L_0x0047:
        r4 = r3.mTextView;
        r4.forceLayout();
    L_0x004c:
        r4 = r3.mTextView;
        r4.invalidate();
    L_0x0051:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.AppCompatTextViewAutoSizeHelper.setRawTextSize(float):void");
    }

    private int findLargestTextSizeWhichFits(RectF rectF) {
        int length = this.mAutoSizeTextSizesInPx.length;
        if (length == 0) {
            throw new IllegalStateException("No available text sizes to choose from.");
        }
        int i = 0;
        int i2 = 1;
        length--;
        while (true) {
            int i3 = i2;
            i2 = i;
            i = i3;
            while (i <= length) {
                i2 = (i + length) / 2;
                if (suggestedSizeFitsInSpace(this.mAutoSizeTextSizesInPx[i2], rectF)) {
                    i2++;
                } else {
                    i2--;
                    length = i2;
                }
            }
            return this.mAutoSizeTextSizesInPx[i2];
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean suggestedSizeFitsInSpace(int r6, android.graphics.RectF r7) {
        /*
        r5 = this;
        r0 = r5.mTextView;
        r0 = r0.getText();
        r1 = android.os.Build.VERSION.SDK_INT;
        r2 = -1;
        r3 = 16;
        if (r1 < r3) goto L_0x0014;
    L_0x000d:
        r1 = r5.mTextView;
        r1 = r1.getMaxLines();
        goto L_0x0015;
    L_0x0014:
        r1 = r2;
    L_0x0015:
        r3 = r5.mTempTextPaint;
        if (r3 != 0) goto L_0x0021;
    L_0x0019:
        r3 = new android.text.TextPaint;
        r3.<init>();
        r5.mTempTextPaint = r3;
        goto L_0x0026;
    L_0x0021:
        r3 = r5.mTempTextPaint;
        r3.reset();
    L_0x0026:
        r3 = r5.mTempTextPaint;
        r4 = r5.mTextView;
        r4 = r4.getPaint();
        r3.set(r4);
        r3 = r5.mTempTextPaint;
        r6 = (float) r6;
        r3.setTextSize(r6);
        r6 = r5.mTextView;
        r3 = "getLayoutAlignment";
        r4 = android.text.Layout.Alignment.ALIGN_NORMAL;
        r6 = r5.invokeAndReturnWithDefault(r6, r3, r4);
        r6 = (android.text.Layout.Alignment) r6;
        r3 = android.os.Build.VERSION.SDK_INT;
        r4 = 23;
        if (r3 < r4) goto L_0x0054;
    L_0x0049:
        r3 = r7.right;
        r3 = java.lang.Math.round(r3);
        r6 = r5.createStaticLayoutForMeasuring(r0, r6, r3, r1);
        goto L_0x005e;
    L_0x0054:
        r3 = r7.right;
        r3 = java.lang.Math.round(r3);
        r6 = r5.createStaticLayoutForMeasuringPre23(r0, r6, r3);
    L_0x005e:
        r3 = 0;
        r4 = 1;
        if (r1 == r2) goto L_0x0078;
    L_0x0062:
        r2 = r6.getLineCount();
        if (r2 > r1) goto L_0x0077;
    L_0x0068:
        r1 = r6.getLineCount();
        r1 = r1 - r4;
        r1 = r6.getLineEnd(r1);
        r0 = r0.length();
        if (r1 == r0) goto L_0x0078;
    L_0x0077:
        return r3;
    L_0x0078:
        r6 = r6.getHeight();
        r6 = (float) r6;
        r7 = r7.bottom;
        r6 = (r6 > r7 ? 1 : (r6 == r7 ? 0 : -1));
        if (r6 <= 0) goto L_0x0084;
    L_0x0083:
        return r3;
    L_0x0084:
        return r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.AppCompatTextViewAutoSizeHelper.suggestedSizeFitsInSpace(int, android.graphics.RectF):boolean");
    }

    @TargetApi(23)
    private StaticLayout createStaticLayoutForMeasuring(CharSequence charSequence, Alignment alignment, int i, int i2) {
        TextDirectionHeuristic textDirectionHeuristic = (TextDirectionHeuristic) invokeAndReturnWithDefault(this.mTextView, "getTextDirectionHeuristic", TextDirectionHeuristics.FIRSTSTRONG_LTR);
        charSequence = Builder.obtain(charSequence, 0, charSequence.length(), this.mTempTextPaint, i).setAlignment(alignment).setLineSpacing(this.mTextView.getLineSpacingExtra(), this.mTextView.getLineSpacingMultiplier()).setIncludePad(this.mTextView.getIncludeFontPadding()).setBreakStrategy(this.mTextView.getBreakStrategy()).setHyphenationFrequency(this.mTextView.getHyphenationFrequency());
        if (i2 == -1) {
            i2 = Integer.MAX_VALUE;
        }
        return charSequence.setMaxLines(i2).setTextDirection(textDirectionHeuristic).build();
    }

    @TargetApi(14)
    private StaticLayout createStaticLayoutForMeasuringPre23(CharSequence charSequence, Alignment alignment, int i) {
        float lineSpacingMultiplier;
        float lineSpacingExtra;
        boolean includeFontPadding;
        if (VERSION.SDK_INT >= 16) {
            lineSpacingMultiplier = this.mTextView.getLineSpacingMultiplier();
            lineSpacingExtra = this.mTextView.getLineSpacingExtra();
            includeFontPadding = this.mTextView.getIncludeFontPadding();
        } else {
            lineSpacingMultiplier = ((Float) invokeAndReturnWithDefault(this.mTextView, "getLineSpacingMultiplier", Float.valueOf(1.0f))).floatValue();
            lineSpacingExtra = ((Float) invokeAndReturnWithDefault(this.mTextView, "getLineSpacingExtra", Float.valueOf(0.0f))).floatValue();
            includeFontPadding = ((Boolean) invokeAndReturnWithDefault(this.mTextView, "getIncludeFontPadding", Boolean.valueOf(true))).booleanValue();
        }
        return new StaticLayout(charSequence, this.mTempTextPaint, i, alignment, lineSpacingMultiplier, lineSpacingExtra, includeFontPadding);
    }

    private <T> T invokeAndReturnWithDefault(@android.support.annotation.NonNull java.lang.Object r3, @android.support.annotation.NonNull java.lang.String r4, @android.support.annotation.NonNull T r5) {
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
        r0 = r2.getTextViewMethod(r4);	 Catch:{ Exception -> 0x000e }
        r1 = 0;	 Catch:{ Exception -> 0x000e }
        r1 = new java.lang.Object[r1];	 Catch:{ Exception -> 0x000e }
        r3 = r0.invoke(r3, r1);	 Catch:{ Exception -> 0x000e }
        goto L_0x001e;
    L_0x000c:
        r3 = move-exception;
        goto L_0x001f;
    L_0x000e:
        r3 = new java.lang.StringBuilder;	 Catch:{ all -> 0x000c }
        r0 = "Failed to invoke TextView#";	 Catch:{ all -> 0x000c }
        r3.<init>(r0);	 Catch:{ all -> 0x000c }
        r3.append(r4);	 Catch:{ all -> 0x000c }
        r4 = "() method";	 Catch:{ all -> 0x000c }
        r3.append(r4);	 Catch:{ all -> 0x000c }
        r3 = r5;
    L_0x001e:
        return r3;
    L_0x001f:
        throw r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.AppCompatTextViewAutoSizeHelper.invokeAndReturnWithDefault(java.lang.Object, java.lang.String, java.lang.Object):T");
    }

    @android.support.annotation.Nullable
    private java.lang.reflect.Method getTextViewMethod(@android.support.annotation.NonNull java.lang.String r3) {
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
        r0 = sTextViewMethodByNameCache;	 Catch:{ Exception -> 0x001f }
        r0 = r0.get(r3);	 Catch:{ Exception -> 0x001f }
        r0 = (java.lang.reflect.Method) r0;	 Catch:{ Exception -> 0x001f }
        if (r0 != 0) goto L_0x001e;	 Catch:{ Exception -> 0x001f }
    L_0x000a:
        r0 = android.widget.TextView.class;	 Catch:{ Exception -> 0x001f }
        r1 = 0;	 Catch:{ Exception -> 0x001f }
        r1 = new java.lang.Class[r1];	 Catch:{ Exception -> 0x001f }
        r0 = r0.getDeclaredMethod(r3, r1);	 Catch:{ Exception -> 0x001f }
        if (r0 == 0) goto L_0x001e;	 Catch:{ Exception -> 0x001f }
    L_0x0015:
        r1 = 1;	 Catch:{ Exception -> 0x001f }
        r0.setAccessible(r1);	 Catch:{ Exception -> 0x001f }
        r1 = sTextViewMethodByNameCache;	 Catch:{ Exception -> 0x001f }
        r1.put(r3, r0);	 Catch:{ Exception -> 0x001f }
    L_0x001e:
        return r0;
    L_0x001f:
        r0 = new java.lang.StringBuilder;
        r1 = "Failed to retrieve TextView#";
        r0.<init>(r1);
        r0.append(r3);
        r3 = "() method";
        r0.append(r3);
        r3 = 0;
        return r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.AppCompatTextViewAutoSizeHelper.getTextViewMethod(java.lang.String):java.lang.reflect.Method");
    }

    @RestrictTo({Scope.LIBRARY_GROUP})
    boolean isAutoSizeEnabled() {
        return supportsAutoSizeText() && this.mAutoSizeTextType != 0;
    }

    private boolean supportsAutoSizeText() {
        return !(this.mTextView instanceof AppCompatEditText);
    }
}
