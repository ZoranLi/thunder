package com.xunlei.downloadprovider.download.player.views.member.widget;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.xunlei.common.androidutil.DipPixelUtil;

public class MemberActionViewGroup extends LinearLayout {
    public MemberActionView a;
    public MemberActionStatusView b;
    public MemberSpeedTextView c;

    public MemberActionViewGroup(@NonNull Context context) {
        this(context, null, 0);
    }

    public MemberActionViewGroup(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MemberActionViewGroup(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setOrientation(null);
        setGravity(16);
        this.c = new MemberSpeedTextView(context);
        addView(this.c, new LayoutParams(-2, -2));
        attributeSet = new FrameLayout(context);
        ViewGroup.LayoutParams layoutParams = new LayoutParams(-2, -2);
        layoutParams.leftMargin = DipPixelUtil.dip2px(12.0f);
        addView(attributeSet, layoutParams);
        this.a = new MemberActionView(context);
        layoutParams = new LayoutParams(DipPixelUtil.dip2px(67.0f), DipPixelUtil.dip2px(25.0f));
        layoutParams.gravity = 17;
        this.a.setLayoutParams(layoutParams);
        this.a.setVisibility(8);
        attributeSet.addView(this.a);
        this.b = new MemberActionStatusView(context);
        context = new LayoutParams(-2, DipPixelUtil.dip2px(32.0f));
        context.gravity = 17;
        this.b.setLayoutParams(context);
        this.b.setVisibility(8);
        attributeSet.addView(this.b);
        setVisibility(8);
    }
}
