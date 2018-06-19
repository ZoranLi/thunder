package com.xunlei.downloadprovidershare.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import com.xunlei.downloadprovidershare.R;

public class SharePopView extends LinearLayout {
    private LayoutInflater a;

    public SharePopView(Context context) {
        super(context);
    }

    public SharePopView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = LayoutInflater.from(context);
        this.a.inflate(R.layout.choiceness_popwindow, this, true);
    }
}
