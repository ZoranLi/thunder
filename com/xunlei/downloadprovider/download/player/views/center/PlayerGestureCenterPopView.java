package com.xunlei.downloadprovider.download.player.views.center;

import android.animation.ObjectAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Color;
import android.media.AudioManager;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.xunlei.downloadprovider.R;
import com.xunlei.xllib.b.j;

public class PlayerGestureCenterPopView extends FrameLayout {
    private static final String c = "PlayerGestureCenterPopView";
    public View a;
    public View b;
    private View d;
    private ImageView e;
    private ProgressBar f;
    private TextView g;
    private ImageView h;
    private ProgressBar i;
    private ProgressBar j;
    private ObjectAnimator k;
    private ObjectAnimator l;

    public PlayerGestureCenterPopView(@NonNull Context context) {
        super(context);
    }

    public PlayerGestureCenterPopView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public PlayerGestureCenterPopView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @TargetApi(21)
    public PlayerGestureCenterPopView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        this.d = findViewById(R.id.position_layout);
        this.g = (TextView) findViewById(R.id.position_view);
        this.e = (ImageView) findViewById(R.id.position_icon);
        this.f = (ProgressBar) findViewById(R.id.position_progress);
        this.a = findViewById(R.id.volume_layout);
        this.h = (ImageView) findViewById(R.id.volume_icon);
        this.i = (ProgressBar) findViewById(R.id.volume_progress);
        if (getContext() != null) {
            AudioManager audioManager = (AudioManager) getContext().getSystemService("audio");
            if (audioManager != null) {
                this.i.setMax(audioManager.getStreamMaxVolume(3));
            }
        }
        this.b = findViewById(R.id.light_layout);
        this.j = (ProgressBar) findViewById(R.id.light_progress);
        this.j.setMax(255);
    }

    public void setVolumeProgerss(int i) {
        this.i.setProgress(i);
    }

    public void setLightProgress(int i) {
        this.j.setProgress(i);
    }

    public final boolean a() {
        return this.b.getVisibility() == 0;
    }

    public final boolean b() {
        return this.a.getVisibility() == 0;
    }

    public final void c() {
        this.d.setAlpha(1.0f);
        a(this.d);
    }

    public final void d() {
        b(this.d);
    }

    public final boolean e() {
        return this.d.getVisibility() == 0;
    }

    public final void a(int i) {
        if (i == 0) {
            this.h.setImageResource(R.drawable.player_gesture_silent_icon);
        } else {
            this.h.setImageResource(R.drawable.player_gesture_volume_icon);
        }
    }

    public final void a(View view) {
        if (view.getVisibility() != 0) {
            view.setAlpha(1.0f);
            new StringBuilder("showStateLayout--layout=").append(view);
            if (this.k != null) {
                this.k.cancel();
                this.k = null;
            }
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, View.ALPHA, new float[]{1.0f});
            ofFloat.setDuration(200);
            view.setVisibility(0);
            ofFloat.start();
            this.l = ofFloat;
        }
    }

    public final void b(View view) {
        if (view.getVisibility() == 0) {
            new StringBuilder("startHideAnimation--layout=").append(view);
            if (this.l != null) {
                this.l.cancel();
                this.l = null;
            }
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, View.ALPHA, new float[]{0.0f});
            ofFloat.setDuration(500);
            ofFloat.addListener(new c(this, view));
            ofFloat.start();
            this.k = ofFloat;
        }
    }

    public final void a(int i, int i2, int i3) {
        if (i < 0) {
            this.e.setImageResource(R.drawable.player_gesture_go_back_icon);
        } else {
            this.e.setImageResource(R.drawable.player_gesture_go_forward_icon);
        }
        i = j.a((long) i2);
        String a = j.a((long) i3);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(i);
        stringBuilder.append(" / ");
        stringBuilder.append(a);
        Object stringBuilder2 = stringBuilder.toString();
        CharSequence spannableStringBuilder = new SpannableStringBuilder(stringBuilder2);
        int indexOf = stringBuilder2.indexOf(i);
        spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#1294f6")), indexOf, i.length() + indexOf, 34);
        this.g.setText(spannableStringBuilder);
        this.f.setProgress(i2);
        this.f.setMax(i3);
    }
}
