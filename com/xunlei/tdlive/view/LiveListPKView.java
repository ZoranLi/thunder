package com.xunlei.tdlive.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import com.xunlei.tdlive.modal.JsonWrapper;
import com.xunlei.tdlive.sdk.R;

public class LiveListPKView extends LinearLayout {
    private PkListItemView a;
    private PkListItemView b;
    private JsonWrapper c = new JsonWrapper("[]");
    public View mTitleView;

    public LiveListPKView(Context context) {
        super(context);
    }

    public LiveListPKView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public LiveListPKView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        this.mTitleView = findViewById(R.id.go_pk_list);
        this.a = (PkListItemView) findViewById(R.id.first_item);
        this.b = (PkListItemView) findViewById(R.id.second_item);
    }

    public void bindData(JsonWrapper jsonWrapper, OnClickListener onClickListener) {
        if (jsonWrapper != null && jsonWrapper.isArray()) {
            if (jsonWrapper.getLength() != 0) {
                setVisibility(0);
                this.c = jsonWrapper;
                this.a.leftItemView.setOnClickListener(onClickListener);
                this.a.rightItemView.setOnClickListener(onClickListener);
                this.b.leftItemView.setOnClickListener(onClickListener);
                this.b.rightItemView.setOnClickListener(onClickListener);
                this.a.bind(this.c.getObject(0));
                if (this.c.getLength() > 1) {
                    this.b.setVisibility(0);
                    this.b.bind(this.c.getObject(1));
                    return;
                }
                this.b.setVisibility(8);
                return;
            }
        }
        setVisibility(8);
    }
}
