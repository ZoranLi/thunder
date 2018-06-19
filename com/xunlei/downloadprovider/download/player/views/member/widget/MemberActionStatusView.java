package com.xunlei.downloadprovider.download.player.views.member.widget;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;
import com.xunlei.common.androidutil.DipPixelUtil;

public class MemberActionStatusView extends AppCompatTextView {
    public MemberActionStatusView(Context context) {
        this(context, null, 0);
    }

    public MemberActionStatusView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MemberActionStatusView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setTextSize(11.0f);
        setGravity(17);
        setTextColor(Color.parseColor("#FFFFFF"));
        setCompoundDrawablePadding(DipPixelUtil.dip2px(6.0f));
    }
}
