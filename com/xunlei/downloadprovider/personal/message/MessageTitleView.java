package com.xunlei.downloadprovider.personal.message;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.xunlei.downloadprovider.R;

public class MessageTitleView extends FrameLayout {
    ImageView a;
    private TextView b;

    public MessageTitleView(@NonNull Context context) {
        super(context);
        a(context);
    }

    public MessageTitleView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    private void a(Context context) {
        context = LayoutInflater.from(context).inflate(R.layout.message_title_view, this, true);
        this.b = (TextView) context.findViewById(R.id.tex_title);
        this.a = (ImageView) context.findViewById(R.id.img_red_point);
    }

    public void setTexTitle(String str) {
        this.b.setText(str);
    }
}
