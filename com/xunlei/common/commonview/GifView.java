package com.xunlei.common.commonview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Movie;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.drawable.ColorDrawable;
import android.os.Build.VERSION;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import com.xunlei.common.R;

public class GifView extends View {
    private static final int DEFAULT_MOVIE_DURATION = 1000;
    private boolean byUser;
    private ColorDrawable mColorDrawable;
    private int mCurrentAnimationTime;
    private float mLeft;
    private int mMeasuredMovieHeight;
    private int mMeasuredMovieWidth;
    private Movie mMovie;
    private int mMovieResourceId;
    private long mMovieStart;
    private volatile boolean mPaused;
    private float mScale;
    private float mTop;
    private boolean mVisible;

    public GifView(Context context) {
        this(context, null);
    }

    public GifView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.styleable.CustomTheme_gifViewStyle);
    }

    public GifView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mCurrentAnimationTime = 0;
        this.mVisible = true;
        this.mPaused = false;
        setViewAttributes(context, attributeSet, i);
    }

    @SuppressLint({"NewApi"})
    private void setViewAttributes(Context context, AttributeSet attributeSet, int i) {
        if (VERSION.SDK_INT >= 11) {
            setLayerType(1, null);
        }
        context = context.obtainStyledAttributes(attributeSet, R.styleable.GifView, i, 0);
        this.mMovieResourceId = context.getResourceId(R.styleable.GifView_gif, -1);
        this.mPaused = context.getBoolean(R.styleable.GifView_paused, false);
        context.recycle();
        if (this.mMovieResourceId != -1) {
            this.mMovie = Movie.decodeStream(getResources().openRawResource(this.mMovieResourceId));
        }
    }

    public void setMovieResource(int i) {
        this.mMovieResourceId = i;
        this.mMovie = Movie.decodeStream(getResources().openRawResource(this.mMovieResourceId));
        requestLayout();
    }

    public void setMovie(Movie movie) {
        this.mMovie = movie;
        requestLayout();
    }

    public Movie getMovie() {
        return this.mMovie;
    }

    public void setMovieTime(int i) {
        this.mCurrentAnimationTime = i;
        invalidate();
    }

    public int getDuration() {
        return this.mMovie != null ? this.mMovie.duration() : 0;
    }

    public void setPaused(boolean z) {
        this.mPaused = z;
        if (!z) {
            this.mCurrentAnimationTime = false;
            this.mMovieStart = SystemClock.uptimeMillis() - ((long) this.mCurrentAnimationTime);
        }
        invalidate();
    }

    public void setByUser(boolean z) {
        this.byUser = z;
    }

    public boolean isByUser() {
        return this.byUser;
    }

    public boolean isPaused() {
        return this.mPaused;
    }

    protected void onMeasure(int i, int i2) {
        if (this.mMovie != 0) {
            i2 = this.mMovie.width();
            int height = this.mMovie.height();
            i = MeasureSpec.getSize(i);
            this.mScale = 1.0f / (((float) i2) / ((float) i));
            this.mMeasuredMovieWidth = i;
            this.mMeasuredMovieHeight = (int) (((float) height) * this.mScale);
            setMeasuredDimension(this.mMeasuredMovieWidth, this.mMeasuredMovieHeight);
            if (this.mColorDrawable != 0) {
                this.mColorDrawable.setBounds(0, 0, this.mMeasuredMovieWidth, this.mMeasuredMovieHeight);
            }
            return;
        }
        setMeasuredDimension(getSuggestedMinimumWidth(), getSuggestedMinimumHeight());
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.mLeft = ((float) (getWidth() - this.mMeasuredMovieWidth)) / true;
        this.mTop = ((float) (getHeight() - this.mMeasuredMovieHeight)) / true;
        this.mVisible = !getVisibility();
    }

    protected void onDraw(Canvas canvas) {
        if (this.mMovie != null) {
            if (this.mPaused) {
                drawMovieFrame(canvas);
            } else {
                if (!this.byUser) {
                    updateAnimationTime();
                }
                drawMovieFrame(canvas);
                invalidateView();
            }
        }
    }

    @SuppressLint({"NewApi"})
    private void invalidateView() {
        if (this.mVisible) {
            invalidate();
        }
    }

    private void updateAnimationTime() {
        long uptimeMillis = SystemClock.uptimeMillis();
        if (this.mMovieStart == 0) {
            this.mMovieStart = uptimeMillis;
        }
        int duration = this.mMovie.duration();
        if (duration == 0) {
            duration = 1000;
        }
        this.mCurrentAnimationTime = (int) ((uptimeMillis - this.mMovieStart) % ((long) duration));
    }

    private void drawMovieFrame(Canvas canvas) {
        if (this.mColorDrawable != null) {
            this.mColorDrawable.draw(canvas);
        }
        this.mMovie.setTime(this.mCurrentAnimationTime);
        canvas.setDrawFilter(new PaintFlagsDrawFilter(0, 3));
        canvas.save(1);
        canvas.scale(this.mScale, this.mScale);
        this.mMovie.draw(canvas, this.mLeft / this.mScale, this.mTop / this.mScale);
        canvas.restore();
    }

    @SuppressLint({"NewApi"})
    public void onScreenStateChanged(int i) {
        super.onScreenStateChanged(i);
        boolean z = true;
        if (i != 1) {
            z = false;
        }
        this.mVisible = z;
        invalidateView();
    }

    @SuppressLint({"NewApi"})
    protected void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        this.mVisible = i == 0 ? true : null;
        invalidateView();
    }

    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        this.mVisible = i == 0 ? 1 : 0;
        invalidateView();
    }

    public void setBgColor(int i) {
        this.mColorDrawable = new ColorDrawable(getContext().getResources().getColor(i));
        this.mColorDrawable.setBounds(0, 0, this.mMeasuredMovieWidth, this.mMeasuredMovieHeight);
    }
}
