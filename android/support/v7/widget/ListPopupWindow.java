package android.support.v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.support.annotation.AttrRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RestrictTo;
import android.support.annotation.RestrictTo.Scope;
import android.support.annotation.StyleRes;
import android.support.v4.view.ViewCompat;
import android.support.v7.appcompat.R;
import android.support.v7.view.menu.ShowableListMenu;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.PopupWindow.OnDismissListener;
import java.lang.reflect.Method;

public class ListPopupWindow implements ShowableListMenu {
    private static final boolean DEBUG = false;
    static final int EXPAND_LIST_TIMEOUT = 250;
    public static final int INPUT_METHOD_FROM_FOCUSABLE = 0;
    public static final int INPUT_METHOD_NEEDED = 1;
    public static final int INPUT_METHOD_NOT_NEEDED = 2;
    public static final int MATCH_PARENT = -1;
    public static final int POSITION_PROMPT_ABOVE = 0;
    public static final int POSITION_PROMPT_BELOW = 1;
    private static final String TAG = "ListPopupWindow";
    public static final int WRAP_CONTENT = -2;
    private static Method sClipToWindowEnabledMethod;
    private static Method sGetMaxAvailableHeightMethod;
    private static Method sSetEpicenterBoundsMethod;
    private ListAdapter mAdapter;
    private Context mContext;
    private boolean mDropDownAlwaysVisible;
    private View mDropDownAnchorView;
    private int mDropDownGravity;
    private int mDropDownHeight;
    private int mDropDownHorizontalOffset;
    DropDownListView mDropDownList;
    private Drawable mDropDownListHighlight;
    private int mDropDownVerticalOffset;
    private boolean mDropDownVerticalOffsetSet;
    private int mDropDownWidth;
    private int mDropDownWindowLayoutType;
    private Rect mEpicenterBounds;
    private boolean mForceIgnoreOutsideTouch;
    final Handler mHandler;
    private final ListSelectorHider mHideSelector;
    private boolean mIsAnimatedFromAnchor;
    private OnItemClickListener mItemClickListener;
    private OnItemSelectedListener mItemSelectedListener;
    int mListItemExpandMaximum;
    private boolean mModal;
    private DataSetObserver mObserver;
    private boolean mOverlapAnchor;
    private boolean mOverlapAnchorSet;
    PopupWindow mPopup;
    private int mPromptPosition;
    private View mPromptView;
    final ResizePopupRunnable mResizePopupRunnable;
    private final PopupScrollListener mScrollListener;
    private Runnable mShowDropDownRunnable;
    private final Rect mTempRect;
    private final PopupTouchInterceptor mTouchInterceptor;

    private class ListSelectorHider implements Runnable {
        ListSelectorHider() {
        }

        public void run() {
            ListPopupWindow.this.clearListSelection();
        }
    }

    private class PopupDataSetObserver extends DataSetObserver {
        PopupDataSetObserver() {
        }

        public void onChanged() {
            if (ListPopupWindow.this.isShowing()) {
                ListPopupWindow.this.show();
            }
        }

        public void onInvalidated() {
            ListPopupWindow.this.dismiss();
        }
    }

    private class PopupScrollListener implements OnScrollListener {
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        }

        PopupScrollListener() {
        }

        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (i == 1 && ListPopupWindow.this.isInputMethodNotNeeded() == null && ListPopupWindow.this.mPopup.getContentView() != null) {
                ListPopupWindow.this.mHandler.removeCallbacks(ListPopupWindow.this.mResizePopupRunnable);
                ListPopupWindow.this.mResizePopupRunnable.run();
            }
        }
    }

    private class PopupTouchInterceptor implements OnTouchListener {
        PopupTouchInterceptor() {
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            view = motionEvent.getAction();
            int x = (int) motionEvent.getX();
            motionEvent = (int) motionEvent.getY();
            if (view == null && ListPopupWindow.this.mPopup != null && ListPopupWindow.this.mPopup.isShowing() && x >= 0 && x < ListPopupWindow.this.mPopup.getWidth() && motionEvent >= null && motionEvent < ListPopupWindow.this.mPopup.getHeight()) {
                ListPopupWindow.this.mHandler.postDelayed(ListPopupWindow.this.mResizePopupRunnable, 250);
            } else if (view == 1) {
                ListPopupWindow.this.mHandler.removeCallbacks(ListPopupWindow.this.mResizePopupRunnable);
            }
            return null;
        }
    }

    private class ResizePopupRunnable implements Runnable {
        ResizePopupRunnable() {
        }

        public void run() {
            if (ListPopupWindow.this.mDropDownList != null && ViewCompat.isAttachedToWindow(ListPopupWindow.this.mDropDownList) && ListPopupWindow.this.mDropDownList.getCount() > ListPopupWindow.this.mDropDownList.getChildCount() && ListPopupWindow.this.mDropDownList.getChildCount() <= ListPopupWindow.this.mListItemExpandMaximum) {
                ListPopupWindow.this.mPopup.setInputMethodMode(2);
                ListPopupWindow.this.show();
            }
        }
    }

    private static boolean isConfirmKey(int i) {
        if (i != 66) {
            if (i != 23) {
                return false;
            }
        }
        return true;
    }

    static {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = 0;
        r1 = 1;
        r2 = android.widget.PopupWindow.class;	 Catch:{ NoSuchMethodException -> 0x0012 }
        r3 = "setClipToScreenEnabled";	 Catch:{ NoSuchMethodException -> 0x0012 }
        r4 = new java.lang.Class[r1];	 Catch:{ NoSuchMethodException -> 0x0012 }
        r5 = java.lang.Boolean.TYPE;	 Catch:{ NoSuchMethodException -> 0x0012 }
        r4[r0] = r5;	 Catch:{ NoSuchMethodException -> 0x0012 }
        r2 = r2.getDeclaredMethod(r3, r4);	 Catch:{ NoSuchMethodException -> 0x0012 }
        sClipToWindowEnabledMethod = r2;	 Catch:{ NoSuchMethodException -> 0x0012 }
    L_0x0012:
        r2 = android.widget.PopupWindow.class;	 Catch:{ NoSuchMethodException -> 0x002c }
        r3 = "getMaxAvailableHeight";	 Catch:{ NoSuchMethodException -> 0x002c }
        r4 = 3;	 Catch:{ NoSuchMethodException -> 0x002c }
        r4 = new java.lang.Class[r4];	 Catch:{ NoSuchMethodException -> 0x002c }
        r5 = android.view.View.class;	 Catch:{ NoSuchMethodException -> 0x002c }
        r4[r0] = r5;	 Catch:{ NoSuchMethodException -> 0x002c }
        r5 = java.lang.Integer.TYPE;	 Catch:{ NoSuchMethodException -> 0x002c }
        r4[r1] = r5;	 Catch:{ NoSuchMethodException -> 0x002c }
        r5 = 2;	 Catch:{ NoSuchMethodException -> 0x002c }
        r6 = java.lang.Boolean.TYPE;	 Catch:{ NoSuchMethodException -> 0x002c }
        r4[r5] = r6;	 Catch:{ NoSuchMethodException -> 0x002c }
        r2 = r2.getDeclaredMethod(r3, r4);	 Catch:{ NoSuchMethodException -> 0x002c }
        sGetMaxAvailableHeightMethod = r2;	 Catch:{ NoSuchMethodException -> 0x002c }
    L_0x002c:
        r2 = android.widget.PopupWindow.class;	 Catch:{ NoSuchMethodException -> 0x003d }
        r3 = "setEpicenterBounds";	 Catch:{ NoSuchMethodException -> 0x003d }
        r1 = new java.lang.Class[r1];	 Catch:{ NoSuchMethodException -> 0x003d }
        r4 = android.graphics.Rect.class;	 Catch:{ NoSuchMethodException -> 0x003d }
        r1[r0] = r4;	 Catch:{ NoSuchMethodException -> 0x003d }
        r0 = r2.getDeclaredMethod(r3, r1);	 Catch:{ NoSuchMethodException -> 0x003d }
        sSetEpicenterBoundsMethod = r0;	 Catch:{ NoSuchMethodException -> 0x003d }
        return;
    L_0x003d:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.ListPopupWindow.<clinit>():void");
    }

    public ListPopupWindow(@NonNull Context context) {
        this(context, null, R.attr.listPopupWindowStyle);
    }

    public ListPopupWindow(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.listPopupWindowStyle);
    }

    public ListPopupWindow(@NonNull Context context, @Nullable AttributeSet attributeSet, @AttrRes int i) {
        this(context, attributeSet, i, 0);
    }

    public ListPopupWindow(@NonNull Context context, @Nullable AttributeSet attributeSet, @AttrRes int i, @StyleRes int i2) {
        this.mDropDownHeight = -2;
        this.mDropDownWidth = -2;
        this.mDropDownWindowLayoutType = 1002;
        this.mIsAnimatedFromAnchor = true;
        this.mDropDownGravity = 0;
        this.mDropDownAlwaysVisible = false;
        this.mForceIgnoreOutsideTouch = false;
        this.mListItemExpandMaximum = Integer.MAX_VALUE;
        this.mPromptPosition = 0;
        this.mResizePopupRunnable = new ResizePopupRunnable();
        this.mTouchInterceptor = new PopupTouchInterceptor();
        this.mScrollListener = new PopupScrollListener();
        this.mHideSelector = new ListSelectorHider();
        this.mTempRect = new Rect();
        this.mContext = context;
        this.mHandler = new Handler(context.getMainLooper());
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ListPopupWindow, i, i2);
        this.mDropDownHorizontalOffset = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.ListPopupWindow_android_dropDownHorizontalOffset, 0);
        this.mDropDownVerticalOffset = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.ListPopupWindow_android_dropDownVerticalOffset, 0);
        if (this.mDropDownVerticalOffset != 0) {
            this.mDropDownVerticalOffsetSet = true;
        }
        obtainStyledAttributes.recycle();
        this.mPopup = new AppCompatPopupWindow(context, attributeSet, i, i2);
        this.mPopup.setInputMethodMode(1);
    }

    public void setAdapter(@Nullable ListAdapter listAdapter) {
        if (this.mObserver == null) {
            this.mObserver = new PopupDataSetObserver();
        } else if (this.mAdapter != null) {
            this.mAdapter.unregisterDataSetObserver(this.mObserver);
        }
        this.mAdapter = listAdapter;
        if (this.mAdapter != null) {
            listAdapter.registerDataSetObserver(this.mObserver);
        }
        if (this.mDropDownList != null) {
            this.mDropDownList.setAdapter(this.mAdapter);
        }
    }

    public void setPromptPosition(int i) {
        this.mPromptPosition = i;
    }

    public int getPromptPosition() {
        return this.mPromptPosition;
    }

    public void setModal(boolean z) {
        this.mModal = z;
        this.mPopup.setFocusable(z);
    }

    public boolean isModal() {
        return this.mModal;
    }

    @RestrictTo({Scope.LIBRARY_GROUP})
    public void setForceIgnoreOutsideTouch(boolean z) {
        this.mForceIgnoreOutsideTouch = z;
    }

    @RestrictTo({Scope.LIBRARY_GROUP})
    public void setDropDownAlwaysVisible(boolean z) {
        this.mDropDownAlwaysVisible = z;
    }

    @RestrictTo({Scope.LIBRARY_GROUP})
    public boolean isDropDownAlwaysVisible() {
        return this.mDropDownAlwaysVisible;
    }

    public void setSoftInputMode(int i) {
        this.mPopup.setSoftInputMode(i);
    }

    public int getSoftInputMode() {
        return this.mPopup.getSoftInputMode();
    }

    public void setListSelector(Drawable drawable) {
        this.mDropDownListHighlight = drawable;
    }

    @Nullable
    public Drawable getBackground() {
        return this.mPopup.getBackground();
    }

    public void setBackgroundDrawable(@Nullable Drawable drawable) {
        this.mPopup.setBackgroundDrawable(drawable);
    }

    public void setAnimationStyle(@StyleRes int i) {
        this.mPopup.setAnimationStyle(i);
    }

    @StyleRes
    public int getAnimationStyle() {
        return this.mPopup.getAnimationStyle();
    }

    @Nullable
    public View getAnchorView() {
        return this.mDropDownAnchorView;
    }

    public void setAnchorView(@Nullable View view) {
        this.mDropDownAnchorView = view;
    }

    public int getHorizontalOffset() {
        return this.mDropDownHorizontalOffset;
    }

    public void setHorizontalOffset(int i) {
        this.mDropDownHorizontalOffset = i;
    }

    public int getVerticalOffset() {
        if (this.mDropDownVerticalOffsetSet) {
            return this.mDropDownVerticalOffset;
        }
        return 0;
    }

    public void setVerticalOffset(int i) {
        this.mDropDownVerticalOffset = i;
        this.mDropDownVerticalOffsetSet = true;
    }

    @RestrictTo({Scope.LIBRARY_GROUP})
    public void setEpicenterBounds(Rect rect) {
        this.mEpicenterBounds = rect;
    }

    public void setDropDownGravity(int i) {
        this.mDropDownGravity = i;
    }

    public int getWidth() {
        return this.mDropDownWidth;
    }

    public void setWidth(int i) {
        this.mDropDownWidth = i;
    }

    public void setContentWidth(int i) {
        Drawable background = this.mPopup.getBackground();
        if (background != null) {
            background.getPadding(this.mTempRect);
            this.mDropDownWidth = (this.mTempRect.left + this.mTempRect.right) + i;
            return;
        }
        setWidth(i);
    }

    public int getHeight() {
        return this.mDropDownHeight;
    }

    public void setHeight(int i) {
        if (i >= 0 || -2 == i || -1 == i) {
            this.mDropDownHeight = i;
            return;
        }
        throw new IllegalArgumentException("Invalid height. Must be a positive value, MATCH_PARENT, or WRAP_CONTENT.");
    }

    public void setWindowLayoutType(int i) {
        this.mDropDownWindowLayoutType = i;
    }

    public void setOnItemClickListener(@Nullable OnItemClickListener onItemClickListener) {
        this.mItemClickListener = onItemClickListener;
    }

    public void setOnItemSelectedListener(@Nullable OnItemSelectedListener onItemSelectedListener) {
        this.mItemSelectedListener = onItemSelectedListener;
    }

    public void setPromptView(@Nullable View view) {
        boolean isShowing = isShowing();
        if (isShowing) {
            removePromptView();
        }
        this.mPromptView = view;
        if (isShowing) {
            show();
        }
    }

    public void postShow() {
        this.mHandler.post(this.mShowDropDownRunnable);
    }

    public void show() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r13 = this;
        r0 = r13.buildDropDown();
        r1 = r13.isInputMethodNotNeeded();
        r2 = r13.mPopup;
        r3 = r13.mDropDownWindowLayoutType;
        android.support.v4.widget.PopupWindowCompat.setWindowLayoutType(r2, r3);
        r2 = r13.mPopup;
        r2 = r2.isShowing();
        r3 = 1;
        r4 = -2;
        r5 = 0;
        r6 = -1;
        if (r2 == 0) goto L_0x0096;
    L_0x001b:
        r2 = r13.getAnchorView();
        r2 = android.support.v4.view.ViewCompat.isAttachedToWindow(r2);
        if (r2 != 0) goto L_0x0026;
    L_0x0025:
        return;
    L_0x0026:
        r2 = r13.mDropDownWidth;
        if (r2 != r6) goto L_0x002c;
    L_0x002a:
        r2 = r6;
        goto L_0x003b;
    L_0x002c:
        r2 = r13.mDropDownWidth;
        if (r2 != r4) goto L_0x0039;
    L_0x0030:
        r2 = r13.getAnchorView();
        r2 = r2.getWidth();
        goto L_0x003b;
    L_0x0039:
        r2 = r13.mDropDownWidth;
    L_0x003b:
        r7 = r13.mDropDownHeight;
        if (r7 != r6) goto L_0x0069;
    L_0x003f:
        if (r1 == 0) goto L_0x0042;
    L_0x0041:
        goto L_0x0043;
    L_0x0042:
        r0 = r6;
    L_0x0043:
        if (r1 == 0) goto L_0x0057;
    L_0x0045:
        r1 = r13.mPopup;
        r4 = r13.mDropDownWidth;
        if (r4 != r6) goto L_0x004d;
    L_0x004b:
        r4 = r6;
        goto L_0x004e;
    L_0x004d:
        r4 = r5;
    L_0x004e:
        r1.setWidth(r4);
        r1 = r13.mPopup;
        r1.setHeight(r5);
        goto L_0x006f;
    L_0x0057:
        r1 = r13.mPopup;
        r4 = r13.mDropDownWidth;
        if (r4 != r6) goto L_0x005f;
    L_0x005d:
        r4 = r6;
        goto L_0x0060;
    L_0x005f:
        r4 = r5;
    L_0x0060:
        r1.setWidth(r4);
        r1 = r13.mPopup;
        r1.setHeight(r6);
        goto L_0x006f;
    L_0x0069:
        r1 = r13.mDropDownHeight;
        if (r1 == r4) goto L_0x006f;
    L_0x006d:
        r0 = r13.mDropDownHeight;
    L_0x006f:
        r1 = r13.mPopup;
        r4 = r13.mForceIgnoreOutsideTouch;
        if (r4 != 0) goto L_0x007a;
    L_0x0075:
        r4 = r13.mDropDownAlwaysVisible;
        if (r4 != 0) goto L_0x007a;
    L_0x0079:
        goto L_0x007b;
    L_0x007a:
        r3 = r5;
    L_0x007b:
        r1.setOutsideTouchable(r3);
        r7 = r13.mPopup;
        r8 = r13.getAnchorView();
        r9 = r13.mDropDownHorizontalOffset;
        r10 = r13.mDropDownVerticalOffset;
        if (r2 >= 0) goto L_0x008c;
    L_0x008a:
        r11 = r6;
        goto L_0x008d;
    L_0x008c:
        r11 = r2;
    L_0x008d:
        if (r0 >= 0) goto L_0x0091;
    L_0x008f:
        r12 = r6;
        goto L_0x0092;
    L_0x0091:
        r12 = r0;
    L_0x0092:
        r7.update(r8, r9, r10, r11, r12);
        return;
    L_0x0096:
        r1 = r13.mDropDownWidth;
        if (r1 != r6) goto L_0x009c;
    L_0x009a:
        r1 = r6;
        goto L_0x00ab;
    L_0x009c:
        r1 = r13.mDropDownWidth;
        if (r1 != r4) goto L_0x00a9;
    L_0x00a0:
        r1 = r13.getAnchorView();
        r1 = r1.getWidth();
        goto L_0x00ab;
    L_0x00a9:
        r1 = r13.mDropDownWidth;
    L_0x00ab:
        r2 = r13.mDropDownHeight;
        if (r2 != r6) goto L_0x00b1;
    L_0x00af:
        r0 = r6;
        goto L_0x00b7;
    L_0x00b1:
        r2 = r13.mDropDownHeight;
        if (r2 == r4) goto L_0x00b7;
    L_0x00b5:
        r0 = r13.mDropDownHeight;
    L_0x00b7:
        r2 = r13.mPopup;
        r2.setWidth(r1);
        r1 = r13.mPopup;
        r1.setHeight(r0);
        r13.setPopupClipToScreenEnabled(r3);
        r0 = r13.mPopup;
        r1 = r13.mForceIgnoreOutsideTouch;
        if (r1 != 0) goto L_0x00d0;
    L_0x00ca:
        r1 = r13.mDropDownAlwaysVisible;
        if (r1 != 0) goto L_0x00d0;
    L_0x00ce:
        r1 = r3;
        goto L_0x00d1;
    L_0x00d0:
        r1 = r5;
    L_0x00d1:
        r0.setOutsideTouchable(r1);
        r0 = r13.mPopup;
        r1 = r13.mTouchInterceptor;
        r0.setTouchInterceptor(r1);
        r0 = r13.mOverlapAnchorSet;
        if (r0 == 0) goto L_0x00e6;
    L_0x00df:
        r0 = r13.mPopup;
        r1 = r13.mOverlapAnchor;
        android.support.v4.widget.PopupWindowCompat.setOverlapAnchor(r0, r1);
    L_0x00e6:
        r0 = sSetEpicenterBoundsMethod;
        if (r0 == 0) goto L_0x00f7;
    L_0x00ea:
        r0 = sSetEpicenterBoundsMethod;	 Catch:{ Exception -> 0x00f7 }
        r1 = r13.mPopup;	 Catch:{ Exception -> 0x00f7 }
        r2 = new java.lang.Object[r3];	 Catch:{ Exception -> 0x00f7 }
        r3 = r13.mEpicenterBounds;	 Catch:{ Exception -> 0x00f7 }
        r2[r5] = r3;	 Catch:{ Exception -> 0x00f7 }
        r0.invoke(r1, r2);	 Catch:{ Exception -> 0x00f7 }
    L_0x00f7:
        r0 = r13.mPopup;
        r1 = r13.getAnchorView();
        r2 = r13.mDropDownHorizontalOffset;
        r3 = r13.mDropDownVerticalOffset;
        r4 = r13.mDropDownGravity;
        android.support.v4.widget.PopupWindowCompat.showAsDropDown(r0, r1, r2, r3, r4);
        r0 = r13.mDropDownList;
        r0.setSelection(r6);
        r0 = r13.mModal;
        if (r0 == 0) goto L_0x0117;
    L_0x010f:
        r0 = r13.mDropDownList;
        r0 = r0.isInTouchMode();
        if (r0 == 0) goto L_0x011a;
    L_0x0117:
        r13.clearListSelection();
    L_0x011a:
        r0 = r13.mModal;
        if (r0 != 0) goto L_0x0125;
    L_0x011e:
        r0 = r13.mHandler;
        r1 = r13.mHideSelector;
        r0.post(r1);
    L_0x0125:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.ListPopupWindow.show():void");
    }

    public void dismiss() {
        this.mPopup.dismiss();
        removePromptView();
        this.mPopup.setContentView(null);
        this.mDropDownList = null;
        this.mHandler.removeCallbacks(this.mResizePopupRunnable);
    }

    public void setOnDismissListener(@Nullable OnDismissListener onDismissListener) {
        this.mPopup.setOnDismissListener(onDismissListener);
    }

    private void removePromptView() {
        if (this.mPromptView != null) {
            ViewParent parent = this.mPromptView.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.mPromptView);
            }
        }
    }

    public void setInputMethodMode(int i) {
        this.mPopup.setInputMethodMode(i);
    }

    public int getInputMethodMode() {
        return this.mPopup.getInputMethodMode();
    }

    public void setSelection(int i) {
        DropDownListView dropDownListView = this.mDropDownList;
        if (isShowing() && dropDownListView != null) {
            dropDownListView.setListSelectionHidden(false);
            dropDownListView.setSelection(i);
            if (dropDownListView.getChoiceMode() != 0) {
                dropDownListView.setItemChecked(i, true);
            }
        }
    }

    public void clearListSelection() {
        DropDownListView dropDownListView = this.mDropDownList;
        if (dropDownListView != null) {
            dropDownListView.setListSelectionHidden(true);
            dropDownListView.requestLayout();
        }
    }

    public boolean isShowing() {
        return this.mPopup.isShowing();
    }

    public boolean isInputMethodNotNeeded() {
        return this.mPopup.getInputMethodMode() == 2;
    }

    public boolean performItemClick(int i) {
        if (!isShowing()) {
            return false;
        }
        if (this.mItemClickListener != null) {
            AdapterView adapterView = this.mDropDownList;
            int i2 = i;
            this.mItemClickListener.onItemClick(adapterView, adapterView.getChildAt(i - adapterView.getFirstVisiblePosition()), i2, adapterView.getAdapter().getItemId(i));
        }
        return true;
    }

    @Nullable
    public Object getSelectedItem() {
        if (isShowing()) {
            return this.mDropDownList.getSelectedItem();
        }
        return null;
    }

    public int getSelectedItemPosition() {
        if (isShowing()) {
            return this.mDropDownList.getSelectedItemPosition();
        }
        return -1;
    }

    public long getSelectedItemId() {
        if (isShowing()) {
            return this.mDropDownList.getSelectedItemId();
        }
        return Long.MIN_VALUE;
    }

    @Nullable
    public View getSelectedView() {
        if (isShowing()) {
            return this.mDropDownList.getSelectedView();
        }
        return null;
    }

    @Nullable
    public ListView getListView() {
        return this.mDropDownList;
    }

    @NonNull
    DropDownListView createDropDownListView(Context context, boolean z) {
        return new DropDownListView(context, z);
    }

    void setListItemExpandMax(int i) {
        this.mListItemExpandMaximum = i;
    }

    public boolean onKeyDown(int i, @NonNull KeyEvent keyEvent) {
        if (isShowing() && i != 62 && (this.mDropDownList.getSelectedItemPosition() >= 0 || !isConfirmKey(i))) {
            int count;
            int selectedItemPosition = this.mDropDownList.getSelectedItemPosition();
            int isAboveAnchor = this.mPopup.isAboveAnchor() ^ 1;
            ListAdapter listAdapter = this.mAdapter;
            int i2 = Integer.MAX_VALUE;
            if (listAdapter != null) {
                int i3;
                boolean areAllItemsEnabled = listAdapter.areAllItemsEnabled();
                if (areAllItemsEnabled) {
                    i3 = 0;
                } else {
                    i3 = this.mDropDownList.lookForSelectablePosition(0, true);
                }
                if (areAllItemsEnabled) {
                    count = listAdapter.getCount() - 1;
                } else {
                    count = this.mDropDownList.lookForSelectablePosition(listAdapter.getCount() - 1, false);
                }
                i2 = i3;
            } else {
                count = Integer.MIN_VALUE;
            }
            if ((isAboveAnchor == 0 || i != 19 || selectedItemPosition > r5) && !(isAboveAnchor == 0 && i == 20 && selectedItemPosition >= count)) {
                this.mDropDownList.setListSelectionHidden(false);
                if (this.mDropDownList.onKeyDown(i, keyEvent) != null) {
                    this.mPopup.setInputMethodMode(2);
                    this.mDropDownList.requestFocusFromTouch();
                    show();
                    if (!(i == 23 || i == 66)) {
                        switch (i) {
                            case 19:
                            case 20:
                                break;
                            default:
                                break;
                        }
                    }
                    return true;
                } else if (isAboveAnchor == 0 || i != 20) {
                    if (isAboveAnchor == 0 && i == 19 && selectedItemPosition == r5) {
                        return true;
                    }
                    return false;
                } else if (selectedItemPosition == count) {
                    return true;
                }
            }
            clearListSelection();
            this.mPopup.setInputMethodMode(1);
            show();
            return true;
        }
        return false;
    }

    public boolean onKeyUp(int i, @NonNull KeyEvent keyEvent) {
        if (!isShowing() || this.mDropDownList.getSelectedItemPosition() < 0) {
            return false;
        }
        keyEvent = this.mDropDownList.onKeyUp(i, keyEvent);
        if (!(keyEvent == null || isConfirmKey(i) == 0)) {
            dismiss();
        }
        return keyEvent;
    }

    public boolean onKeyPreIme(int i, @NonNull KeyEvent keyEvent) {
        if (i == 4 && isShowing() != 0) {
            i = this.mDropDownAnchorView;
            if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
                i = i.getKeyDispatcherState();
                if (i != 0) {
                    i.startTracking(keyEvent, this);
                }
                return true;
            } else if (keyEvent.getAction() == 1) {
                i = i.getKeyDispatcherState();
                if (i != 0) {
                    i.handleUpEvent(keyEvent);
                }
                if (keyEvent.isTracking() != 0 && keyEvent.isCanceled() == 0) {
                    dismiss();
                    return true;
                }
            }
        }
        return false;
    }

    public OnTouchListener createDragToOpenListener(View view) {
        return new ForwardingListener(view) {
            public ListPopupWindow getPopup() {
                return ListPopupWindow.this;
            }
        };
    }

    private int buildDropDown() {
        int i;
        int i2;
        boolean z = true;
        if (this.mDropDownList == null) {
            Context context = this.mContext;
            this.mShowDropDownRunnable = new Runnable() {
                public void run() {
                    View anchorView = ListPopupWindow.this.getAnchorView();
                    if (anchorView != null && anchorView.getWindowToken() != null) {
                        ListPopupWindow.this.show();
                    }
                }
            };
            this.mDropDownList = createDropDownListView(context, this.mModal ^ true);
            if (this.mDropDownListHighlight != null) {
                this.mDropDownList.setSelector(this.mDropDownListHighlight);
            }
            this.mDropDownList.setAdapter(this.mAdapter);
            this.mDropDownList.setOnItemClickListener(this.mItemClickListener);
            this.mDropDownList.setFocusable(true);
            this.mDropDownList.setFocusableInTouchMode(true);
            this.mDropDownList.setOnItemSelectedListener(new OnItemSelectedListener() {
                public void onNothingSelected(AdapterView<?> adapterView) {
                }

                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
                    if (i != -1) {
                        adapterView = ListPopupWindow.this.mDropDownList;
                        if (adapterView != null) {
                            adapterView.setListSelectionHidden(null);
                        }
                    }
                }
            });
            this.mDropDownList.setOnScrollListener(this.mScrollListener);
            if (this.mItemSelectedListener != null) {
                this.mDropDownList.setOnItemSelectedListener(this.mItemSelectedListener);
            }
            View view = this.mDropDownList;
            View view2 = this.mPromptView;
            if (view2 != null) {
                View linearLayout = new LinearLayout(context);
                linearLayout.setOrientation(1);
                LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, 0, 1.0f);
                switch (this.mPromptPosition) {
                    case 0:
                        linearLayout.addView(view2);
                        linearLayout.addView(view, layoutParams);
                        break;
                    case 1:
                        linearLayout.addView(view, layoutParams);
                        linearLayout.addView(view2);
                        break;
                    default:
                        new StringBuilder("Invalid hint position ").append(this.mPromptPosition);
                        break;
                }
                if (this.mDropDownWidth >= 0) {
                    i = this.mDropDownWidth;
                    i2 = Integer.MIN_VALUE;
                } else {
                    i = 0;
                    i2 = i;
                }
                view2.measure(MeasureSpec.makeMeasureSpec(i, i2), 0);
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) view2.getLayoutParams();
                i = (view2.getMeasuredHeight() + layoutParams2.topMargin) + layoutParams2.bottomMargin;
                view = linearLayout;
            } else {
                i = 0;
            }
            this.mPopup.setContentView(view);
        } else {
            this.mPopup.getContentView();
            View view3 = this.mPromptView;
            if (view3 != null) {
                LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) view3.getLayoutParams();
                i = (view3.getMeasuredHeight() + layoutParams3.topMargin) + layoutParams3.bottomMargin;
            } else {
                i = 0;
            }
        }
        Drawable background = this.mPopup.getBackground();
        if (background != null) {
            background.getPadding(this.mTempRect);
            i2 = this.mTempRect.top + this.mTempRect.bottom;
            if (!this.mDropDownVerticalOffsetSet) {
                this.mDropDownVerticalOffset = -this.mTempRect.top;
            }
        } else {
            this.mTempRect.setEmpty();
            i2 = 0;
        }
        if (this.mPopup.getInputMethodMode() != 2) {
            z = false;
        }
        int maxAvailableHeight = getMaxAvailableHeight(getAnchorView(), this.mDropDownVerticalOffset, z);
        if (!this.mDropDownAlwaysVisible) {
            if (this.mDropDownHeight != -1) {
                int makeMeasureSpec;
                switch (this.mDropDownWidth) {
                    case -2:
                        makeMeasureSpec = MeasureSpec.makeMeasureSpec(this.mContext.getResources().getDisplayMetrics().widthPixels - (this.mTempRect.left + this.mTempRect.right), Integer.MIN_VALUE);
                        break;
                    case -1:
                        makeMeasureSpec = MeasureSpec.makeMeasureSpec(this.mContext.getResources().getDisplayMetrics().widthPixels - (this.mTempRect.left + this.mTempRect.right), 1073741824);
                        break;
                    default:
                        makeMeasureSpec = MeasureSpec.makeMeasureSpec(this.mDropDownWidth, 1073741824);
                        break;
                }
                makeMeasureSpec = this.mDropDownList.measureHeightOfChildrenCompat(makeMeasureSpec, 0, -1, maxAvailableHeight - i, -1);
                if (makeMeasureSpec > 0) {
                    i += i2 + (this.mDropDownList.getPaddingTop() + this.mDropDownList.getPaddingBottom());
                }
                return makeMeasureSpec + i;
            }
        }
        return maxAvailableHeight + i2;
    }

    @RestrictTo({Scope.LIBRARY_GROUP})
    public void setOverlapAnchor(boolean z) {
        this.mOverlapAnchorSet = true;
        this.mOverlapAnchor = z;
    }

    private void setPopupClipToScreenEnabled(boolean r5) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r4 = this;
        r0 = sClipToWindowEnabledMethod;
        if (r0 == 0) goto L_0x0016;
    L_0x0004:
        r0 = sClipToWindowEnabledMethod;	 Catch:{ Exception -> 0x0016 }
        r1 = r4.mPopup;	 Catch:{ Exception -> 0x0016 }
        r2 = 1;	 Catch:{ Exception -> 0x0016 }
        r2 = new java.lang.Object[r2];	 Catch:{ Exception -> 0x0016 }
        r3 = 0;	 Catch:{ Exception -> 0x0016 }
        r5 = java.lang.Boolean.valueOf(r5);	 Catch:{ Exception -> 0x0016 }
        r2[r3] = r5;	 Catch:{ Exception -> 0x0016 }
        r0.invoke(r1, r2);	 Catch:{ Exception -> 0x0016 }
        return;
    L_0x0016:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.ListPopupWindow.setPopupClipToScreenEnabled(boolean):void");
    }

    private int getMaxAvailableHeight(android.view.View r6, int r7, boolean r8) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r5 = this;
        r0 = sGetMaxAvailableHeightMethod;
        if (r0 == 0) goto L_0x0027;
    L_0x0004:
        r0 = sGetMaxAvailableHeightMethod;	 Catch:{ Exception -> 0x0027 }
        r1 = r5.mPopup;	 Catch:{ Exception -> 0x0027 }
        r2 = 3;	 Catch:{ Exception -> 0x0027 }
        r2 = new java.lang.Object[r2];	 Catch:{ Exception -> 0x0027 }
        r3 = 0;	 Catch:{ Exception -> 0x0027 }
        r2[r3] = r6;	 Catch:{ Exception -> 0x0027 }
        r3 = 1;	 Catch:{ Exception -> 0x0027 }
        r4 = java.lang.Integer.valueOf(r7);	 Catch:{ Exception -> 0x0027 }
        r2[r3] = r4;	 Catch:{ Exception -> 0x0027 }
        r3 = 2;	 Catch:{ Exception -> 0x0027 }
        r8 = java.lang.Boolean.valueOf(r8);	 Catch:{ Exception -> 0x0027 }
        r2[r3] = r8;	 Catch:{ Exception -> 0x0027 }
        r8 = r0.invoke(r1, r2);	 Catch:{ Exception -> 0x0027 }
        r8 = (java.lang.Integer) r8;	 Catch:{ Exception -> 0x0027 }
        r8 = r8.intValue();	 Catch:{ Exception -> 0x0027 }
        return r8;
    L_0x0027:
        r8 = r5.mPopup;
        r6 = r8.getMaxAvailableHeight(r6, r7);
        return r6;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.ListPopupWindow.getMaxAvailableHeight(android.view.View, int, boolean):int");
    }
}
