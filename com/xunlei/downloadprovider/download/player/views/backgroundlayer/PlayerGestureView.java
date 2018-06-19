package com.xunlei.downloadprovider.download.player.views.backgroundlayer;

import android.app.Activity;
import android.content.Context;
import android.media.AudioManager;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import com.xunlei.downloadprovider.download.player.b;
import com.xunlei.downloadprovider.download.player.views.center.PlayerGestureCenterPopView;
import com.xunlei.xllib.android.c;

public class PlayerGestureView extends View {
    static final /* synthetic */ boolean a = true;
    private static final String b = "PlayerGestureView";
    private GestureDetector c;
    private State d = State.IDLE;
    private float e = -1.0f;
    private float f = -1.0f;
    private PlayerGestureCenterPopView g;
    private int h;
    private int i;
    private float j;
    private int k;
    private int l;
    private AudioManager m;
    private c n;
    private int o;
    private boolean p = true;
    private boolean q = true;
    @Nullable
    private b r;
    private a s;
    private OnGestureListener t = new a(this);

    enum State {
        IDLE,
        POSITION,
        VOLUME,
        LIGHT
    }

    public interface a {
        boolean a();

        boolean b();

        boolean c();

        boolean d();

        boolean e();

        void f();
    }

    public PlayerGestureView(Context context) {
        super(context);
        b(context);
        a(context);
    }

    public PlayerGestureView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        b(context);
        a(context);
    }

    public PlayerGestureView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        b(context);
        a(context);
    }

    private void a(Context context) {
        this.c = new GestureDetector(context, this.t);
        this.c.setIsLongpressEnabled(true);
    }

    private void b(Context context) {
        if (!isInEditMode()) {
            this.m = (AudioManager) context.getSystemService("audio");
            if (a || this.m != null) {
                this.k = this.m.getStreamMaxVolume(3);
            } else {
                throw new AssertionError();
            }
        }
        this.n = c.a(context);
        if (this.n != null) {
            this.o = this.n.a();
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.p) {
            return true;
        }
        boolean z = (motionEvent.getAction() & 255) == 1;
        if (this.c.onTouchEvent(motionEvent) != null || !z) {
            return true;
        }
        new StringBuilder("onTouchUp--mState=").append(this.d);
        new StringBuilder("animationToResetState--mState=").append(this.d);
        switch (b.a[this.d.ordinal()]) {
            case 1:
                break;
            case 2:
                if (!(this.g == null || this.g.e() == null)) {
                    this.g.d();
                    if (getDuration() > null && this.r != null) {
                        this.r.a(this.i);
                        break;
                    }
                }
            case 3:
                if (!(this.g == null || this.g.b() == null)) {
                    motionEvent = this.g;
                    motionEvent.b(motionEvent.a);
                    b();
                    break;
                }
            case 4:
                if (!(this.g == null || this.g.a() == null)) {
                    motionEvent = this.g;
                    motionEvent.b(motionEvent.b);
                    if (this.n != null) {
                        this.o = c.a(getActivity());
                        break;
                    }
                }
                break;
            default:
                break;
        }
        this.d = State.IDLE;
        return true;
    }

    public void setPlayerGestureCenterPopView(PlayerGestureCenterPopView playerGestureCenterPopView) {
        this.g = playerGestureCenterPopView;
    }

    public void setPlayController(@Nullable b bVar) {
        this.r = bVar;
    }

    private void setMediaDuration(int i) {
        int width = getWidth();
        if (width > 0) {
            this.j = ((float) i) / ((float) width);
        }
    }

    private void setTouchDownPosition(int i) {
        this.h = i;
    }

    public void setShouldDetectorGesture(boolean z) {
        this.p = z;
    }

    public void setShouldDetectorGestureMove(boolean z) {
        this.q = z;
    }

    public Activity getActivity() {
        return (Activity) getContext();
    }

    private int getPlayerDuration() {
        return this.r != null ? this.r.e() : 0;
    }

    private int getPlayerPosition() {
        return this.r != null ? this.r.k_() : 0;
    }

    private void b() {
        this.l = this.m.getStreamVolume(3);
    }

    private int getDuration() {
        int playerDuration = getPlayerDuration();
        setMediaDuration(playerDuration);
        return playerDuration;
    }

    public void setOnGestureListener(a aVar) {
        this.s = aVar;
    }

    static /* synthetic */ boolean a(PlayerGestureView playerGestureView, float f, float f2) {
        playerGestureView = playerGestureView.getResources().getDisplayMetrics();
        int i = playerGestureView.widthPixels;
        playerGestureView = playerGestureView.heightPixels;
        if (f >= 50.0f && f <= ((float) (i - 50)) && f2 >= 50.0f) {
            if (f2 <= ((float) (playerGestureView - 50))) {
                return true;
            }
        }
        return null;
    }

    static /* synthetic */ void b(PlayerGestureView playerGestureView, int i) {
        StringBuilder stringBuilder = new StringBuilder("enterPositionState, distanceDownX : ");
        stringBuilder.append(i);
        stringBuilder.append(" duration : ");
        stringBuilder.append(playerGestureView.getDuration());
        playerGestureView.d = State.POSITION;
        if (playerGestureView.getDuration() > 0 && playerGestureView.s != null && playerGestureView.s.c() && playerGestureView.g != null) {
            playerGestureView.g.c();
            playerGestureView.g.a(i, playerGestureView.getPlayerPosition(), playerGestureView.getDuration());
        }
    }

    static /* synthetic */ void h(PlayerGestureView playerGestureView) {
        playerGestureView.d = State.VOLUME;
        if (playerGestureView.s != null && playerGestureView.s.d()) {
            playerGestureView.b();
            if (playerGestureView.g != null) {
                PlayerGestureCenterPopView playerGestureCenterPopView = playerGestureView.g;
                playerGestureCenterPopView.a(playerGestureCenterPopView.a);
                playerGestureView.g.a(playerGestureView.l);
            }
        }
    }

    static /* synthetic */ void i(PlayerGestureView playerGestureView) {
        playerGestureView.d = State.LIGHT;
        if (playerGestureView.s != null && playerGestureView.s.b() && playerGestureView.g != null) {
            playerGestureView = playerGestureView.g;
            playerGestureView.a(playerGestureView.b);
        }
    }
}
