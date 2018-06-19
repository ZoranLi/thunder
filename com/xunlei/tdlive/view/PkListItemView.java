package com.xunlei.tdlive.view;

import android.content.Context;
import android.support.annotation.AttrRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.xunlei.tdlive.modal.JsonWrapper;
import com.xunlei.tdlive.sdk.R;

public class PkListItemView extends FrameLayout {
    private TextView a;
    private TextView b;
    private ProgressBar c;
    public PkListInnerItemView leftItemView;
    public PkListInnerItemView rightItemView;

    public PkListItemView(@NonNull Context context) {
        super(context);
    }

    public PkListItemView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public PkListItemView(@NonNull Context context, @Nullable AttributeSet attributeSet, @AttrRes int i) {
        super(context, attributeSet, i);
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        this.a = (TextView) findViewById(R.id.host_score);
        this.b = (TextView) findViewById(R.id.guest_score);
        this.c = (ProgressBar) findViewById(R.id.pk_progress);
        this.leftItemView = (PkListInnerItemView) findViewById(R.id.left_inner_view);
        this.rightItemView = (PkListInnerItemView) findViewById(R.id.right_inner_view);
        a();
    }

    private void a() {
        this.leftItemView.setGap(5.0f, 5.0f);
        this.rightItemView.setGap(5.0f, 5.0f);
    }

    private void a(int i, int i2) {
        if (i == 0 && i2 == 0) {
            this.c.setProgressDrawable(getResources().getDrawable(R.drawable.xllive_pk_item_progress_drawable));
            this.c.setMax(100);
            this.c.setProgress(50);
        } else if (i == 0 || i2 != 0) {
            this.c.setProgressDrawable(getResources().getDrawable(R.drawable.xllive_pk_item_progress_drawable));
            this.c.setMax(i + i2);
            this.c.setProgress(i);
        } else {
            this.c.setProgressDrawable(getResources().getDrawable(R.drawable.xllive_pk_item_progress_drawable_special));
            this.c.setMax(i + i2);
            this.c.setProgress(i);
        }
        TextView textView = this.a;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(i);
        stringBuilder.append("票");
        textView.setText(stringBuilder.toString());
        i = this.b;
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append(i2);
        stringBuilder2.append("票");
        i.setText(stringBuilder2.toString());
    }

    public void bind(JsonWrapper jsonWrapper) {
        if (jsonWrapper != null) {
            this.leftItemView.bind(jsonWrapper.getObject("accept_player"));
            this.rightItemView.bind(jsonWrapper.getObject("defier_player"));
            a(jsonWrapper.getObject("accept_player", "{}").getInt("pk_value", 0), jsonWrapper.getObject("defier_player", "{}").getInt("pk_value", 0));
        }
    }
}
