package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources.Theme;
import android.database.DataSetObserver;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.annotation.DrawableRes;
import android.support.annotation.Nullable;
import android.support.annotation.RestrictTo;
import android.support.annotation.RestrictTo.Scope;
import android.support.v4.view.TintableBackgroundView;
import android.support.v4.view.ViewCompat;
import android.support.v7.appcompat.R;
import android.support.v7.content.res.AppCompatResources;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListAdapter;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.ThemedSpinnerAdapter;

public class AppCompatSpinner extends Spinner implements TintableBackgroundView {
    private static final int[] ATTRS_ANDROID_SPINNERMODE = new int[]{16843505};
    private static final int MAX_ITEMS_MEASURED = 15;
    private static final int MODE_DIALOG = 0;
    private static final int MODE_DROPDOWN = 1;
    private static final int MODE_THEME = -1;
    private static final String TAG = "AppCompatSpinner";
    private final AppCompatBackgroundHelper mBackgroundTintHelper;
    private int mDropDownWidth;
    private ForwardingListener mForwardingListener;
    private DropdownPopup mPopup;
    private final Context mPopupContext;
    private final boolean mPopupSet;
    private SpinnerAdapter mTempAdapter;
    private final Rect mTempRect;

    private static class DropDownAdapter implements ListAdapter, SpinnerAdapter {
        private SpinnerAdapter mAdapter;
        private ListAdapter mListAdapter;

        public int getItemViewType(int i) {
            return 0;
        }

        public int getViewTypeCount() {
            return 1;
        }

        public DropDownAdapter(@Nullable SpinnerAdapter spinnerAdapter, @Nullable Theme theme) {
            this.mAdapter = spinnerAdapter;
            if (spinnerAdapter instanceof ListAdapter) {
                this.mListAdapter = (ListAdapter) spinnerAdapter;
            }
            if (theme != null) {
                if (VERSION.SDK_INT >= 23 && (spinnerAdapter instanceof ThemedSpinnerAdapter)) {
                    ThemedSpinnerAdapter themedSpinnerAdapter = (ThemedSpinnerAdapter) spinnerAdapter;
                    if (themedSpinnerAdapter.getDropDownViewTheme() != theme) {
                        themedSpinnerAdapter.setDropDownViewTheme(theme);
                    }
                } else if (spinnerAdapter instanceof ThemedSpinnerAdapter) {
                    ThemedSpinnerAdapter themedSpinnerAdapter2 = (ThemedSpinnerAdapter) spinnerAdapter;
                    if (themedSpinnerAdapter2.getDropDownViewTheme() == null) {
                        themedSpinnerAdapter2.setDropDownViewTheme(theme);
                    }
                }
            }
        }

        public int getCount() {
            return this.mAdapter == null ? 0 : this.mAdapter.getCount();
        }

        public Object getItem(int i) {
            return this.mAdapter == null ? 0 : this.mAdapter.getItem(i);
        }

        public long getItemId(int i) {
            return this.mAdapter == null ? -1 : this.mAdapter.getItemId(i);
        }

        public View getView(int i, View view, ViewGroup viewGroup) {
            return getDropDownView(i, view, viewGroup);
        }

        public View getDropDownView(int i, View view, ViewGroup viewGroup) {
            if (this.mAdapter == null) {
                return 0;
            }
            return this.mAdapter.getDropDownView(i, view, viewGroup);
        }

        public boolean hasStableIds() {
            return this.mAdapter != null && this.mAdapter.hasStableIds();
        }

        public void registerDataSetObserver(DataSetObserver dataSetObserver) {
            if (this.mAdapter != null) {
                this.mAdapter.registerDataSetObserver(dataSetObserver);
            }
        }

        public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
            if (this.mAdapter != null) {
                this.mAdapter.unregisterDataSetObserver(dataSetObserver);
            }
        }

        public boolean areAllItemsEnabled() {
            ListAdapter listAdapter = this.mListAdapter;
            return listAdapter != null ? listAdapter.areAllItemsEnabled() : true;
        }

        public boolean isEnabled(int i) {
            ListAdapter listAdapter = this.mListAdapter;
            return listAdapter != null ? listAdapter.isEnabled(i) : true;
        }

        public boolean isEmpty() {
            return getCount() == 0;
        }
    }

    private class DropdownPopup extends ListPopupWindow {
        ListAdapter mAdapter;
        private CharSequence mHintText;
        private final Rect mVisibleRect = new Rect();

        public DropdownPopup(Context context, AttributeSet attributeSet, int i) {
            super(context, attributeSet, i);
            setAnchorView(AppCompatSpinner.this);
            setModal(true);
            setPromptPosition(null);
            setOnItemClickListener(new OnItemClickListener(AppCompatSpinner.this) {
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                    AppCompatSpinner.this.setSelection(i);
                    if (AppCompatSpinner.this.getOnItemClickListener() != null) {
                        AppCompatSpinner.this.performItemClick(view, i, DropdownPopup.this.mAdapter.getItemId(i));
                    }
                    DropdownPopup.this.dismiss();
                }
            });
        }

        public void setAdapter(ListAdapter listAdapter) {
            super.setAdapter(listAdapter);
            this.mAdapter = listAdapter;
        }

        public CharSequence getHintText() {
            return this.mHintText;
        }

        public void setPromptText(CharSequence charSequence) {
            this.mHintText = charSequence;
        }

        void computeContentWidth() {
            int i;
            Drawable background = getBackground();
            int i2 = 0;
            if (background != null) {
                background.getPadding(AppCompatSpinner.this.mTempRect);
                if (ViewUtils.isLayoutRtl(AppCompatSpinner.this)) {
                    i = AppCompatSpinner.this.mTempRect.right;
                } else {
                    i = -AppCompatSpinner.this.mTempRect.left;
                }
                i2 = i;
            } else {
                Rect access$100 = AppCompatSpinner.this.mTempRect;
                AppCompatSpinner.this.mTempRect.right = 0;
                access$100.left = 0;
            }
            i = AppCompatSpinner.this.getPaddingLeft();
            int paddingRight = AppCompatSpinner.this.getPaddingRight();
            int width = AppCompatSpinner.this.getWidth();
            if (AppCompatSpinner.this.mDropDownWidth == -2) {
                int compatMeasureContentWidth = AppCompatSpinner.this.compatMeasureContentWidth((SpinnerAdapter) this.mAdapter, getBackground());
                int i3 = (AppCompatSpinner.this.getContext().getResources().getDisplayMetrics().widthPixels - AppCompatSpinner.this.mTempRect.left) - AppCompatSpinner.this.mTempRect.right;
                if (compatMeasureContentWidth > i3) {
                    compatMeasureContentWidth = i3;
                }
                setContentWidth(Math.max(compatMeasureContentWidth, (width - i) - paddingRight));
            } else if (AppCompatSpinner.this.mDropDownWidth == -1) {
                setContentWidth((width - i) - paddingRight);
            } else {
                setContentWidth(AppCompatSpinner.this.mDropDownWidth);
            }
            setHorizontalOffset(ViewUtils.isLayoutRtl(AppCompatSpinner.this) ? i2 + ((width - paddingRight) - getWidth()) : i2 + i);
        }

        public void show() {
            boolean isShowing = isShowing();
            computeContentWidth();
            setInputMethodMode(2);
            super.show();
            getListView().setChoiceMode(1);
            setSelection(AppCompatSpinner.this.getSelectedItemPosition());
            if (!isShowing) {
                ViewTreeObserver viewTreeObserver = AppCompatSpinner.this.getViewTreeObserver();
                if (viewTreeObserver != null) {
                    final OnGlobalLayoutListener anonymousClass2 = new OnGlobalLayoutListener() {
                        public void onGlobalLayout() {
                            if (DropdownPopup.this.isVisibleToUser(AppCompatSpinner.this)) {
                                DropdownPopup.this.computeContentWidth();
                                super.show();
                                return;
                            }
                            DropdownPopup.this.dismiss();
                        }
                    };
                    viewTreeObserver.addOnGlobalLayoutListener(anonymousClass2);
                    setOnDismissListener(new OnDismissListener() {
                        public void onDismiss() {
                            ViewTreeObserver viewTreeObserver = AppCompatSpinner.this.getViewTreeObserver();
                            if (viewTreeObserver != null) {
                                viewTreeObserver.removeGlobalOnLayoutListener(anonymousClass2);
                            }
                        }
                    });
                }
            }
        }

        boolean isVisibleToUser(View view) {
            return (!ViewCompat.isAttachedToWindow(view) || view.getGlobalVisibleRect(this.mVisibleRect) == null) ? null : true;
        }
    }

    public AppCompatSpinner(Context context) {
        this(context, null);
    }

    public AppCompatSpinner(Context context, int i) {
        this(context, null, R.attr.spinnerStyle, i);
    }

    public AppCompatSpinner(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.spinnerStyle);
    }

    public AppCompatSpinner(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, -1);
    }

    public AppCompatSpinner(Context context, AttributeSet attributeSet, int i, int i2) {
        this(context, attributeSet, i, i2, null);
    }

    public AppCompatSpinner(android.content.Context r6, android.util.AttributeSet r7, int r8, int r9, android.content.res.Resources.Theme r10) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r5 = this;
        r5.<init>(r6, r7, r8);
        r0 = new android.graphics.Rect;
        r0.<init>();
        r5.mTempRect = r0;
        r0 = android.support.v7.appcompat.R.styleable.Spinner;
        r1 = 0;
        r0 = android.support.v7.widget.TintTypedArray.obtainStyledAttributes(r6, r7, r0, r8, r1);
        r2 = new android.support.v7.widget.AppCompatBackgroundHelper;
        r2.<init>(r5);
        r5.mBackgroundTintHelper = r2;
        r2 = 0;
        if (r10 == 0) goto L_0x0021;
    L_0x001b:
        r3 = new android.support.v7.view.ContextThemeWrapper;
        r3.<init>(r6, r10);
        goto L_0x0038;
    L_0x0021:
        r10 = android.support.v7.appcompat.R.styleable.Spinner_popupTheme;
        r10 = r0.getResourceId(r10, r1);
        if (r10 == 0) goto L_0x002f;
    L_0x0029:
        r3 = new android.support.v7.view.ContextThemeWrapper;
        r3.<init>(r6, r10);
        goto L_0x0038;
    L_0x002f:
        r10 = android.os.Build.VERSION.SDK_INT;
        r3 = 23;
        if (r10 >= r3) goto L_0x0037;
    L_0x0035:
        r3 = r6;
        goto L_0x0038;
    L_0x0037:
        r3 = r2;
    L_0x0038:
        r5.mPopupContext = r3;
        r10 = r5.mPopupContext;
        r3 = 1;
        if (r10 == 0) goto L_0x00a6;
    L_0x003f:
        r10 = -1;
        if (r9 != r10) goto L_0x006e;
    L_0x0042:
        r10 = android.os.Build.VERSION.SDK_INT;
        r4 = 11;
        if (r10 < r4) goto L_0x006d;
    L_0x0048:
        r10 = ATTRS_ANDROID_SPINNERMODE;	 Catch:{ Exception -> 0x0069, all -> 0x0061 }
        r10 = r6.obtainStyledAttributes(r7, r10, r8, r1);	 Catch:{ Exception -> 0x0069, all -> 0x0061 }
        r4 = r10.hasValue(r1);	 Catch:{ Exception -> 0x006a, all -> 0x005f }
        if (r4 == 0) goto L_0x0059;	 Catch:{ Exception -> 0x006a, all -> 0x005f }
    L_0x0054:
        r4 = r10.getInt(r1, r1);	 Catch:{ Exception -> 0x006a, all -> 0x005f }
        r9 = r4;
    L_0x0059:
        if (r10 == 0) goto L_0x006e;
    L_0x005b:
        r10.recycle();
        goto L_0x006e;
    L_0x005f:
        r6 = move-exception;
        goto L_0x0063;
    L_0x0061:
        r6 = move-exception;
        r10 = r2;
    L_0x0063:
        if (r10 == 0) goto L_0x0068;
    L_0x0065:
        r10.recycle();
    L_0x0068:
        throw r6;
    L_0x0069:
        r10 = r2;
    L_0x006a:
        if (r10 == 0) goto L_0x006e;
    L_0x006c:
        goto L_0x005b;
    L_0x006d:
        r9 = r3;
    L_0x006e:
        if (r9 != r3) goto L_0x00a6;
    L_0x0070:
        r9 = new android.support.v7.widget.AppCompatSpinner$DropdownPopup;
        r10 = r5.mPopupContext;
        r9.<init>(r10, r7, r8);
        r10 = r5.mPopupContext;
        r4 = android.support.v7.appcompat.R.styleable.Spinner;
        r10 = android.support.v7.widget.TintTypedArray.obtainStyledAttributes(r10, r7, r4, r8, r1);
        r1 = android.support.v7.appcompat.R.styleable.Spinner_android_dropDownWidth;
        r4 = -2;
        r1 = r10.getLayoutDimension(r1, r4);
        r5.mDropDownWidth = r1;
        r1 = android.support.v7.appcompat.R.styleable.Spinner_android_popupBackground;
        r1 = r10.getDrawable(r1);
        r9.setBackgroundDrawable(r1);
        r1 = android.support.v7.appcompat.R.styleable.Spinner_android_prompt;
        r1 = r0.getString(r1);
        r9.setPromptText(r1);
        r10.recycle();
        r5.mPopup = r9;
        r10 = new android.support.v7.widget.AppCompatSpinner$1;
        r10.<init>(r5, r9);
        r5.mForwardingListener = r10;
    L_0x00a6:
        r9 = android.support.v7.appcompat.R.styleable.Spinner_android_entries;
        r9 = r0.getTextArray(r9);
        if (r9 == 0) goto L_0x00be;
    L_0x00ae:
        r10 = new android.widget.ArrayAdapter;
        r1 = 17367048; // 0x1090008 float:2.5162948E-38 double:8.580462E-317;
        r10.<init>(r6, r1, r9);
        r6 = android.support.v7.appcompat.R.layout.support_simple_spinner_dropdown_item;
        r10.setDropDownViewResource(r6);
        r5.setAdapter(r10);
    L_0x00be:
        r0.recycle();
        r5.mPopupSet = r3;
        r6 = r5.mTempAdapter;
        if (r6 == 0) goto L_0x00ce;
    L_0x00c7:
        r6 = r5.mTempAdapter;
        r5.setAdapter(r6);
        r5.mTempAdapter = r2;
    L_0x00ce:
        r6 = r5.mBackgroundTintHelper;
        r6.loadFromAttributes(r7, r8);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.AppCompatSpinner.<init>(android.content.Context, android.util.AttributeSet, int, int, android.content.res.Resources$Theme):void");
    }

    public Context getPopupContext() {
        if (this.mPopup != null) {
            return this.mPopupContext;
        }
        return VERSION.SDK_INT >= 23 ? super.getPopupContext() : null;
    }

    public void setPopupBackgroundDrawable(Drawable drawable) {
        if (this.mPopup != null) {
            this.mPopup.setBackgroundDrawable(drawable);
            return;
        }
        if (VERSION.SDK_INT >= 16) {
            super.setPopupBackgroundDrawable(drawable);
        }
    }

    public void setPopupBackgroundResource(@DrawableRes int i) {
        setPopupBackgroundDrawable(AppCompatResources.getDrawable(getPopupContext(), i));
    }

    public Drawable getPopupBackground() {
        if (this.mPopup != null) {
            return this.mPopup.getBackground();
        }
        return VERSION.SDK_INT >= 16 ? super.getPopupBackground() : null;
    }

    public void setDropDownVerticalOffset(int i) {
        if (this.mPopup != null) {
            this.mPopup.setVerticalOffset(i);
            return;
        }
        if (VERSION.SDK_INT >= 16) {
            super.setDropDownVerticalOffset(i);
        }
    }

    public int getDropDownVerticalOffset() {
        if (this.mPopup != null) {
            return this.mPopup.getVerticalOffset();
        }
        return VERSION.SDK_INT >= 16 ? super.getDropDownVerticalOffset() : 0;
    }

    public void setDropDownHorizontalOffset(int i) {
        if (this.mPopup != null) {
            this.mPopup.setHorizontalOffset(i);
            return;
        }
        if (VERSION.SDK_INT >= 16) {
            super.setDropDownHorizontalOffset(i);
        }
    }

    public int getDropDownHorizontalOffset() {
        if (this.mPopup != null) {
            return this.mPopup.getHorizontalOffset();
        }
        return VERSION.SDK_INT >= 16 ? super.getDropDownHorizontalOffset() : 0;
    }

    public void setDropDownWidth(int i) {
        if (this.mPopup != null) {
            this.mDropDownWidth = i;
            return;
        }
        if (VERSION.SDK_INT >= 16) {
            super.setDropDownWidth(i);
        }
    }

    public int getDropDownWidth() {
        if (this.mPopup != null) {
            return this.mDropDownWidth;
        }
        return VERSION.SDK_INT >= 16 ? super.getDropDownWidth() : 0;
    }

    public void setAdapter(SpinnerAdapter spinnerAdapter) {
        if (this.mPopupSet) {
            super.setAdapter(spinnerAdapter);
            if (this.mPopup != null) {
                this.mPopup.setAdapter(new DropDownAdapter(spinnerAdapter, (this.mPopupContext == null ? getContext() : this.mPopupContext).getTheme()));
            }
            return;
        }
        this.mTempAdapter = spinnerAdapter;
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.mPopup != null && this.mPopup.isShowing()) {
            this.mPopup.dismiss();
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.mForwardingListener == null || !this.mForwardingListener.onTouch(this, motionEvent)) {
            return super.onTouchEvent(motionEvent);
        }
        return true;
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.mPopup != 0 && MeasureSpec.getMode(i) == Integer.MIN_VALUE) {
            setMeasuredDimension(Math.min(Math.max(getMeasuredWidth(), compatMeasureContentWidth(getAdapter(), getBackground())), MeasureSpec.getSize(i)), getMeasuredHeight());
        }
    }

    public boolean performClick() {
        if (this.mPopup == null) {
            return super.performClick();
        }
        if (!this.mPopup.isShowing()) {
            this.mPopup.show();
        }
        return true;
    }

    public void setPrompt(CharSequence charSequence) {
        if (this.mPopup != null) {
            this.mPopup.setPromptText(charSequence);
        } else {
            super.setPrompt(charSequence);
        }
    }

    public CharSequence getPrompt() {
        return this.mPopup != null ? this.mPopup.getHintText() : super.getPrompt();
    }

    public void setBackgroundResource(@DrawableRes int i) {
        super.setBackgroundResource(i);
        if (this.mBackgroundTintHelper != null) {
            this.mBackgroundTintHelper.onSetBackgroundResource(i);
        }
    }

    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        if (this.mBackgroundTintHelper != null) {
            this.mBackgroundTintHelper.onSetBackgroundDrawable(drawable);
        }
    }

    @RestrictTo({Scope.LIBRARY_GROUP})
    public void setSupportBackgroundTintList(@Nullable ColorStateList colorStateList) {
        if (this.mBackgroundTintHelper != null) {
            this.mBackgroundTintHelper.setSupportBackgroundTintList(colorStateList);
        }
    }

    @Nullable
    @RestrictTo({Scope.LIBRARY_GROUP})
    public ColorStateList getSupportBackgroundTintList() {
        return this.mBackgroundTintHelper != null ? this.mBackgroundTintHelper.getSupportBackgroundTintList() : null;
    }

    @RestrictTo({Scope.LIBRARY_GROUP})
    public void setSupportBackgroundTintMode(@Nullable Mode mode) {
        if (this.mBackgroundTintHelper != null) {
            this.mBackgroundTintHelper.setSupportBackgroundTintMode(mode);
        }
    }

    @Nullable
    @RestrictTo({Scope.LIBRARY_GROUP})
    public Mode getSupportBackgroundTintMode() {
        return this.mBackgroundTintHelper != null ? this.mBackgroundTintHelper.getSupportBackgroundTintMode() : null;
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.mBackgroundTintHelper != null) {
            this.mBackgroundTintHelper.applySupportBackgroundTint();
        }
    }

    int compatMeasureContentWidth(SpinnerAdapter spinnerAdapter, Drawable drawable) {
        int i = 0;
        if (spinnerAdapter == null) {
            return 0;
        }
        int makeMeasureSpec = MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 0);
        int makeMeasureSpec2 = MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 0);
        int max = Math.max(0, getSelectedItemPosition());
        int min = Math.min(spinnerAdapter.getCount(), max + 15);
        int i2 = 0;
        View view = null;
        for (max = Math.max(0, max - (15 - (min - max))); max < min; max++) {
            int itemViewType = spinnerAdapter.getItemViewType(max);
            if (itemViewType != i) {
                view = null;
                i = itemViewType;
            }
            view = spinnerAdapter.getView(max, view, this);
            if (view.getLayoutParams() == null) {
                view.setLayoutParams(new LayoutParams(-2, -2));
            }
            view.measure(makeMeasureSpec, makeMeasureSpec2);
            i2 = Math.max(i2, view.getMeasuredWidth());
        }
        if (drawable != null) {
            drawable.getPadding(this.mTempRect);
            i2 += this.mTempRect.left + this.mTempRect.right;
        }
        return i2;
    }
}
