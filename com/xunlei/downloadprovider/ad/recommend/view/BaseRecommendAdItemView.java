package com.xunlei.downloadprovider.ad.recommend.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.ad.a.h;
import com.xunlei.downloadprovider.ad.common.adget.l;

public abstract class BaseRecommendAdItemView extends LinearLayout {
    public abstract void setData(l lVar);

    public abstract void setDivideLineVisibility(int i);

    public BaseRecommendAdItemView(Context context) {
        super(context);
    }

    public BaseRecommendAdItemView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public BaseRecommendAdItemView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public static BaseRecommendAdItemView a(Context context) {
        if (h.b() == 3) {
            return new b(context, R.layout.layout_task_list_recommend_list_right_image_item);
        }
        if (h.b() == 1) {
            return new b(context, R.layout.layout_task_list_recommend_list_image_2_item);
        }
        return new RecommendAdIconItemView(context);
    }
}
