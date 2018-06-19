package com.xunlei.downloadprovider.player.xmp.ui;

import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import com.xunlei.xllib.android.c;

/* compiled from: PlayerGestureViewDefault */
final class ag extends SimpleOnGestureListener {
    final /* synthetic */ PlayerGestureViewDefault a;

    ag(PlayerGestureViewDefault playerGestureViewDefault) {
        this.a = playerGestureViewDefault;
    }

    public final boolean onDown(MotionEvent motionEvent) {
        this.a.c = motionEvent.getRawX();
        this.a.d = motionEvent.getRawY();
        if (this.a.z != null) {
            int h = this.a.z.h();
            if (h >= null) {
                this.a.setTouchDownPosition(h);
            }
        }
        motionEvent = new StringBuilder("onDown--mState=");
        motionEvent.append(this.a.b);
        motionEvent.append("|X=");
        motionEvent.append(this.a.c);
        motionEvent.append("|Y=");
        motionEvent.append(this.a.d);
        return true;
    }

    public final boolean onSingleTapConfirmed(MotionEvent motionEvent) {
        if (this.a.A != null) {
            return this.a.A.a();
        }
        return super.onSingleTapConfirmed(motionEvent);
    }

    public final boolean onDoubleTap(MotionEvent motionEvent) {
        if (this.a.A != null) {
            return this.a.A.e();
        }
        return super.onDoubleTap(motionEvent);
    }

    public final void onLongPress(MotionEvent motionEvent) {
        if (this.a.A != null) {
            this.a.A.f();
        }
    }

    public final boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        if (this.a.w == null) {
            return true;
        }
        float c = this.a.c;
        float d = this.a.d;
        if (!PlayerGestureViewDefault.a(this.a, c, d)) {
            return true;
        }
        int x = (int) (motionEvent2.getX() - c);
        motionEvent2 = (int) (motionEvent2.getY() - d);
        int i = 0;
        switch (aj.a[this.a.b.ordinal()]) {
            case 1:
                if (Math.abs(f) <= Math.abs(f2)) {
                    if (c <= ((float) (this.a.getWidth() / 2))) {
                        PlayerGestureViewDefault.h(this.a);
                        break;
                    }
                    PlayerGestureViewDefault.g(this.a);
                    break;
                }
                PlayerGestureViewDefault.b(this.a, x);
                break;
            case 2:
                if (this.a.getDuration() > null) {
                    motionEvent = ((int) (((float) x) * this.a.h)) + this.a.f;
                    if (motionEvent >= null) {
                        i = motionEvent > this.a.getDuration() ? this.a.getDuration() : motionEvent;
                    }
                    this.a.a(x);
                    PlayerGestureViewDefault.a(this.a, i, this.a.getDuration());
                    this.a.k.setProgress(i);
                    this.a.g = i;
                    break;
                }
                return true;
            case 3:
                if (this.a.m > null) {
                    motionEvent = (-((motionEvent2 * this.a.m) / this.a.getHeight())) + this.a.n;
                    if (motionEvent >= null) {
                        i = motionEvent > this.a.m ? this.a.m : motionEvent;
                    }
                    this.a.b(i);
                    this.a.r.setProgress(i);
                    this.a.o.setStreamVolume(3, i, 1.1E-44f);
                    break;
                }
                break;
            case 4:
                if (this.a.s != null) {
                    motionEvent = 255;
                    motionEvent2 = (-((motionEvent2 * 255) / this.a.getHeight())) + this.a.t;
                    if (motionEvent2 < null) {
                        motionEvent = null;
                    } else if (motionEvent2 <= 255) {
                        motionEvent = motionEvent2;
                    }
                    this.a.v.setProgress(motionEvent);
                    this.a.s;
                    c.a(motionEvent, this.a.z.e);
                    break;
                }
                break;
            default:
                break;
        }
        return true;
    }
}
