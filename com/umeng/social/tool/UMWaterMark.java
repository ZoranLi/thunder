package com.umeng.social.tool;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import com.xunlei.downloadprovider.member.payment.external.PayBaseConstants;

class UMWaterMark {
    static final int RELATIVE_POSITION_HORIZONTAL_LEFT = 4;
    static final int RELATIVE_POSITION_HORIZONTAL_RIGHT = 3;
    static final int RELATIVE_POSITION_VERTICAL_BOTTOM = 1;
    static final int RELATIVE_POSITION_VERTICAL_TOP = 2;
    private static final String TAG = "UMWaterMark";
    private float mAlpha = -1.0f;
    private Rect mAnchorMarkRect = new Rect();
    private int mBottomMargin;
    private Context mContext;
    private int mDegree = -1;
    private int mGravity = 51;
    private int mHorizontalRelativePosition = -1;
    private boolean mIsBringToFront = false;
    private boolean mIsTransparent = false;
    private int mLeftMargin;
    private Rect mMeasureRect = new Rect();
    private int mRightMargin;
    private float mScale = 0.3f;
    private int mTopMargin;
    private int mVerticalRelativePosition = -1;

    Bitmap getMarkBitmap() {
        return null;
    }

    void releaseResource() {
    }

    UMWaterMark() {
    }

    public void setMargins(int i, int i2, int i3, int i4) {
        this.mLeftMargin = i;
        this.mTopMargin = i2;
        this.mRightMargin = i3;
        this.mBottomMargin = i4;
    }

    public void setContext(Context context) {
        this.mContext = context;
    }

    public void setGravity(int i) {
        if (i > 0 && this.mGravity != i) {
            this.mGravity = i;
        }
    }

    public void setScale(float f) {
        if (f >= 0.0f) {
            if (f <= 1.0f) {
                this.mScale = f;
            }
        }
    }

    public void setRotate(int i) {
        if (i >= 0) {
            if (i <= 360) {
                this.mDegree = i;
            }
        }
    }

    public void bringToFront() {
        this.mIsBringToFront = true;
    }

    public void setAlpha(float f) {
        if (f >= 0.0f) {
            if (f <= 1.0f) {
                this.mAlpha = f;
            }
        }
    }

    public void setTransparent() {
        this.mIsTransparent = true;
    }

    public Bitmap compound(Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        }
        try {
            Bitmap markBitmap = getMarkBitmap();
            if (markBitmap == null) {
                return bitmap;
            }
            StringBuilder stringBuilder;
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            if (width > 0) {
                if (height > 0) {
                    int markWidth = getMarkWidth();
                    int markHeight = getMarkHeight();
                    if (markWidth > 0) {
                        if (markHeight > 0) {
                            Bitmap createBitmap;
                            Canvas canvas;
                            if (this.mIsTransparent) {
                                createBitmap = Bitmap.createBitmap(width, height, Config.ARGB_8888);
                                canvas = new Canvas(createBitmap);
                                canvas.drawColor(0);
                            } else {
                                createBitmap = Bitmap.createBitmap(width, height, Config.RGB_565);
                                canvas = new Canvas(createBitmap);
                            }
                            canvas.drawBitmap(bitmap, 0.0f, 0.0f, null);
                            Matrix matrix = new Matrix();
                            float min = (this.mScale * ((float) Math.min(bitmap.getWidth(), bitmap.getHeight()))) / ((float) Math.max(markWidth, markHeight));
                            matrix.postScale(min, min, getScaleAnchorX(markWidth), getScaleAnchorY(markHeight));
                            if (this.mDegree != -1) {
                                matrix.postRotate((float) this.mDegree, (float) (markWidth / 2), (float) (markHeight / 2));
                            }
                            matrix.postTranslate(isHorizontalRelativePosition() ? getRelativeDx(width) : getDx(width), isVerticalRelativePosition() ? getRelativeDy(height) : getDy(height));
                            if (this.mAlpha != -1.0f) {
                                Paint paint = new Paint();
                                paint.setAlpha((int) (255.0f * this.mAlpha));
                                canvas.drawBitmap(markBitmap, matrix, paint);
                            } else {
                                canvas.drawBitmap(markBitmap, matrix, null);
                            }
                            canvas.save(31);
                            canvas.restore();
                            safelyRecycleBitmap(bitmap);
                            safelyRecycleBitmap(markBitmap);
                            releaseResource();
                            return createBitmap;
                        }
                    }
                    stringBuilder = new StringBuilder("mark bitmap is error, markWidth:");
                    stringBuilder.append(markWidth);
                    stringBuilder.append(", markHeight:");
                    stringBuilder.append(markHeight);
                    return bitmap;
                }
            }
            stringBuilder = new StringBuilder("mark bitmap is error, markWidth:");
            stringBuilder.append(width);
            stringBuilder.append(", markHeight:");
            stringBuilder.append(height);
            return bitmap;
        } catch (Bitmap bitmap2) {
            bitmap2.printStackTrace();
            return null;
        }
    }

    private float getScaleAnchorY(int i) {
        int i2 = this.mGravity & 112;
        if (i2 != 16) {
            return i2 != 80 ? 0 : (float) i;
        } else {
            return (float) (i / 2);
        }
    }

    private float getScaleAnchorX(int i) {
        int i2 = this.mGravity & 7;
        if (i2 != 1) {
            return i2 != 5 ? 0 : (float) i;
        } else {
            return (float) (i / 2);
        }
    }

    private void safelyRecycleBitmap(Bitmap bitmap) {
        if (bitmap != null) {
            try {
                if (!bitmap.isRecycled()) {
                    bitmap.recycle();
                }
            } catch (Bitmap bitmap2) {
                bitmap2.printStackTrace();
            }
        }
    }

    private float getRelativeDy(int i) {
        float f = (float) this.mAnchorMarkRect.top;
        float f2 = (float) this.mAnchorMarkRect.bottom;
        switch (this.mVerticalRelativePosition) {
            case 1:
                return f2 + ((float) dip2px((float) this.mTopMargin));
            case 2:
                return (f - ((float) getMarkHeight())) + ((float) (-dip2px((float) this.mBottomMargin)));
            default:
                return getDy(i);
        }
    }

    private float getRelativeDx(int i) {
        float f = (float) this.mAnchorMarkRect.left;
        float f2 = (float) this.mAnchorMarkRect.right;
        switch (this.mHorizontalRelativePosition) {
            case 3:
                return f2 + ((float) dip2px((float) this.mLeftMargin));
            case 4:
                return (f - ((float) getMarkWidth())) + ((float) (-dip2px((float) this.mRightMargin)));
            default:
                return getDx(i);
        }
    }

    private float getDy(int i) {
        int i2 = -dip2px((float) this.mBottomMargin);
        int dip2px = dip2px((float) this.mTopMargin);
        int i3 = this.mGravity & 112;
        if (i3 == 16) {
            if (dip2px != 0) {
                i2 = dip2px;
            }
            return ((((float) (i - getMarkHeight())) * 1065353216) / 1073741824) + ((float) i2);
        } else if (i3 != 80) {
            return (float) dip2px;
        } else {
            return (float) ((i - getMarkHeight()) + i2);
        }
    }

    private float getDx(int i) {
        int dip2px = dip2px((float) this.mLeftMargin);
        int i2 = -dip2px((float) this.mRightMargin);
        int i3 = this.mGravity & 7;
        if (i3 == 1) {
            if (dip2px == 0) {
                dip2px = i2;
            }
            return ((((float) (i - getMarkWidth())) * 1065353216) / 1073741824) + ((float) dip2px);
        } else if (i3 != 5) {
            return (float) dip2px;
        } else {
            return (float) ((i - getMarkWidth()) + i2);
        }
    }

    private int getMarkWidth() {
        if (getMarkBitmap() == null) {
            return -1;
        }
        return getMarkBitmap().getWidth();
    }

    private int getMarkHeight() {
        if (getMarkBitmap() == null) {
            return -1;
        }
        return getMarkBitmap().getHeight();
    }

    void setAnchorMarkHorizontalRect(Rect rect) {
        this.mAnchorMarkRect.set(rect.left, this.mAnchorMarkRect.top, rect.right, this.mAnchorMarkRect.bottom);
    }

    void setAnchorMarkVerticalRect(Rect rect) {
        this.mAnchorMarkRect = rect;
        this.mAnchorMarkRect.set(this.mAnchorMarkRect.left, rect.top, this.mAnchorMarkRect.right, rect.bottom);
    }

    Rect onMeasure(int i, int i2) {
        int i3;
        int i4 = 0;
        if (isHorizontalRelativePosition()) {
            i = 0;
            i3 = i;
        } else {
            i = (int) getDx(i);
            i3 = getMarkWidth() + i;
        }
        if (isVerticalRelativePosition()) {
            i2 = 0;
        } else {
            i4 = (int) getDy(i2);
            i2 = getMarkHeight() + i4;
        }
        this.mMeasureRect.set(i, i4, i3, i2);
        return this.mMeasureRect;
    }

    void setHorizontalRelativePosition(int i) {
        this.mHorizontalRelativePosition = i;
    }

    void setVerticalRelativePosition(int i) {
        this.mVerticalRelativePosition = i;
    }

    void clearRelativePosition() {
        this.mHorizontalRelativePosition = -1;
        this.mVerticalRelativePosition = -1;
    }

    boolean isVerticalRelativePosition() {
        return this.mVerticalRelativePosition != -1;
    }

    boolean isHorizontalRelativePosition() {
        return this.mHorizontalRelativePosition != -1;
    }

    boolean isBringToFront() {
        return this.mIsBringToFront;
    }

    int dip2px(float f) {
        return (int) ((f * this.mContext.getResources().getDisplayMetrics().density) + PayBaseConstants.HALF_OF_FLOAT);
    }
}
