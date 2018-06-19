package com.xunlei.downloadprovider.web.website.view;

import android.content.Context;
import android.support.annotation.AttrRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.xunlei.downloadprovider.R;

public class CollectionUserSyncTipView extends RelativeLayout {
    private View a;
    private View b;
    private OnClickListener c;

    public CollectionUserSyncTipView(@NonNull Context context) {
        super(context);
        a(context);
    }

    public CollectionUserSyncTipView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    public CollectionUserSyncTipView(@NonNull Context context, @Nullable AttributeSet attributeSet, @AttrRes int i) {
        super(context, attributeSet, i);
        a(context);
    }

    private void a(Context context) {
        this.a = LayoutInflater.from(context).inflate(R.layout.collection_user_sync_tip_layout, null, false);
        this.b = this.a.findViewById(R.id.collection_sycn_btn);
        context = new LayoutParams(-1, -2);
        context.addRule(12);
        addView(this.a, context);
        this.b.setOnClickListener(new b(this));
    }

    public void setSyncClickListener(OnClickListener onClickListener) {
        this.c = onClickListener;
    }
}
