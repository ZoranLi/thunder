package com.xunlei.common.commonview.anim;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;

public class MovingImageView extends ImageView {
    private float canvasHeight;
    private float canvasWidth;
    private float imageHeight;
    private float imageWidth;
    private boolean loadOnCreate;
    private MovingViewAnimator mAnimator;
    private int mRepetitions;
    private int mSpeed;
    private float maxRelativeSize;
    private float minRelativeOffset;
    private int movementType;
    private float offsetHeight;
    private float offsetWidth;
    private long startDelay;

    @Deprecated
    public void setScaleType(ScaleType scaleType) {
    }

    public MovingImageView(Context context) {
        this(context, null);
    }

    public MovingImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MovingImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.maxRelativeSize = 3.0f;
        this.minRelativeOffset = 0.3f;
        this.mSpeed = 50;
        this.mRepetitions = -1;
        this.startDelay = null;
        this.loadOnCreate = true;
        init();
    }

    private void init() {
        super.setScaleType(ScaleType.MATRIX);
        this.mAnimator = new MovingViewAnimator(this);
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.canvasWidth = ((float) i) - ((float) (getPaddingLeft() + getPaddingRight()));
        this.canvasHeight = ((float) i2) - ((float) (getPaddingTop() + getPaddingBottom()));
        updateAll();
    }

    private void updateAll() {
        if (getDrawable() != null) {
            updateImageSize();
            updateOffsets();
            updateAnimator();
        }
    }

    private void updateImageSize() {
        this.imageWidth = (float) getDrawable().getIntrinsicWidth();
        this.imageHeight = (float) getDrawable().getIntrinsicHeight();
    }

    private void updateOffsets() {
        float f = this.imageHeight * this.minRelativeOffset;
        float f2 = 0.0f;
        this.offsetWidth = (this.imageWidth - this.canvasWidth) - (this.imageWidth * this.minRelativeOffset) > 0.0f ? this.imageWidth - this.canvasWidth : 0.0f;
        if ((this.imageHeight - this.canvasHeight) - f > 0.0f) {
            f2 = this.imageHeight - this.canvasHeight;
        }
        this.offsetHeight = f2;
    }

    private void updateAnimator() {
        if (this.canvasHeight != 0.0f || this.canvasWidth != 0.0f) {
            float calculateTypeAndScale = calculateTypeAndScale();
            if (calculateTypeAndScale != 0.0f) {
                this.mAnimator.updateValues(this.movementType, (this.imageWidth * calculateTypeAndScale) - this.canvasWidth, (this.imageHeight * calculateTypeAndScale) - this.canvasHeight);
                this.mAnimator.setStartDelay(this.startDelay);
                this.mAnimator.setSpeed(this.mSpeed);
                this.mAnimator.setRepetition(this.mRepetitions);
                if (this.loadOnCreate) {
                    this.mAnimator.start();
                }
            }
        }
    }

    private float calculateTypeAndScale() {
        this.movementType = 0;
        float max = Math.max(this.imageWidth / this.canvasWidth, this.imageHeight / this.canvasHeight);
        Matrix matrix = new Matrix();
        int i = 1;
        if (this.offsetWidth == 0.0f && this.offsetHeight == 0.0f) {
            max = this.canvasWidth / this.imageWidth;
            float f = this.canvasHeight / this.imageHeight;
            if (max > f) {
                max = Math.min(max, this.maxRelativeSize);
                matrix.setTranslate((this.canvasWidth - (this.imageWidth * max)) / 2.0f, 0.0f);
                i = 2;
            } else if (max < f) {
                max = Math.min(f, this.maxRelativeSize);
                matrix.setTranslate(0.0f, (this.canvasHeight - (this.imageHeight * max)) / 2.0f);
            } else {
                f = Math.max(max, this.maxRelativeSize);
                i = f == max ? -1 : 3;
                max = f;
            }
            this.movementType = i;
        } else if (this.offsetWidth == 0.0f) {
            max = this.canvasWidth / this.imageWidth;
            this.movementType = 2;
        } else if (this.offsetHeight == 0.0f) {
            max = this.canvasHeight / this.imageHeight;
            this.movementType = 1;
        } else if (max > this.maxRelativeSize) {
            max = this.maxRelativeSize / max;
            if (this.imageWidth * max < this.canvasWidth || this.imageHeight * max < this.canvasHeight) {
                max = Math.max(this.canvasWidth / this.imageWidth, this.canvasHeight / this.imageHeight);
            }
        } else {
            max = 1.0f;
        }
        matrix.preScale(max, max);
        setImageMatrix(matrix);
        return max;
    }

    public void setImageResource(int i) {
        super.setImageResource(i);
        updateAll();
    }

    public void setImageURI(Uri uri) {
        super.setImageURI(uri);
        updateAll();
    }

    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        updateAll();
    }

    public void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
        updateAll();
    }

    public MovingViewAnimator getMovingAnimator() {
        return this.mAnimator;
    }

    public float getMaxRelativeSize() {
        return this.maxRelativeSize;
    }

    public void setMaxRelativeSize(float f) {
        this.maxRelativeSize = f;
        updateAnimator();
    }

    public float getMinRelativeOffset() {
        return this.minRelativeOffset;
    }

    public void setMinRelativeOffset(float f) {
        this.minRelativeOffset = f;
        updateAnimator();
    }

    public boolean isLoadOnCreate() {
        return this.loadOnCreate;
    }

    public void setLoadOnCreate(boolean z) {
        this.loadOnCreate = z;
    }
}
