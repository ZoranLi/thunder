package com.xunlei.downloadprovider.vod.speeduptrial;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Color;
import android.support.annotation.AttrRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.StyleRes;
import android.util.AttributeSet;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.bugly.beta.tinker.TinkerReport;
import com.tencent.tinker.android.dx.instruction.Opcodes;
import com.xunlei.downloadprovider.app.BrothersApplication;
import com.xunlei.downloadprovider.member.payment.external.PayBaseConstants;

public class BubbleTipBar extends FrameLayout {
    public BubbleBarView a;
    private TextView b;
    private TextView c;
    private final float d = BrothersApplication.getApplicationInstance().getResources().getDisplayMetrics().density;
    private a e;
    private LinearLayout f;

    public interface a extends com.xunlei.downloadprovider.vod.speeduptrial.BubbleBarView.a {
    }

    public static abstract class b implements a {
        public void b(BubbleBarView bubbleBarView) {
        }

        public void d(BubbleBarView bubbleBarView) {
        }

        public final void e(BubbleBarView bubbleBarView) {
        }

        public void f(BubbleBarView bubbleBarView) {
        }

        public final void g(BubbleBarView bubbleBarView) {
        }

        public final void h(BubbleBarView bubbleBarView) {
        }

        public void i(BubbleBarView bubbleBarView) {
        }

        public void j(BubbleBarView bubbleBarView) {
        }
    }

    public BubbleTipBar(@NonNull Context context) {
        super(context);
        e();
    }

    public BubbleTipBar(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        e();
    }

    public BubbleTipBar(@NonNull Context context, @Nullable AttributeSet attributeSet, @AttrRes int i) {
        super(context, attributeSet, i);
        e();
    }

    @TargetApi(21)
    public BubbleTipBar(@NonNull Context context, @Nullable AttributeSet attributeSet, @AttrRes int i, @StyleRes int i2) {
        super(context, attributeSet, i, i2);
        e();
    }

    public void setCallBack(a aVar) {
        this.e = aVar;
    }

    public void setFirstTextColor(int i) {
        this.b.setTextColor(i);
    }

    public void setSecondTextColor(int i) {
        this.c.setTextColor(i);
    }

    public void setFirstText(String str) {
        this.b.setText(str);
    }

    public void setSecondText(String str) {
        this.c.setText(str);
    }

    public void setFirstTextClickListener(OnClickListener onClickListener) {
        this.b.setOnClickListener(onClickListener);
    }

    public void setSecondTextClickListener(OnClickListener onClickListener) {
        this.c.setOnClickListener(onClickListener);
    }

    private void e() {
        this.a = new BubbleBarView(getContext());
        this.a.setCallback(new e(this));
        addView(this.a);
        this.b = new TextView(getContext());
        this.b.setTextSize(1, 8.0f);
        this.b.setTextColor(Color.argb(255, 35, Opcodes.REM_LONG, TinkerReport.KEY_LOADED_EXCEPTION_DEX_CHECK));
        this.c = new TextView(getContext());
        this.c.setTextSize(1, 8.0f);
        this.c.setTextColor(-1);
        this.f = new LinearLayout(getContext());
        this.f.setOrientation(1);
        this.f.setVisibility(8);
        LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.leftMargin = (int) ((this.d * 11.0f) + PayBaseConstants.HALF_OF_FLOAT);
        this.f.addView(this.b, layoutParams);
        this.f.addView(this.c, layoutParams);
        layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 16;
        addView(this.f, layoutParams);
    }

    public final void a() {
        if (getVisibility() != 0) {
            setVisibility(0);
        }
        BubbleBarView bubbleBarView = this.a;
        if (bubbleBarView.getVisibility() != 0) {
            bubbleBarView.setVisibility(0);
        }
        bubbleBarView.c.start();
    }

    public final void b() {
        if (getVisibility() != 0) {
            setVisibility(0);
        }
        BubbleBarView bubbleBarView = this.a;
        if (bubbleBarView.getVisibility() != 0) {
            bubbleBarView.setVisibility(0);
        }
        bubbleBarView.d.start();
    }

    public void setProgress(int i) {
        this.a.setProgress(i);
    }

    public void setMax(int i) {
        this.a.setMax(i);
    }

    public final boolean c() {
        return this.a.b == BubbleBarView.a;
    }

    public final boolean d() {
        return this.a.b > BubbleBarView.a;
    }

    public float getProgressRate() {
        return this.a.getProgressRate();
    }

    public void setExitAnimRightMargin(float f) {
        this.a.setExitAnimRightMargin(f);
    }
}
