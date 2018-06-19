package com.xunlei.downloadprovider.download.player.views.backgroundlayer;

import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import com.xunlei.xllib.android.c;

/* compiled from: PlayerGestureView */
final class a extends SimpleOnGestureListener {
    final /* synthetic */ PlayerGestureView a;

    a(PlayerGestureView playerGestureView) {
        this.a = playerGestureView;
    }

    public final boolean onDown(MotionEvent motionEvent) {
        this.a.e = motionEvent.getRawX();
        this.a.f = motionEvent.getRawY();
        int a = this.a.getPlayerPosition();
        if (a >= null) {
            this.a.setTouchDownPosition(a);
        }
        PlayerGestureView.b;
        motionEvent = new StringBuilder("onDown--mState=");
        motionEvent.append(this.a.d);
        motionEvent.append("|X=");
        motionEvent.append(this.a.e);
        motionEvent.append("|Y=");
        motionEvent.append(this.a.f);
        return true;
    }

    public final boolean onSingleTapConfirmed(MotionEvent motionEvent) {
        if (this.a.s == null) {
            return super.onSingleTapConfirmed(motionEvent);
        }
        PlayerGestureView.b;
        return this.a.s.a();
    }

    public final boolean onDoubleTap(MotionEvent motionEvent) {
        if (this.a.s == null) {
            return super.onDoubleTap(motionEvent);
        }
        PlayerGestureView.b;
        return this.a.s.e();
    }

    public final void onLongPress(MotionEvent motionEvent) {
        if (this.a.s != null) {
            this.a.s.f();
        }
    }

    public final boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        if (this.a.q != null) {
            if (this.a.r == null || this.a.r.l_() == null) {
                motionEvent = this.a.e;
                float d = this.a.f;
                if (!PlayerGestureView.a(this.a, motionEvent, d)) {
                    return true;
                }
                int x = (int) (motionEvent2.getX() - motionEvent);
                motionEvent2 = (int) (motionEvent2.getY() - d);
                int i = 0;
                switch (b.a[this.a.d.ordinal()]) {
                    case 1:
                        if (Math.abs(f) <= Math.abs(f2)) {
                            if (motionEvent <= ((float) (this.a.getWidth() / 2))) {
                                PlayerGestureView.i(this.a);
                                break;
                            }
                            PlayerGestureView.h(this.a);
                            break;
                        }
                        PlayerGestureView.b(this.a, x);
                        break;
                    case 2:
                        if (this.a.g != null && this.a.g.e() != null && this.a.getDuration() > null) {
                            motionEvent = ((int) (((float) x) * this.a.j)) + this.a.h;
                            if (motionEvent >= null) {
                                i = motionEvent > this.a.getDuration() ? this.a.getDuration() : motionEvent;
                            }
                            this.a.g.a(x, i, this.a.getDuration());
                            this.a.i = i;
                            break;
                        }
                        return true;
                    case 3:
                        if (!(this.a.k < null || this.a.g == null || this.a.g.b() == null)) {
                            motionEvent = (-((motionEvent2 * this.a.k) / this.a.getHeight())) + this.a.l;
                            if (motionEvent >= null) {
                                i = motionEvent > this.a.k ? this.a.k : motionEvent;
                            }
                            this.a.g.a(i);
                            this.a.g.setVolumeProgerss(i);
                            this.a.m.setStreamVolume(3, i, 1.1E-44f);
                            break;
                        }
                    case 4:
                        if (!(this.a.n == null || this.a.g == null || this.a.g.a() == null)) {
                            motionEvent = 255;
                            motionEvent2 = (-((motionEvent2 * 255) / this.a.getHeight())) + this.a.o;
                            if (motionEvent2 < null) {
                                motionEvent = null;
                            } else if (motionEvent2 <= 255) {
                                motionEvent = motionEvent2;
                            }
                            this.a.g.setLightProgress(motionEvent);
                            c.a(motionEvent, this.a.getActivity());
                            break;
                        }
                    default:
                        break;
                }
                return true;
            }
        }
        return true;
    }
}
