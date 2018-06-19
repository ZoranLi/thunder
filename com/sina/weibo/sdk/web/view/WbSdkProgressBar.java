package com.sina.weibo.sdk.web.view;

import android.content.Context;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.View;
import com.xunlei.downloadprovider.member.payment.external.PayBaseConstants;

public class WbSdkProgressBar extends View {
    private boolean addStart;
    private double growTime;
    private double growTimeMax;
    private Handler handler;
    private long lastTime;
    private float length;
    private final int maxLength;
    private final int minLength;
    private int miniSize;
    private int padding;
    private Paint paint;
    private int paintWidth;
    private float progress;
    private RectF rect;
    private boolean showView;
    private float speed;
    private long stopGrowTime;
    private long stopGrowTimeMax;
    int stopNum;

    public WbSdkProgressBar(Context context) {
        this(context, null);
    }

    public WbSdkProgressBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public WbSdkProgressBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.minLength = 20;
        this.maxLength = 300;
        this.lastTime = 0;
        this.speed = 200.0f;
        this.stopGrowTimeMax = 180;
        this.stopGrowTime = 0;
        this.growTimeMax = 0;
        this.addStart = false;
        this.showView = true;
        this.stopNum = 0;
        this.handler = new Handler() {
            public void handleMessage(Message message) {
                super.handleMessage(message);
                if (message.what == null) {
                    WbSdkProgressBar.this.showView = false;
                }
            }
        };
        this.miniSize = dip2px(context, 50);
        this.paintWidth = dip2px(context, 5);
        this.padding = dip2px(context, 3);
        this.paint = new Paint();
        this.paint.setAntiAlias(true);
        this.paint.setColor(-48861);
        this.paint.setStyle(Style.STROKE);
        this.paint.setStrokeWidth((float) this.paintWidth);
        this.rect = new RectF((float) this.padding, (float) this.padding, (float) (this.miniSize - this.padding), (float) (this.miniSize - this.padding));
    }

    private int dip2px(Context context, int i) {
        return (int) (context.getResources().getDisplayMetrics().density * ((float) i));
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected synchronized void onDraw(android.graphics.Canvas r7) {
        /*
        r6 = this;
        monitor-enter(r6);
        r0 = android.os.SystemClock.uptimeMillis();	 Catch:{ all -> 0x005a }
        r2 = r6.lastTime;	 Catch:{ all -> 0x005a }
        r4 = r0 - r2;
        r0 = java.lang.Math.abs(r4);	 Catch:{ all -> 0x005a }
        r2 = 360; // 0x168 float:5.04E-43 double:1.78E-321;
        r0 = r0 % r2;
        r2 = r6.speed;	 Catch:{ all -> 0x005a }
        r3 = (float) r0;	 Catch:{ all -> 0x005a }
        r2 = r2 * r3;
        r3 = 1148846080; // 0x447a0000 float:1000.0 double:5.676053805E-315;
        r2 = r2 / r3;
        r6.calculateProgress(r0);	 Catch:{ all -> 0x005a }
        r0 = android.os.SystemClock.uptimeMillis();	 Catch:{ all -> 0x005a }
        r6.lastTime = r0;	 Catch:{ all -> 0x005a }
        r0 = r6.progress;	 Catch:{ all -> 0x005a }
        r0 = r0 + r2;
        r6.progress = r0;	 Catch:{ all -> 0x005a }
        r0 = r6.progress;	 Catch:{ all -> 0x005a }
        r1 = 1135869952; // 0x43b40000 float:360.0 double:5.611943214E-315;
        r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1));
        if (r0 < 0) goto L_0x0032;
    L_0x002d:
        r0 = r6.progress;	 Catch:{ all -> 0x005a }
        r0 = r0 - r1;
        r6.progress = r0;	 Catch:{ all -> 0x005a }
    L_0x0032:
        r1 = r6.rect;	 Catch:{ all -> 0x005a }
        r0 = r6.progress;	 Catch:{ all -> 0x005a }
        r2 = 1119092736; // 0x42b40000 float:90.0 double:5.529052754E-315;
        r2 = r0 - r2;
        r0 = 1101004800; // 0x41a00000 float:20.0 double:5.439686476E-315;
        r3 = r6.length;	 Catch:{ all -> 0x005a }
        r3 = r3 + r0;
        r4 = 0;
        r5 = r6.paint;	 Catch:{ all -> 0x005a }
        r0 = r7;
        r0.drawArc(r1, r2, r3, r4, r5);	 Catch:{ all -> 0x005a }
        r7 = r6.showView;	 Catch:{ all -> 0x005a }
        if (r7 == 0) goto L_0x0058;
    L_0x004a:
        r7 = android.os.Build.VERSION.SDK_INT;	 Catch:{ all -> 0x005a }
        r0 = 21;
        if (r7 < r0) goto L_0x0055;
    L_0x0050:
        r6.postInvalidate();	 Catch:{ all -> 0x005a }
        monitor-exit(r6);
        return;
    L_0x0055:
        r6.invalidate();	 Catch:{ all -> 0x005a }
    L_0x0058:
        monitor-exit(r6);
        return;
    L_0x005a:
        r7 = move-exception;
        monitor-exit(r6);
        throw r7;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sina.weibo.sdk.web.view.WbSdkProgressBar.onDraw(android.graphics.Canvas):void");
    }

    public void setProgressColor(int i) {
        this.paint.setColor(i);
    }

    protected void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        if (i == 8) {
            this.handler.sendEmptyMessageDelayed(0, 1000);
            return;
        }
        if (i == 0 && getVisibility() == 0) {
            this.handler.removeMessages(0);
            this.showView = true;
            invalidate();
        }
    }

    private void calculateProgress(long j) {
        if (this.stopGrowTime >= this.stopGrowTimeMax) {
            this.growTime += (double) j;
            if (this.growTime >= this.growTimeMax) {
                this.growTime -= this.growTimeMax;
                this.stopGrowTime = 0;
                this.addStart ^= 1;
            }
            j = (((float) Math.cos(((this.growTime / this.growTimeMax) + 4607182418800017408L) * 4614256656552045848L)) / 2.0f) + PayBaseConstants.HALF_OF_FLOAT;
            if (this.addStart) {
                float f = 280.0f * (1.0f - j);
                this.progress += this.length - f;
                this.length = f;
                return;
            }
            this.length = j * 1133248512;
            return;
        }
        this.stopGrowTime += j;
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        setMeasuredDimension(this.miniSize, this.miniSize);
    }
}
