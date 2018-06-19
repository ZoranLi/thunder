package android.support.v4.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.annotation.ColorInt;
import android.support.annotation.ColorRes;
import android.support.annotation.DrawableRes;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewConfiguration;
import com.xunlei.downloadprovider.member.payment.external.PayBaseConstants;

public class PagerTabStrip extends PagerTitleStrip {
    private static final int FULL_UNDERLINE_HEIGHT = 1;
    private static final int INDICATOR_HEIGHT = 3;
    private static final int MIN_PADDING_BOTTOM = 6;
    private static final int MIN_STRIP_HEIGHT = 32;
    private static final int MIN_TEXT_SPACING = 64;
    private static final int TAB_PADDING = 16;
    private static final int TAB_SPACING = 32;
    private static final String TAG = "PagerTabStrip";
    private boolean mDrawFullUnderline;
    private boolean mDrawFullUnderlineSet;
    private int mFullUnderlineHeight;
    private boolean mIgnoreTap;
    private int mIndicatorColor;
    private int mIndicatorHeight;
    private float mInitialMotionX;
    private float mInitialMotionY;
    private int mMinPaddingBottom;
    private int mMinStripHeight;
    private int mMinTextSpacing;
    private int mTabAlpha;
    private int mTabPadding;
    private final Paint mTabPaint;
    private final Rect mTempRect;
    private int mTouchSlop;

    public PagerTabStrip(Context context) {
        this(context, null);
    }

    public PagerTabStrip(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mTabPaint = new Paint();
        this.mTempRect = new Rect();
        this.mTabAlpha = 255;
        this.mDrawFullUnderline = false;
        this.mDrawFullUnderlineSet = false;
        this.mIndicatorColor = this.mTextColor;
        this.mTabPaint.setColor(this.mIndicatorColor);
        float f = context.getResources().getDisplayMetrics().density;
        this.mIndicatorHeight = (int) ((3.0f * f) + PayBaseConstants.HALF_OF_FLOAT);
        this.mMinPaddingBottom = (int) ((6.0f * f) + PayBaseConstants.HALF_OF_FLOAT);
        this.mMinTextSpacing = (int) (64.0f * f);
        this.mTabPadding = (int) ((16.0f * f) + PayBaseConstants.HALF_OF_FLOAT);
        this.mFullUnderlineHeight = (int) ((1.0f * f) + PayBaseConstants.HALF_OF_FLOAT);
        this.mMinStripHeight = (int) ((32.0f * f) + PayBaseConstants.HALF_OF_FLOAT);
        this.mTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
        setPadding(getPaddingLeft(), getPaddingTop(), getPaddingRight(), getPaddingBottom());
        setTextSpacing(getTextSpacing());
        setWillNotDraw(false);
        this.mPrevText.setFocusable(true);
        this.mPrevText.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                PagerTabStrip.this.mPager.setCurrentItem(PagerTabStrip.this.mPager.getCurrentItem() - 1);
            }
        });
        this.mNextText.setFocusable(true);
        this.mNextText.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                PagerTabStrip.this.mPager.setCurrentItem(PagerTabStrip.this.mPager.getCurrentItem() + 1);
            }
        });
        if (getBackground() == null) {
            this.mDrawFullUnderline = true;
        }
    }

    public void setTabIndicatorColor(@ColorInt int i) {
        this.mIndicatorColor = i;
        this.mTabPaint.setColor(this.mIndicatorColor);
        invalidate();
    }

    public void setTabIndicatorColorResource(@ColorRes int i) {
        setTabIndicatorColor(ContextCompat.getColor(getContext(), i));
    }

    @ColorInt
    public int getTabIndicatorColor() {
        return this.mIndicatorColor;
    }

    public void setPadding(int i, int i2, int i3, int i4) {
        if (i4 < this.mMinPaddingBottom) {
            i4 = this.mMinPaddingBottom;
        }
        super.setPadding(i, i2, i3, i4);
    }

    public void setTextSpacing(int i) {
        if (i < this.mMinTextSpacing) {
            i = this.mMinTextSpacing;
        }
        super.setTextSpacing(i);
    }

    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        if (!this.mDrawFullUnderlineSet) {
            this.mDrawFullUnderline = drawable == null ? true : null;
        }
    }

    public void setBackgroundColor(@ColorInt int i) {
        super.setBackgroundColor(i);
        if (!this.mDrawFullUnderlineSet) {
            this.mDrawFullUnderline = (i & -16777216) == 0 ? 1 : 0;
        }
    }

    public void setBackgroundResource(@DrawableRes int i) {
        super.setBackgroundResource(i);
        if (!this.mDrawFullUnderlineSet) {
            this.mDrawFullUnderline = i == 0 ? 1 : 0;
        }
    }

    public void setDrawFullUnderline(boolean z) {
        this.mDrawFullUnderline = z;
        this.mDrawFullUnderlineSet = true;
        invalidate();
    }

    public boolean getDrawFullUnderline() {
        return this.mDrawFullUnderline;
    }

    int getMinHeight() {
        return Math.max(super.getMinHeight(), this.mMinStripHeight);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action != 0 && this.mIgnoreTap) {
            return false;
        }
        float x = motionEvent.getX();
        motionEvent = motionEvent.getY();
        switch (action) {
            case 0:
                this.mInitialMotionX = x;
                this.mInitialMotionY = motionEvent;
                this.mIgnoreTap = false;
                break;
            case 1:
                if (x >= ((float) (this.mCurrText.getLeft() - this.mTabPadding))) {
                    if (x > ((float) (this.mCurrText.getRight() + this.mTabPadding))) {
                        this.mPager.setCurrentItem(this.mPager.getCurrentItem() + 1);
                        break;
                    }
                }
                this.mPager.setCurrentItem(this.mPager.getCurrentItem() - 1);
                break;
                break;
            case 2:
                if (Math.abs(x - this.mInitialMotionX) > ((float) this.mTouchSlop) || Math.abs(motionEvent - this.mInitialMotionY) > ((float) this.mTouchSlop)) {
                    this.mIgnoreTap = true;
                    break;
                }
            default:
                break;
        }
        return true;
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int height = getHeight();
        int left = this.mCurrText.getLeft() - this.mTabPadding;
        int right = this.mCurrText.getRight() + this.mTabPadding;
        int i = height - this.mIndicatorHeight;
        this.mTabPaint.setColor((this.mTabAlpha << 24) | (this.mIndicatorColor & ViewCompat.MEASURED_SIZE_MASK));
        float f = (float) height;
        canvas.drawRect((float) left, (float) i, (float) right, f, this.mTabPaint);
        if (this.mDrawFullUnderline) {
            this.mTabPaint.setColor(-16777216 | (this.mIndicatorColor & ViewCompat.MEASURED_SIZE_MASK));
            canvas.drawRect((float) getPaddingLeft(), (float) (height - this.mFullUnderlineHeight), (float) (getWidth() - getPaddingRight()), f, this.mTabPaint);
        }
    }

    void updateTextPositions(int i, float f, boolean z) {
        Rect rect = this.mTempRect;
        int height = getHeight();
        int i2 = height - this.mIndicatorHeight;
        rect.set(this.mCurrText.getLeft() - this.mTabPadding, i2, this.mCurrText.getRight() + this.mTabPadding, height);
        super.updateTextPositions(i, f, z);
        this.mTabAlpha = (int) ((Math.abs(f - 1056964608) * 1073741824) * 1132396544);
        rect.union(this.mCurrText.getLeft() - this.mTabPadding, i2, this.mCurrText.getRight() + this.mTabPadding, height);
        invalidate(rect);
    }
}
