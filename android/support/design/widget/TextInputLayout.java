package android.support.design.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.ClassLoaderCreator;
import android.os.Parcelable.Creator;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.annotation.StyleRes;
import android.support.annotation.VisibleForTesting;
import android.support.design.R;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v4.view.AbsSavedState;
import android.support.v4.view.AccessibilityDelegateCompat;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.v4.widget.Space;
import android.support.v4.widget.TextViewCompat;
import android.support.v7.content.res.AppCompatResources;
import android.support.v7.widget.AppCompatDrawableManager;
import android.support.v7.widget.DrawableUtils;
import android.support.v7.widget.TintTypedArray;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.PasswordTransformationMethod;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStructure;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.AccelerateInterpolator;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.alipay.sdk.util.h;

public class TextInputLayout extends LinearLayout {
    private static final int ANIMATION_DURATION = 200;
    private static final int INVALID_MAX_LENGTH = -1;
    private static final String LOG_TAG = "TextInputLayout";
    private ValueAnimator mAnimator;
    final CollapsingTextHelper mCollapsingTextHelper;
    boolean mCounterEnabled;
    private int mCounterMaxLength;
    private int mCounterOverflowTextAppearance;
    private boolean mCounterOverflowed;
    private int mCounterTextAppearance;
    private TextView mCounterView;
    private ColorStateList mDefaultTextColor;
    EditText mEditText;
    private CharSequence mError;
    private boolean mErrorEnabled;
    private boolean mErrorShown;
    private int mErrorTextAppearance;
    TextView mErrorView;
    private ColorStateList mFocusedTextColor;
    private boolean mHasPasswordToggleTintList;
    private boolean mHasPasswordToggleTintMode;
    private boolean mHasReconstructedEditTextBackground;
    private CharSequence mHint;
    private boolean mHintAnimationEnabled;
    private boolean mHintEnabled;
    private boolean mHintExpanded;
    private boolean mInDrawableStateChanged;
    private LinearLayout mIndicatorArea;
    private int mIndicatorsAdded;
    private final FrameLayout mInputFrame;
    private Drawable mOriginalEditTextEndDrawable;
    private CharSequence mOriginalHint;
    private CharSequence mPasswordToggleContentDesc;
    private Drawable mPasswordToggleDrawable;
    private Drawable mPasswordToggleDummyDrawable;
    private boolean mPasswordToggleEnabled;
    private ColorStateList mPasswordToggleTintList;
    private Mode mPasswordToggleTintMode;
    private CheckableImageButton mPasswordToggleView;
    private boolean mPasswordToggledVisible;
    private boolean mRestoringSavedState;
    private Paint mTmpPaint;
    private final Rect mTmpRect;
    private Typeface mTypeface;

    static class SavedState extends AbsSavedState {
        public static final Creator<SavedState> CREATOR = new ClassLoaderCreator<SavedState>() {
            public final SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            public final SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel, null);
            }

            public final SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        CharSequence error;
        boolean isPasswordToggledVisible;

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.error = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
            classLoader = true;
            if (parcel.readInt() != 1) {
                classLoader = null;
            }
            this.isPasswordToggledVisible = classLoader;
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            TextUtils.writeToParcel(this.error, parcel, i);
            parcel.writeInt(this.isPasswordToggledVisible);
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder("TextInputLayout.SavedState{");
            stringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
            stringBuilder.append(" error=");
            stringBuilder.append(this.error);
            stringBuilder.append(h.d);
            return stringBuilder.toString();
        }
    }

    private class TextInputAccessibilityDelegate extends AccessibilityDelegateCompat {
        TextInputAccessibilityDelegate() {
        }

        public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(view, accessibilityEvent);
            accessibilityEvent.setClassName(TextInputLayout.class.getSimpleName());
        }

        public void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            super.onPopulateAccessibilityEvent(view, accessibilityEvent);
            view = TextInputLayout.this.mCollapsingTextHelper.getText();
            if (!TextUtils.isEmpty(view)) {
                accessibilityEvent.getText().add(view);
            }
        }

        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
            accessibilityNodeInfoCompat.setClassName(TextInputLayout.class.getSimpleName());
            view = TextInputLayout.this.mCollapsingTextHelper.getText();
            if (!TextUtils.isEmpty(view)) {
                accessibilityNodeInfoCompat.setText(view);
            }
            if (TextInputLayout.this.mEditText != null) {
                accessibilityNodeInfoCompat.setLabelFor(TextInputLayout.this.mEditText);
            }
            view = TextInputLayout.this.mErrorView != null ? TextInputLayout.this.mErrorView.getText() : null;
            if (!TextUtils.isEmpty(view)) {
                accessibilityNodeInfoCompat.setContentInvalid(true);
                accessibilityNodeInfoCompat.setError(view);
            }
        }
    }

    public TextInputLayout(Context context) {
        this(context, null);
    }

    public TextInputLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TextInputLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        this.mTmpRect = new Rect();
        this.mCollapsingTextHelper = new CollapsingTextHelper(this);
        ThemeUtils.checkAppCompatTheme(context);
        setOrientation(1);
        setWillNotDraw(false);
        setAddStatesFromChildren(true);
        this.mInputFrame = new FrameLayout(context);
        this.mInputFrame.setAddStatesFromChildren(true);
        addView(this.mInputFrame);
        this.mCollapsingTextHelper.setTextSizeInterpolator(AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR);
        this.mCollapsingTextHelper.setPositionInterpolator(new AccelerateInterpolator());
        this.mCollapsingTextHelper.setCollapsedTextGravity(8388659);
        context = TintTypedArray.obtainStyledAttributes(context, attributeSet, R.styleable.TextInputLayout, i, R.style.Widget_Design_TextInputLayout);
        this.mHintEnabled = context.getBoolean(R.styleable.TextInputLayout_hintEnabled, true);
        setHint(context.getText(R.styleable.TextInputLayout_android_hint));
        this.mHintAnimationEnabled = context.getBoolean(R.styleable.TextInputLayout_hintAnimationEnabled, true);
        if (context.hasValue(R.styleable.TextInputLayout_android_textColorHint) != null) {
            attributeSet = context.getColorStateList(R.styleable.TextInputLayout_android_textColorHint);
            this.mFocusedTextColor = attributeSet;
            this.mDefaultTextColor = attributeSet;
        }
        if (context.getResourceId(R.styleable.TextInputLayout_hintTextAppearance, -1) != -1) {
            setHintTextAppearance(context.getResourceId(R.styleable.TextInputLayout_hintTextAppearance, 0));
        }
        this.mErrorTextAppearance = context.getResourceId(R.styleable.TextInputLayout_errorTextAppearance, 0);
        attributeSet = context.getBoolean(R.styleable.TextInputLayout_errorEnabled, false);
        boolean z = context.getBoolean(R.styleable.TextInputLayout_counterEnabled, false);
        setCounterMaxLength(context.getInt(R.styleable.TextInputLayout_counterMaxLength, -1));
        this.mCounterTextAppearance = context.getResourceId(R.styleable.TextInputLayout_counterTextAppearance, 0);
        this.mCounterOverflowTextAppearance = context.getResourceId(R.styleable.TextInputLayout_counterOverflowTextAppearance, 0);
        this.mPasswordToggleEnabled = context.getBoolean(R.styleable.TextInputLayout_passwordToggleEnabled, false);
        this.mPasswordToggleDrawable = context.getDrawable(R.styleable.TextInputLayout_passwordToggleDrawable);
        this.mPasswordToggleContentDesc = context.getText(R.styleable.TextInputLayout_passwordToggleContentDescription);
        if (context.hasValue(R.styleable.TextInputLayout_passwordToggleTint)) {
            this.mHasPasswordToggleTintList = true;
            this.mPasswordToggleTintList = context.getColorStateList(R.styleable.TextInputLayout_passwordToggleTint);
        }
        if (context.hasValue(R.styleable.TextInputLayout_passwordToggleTintMode)) {
            this.mHasPasswordToggleTintMode = true;
            this.mPasswordToggleTintMode = ViewUtils.parseTintMode(context.getInt(R.styleable.TextInputLayout_passwordToggleTintMode, -1), null);
        }
        context.recycle();
        setErrorEnabled(attributeSet);
        setCounterEnabled(z);
        applyPasswordToggleTint();
        if (ViewCompat.getImportantForAccessibility(this) == null) {
            ViewCompat.setImportantForAccessibility(this, 1);
        }
        ViewCompat.setAccessibilityDelegate(this, new TextInputAccessibilityDelegate());
    }

    public void addView(View view, int i, LayoutParams layoutParams) {
        if (view instanceof EditText) {
            i = new FrameLayout.LayoutParams(layoutParams);
            i.gravity = 16 | (i.gravity & -113);
            this.mInputFrame.addView(view, i);
            this.mInputFrame.setLayoutParams(layoutParams);
            updateInputLayoutMargins();
            setEditText((EditText) view);
            return;
        }
        super.addView(view, i, layoutParams);
    }

    public void setTypeface(@Nullable Typeface typeface) {
        if ((this.mTypeface != null && !this.mTypeface.equals(typeface)) || (this.mTypeface == null && typeface != null)) {
            this.mTypeface = typeface;
            this.mCollapsingTextHelper.setTypefaces(typeface);
            if (this.mCounterView != null) {
                this.mCounterView.setTypeface(typeface);
            }
            if (this.mErrorView != null) {
                this.mErrorView.setTypeface(typeface);
            }
        }
    }

    @NonNull
    public Typeface getTypeface() {
        return this.mTypeface;
    }

    public void dispatchProvideAutofillStructure(ViewStructure viewStructure, int i) {
        if (this.mOriginalHint != null) {
            if (this.mEditText != null) {
                CharSequence hint = this.mEditText.getHint();
                this.mEditText.setHint(this.mOriginalHint);
                try {
                    super.dispatchProvideAutofillStructure(viewStructure, i);
                    return;
                } finally {
                    this.mEditText.setHint(hint);
                }
            }
        }
        super.dispatchProvideAutofillStructure(viewStructure, i);
    }

    private void setEditText(EditText editText) {
        if (this.mEditText != null) {
            throw new IllegalArgumentException("We already have an EditText, can only have one");
        }
        this.mEditText = editText;
        if (hasPasswordTransformation() == null) {
            this.mCollapsingTextHelper.setTypefaces(this.mEditText.getTypeface());
        }
        this.mCollapsingTextHelper.setExpandedTextSize(this.mEditText.getTextSize());
        editText = this.mEditText.getGravity();
        this.mCollapsingTextHelper.setCollapsedTextGravity(48 | (editText & -113));
        this.mCollapsingTextHelper.setExpandedTextGravity(editText);
        this.mEditText.addTextChangedListener(new TextWatcher() {
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public void afterTextChanged(Editable editable) {
                TextInputLayout.this.updateLabelState(TextInputLayout.this.mRestoringSavedState ^ 1);
                if (TextInputLayout.this.mCounterEnabled) {
                    TextInputLayout.this.updateCounter(editable.length());
                }
            }
        });
        if (this.mDefaultTextColor == null) {
            this.mDefaultTextColor = this.mEditText.getHintTextColors();
        }
        if (!(this.mHintEnabled == null || TextUtils.isEmpty(this.mHint) == null)) {
            this.mOriginalHint = this.mEditText.getHint();
            setHint(this.mOriginalHint);
            this.mEditText.setHint(null);
        }
        if (this.mCounterView != null) {
            updateCounter(this.mEditText.getText().length());
        }
        if (this.mIndicatorArea != null) {
            adjustIndicatorPadding();
        }
        updatePasswordToggleView();
        updateLabelState(null, true);
    }

    private void updateInputLayoutMargins() {
        int i;
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.mInputFrame.getLayoutParams();
        if (this.mHintEnabled) {
            if (this.mTmpPaint == null) {
                this.mTmpPaint = new Paint();
            }
            this.mTmpPaint.setTypeface(this.mCollapsingTextHelper.getCollapsedTypeface());
            this.mTmpPaint.setTextSize(this.mCollapsingTextHelper.getCollapsedTextSize());
            i = (int) (-this.mTmpPaint.ascent());
        } else {
            i = 0;
        }
        if (i != layoutParams.topMargin) {
            layoutParams.topMargin = i;
            this.mInputFrame.requestLayout();
        }
    }

    void updateLabelState(boolean z) {
        updateLabelState(z, false);
    }

    void updateLabelState(boolean z, boolean z2) {
        boolean isEnabled = isEnabled();
        int i = (this.mEditText == null || TextUtils.isEmpty(this.mEditText.getText())) ? 0 : 1;
        boolean arrayContains = arrayContains(getDrawableState(), 16842908);
        int isEmpty = 1 ^ TextUtils.isEmpty(getError());
        if (this.mDefaultTextColor != null) {
            this.mCollapsingTextHelper.setExpandedTextColor(this.mDefaultTextColor);
        }
        if (isEnabled && this.mCounterOverflowed && this.mCounterView != null) {
            this.mCollapsingTextHelper.setCollapsedTextColor(this.mCounterView.getTextColors());
        } else if (isEnabled && arrayContains && this.mFocusedTextColor != null) {
            this.mCollapsingTextHelper.setCollapsedTextColor(this.mFocusedTextColor);
        } else if (this.mDefaultTextColor != null) {
            this.mCollapsingTextHelper.setCollapsedTextColor(this.mDefaultTextColor);
        }
        if (i == 0) {
            if (isEnabled()) {
                if (!arrayContains) {
                    if (isEmpty != 0) {
                    }
                }
            }
            if (z2 || !this.mHintExpanded) {
                expandHint(z);
            }
            return;
        }
        if (!z2) {
            if (this.mHintExpanded) {
            }
            return;
        }
        collapseHint(z);
    }

    @Nullable
    public EditText getEditText() {
        return this.mEditText;
    }

    public void setHint(@Nullable CharSequence charSequence) {
        if (this.mHintEnabled) {
            setHintInternal(charSequence);
            sendAccessibilityEvent(2048);
        }
    }

    private void setHintInternal(CharSequence charSequence) {
        this.mHint = charSequence;
        this.mCollapsingTextHelper.setText(charSequence);
    }

    @Nullable
    public CharSequence getHint() {
        return this.mHintEnabled ? this.mHint : null;
    }

    public void setHintEnabled(boolean z) {
        if (z != this.mHintEnabled) {
            this.mHintEnabled = z;
            z = this.mEditText.getHint();
            if (!this.mHintEnabled) {
                if (!TextUtils.isEmpty(this.mHint) && TextUtils.isEmpty(z)) {
                    this.mEditText.setHint(this.mHint);
                }
                setHintInternal(null);
            } else if (!TextUtils.isEmpty(z)) {
                if (TextUtils.isEmpty(this.mHint)) {
                    setHint(z);
                }
                this.mEditText.setHint(null);
            }
            if (this.mEditText) {
                updateInputLayoutMargins();
            }
        }
    }

    public boolean isHintEnabled() {
        return this.mHintEnabled;
    }

    public void setHintTextAppearance(@StyleRes int i) {
        this.mCollapsingTextHelper.setCollapsedTextAppearance(i);
        this.mFocusedTextColor = this.mCollapsingTextHelper.getCollapsedTextColor();
        if (this.mEditText != 0) {
            updateLabelState(0);
            updateInputLayoutMargins();
        }
    }

    private void addIndicator(TextView textView, int i) {
        if (this.mIndicatorArea == null) {
            this.mIndicatorArea = new LinearLayout(getContext());
            this.mIndicatorArea.setOrientation(0);
            addView(this.mIndicatorArea, -1, -2);
            this.mIndicatorArea.addView(new Space(getContext()), new LinearLayout.LayoutParams(0, 0, 1.0f));
            if (this.mEditText != null) {
                adjustIndicatorPadding();
            }
        }
        this.mIndicatorArea.setVisibility(0);
        this.mIndicatorArea.addView(textView, i);
        this.mIndicatorsAdded++;
    }

    private void adjustIndicatorPadding() {
        ViewCompat.setPaddingRelative(this.mIndicatorArea, ViewCompat.getPaddingStart(this.mEditText), 0, ViewCompat.getPaddingEnd(this.mEditText), this.mEditText.getPaddingBottom());
    }

    private void removeIndicator(TextView textView) {
        if (this.mIndicatorArea != null) {
            this.mIndicatorArea.removeView(textView);
            textView = this.mIndicatorsAdded - 1;
            this.mIndicatorsAdded = textView;
            if (textView == null) {
                this.mIndicatorArea.setVisibility(8);
            }
        }
    }

    public void setErrorEnabled(boolean r6) {
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
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r5 = this;
        r0 = r5.mErrorEnabled;
        if (r0 == r6) goto L_0x008a;
    L_0x0004:
        r0 = r5.mErrorView;
        if (r0 == 0) goto L_0x0011;
    L_0x0008:
        r0 = r5.mErrorView;
        r0 = r0.animate();
        r0.cancel();
    L_0x0011:
        r0 = 0;
        if (r6 == 0) goto L_0x007b;
    L_0x0014:
        r1 = new android.support.v7.widget.AppCompatTextView;
        r2 = r5.getContext();
        r1.<init>(r2);
        r5.mErrorView = r1;
        r1 = r5.mErrorView;
        r2 = android.support.design.R.id.textinput_error;
        r1.setId(r2);
        r1 = r5.mTypeface;
        if (r1 == 0) goto L_0x0031;
    L_0x002a:
        r1 = r5.mErrorView;
        r2 = r5.mTypeface;
        r1.setTypeface(r2);
    L_0x0031:
        r1 = 1;
        r2 = r5.mErrorView;	 Catch:{ Exception -> 0x0051 }
        r3 = r5.mErrorTextAppearance;	 Catch:{ Exception -> 0x0051 }
        android.support.v4.widget.TextViewCompat.setTextAppearance(r2, r3);	 Catch:{ Exception -> 0x0051 }
        r2 = android.os.Build.VERSION.SDK_INT;	 Catch:{ Exception -> 0x0051 }
        r3 = 23;	 Catch:{ Exception -> 0x0051 }
        if (r2 < r3) goto L_0x004f;	 Catch:{ Exception -> 0x0051 }
    L_0x003f:
        r2 = r5.mErrorView;	 Catch:{ Exception -> 0x0051 }
        r2 = r2.getTextColors();	 Catch:{ Exception -> 0x0051 }
        r2 = r2.getDefaultColor();	 Catch:{ Exception -> 0x0051 }
        r3 = -65281; // 0xffffffffffff00ff float:NaN double:NaN;
        if (r2 != r3) goto L_0x004f;
    L_0x004e:
        goto L_0x0051;
    L_0x004f:
        r2 = r0;
        goto L_0x0052;
    L_0x0051:
        r2 = r1;
    L_0x0052:
        if (r2 == 0) goto L_0x006a;
    L_0x0054:
        r2 = r5.mErrorView;
        r3 = android.support.v7.appcompat.R.style.TextAppearance_AppCompat_Caption;
        android.support.v4.widget.TextViewCompat.setTextAppearance(r2, r3);
        r2 = r5.mErrorView;
        r3 = r5.getContext();
        r4 = android.support.v7.appcompat.R.color.error_color_material;
        r3 = android.support.v4.content.ContextCompat.getColor(r3, r4);
        r2.setTextColor(r3);
    L_0x006a:
        r2 = r5.mErrorView;
        r3 = 4;
        r2.setVisibility(r3);
        r2 = r5.mErrorView;
        android.support.v4.view.ViewCompat.setAccessibilityLiveRegion(r2, r1);
        r1 = r5.mErrorView;
        r5.addIndicator(r1, r0);
        goto L_0x0088;
    L_0x007b:
        r5.mErrorShown = r0;
        r5.updateEditTextBackground();
        r0 = r5.mErrorView;
        r5.removeIndicator(r0);
        r0 = 0;
        r5.mErrorView = r0;
    L_0x0088:
        r5.mErrorEnabled = r6;
    L_0x008a:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.design.widget.TextInputLayout.setErrorEnabled(boolean):void");
    }

    public void setErrorTextAppearance(@StyleRes int i) {
        this.mErrorTextAppearance = i;
        if (this.mErrorView != null) {
            TextViewCompat.setTextAppearance(this.mErrorView, i);
        }
    }

    public boolean isErrorEnabled() {
        return this.mErrorEnabled;
    }

    public void setError(@Nullable CharSequence charSequence) {
        boolean z = ViewCompat.isLaidOut(this) && isEnabled() && (this.mErrorView == null || !TextUtils.equals(this.mErrorView.getText(), charSequence));
        setError(charSequence, z);
    }

    private void setError(@Nullable final CharSequence charSequence, boolean z) {
        this.mError = charSequence;
        if (!this.mErrorEnabled) {
            if (!TextUtils.isEmpty(charSequence)) {
                setErrorEnabled(true);
            } else {
                return;
            }
        }
        this.mErrorShown = TextUtils.isEmpty(charSequence) ^ true;
        this.mErrorView.animate().cancel();
        if (this.mErrorShown) {
            this.mErrorView.setText(charSequence);
            this.mErrorView.setVisibility(0);
            if (z) {
                if (this.mErrorView.getAlpha() == 1.0f) {
                    this.mErrorView.setAlpha(0.0f);
                }
                this.mErrorView.animate().alpha(1.0f).setDuration(200).setInterpolator(AnimationUtils.LINEAR_OUT_SLOW_IN_INTERPOLATOR).setListener(new AnimatorListenerAdapter() {
                    public void onAnimationStart(Animator animator) {
                        TextInputLayout.this.mErrorView.setVisibility(0);
                    }
                }).start();
            } else {
                this.mErrorView.setAlpha(1.0f);
            }
        } else if (this.mErrorView.getVisibility() == 0) {
            if (z) {
                this.mErrorView.animate().alpha(0.0f).setDuration(200).setInterpolator(AnimationUtils.FAST_OUT_LINEAR_IN_INTERPOLATOR).setListener(new AnimatorListenerAdapter() {
                    public void onAnimationEnd(Animator animator) {
                        TextInputLayout.this.mErrorView.setText(charSequence);
                        TextInputLayout.this.mErrorView.setVisibility(4);
                    }
                }).start();
            } else {
                this.mErrorView.setText(charSequence);
                this.mErrorView.setVisibility(4);
            }
        }
        updateEditTextBackground();
        updateLabelState(z);
    }

    public void setCounterEnabled(boolean r4) {
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
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r3 = this;
        r0 = r3.mCounterEnabled;
        if (r0 == r4) goto L_0x006e;
    L_0x0004:
        if (r4 == 0) goto L_0x0064;
    L_0x0006:
        r0 = new android.support.v7.widget.AppCompatTextView;
        r1 = r3.getContext();
        r0.<init>(r1);
        r3.mCounterView = r0;
        r0 = r3.mCounterView;
        r1 = android.support.design.R.id.textinput_counter;
        r0.setId(r1);
        r0 = r3.mTypeface;
        if (r0 == 0) goto L_0x0023;
    L_0x001c:
        r0 = r3.mCounterView;
        r1 = r3.mTypeface;
        r0.setTypeface(r1);
    L_0x0023:
        r0 = r3.mCounterView;
        r1 = 1;
        r0.setMaxLines(r1);
        r0 = r3.mCounterView;	 Catch:{ Exception -> 0x0031 }
        r1 = r3.mCounterTextAppearance;	 Catch:{ Exception -> 0x0031 }
        android.support.v4.widget.TextViewCompat.setTextAppearance(r0, r1);	 Catch:{ Exception -> 0x0031 }
        goto L_0x0047;
    L_0x0031:
        r0 = r3.mCounterView;
        r1 = android.support.v7.appcompat.R.style.TextAppearance_AppCompat_Caption;
        android.support.v4.widget.TextViewCompat.setTextAppearance(r0, r1);
        r0 = r3.mCounterView;
        r1 = r3.getContext();
        r2 = android.support.v7.appcompat.R.color.error_color_material;
        r1 = android.support.v4.content.ContextCompat.getColor(r1, r2);
        r0.setTextColor(r1);
    L_0x0047:
        r0 = r3.mCounterView;
        r1 = -1;
        r3.addIndicator(r0, r1);
        r0 = r3.mEditText;
        if (r0 != 0) goto L_0x0056;
    L_0x0051:
        r0 = 0;
        r3.updateCounter(r0);
        goto L_0x006c;
    L_0x0056:
        r0 = r3.mEditText;
        r0 = r0.getText();
        r0 = r0.length();
        r3.updateCounter(r0);
        goto L_0x006c;
    L_0x0064:
        r0 = r3.mCounterView;
        r3.removeIndicator(r0);
        r0 = 0;
        r3.mCounterView = r0;
    L_0x006c:
        r3.mCounterEnabled = r4;
    L_0x006e:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.design.widget.TextInputLayout.setCounterEnabled(boolean):void");
    }

    public boolean isCounterEnabled() {
        return this.mCounterEnabled;
    }

    public void setCounterMaxLength(int i) {
        if (this.mCounterMaxLength != i) {
            if (i > 0) {
                this.mCounterMaxLength = i;
            } else {
                this.mCounterMaxLength = -1;
            }
            if (this.mCounterEnabled != 0) {
                updateCounter(this.mEditText == 0 ? 0 : this.mEditText.getText().length());
            }
        }
    }

    public void setEnabled(boolean z) {
        recursiveSetEnabled(this, z);
        super.setEnabled(z);
    }

    private static void recursiveSetEnabled(ViewGroup viewGroup, boolean z) {
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = viewGroup.getChildAt(i);
            childAt.setEnabled(z);
            if (childAt instanceof ViewGroup) {
                recursiveSetEnabled((ViewGroup) childAt, z);
            }
        }
    }

    public int getCounterMaxLength() {
        return this.mCounterMaxLength;
    }

    void updateCounter(int i) {
        boolean z = this.mCounterOverflowed;
        if (this.mCounterMaxLength == -1) {
            this.mCounterView.setText(String.valueOf(i));
            this.mCounterOverflowed = false;
        } else {
            this.mCounterOverflowed = i > this.mCounterMaxLength;
            if (z != this.mCounterOverflowed) {
                TextViewCompat.setTextAppearance(this.mCounterView, this.mCounterOverflowed ? this.mCounterOverflowTextAppearance : this.mCounterTextAppearance);
            }
            this.mCounterView.setText(getContext().getString(R.string.character_counter_pattern, new Object[]{Integer.valueOf(i), Integer.valueOf(this.mCounterMaxLength)}));
        }
        if (this.mEditText != 0 && z != this.mCounterOverflowed) {
            updateLabelState(false);
            updateEditTextBackground();
        }
    }

    private void updateEditTextBackground() {
        if (this.mEditText != null) {
            Drawable background = this.mEditText.getBackground();
            if (background != null) {
                ensureBackgroundDrawableStateWorkaround();
                if (DrawableUtils.canSafelyMutateDrawable(background)) {
                    background = background.mutate();
                }
                if (this.mErrorShown && this.mErrorView != null) {
                    background.setColorFilter(AppCompatDrawableManager.getPorterDuffColorFilter(this.mErrorView.getCurrentTextColor(), Mode.SRC_IN));
                } else if (!this.mCounterOverflowed || this.mCounterView == null) {
                    DrawableCompat.clearColorFilter(background);
                    this.mEditText.refreshDrawableState();
                } else {
                    background.setColorFilter(AppCompatDrawableManager.getPorterDuffColorFilter(this.mCounterView.getCurrentTextColor(), Mode.SRC_IN));
                }
            }
        }
    }

    private void ensureBackgroundDrawableStateWorkaround() {
        int i = VERSION.SDK_INT;
        if (i == 21 || i == 22) {
            Drawable background = this.mEditText.getBackground();
            if (!(background == null || this.mHasReconstructedEditTextBackground)) {
                Drawable newDrawable = background.getConstantState().newDrawable();
                if (background instanceof DrawableContainer) {
                    this.mHasReconstructedEditTextBackground = DrawableUtils.setContainerConstantState((DrawableContainer) background, newDrawable.getConstantState());
                }
                if (!this.mHasReconstructedEditTextBackground) {
                    ViewCompat.setBackground(this.mEditText, newDrawable);
                    this.mHasReconstructedEditTextBackground = true;
                }
            }
        }
    }

    public Parcelable onSaveInstanceState() {
        Parcelable savedState = new SavedState(super.onSaveInstanceState());
        if (this.mErrorShown) {
            savedState.error = getError();
        }
        savedState.isPasswordToggledVisible = this.mPasswordToggledVisible;
        return savedState;
    }

    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            SavedState savedState = (SavedState) parcelable;
            super.onRestoreInstanceState(savedState.getSuperState());
            setError(savedState.error);
            if (savedState.isPasswordToggledVisible != null) {
                passwordVisibilityToggleRequested(true);
            }
            requestLayout();
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    protected void dispatchRestoreInstanceState(SparseArray<Parcelable> sparseArray) {
        this.mRestoringSavedState = true;
        super.dispatchRestoreInstanceState(sparseArray);
        this.mRestoringSavedState = null;
    }

    @Nullable
    public CharSequence getError() {
        return this.mErrorEnabled ? this.mError : null;
    }

    public boolean isHintAnimationEnabled() {
        return this.mHintAnimationEnabled;
    }

    public void setHintAnimationEnabled(boolean z) {
        this.mHintAnimationEnabled = z;
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.mHintEnabled) {
            this.mCollapsingTextHelper.draw(canvas);
        }
    }

    protected void onMeasure(int i, int i2) {
        updatePasswordToggleView();
        super.onMeasure(i, i2);
    }

    private void updatePasswordToggleView() {
        if (this.mEditText != null) {
            Drawable[] compoundDrawablesRelative;
            if (shouldShowPasswordIcon()) {
                if (this.mPasswordToggleView == null) {
                    this.mPasswordToggleView = (CheckableImageButton) LayoutInflater.from(getContext()).inflate(R.layout.design_text_input_password_icon, this.mInputFrame, false);
                    this.mPasswordToggleView.setImageDrawable(this.mPasswordToggleDrawable);
                    this.mPasswordToggleView.setContentDescription(this.mPasswordToggleContentDesc);
                    this.mInputFrame.addView(this.mPasswordToggleView);
                    this.mPasswordToggleView.setOnClickListener(new OnClickListener() {
                        public void onClick(View view) {
                            TextInputLayout.this.passwordVisibilityToggleRequested(false);
                        }
                    });
                }
                if (this.mEditText != null && ViewCompat.getMinimumHeight(this.mEditText) <= 0) {
                    this.mEditText.setMinimumHeight(ViewCompat.getMinimumHeight(this.mPasswordToggleView));
                }
                this.mPasswordToggleView.setVisibility(0);
                this.mPasswordToggleView.setChecked(this.mPasswordToggledVisible);
                if (this.mPasswordToggleDummyDrawable == null) {
                    this.mPasswordToggleDummyDrawable = new ColorDrawable();
                }
                this.mPasswordToggleDummyDrawable.setBounds(0, 0, this.mPasswordToggleView.getMeasuredWidth(), 1);
                compoundDrawablesRelative = TextViewCompat.getCompoundDrawablesRelative(this.mEditText);
                if (compoundDrawablesRelative[2] != this.mPasswordToggleDummyDrawable) {
                    this.mOriginalEditTextEndDrawable = compoundDrawablesRelative[2];
                }
                TextViewCompat.setCompoundDrawablesRelative(this.mEditText, compoundDrawablesRelative[0], compoundDrawablesRelative[1], this.mPasswordToggleDummyDrawable, compoundDrawablesRelative[3]);
                this.mPasswordToggleView.setPadding(this.mEditText.getPaddingLeft(), this.mEditText.getPaddingTop(), this.mEditText.getPaddingRight(), this.mEditText.getPaddingBottom());
                return;
            }
            if (this.mPasswordToggleView != null && this.mPasswordToggleView.getVisibility() == 0) {
                this.mPasswordToggleView.setVisibility(8);
            }
            if (this.mPasswordToggleDummyDrawable != null) {
                compoundDrawablesRelative = TextViewCompat.getCompoundDrawablesRelative(this.mEditText);
                if (compoundDrawablesRelative[2] == this.mPasswordToggleDummyDrawable) {
                    TextViewCompat.setCompoundDrawablesRelative(this.mEditText, compoundDrawablesRelative[0], compoundDrawablesRelative[1], this.mOriginalEditTextEndDrawable, compoundDrawablesRelative[3]);
                    this.mPasswordToggleDummyDrawable = null;
                }
            }
        }
    }

    public void setPasswordVisibilityToggleDrawable(@DrawableRes int i) {
        setPasswordVisibilityToggleDrawable(i != 0 ? AppCompatResources.getDrawable(getContext(), i) : 0);
    }

    public void setPasswordVisibilityToggleDrawable(@Nullable Drawable drawable) {
        this.mPasswordToggleDrawable = drawable;
        if (this.mPasswordToggleView != null) {
            this.mPasswordToggleView.setImageDrawable(drawable);
        }
    }

    public void setPasswordVisibilityToggleContentDescription(@StringRes int i) {
        setPasswordVisibilityToggleContentDescription(i != 0 ? getResources().getText(i) : 0);
    }

    public void setPasswordVisibilityToggleContentDescription(@Nullable CharSequence charSequence) {
        this.mPasswordToggleContentDesc = charSequence;
        if (this.mPasswordToggleView != null) {
            this.mPasswordToggleView.setContentDescription(charSequence);
        }
    }

    @Nullable
    public Drawable getPasswordVisibilityToggleDrawable() {
        return this.mPasswordToggleDrawable;
    }

    @Nullable
    public CharSequence getPasswordVisibilityToggleContentDescription() {
        return this.mPasswordToggleContentDesc;
    }

    public boolean isPasswordVisibilityToggleEnabled() {
        return this.mPasswordToggleEnabled;
    }

    public void setPasswordVisibilityToggleEnabled(boolean z) {
        if (this.mPasswordToggleEnabled != z) {
            this.mPasswordToggleEnabled = z;
            if (!z && this.mPasswordToggledVisible && this.mEditText) {
                this.mEditText.setTransformationMethod(PasswordTransformationMethod.getInstance());
            }
            this.mPasswordToggledVisible = false;
            updatePasswordToggleView();
        }
    }

    public void setPasswordVisibilityToggleTintList(@Nullable ColorStateList colorStateList) {
        this.mPasswordToggleTintList = colorStateList;
        this.mHasPasswordToggleTintList = true;
        applyPasswordToggleTint();
    }

    public void setPasswordVisibilityToggleTintMode(@Nullable Mode mode) {
        this.mPasswordToggleTintMode = mode;
        this.mHasPasswordToggleTintMode = true;
        applyPasswordToggleTint();
    }

    private void passwordVisibilityToggleRequested(boolean z) {
        if (this.mPasswordToggleEnabled) {
            int selectionEnd = this.mEditText.getSelectionEnd();
            if (hasPasswordTransformation()) {
                this.mEditText.setTransformationMethod(null);
                this.mPasswordToggledVisible = true;
            } else {
                this.mEditText.setTransformationMethod(PasswordTransformationMethod.getInstance());
                this.mPasswordToggledVisible = false;
            }
            this.mPasswordToggleView.setChecked(this.mPasswordToggledVisible);
            if (z) {
                this.mPasswordToggleView.jumpDrawablesToCurrentState();
            }
            this.mEditText.setSelection(selectionEnd);
        }
    }

    private boolean hasPasswordTransformation() {
        return this.mEditText != null && (this.mEditText.getTransformationMethod() instanceof PasswordTransformationMethod);
    }

    private boolean shouldShowPasswordIcon() {
        return this.mPasswordToggleEnabled && (hasPasswordTransformation() || this.mPasswordToggledVisible);
    }

    private void applyPasswordToggleTint() {
        if (this.mPasswordToggleDrawable == null) {
            return;
        }
        if (this.mHasPasswordToggleTintList || this.mHasPasswordToggleTintMode) {
            this.mPasswordToggleDrawable = DrawableCompat.wrap(this.mPasswordToggleDrawable).mutate();
            if (this.mHasPasswordToggleTintList) {
                DrawableCompat.setTintList(this.mPasswordToggleDrawable, this.mPasswordToggleTintList);
            }
            if (this.mHasPasswordToggleTintMode) {
                DrawableCompat.setTintMode(this.mPasswordToggleDrawable, this.mPasswordToggleTintMode);
            }
            if (this.mPasswordToggleView != null && this.mPasswordToggleView.getDrawable() != this.mPasswordToggleDrawable) {
                this.mPasswordToggleView.setImageDrawable(this.mPasswordToggleDrawable);
            }
        }
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.mHintEnabled && this.mEditText) {
            z = this.mTmpRect;
            ViewGroupUtils.getDescendantRect(this, this.mEditText, z);
            i = z.left + this.mEditText.getCompoundPaddingLeft();
            i3 = z.right - this.mEditText.getCompoundPaddingRight();
            this.mCollapsingTextHelper.setExpandedBounds(i, z.top + this.mEditText.getCompoundPaddingTop(), i3, z.bottom - this.mEditText.getCompoundPaddingBottom());
            this.mCollapsingTextHelper.setCollapsedBounds(i, getPaddingTop(), i3, (i4 - i2) - getPaddingBottom());
            this.mCollapsingTextHelper.recalculate();
        }
    }

    private void collapseHint(boolean z) {
        if (this.mAnimator != null && this.mAnimator.isRunning()) {
            this.mAnimator.cancel();
        }
        if (z && this.mHintAnimationEnabled) {
            animateToExpansionFraction(1.0f);
        } else {
            this.mCollapsingTextHelper.setExpansionFraction(1.0f);
        }
        this.mHintExpanded = false;
    }

    protected void drawableStateChanged() {
        if (!this.mInDrawableStateChanged) {
            boolean z = true;
            this.mInDrawableStateChanged = true;
            super.drawableStateChanged();
            int[] drawableState = getDrawableState();
            if (!ViewCompat.isLaidOut(this) || !isEnabled()) {
                z = false;
            }
            updateLabelState(z);
            updateEditTextBackground();
            if ((this.mCollapsingTextHelper != null ? this.mCollapsingTextHelper.setState(drawableState) | 0 : 0) != 0) {
                invalidate();
            }
            this.mInDrawableStateChanged = false;
        }
    }

    private void expandHint(boolean z) {
        if (this.mAnimator != null && this.mAnimator.isRunning()) {
            this.mAnimator.cancel();
        }
        if (z && this.mHintAnimationEnabled) {
            animateToExpansionFraction(0.0f);
        } else {
            this.mCollapsingTextHelper.setExpansionFraction(0.0f);
        }
        this.mHintExpanded = true;
    }

    @VisibleForTesting
    void animateToExpansionFraction(float f) {
        if (this.mCollapsingTextHelper.getExpansionFraction() != f) {
            if (this.mAnimator == null) {
                this.mAnimator = new ValueAnimator();
                this.mAnimator.setInterpolator(AnimationUtils.LINEAR_INTERPOLATOR);
                this.mAnimator.setDuration(200);
                this.mAnimator.addUpdateListener(new AnimatorUpdateListener() {
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        TextInputLayout.this.mCollapsingTextHelper.setExpansionFraction(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    }
                });
            }
            this.mAnimator.setFloatValues(new float[]{this.mCollapsingTextHelper.getExpansionFraction(), f});
            this.mAnimator.start();
        }
    }

    @VisibleForTesting
    final boolean isHintExpanded() {
        return this.mHintExpanded;
    }

    private static boolean arrayContains(int[] iArr, int i) {
        for (int i2 : iArr) {
            if (i2 == i) {
                return 1;
            }
        }
        return false;
    }
}
