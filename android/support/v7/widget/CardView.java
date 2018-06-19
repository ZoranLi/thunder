package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.annotation.ColorInt;
import android.support.annotation.Nullable;
import android.support.v7.cardview.R;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.FrameLayout;

public class CardView extends FrameLayout {
    private static final int[] COLOR_BACKGROUND_ATTR = new int[]{16842801};
    private static final CardViewImpl IMPL;
    private final CardViewDelegate mCardViewDelegate = new CardViewDelegate() {
        private Drawable mCardBackground;

        public void setCardBackground(Drawable drawable) {
            this.mCardBackground = drawable;
            CardView.this.setBackgroundDrawable(drawable);
        }

        public boolean getUseCompatPadding() {
            return CardView.this.getUseCompatPadding();
        }

        public boolean getPreventCornerOverlap() {
            return CardView.this.getPreventCornerOverlap();
        }

        public void setShadowPadding(int i, int i2, int i3, int i4) {
            CardView.this.mShadowBounds.set(i, i2, i3, i4);
            super.setPadding(i + CardView.this.mContentPadding.left, i2 + CardView.this.mContentPadding.top, i3 + CardView.this.mContentPadding.right, i4 + CardView.this.mContentPadding.bottom);
        }

        public void setMinWidthHeightInternal(int i, int i2) {
            if (i > CardView.this.mUserSetMinWidth) {
                super.setMinimumWidth(i);
            }
            if (i2 > CardView.this.mUserSetMinHeight) {
                super.setMinimumHeight(i2);
            }
        }

        public Drawable getCardBackground() {
            return this.mCardBackground;
        }

        public View getCardView() {
            return CardView.this;
        }
    };
    private boolean mCompatPadding;
    final Rect mContentPadding = new Rect();
    private boolean mPreventCornerOverlap;
    final Rect mShadowBounds = new Rect();
    int mUserSetMinHeight;
    int mUserSetMinWidth;

    public void setPadding(int i, int i2, int i3, int i4) {
    }

    public void setPaddingRelative(int i, int i2, int i3, int i4) {
    }

    static {
        if (VERSION.SDK_INT >= 21) {
            IMPL = new CardViewApi21Impl();
        } else if (VERSION.SDK_INT >= 17) {
            IMPL = new CardViewApi17Impl();
        } else {
            IMPL = new CardViewBaseImpl();
        }
        IMPL.initStatic();
    }

    public CardView(Context context) {
        super(context);
        initialize(context, null, 0);
    }

    public CardView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initialize(context, attributeSet, 0);
    }

    public CardView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        initialize(context, attributeSet, i);
    }

    public boolean getUseCompatPadding() {
        return this.mCompatPadding;
    }

    public void setUseCompatPadding(boolean z) {
        if (this.mCompatPadding != z) {
            this.mCompatPadding = z;
            IMPL.onCompatPaddingChanged(this.mCardViewDelegate);
        }
    }

    public void setContentPadding(int i, int i2, int i3, int i4) {
        this.mContentPadding.set(i, i2, i3, i4);
        IMPL.updatePadding(this.mCardViewDelegate);
    }

    protected void onMeasure(int i, int i2) {
        if (IMPL instanceof CardViewApi21Impl) {
            super.onMeasure(i, i2);
            return;
        }
        int mode = MeasureSpec.getMode(i);
        if (mode == Integer.MIN_VALUE || mode == 1073741824) {
            i = MeasureSpec.makeMeasureSpec(Math.max((int) Math.ceil((double) IMPL.getMinWidth(this.mCardViewDelegate)), MeasureSpec.getSize(i)), mode);
        }
        mode = MeasureSpec.getMode(i2);
        if (mode == Integer.MIN_VALUE || mode == 1073741824) {
            i2 = MeasureSpec.makeMeasureSpec(Math.max((int) Math.ceil((double) IMPL.getMinHeight(this.mCardViewDelegate)), MeasureSpec.getSize(i2)), mode);
        }
        super.onMeasure(i, i2);
    }

    private void initialize(Context context, AttributeSet attributeSet, int i) {
        int color;
        attributeSet = context.obtainStyledAttributes(attributeSet, R.styleable.CardView, i, R.style.CardView);
        if (attributeSet.hasValue(R.styleable.CardView_cardBackgroundColor) != 0) {
            i = attributeSet.getColorStateList(R.styleable.CardView_cardBackgroundColor);
        } else {
            i = getContext().obtainStyledAttributes(COLOR_BACKGROUND_ATTR);
            color = i.getColor(0, 0);
            i.recycle();
            i = new float[3];
            Color.colorToHSV(color, i);
            if (i[2] > 1056964608) {
                i = getResources().getColor(R.color.cardview_light_background);
            } else {
                i = getResources().getColor(R.color.cardview_dark_background);
            }
            i = ColorStateList.valueOf(i);
        }
        ColorStateList colorStateList = i;
        float dimension = attributeSet.getDimension(R.styleable.CardView_cardCornerRadius, 0.0f);
        float dimension2 = attributeSet.getDimension(R.styleable.CardView_cardElevation, 0.0f);
        i = attributeSet.getDimension(R.styleable.CardView_cardMaxElevation, 0.0f);
        this.mCompatPadding = attributeSet.getBoolean(R.styleable.CardView_cardUseCompatPadding, false);
        this.mPreventCornerOverlap = attributeSet.getBoolean(R.styleable.CardView_cardPreventCornerOverlap, true);
        color = attributeSet.getDimensionPixelSize(R.styleable.CardView_contentPadding, 0);
        this.mContentPadding.left = attributeSet.getDimensionPixelSize(R.styleable.CardView_contentPaddingLeft, color);
        this.mContentPadding.top = attributeSet.getDimensionPixelSize(R.styleable.CardView_contentPaddingTop, color);
        this.mContentPadding.right = attributeSet.getDimensionPixelSize(R.styleable.CardView_contentPaddingRight, color);
        this.mContentPadding.bottom = attributeSet.getDimensionPixelSize(R.styleable.CardView_contentPaddingBottom, color);
        float f = dimension2 > i ? dimension2 : i;
        this.mUserSetMinWidth = attributeSet.getDimensionPixelSize(R.styleable.CardView_android_minWidth, 0);
        this.mUserSetMinHeight = attributeSet.getDimensionPixelSize(R.styleable.CardView_android_minHeight, 0);
        attributeSet.recycle();
        IMPL.initialize(this.mCardViewDelegate, context, colorStateList, dimension, dimension2, f);
    }

    public void setMinimumWidth(int i) {
        this.mUserSetMinWidth = i;
        super.setMinimumWidth(i);
    }

    public void setMinimumHeight(int i) {
        this.mUserSetMinHeight = i;
        super.setMinimumHeight(i);
    }

    public void setCardBackgroundColor(@ColorInt int i) {
        IMPL.setBackgroundColor(this.mCardViewDelegate, ColorStateList.valueOf(i));
    }

    public void setCardBackgroundColor(@Nullable ColorStateList colorStateList) {
        IMPL.setBackgroundColor(this.mCardViewDelegate, colorStateList);
    }

    public ColorStateList getCardBackgroundColor() {
        return IMPL.getBackgroundColor(this.mCardViewDelegate);
    }

    public int getContentPaddingLeft() {
        return this.mContentPadding.left;
    }

    public int getContentPaddingRight() {
        return this.mContentPadding.right;
    }

    public int getContentPaddingTop() {
        return this.mContentPadding.top;
    }

    public int getContentPaddingBottom() {
        return this.mContentPadding.bottom;
    }

    public void setRadius(float f) {
        IMPL.setRadius(this.mCardViewDelegate, f);
    }

    public float getRadius() {
        return IMPL.getRadius(this.mCardViewDelegate);
    }

    public void setCardElevation(float f) {
        IMPL.setElevation(this.mCardViewDelegate, f);
    }

    public float getCardElevation() {
        return IMPL.getElevation(this.mCardViewDelegate);
    }

    public void setMaxCardElevation(float f) {
        IMPL.setMaxElevation(this.mCardViewDelegate, f);
    }

    public float getMaxCardElevation() {
        return IMPL.getMaxElevation(this.mCardViewDelegate);
    }

    public boolean getPreventCornerOverlap() {
        return this.mPreventCornerOverlap;
    }

    public void setPreventCornerOverlap(boolean z) {
        if (z != this.mPreventCornerOverlap) {
            this.mPreventCornerOverlap = z;
            IMPL.onPreventCornerOverlapChanged(this.mCardViewDelegate);
        }
    }
}
