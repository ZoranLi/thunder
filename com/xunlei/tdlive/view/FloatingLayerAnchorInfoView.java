package com.xunlei.tdlive.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.xunlei.tdlive.control.RoundImageView;
import com.xunlei.tdlive.sdk.R;
import com.xunlei.tdlive.util.b;

public class FloatingLayerAnchorInfoView extends LinearLayout {
    private RoundImageView a;
    private TextView b;
    private TextView c;
    private TextView d;

    public FloatingLayerAnchorInfoView(Context context) {
        super(context);
    }

    public FloatingLayerAnchorInfoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public FloatingLayerAnchorInfoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        this.a = (RoundImageView) findViewById(R.id.info_anchor_avatar);
        this.b = (TextView) findViewById(R.id.info_num);
        this.c = (TextView) findViewById(R.id.info_anchor_name);
        this.d = (TextView) findViewById(R.id.info_live_title);
    }

    public void refreshView(String str, int i, String str2, String str3) {
        b.a(getContext()).a(this.a, str, b.a(getContext(), R.drawable.xllive_avatar_default));
        this.b.setText(String.valueOf(i));
        str = this.c;
        i = new StringBuilder();
        i.append(str2);
        i.append("的直播开始了");
        str.setText(i.toString());
        str = this.d;
        i = new StringBuilder("[直播]");
        if (TextUtils.isEmpty(str3) != null) {
            str3 = "快来看看我吧";
        }
        i.append(str3);
        str.setText(i.toString());
        setVisibility(null);
    }
}
