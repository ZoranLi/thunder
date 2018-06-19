package com.xunlei.downloadprovider.publiser.common;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewConfigurationCompat;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.bumptech.glide.DrawableRequestBuilder;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.member.payment.external.PayBaseConstants;
import com.xunlei.xllib.android.XLIntent;

public class AvatarActivity extends AppCompatActivity {
    private static final String a = "AvatarActivity";
    private ImageView b;
    private String c;
    private String d;
    private ImageView e;
    private View f;
    private GestureDetectorCompat g;
    private int h;
    private int i;
    private View j;
    private boolean k = false;
    private a l;

    private static class a {
        final int a;
        final a b;
        float c;
        float d;
        float e;
        float f;
        boolean g = false;
        boolean h = false;
        boolean i = false;
        boolean j = false;

        interface a {
            boolean a();

            boolean a(float f);

            boolean b();

            boolean c();

            boolean d();
        }

        public a(Context context, a aVar) {
            this.b = aVar;
            this.a = ViewConfigurationCompat.getScaledPagingTouchSlop(ViewConfiguration.get(context));
        }
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_avatar);
        this.c = getIntent().getStringExtra("avatar_thumb");
        this.d = getIntent().getStringExtra("avatar_origin");
        new StringBuilder("avatar thumb=>").append(this.c);
        new StringBuilder("avatar =>").append(this.d);
        this.j = findViewById(R.id.lyt_root);
        this.b = (ImageView) findViewById(R.id.iv_avatar);
        this.b.setScaleType(ScaleType.FIT_CENTER);
        ViewCompat.setTransitionName(this.b, "avatar");
        this.f = findViewById(R.id.lyt_loading_bg);
        this.e = (ImageView) findViewById(R.id.iv_loading);
        this.f.setVisibility(4);
        this.g = new GestureDetectorCompat(this, new a(this));
        this.l = new a(this, new b(this));
        bundle = TextUtils.isEmpty(this.c) == null ? Glide.with(this).load(this.c).dontAnimate() : null;
        if (TextUtils.isEmpty(this.d)) {
            if (bundle != null) {
                bundle.listener(new f(this)).into(this.b);
            }
            return;
        }
        DrawableRequestBuilder diskCacheStrategy = Glide.with(this).load(this.d).diskCacheStrategy(DiskCacheStrategy.ALL);
        if (bundle != null) {
            diskCacheStrategy.thumbnail(bundle);
        }
        diskCacheStrategy.dontAnimate();
        diskCacheStrategy.listener(new d(this));
        diskCacheStrategy.into(new e(this, this.b));
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.g.onTouchEvent(motionEvent)) {
            return true;
        }
        a aVar = this.l;
        int action = motionEvent.getAction();
        boolean z = false;
        float rawX;
        if (action == 0) {
            rawX = motionEvent.getRawX();
            aVar.d = rawX;
            aVar.c = rawX;
            rawX = motionEvent.getRawY();
            aVar.f = rawX;
            aVar.e = rawX;
        } else if (action == 2) {
            rawX = motionEvent.getRawX();
            float rawY = motionEvent.getRawY();
            float f = rawX - aVar.d;
            float f2 = rawY - aVar.f;
            if (!aVar.g) {
                f = rawX - aVar.c;
            }
            if (!aVar.h) {
                f2 = rawY - aVar.e;
            }
            if (!aVar.g && Math.abs(f) >= ((float) aVar.a)) {
                aVar.g = true;
                z = aVar.b.a();
                aVar.i = z;
            }
            if (aVar.i && aVar.g) {
                z = aVar.b.a(f);
            }
            if (!aVar.h && Math.abs(r6) >= ((float) aVar.a)) {
                aVar.h = true;
                z = aVar.b.b();
                aVar.j = z;
            }
            if (aVar.j && aVar.h) {
                z = aVar.b.c();
            }
            aVar.d = rawX;
            aVar.f = rawY;
        } else if (action == 1) {
            aVar.g = false;
            aVar.h = false;
            if (aVar.i || aVar.j) {
                aVar.i = false;
                aVar.j = false;
                z = aVar.b.d();
            }
        }
        if (z) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    private void b() {
        this.f.setVisibility(4);
        this.e.clearAnimation();
        this.e.setRotation(0.0f);
    }

    protected void onDestroy() {
        super.onDestroy();
        b();
    }

    public static Intent a(Context context, String str, String str2) {
        Intent xLIntent = new XLIntent(context, AvatarActivity.class);
        xLIntent.putExtra("avatar_origin", str);
        xLIntent.putExtra("avatar_thumb", str2);
        return xLIntent;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ void a(com.xunlei.downloadprovider.publiser.common.AvatarActivity r12, android.view.MotionEvent r13) {
        /*
        r0 = r12.j;
        r0 = r0.getMeasuredWidth();
        r1 = r12.j;
        r1 = r1.getMeasuredHeight();
        r2 = r12.b;
        r8 = r2.getMeasuredWidth();
        r2 = r12.b;
        r10 = r2.getMeasuredHeight();
        r2 = r12.b;
        r5 = r2.getTranslationX();
        r13 = r13.getX();
        r2 = r12.b;
        r7 = r2.getLayoutParams();
        r2 = r12.k;
        r3 = 1056964608; // 0x3f000000 float:0.5 double:5.222099017E-315;
        r4 = 1065353216; // 0x3f800000 float:1.0 double:5.263544247E-315;
        if (r2 != 0) goto L_0x0047;
    L_0x0030:
        r2 = (float) r1;
        r6 = r12.h;
        r6 = (float) r6;
        r6 = r6 * r4;
        r4 = r12.i;
        r4 = (float) r4;
        r6 = r6 / r4;
        r2 = r2 * r6;
        r2 = r2 + r3;
        r2 = (int) r2;
        r3 = (float) r2;
        r0 = (float) r0;
        r0 = r13 / r0;
        r3 = r3 * r0;
        r3 = r3 - r13;
        r13 = -r3;
        r6 = r13;
        r11 = r1;
        r9 = r2;
        goto L_0x0057;
    L_0x0047:
        r13 = (float) r0;
        r1 = r12.i;
        r1 = (float) r1;
        r1 = r1 * r4;
        r2 = r12.h;
        r2 = (float) r2;
        r1 = r1 / r2;
        r13 = r13 * r1;
        r13 = r13 + r3;
        r1 = (int) r13;
        r13 = 0;
        r6 = r13;
        r9 = r0;
        r11 = r1;
    L_0x0057:
        r13 = 2;
        r13 = new float[r13];
        r13 = {0, 1065353216};
        r13 = android.animation.ValueAnimator.ofFloat(r13);
        r0 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;
        r13.setDuration(r0);
        r0 = new android.view.animation.AccelerateDecelerateInterpolator;
        r0.<init>();
        r13.setInterpolator(r0);
        r0 = new com.xunlei.downloadprovider.publiser.common.c;
        r3 = r0;
        r4 = r12;
        r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11);
        r13.addUpdateListener(r0);
        r0 = r12.k;
        r0 = r0 ^ 1;
        r12.k = r0;
        r13.start();
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.downloadprovider.publiser.common.AvatarActivity.a(com.xunlei.downloadprovider.publiser.common.AvatarActivity, android.view.MotionEvent):void");
    }

    static /* synthetic */ void e(AvatarActivity avatarActivity) {
        avatarActivity.f.setVisibility(0);
        Animation rotateAnimation = new RotateAnimation(0.0f, 360.0f, 1, PayBaseConstants.HALF_OF_FLOAT, 1, PayBaseConstants.HALF_OF_FLOAT);
        rotateAnimation.setDuration(800);
        rotateAnimation.setInterpolator(new LinearInterpolator());
        rotateAnimation.setRepeatMode(1);
        rotateAnimation.setRepeatCount(-1);
        avatarActivity.e.startAnimation(rotateAnimation);
    }
}
