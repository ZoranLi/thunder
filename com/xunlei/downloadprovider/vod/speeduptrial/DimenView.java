package com.xunlei.downloadprovider.vod.speeduptrial;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import com.xunlei.downloadprovider.app.BrothersApplication;
import com.xunlei.downloadprovider.member.payment.external.PayBaseConstants;

public class DimenView extends View {
    protected static final float i = BrothersApplication.getApplicationInstance().getResources().getDisplayMetrics().density;

    public DimenView(Context context) {
        super(context);
    }

    public DimenView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public DimenView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    protected static int a(float f) {
        return (int) ((i * f) + PayBaseConstants.HALF_OF_FLOAT);
    }

    protected static float b(float f) {
        return i * f;
    }
}
