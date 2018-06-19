package com.xunlei.downloadprovider.personal.redenvelope.redenvelopedetail;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.xunlei.downloadprovider.R;

public class RedWebTitleBar extends FrameLayout {
    private ImageView a;
    private View b;
    private TextView c;
    private a d = null;

    public interface a {
    }

    public RedWebTitleBar(Context context) {
        super(context);
        a(context);
    }

    public RedWebTitleBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    public RedWebTitleBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a(context);
    }

    private void a(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.web_title_bar, this, false);
        addView(inflate, new LayoutParams(-1, -2));
        this.a = (ImageView) inflate.findViewById(R.id.goback_btn);
        this.a.setVisibility(8);
        this.b = inflate.findViewById(R.id.cancel_btn);
        this.b.setVisibility(0);
        this.b.setOnClickListener(new m(this, context));
        this.c = (TextView) inflate.findViewById(R.id.title);
    }

    public void setTitleText(String str) {
        this.c.setText(str);
    }
}
