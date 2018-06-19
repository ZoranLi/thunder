package com.xunlei.downloadprovider.vod.player;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.Region.Op;
import android.graphics.RegionIterator;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.AppCompatSeekBar;
import android.util.AttributeSet;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.download.engine.task.info.TaskRangeInfo;
import java.util.List;

public class PlaySeekBar extends AppCompatSeekBar {
    public Paint a;
    public Paint b;
    public Paint c;
    public List<TaskRangeInfo> d;
    public long e;
    private int f = 10;
    private Region g;
    private float h;
    private Drawable i;
    private int j;

    public PlaySeekBar(Context context) {
        super(context);
        a();
    }

    public PlaySeekBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    public PlaySeekBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a();
    }

    public void setThumb(Drawable drawable) {
        super.setThumb(drawable);
        this.i = drawable;
    }

    public android.graphics.drawable.Drawable getThumb() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r1 = this;
        r0 = super.getThumb();	 Catch:{ Throwable -> 0x0005 }
        return r0;
    L_0x0005:
        r0 = r1.i;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.downloadprovider.vod.player.PlaySeekBar.getThumb():android.graphics.drawable.Drawable");
    }

    private void a() {
        this.d = null;
        this.e = -1;
        this.b = new Paint();
        this.b.setColor(getResources().getColor(R.color.vod_player_seek_bar_background));
        this.a = new Paint();
        this.a.setColor(getResources().getColor(R.color.vod_player_seek_bar_progress));
        this.c = new Paint();
        this.c.setColor(getResources().getColor(R.color.vod_player_seek_bar_cache));
    }

    public void setTrackStrokeSize(int i) {
        this.f = i;
        invalidate();
    }

    @SuppressLint({"DrawAllocation"})
    protected synchronized void onDraw(Canvas canvas) {
        if (!(this.j == 0 || this.j == getWidth())) {
            this.h = ((float) getWidth()) / ((float) this.j);
        }
        this.j = getWidth();
        int paddingTop = getPaddingTop() + ((((getHeight() - getPaddingBottom()) - getPaddingTop()) - this.f) / 2);
        Rect rect = new Rect(getPaddingLeft(), paddingTop, getWidth() - getPaddingRight(), this.f + paddingTop);
        canvas.drawRect(rect, this.b);
        a(canvas, rect);
        Drawable thumb = getThumb();
        Rect rect2 = new Rect(rect);
        rect2.right = Math.max(rect2.left, thumb.getBounds().right - 12);
        canvas.drawRect(rect2, this.a);
        if (this.i != null) {
            paddingTop = canvas.save();
            canvas.translate((float) (getPaddingLeft() - getThumbOffset()), (float) getPaddingTop());
            this.i.draw(canvas);
            canvas.restoreToCount(paddingTop);
        }
    }

    private void a(Canvas canvas, Rect rect) {
        Rect rect2;
        int i = rect.top;
        int i2 = rect.bottom;
        int i3 = rect.left;
        rect = rect.width();
        if (this.h != 0.0f) {
            Region a = a(i3, i, i2);
            this.g = new Region(i3, i, 1, i2);
            RegionIterator regionIterator = new RegionIterator(a);
            rect2 = new Rect();
            while (regionIterator.next(rect2)) {
                rect2.set((int) (((float) rect2.left) * this.h), rect2.top, (int) (((float) rect2.right) * this.h), rect2.bottom);
                this.g.op(rect2, Op.UNION);
            }
            this.h = 0.0f;
        }
        if (this.e > 0 && this.d != null) {
            rect2 = new Rect();
            double d = (((double) rect) * 1.0d) / ((double) this.e);
            int i4 = i3;
            for (TaskRangeInfo taskRangeInfo : this.d) {
                if (((float) taskRangeInfo.getLength()) / ((float) this.e) > 0.003f) {
                    int startPosition = ((int) (((double) taskRangeInfo.getStartPosition()) * d)) + i3;
                    int endPosition = ((int) (((double) taskRangeInfo.getEndPosition()) * d)) + i3;
                    if (((float) (startPosition - i4)) / ((float) rect) >= 0.003f) {
                        i4 = startPosition;
                    }
                    rect2.set(i4, i, endPosition, i2);
                    a(i3, i, i2).op(rect2, Op.UNION);
                    i4 = endPosition;
                }
            }
        }
        a(canvas, a(i3, i, i2), this.c);
    }

    private static void a(Canvas canvas, Region region, Paint paint) {
        RegionIterator regionIterator = new RegionIterator(region);
        region = new Rect();
        while (regionIterator.next(region)) {
            canvas.drawRect(region, paint);
        }
    }

    private Region a(int i, int i2, int i3) {
        if (this.g == null) {
            this.g = new Region(i, i2, 1, i3);
        }
        return this.g;
    }
}
