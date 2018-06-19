package com.xunlei.downloadprovider.homepage.follow.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.xunlei.common.androidutil.DipPixelUtil;

public class HorizontalAvatarList extends LinearLayout {
    public int a = 4;
    public int b;

    public HorizontalAvatarList(Context context) {
        super(context);
        a();
    }

    public HorizontalAvatarList(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    public HorizontalAvatarList(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a();
    }

    private void a() {
        this.b = DipPixelUtil.dip2px(6.0f);
    }

    public void setAvatarMaxCount(int i) {
        this.a = i;
    }
}
