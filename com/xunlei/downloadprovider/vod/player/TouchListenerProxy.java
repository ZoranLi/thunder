package com.xunlei.downloadprovider.vod.player;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

public class TouchListenerProxy implements OnTouchListener {
    private static final String b = "com.xunlei.downloadprovider.vod.player.TouchListenerProxy";
    public int a = 7;
    private long c = 0;
    private float d = 0.0f;
    private float e = 0.0f;
    private TouchOperateType f = TouchOperateType.touch_singleTap;
    private a g = null;
    private float h;
    private float i;
    private float j;
    private float k;
    private float l;
    private Runnable m = new a(this);

    public enum TouchOperateType {
        touch_singleTap,
        touch_doubleTap,
        touch_moveHorizontal,
        touch_moveVerticalLeft,
        touch_moveVerticalRight
    }

    public interface a {
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        new StringBuilder("onTouch=>").append(motionEvent.getAction());
        switch (motionEvent.getAction() & 255) {
            case 0:
                this.f = TouchOperateType.touch_singleTap;
                this.d = motionEvent.getX();
                this.e = motionEvent.getY();
                this.h = this.d;
                this.i = this.e;
                break;
            case 1:
            case 3:
                new StringBuilder("MotionEvent.ACTION_UP mTouchFlag: ").append(this.a);
                if (b.a[this.f.ordinal()] == 1) {
                    long currentTimeMillis = System.currentTimeMillis();
                    if (currentTimeMillis - this.c > 200) {
                        this.c = currentTimeMillis;
                        view.postDelayed(this.m, 200);
                        break;
                    }
                    this.c = 0;
                    view.removeCallbacks(this.m);
                    if (this.g != null) {
                        view = this.a & 2;
                        break;
                    }
                }
                break;
                break;
            case 2:
                boolean z;
                float f;
                float f2 = this.h;
                float f3 = this.i;
                boolean z2 = false;
                if (f2 > this.l && f2 < this.j - this.l && f3 > this.l) {
                    if (f3 < this.k - this.l) {
                        z = false;
                        if (z) {
                            f2 = motionEvent.getX();
                            motionEvent = motionEvent.getY();
                            if (this.f == TouchOperateType.touch_singleTap) {
                                if (!(this.g == null || (this.a & 4) == null || this.f == TouchOperateType.touch_moveHorizontal || this.f == TouchOperateType.touch_moveVerticalLeft)) {
                                    view = TouchOperateType.touch_moveVerticalRight;
                                }
                                this.d = f2;
                                this.e = motionEvent;
                                break;
                            }
                            view = (float) view.getWidth();
                            f3 = this.d;
                            f = this.e;
                            if (this.f == TouchOperateType.touch_singleTap) {
                                if (Math.abs(f2 - f3) > 50.0f) {
                                    this.f = TouchOperateType.touch_moveHorizontal;
                                    if (this.g != null) {
                                        view = this.a & 4;
                                    }
                                } else if (Math.abs(motionEvent - f) > 50.0f) {
                                    if (f2 >= view / 2.0f) {
                                        this.f = TouchOperateType.touch_moveVerticalLeft;
                                        if (this.g != null) {
                                            view = this.a & 4;
                                        }
                                    } else {
                                        this.f = TouchOperateType.touch_moveVerticalRight;
                                    }
                                }
                                z2 = true;
                            }
                            if (z2) {
                                this.d = f2;
                                this.e = motionEvent;
                                break;
                            }
                        }
                        this.f = TouchOperateType.touch_moveHorizontal;
                        return true;
                    }
                }
                z = true;
                if (z) {
                    f2 = motionEvent.getX();
                    motionEvent = motionEvent.getY();
                    if (this.f == TouchOperateType.touch_singleTap) {
                        view = TouchOperateType.touch_moveVerticalRight;
                        this.d = f2;
                        this.e = motionEvent;
                        break;
                    }
                    view = (float) view.getWidth();
                    f3 = this.d;
                    f = this.e;
                    if (this.f == TouchOperateType.touch_singleTap) {
                        if (Math.abs(f2 - f3) > 50.0f) {
                            this.f = TouchOperateType.touch_moveHorizontal;
                            if (this.g != null) {
                                view = this.a & 4;
                            }
                        } else if (Math.abs(motionEvent - f) > 50.0f) {
                            if (f2 >= view / 2.0f) {
                                this.f = TouchOperateType.touch_moveVerticalRight;
                            } else {
                                this.f = TouchOperateType.touch_moveVerticalLeft;
                                if (this.g != null) {
                                    view = this.a & 4;
                                }
                            }
                        }
                        z2 = true;
                    }
                    if (z2) {
                        this.d = f2;
                        this.e = motionEvent;
                    }
                } else {
                    this.f = TouchOperateType.touch_moveHorizontal;
                    return true;
                }
                break;
            default:
                break;
        }
        return true;
    }
}
