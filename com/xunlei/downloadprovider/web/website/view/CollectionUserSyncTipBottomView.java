package com.xunlei.downloadprovider.web.website.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.xunlei.downloadprovider.R;

public class CollectionUserSyncTipBottomView extends RelativeLayout {
    private View a;
    private View b;
    private OnClickListener c;

    public CollectionUserSyncTipBottomView(Context context) {
        super(context);
        a(context);
    }

    public CollectionUserSyncTipBottomView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    public CollectionUserSyncTipBottomView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a(context);
    }

    private void a(Context context) {
        this.a = LayoutInflater.from(context).inflate(R.layout.collection_user_sync_tip_bottom_layout, null, false);
        this.b = this.a.findViewById(R.id.colletion_cloud_sync_bottom_btn);
        context = new LayoutParams(-1, -2);
        context.addRule(15);
        addView(this.a, context);
        this.b.setOnClickListener(new a(this));
    }

    public void setSyncClickListener(OnClickListener onClickListener) {
        this.c = onClickListener;
    }
}
