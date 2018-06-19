package com.xunlei.downloadprovider.player.xmp.ui.widget;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.xunlei.downloadprovider.R;

public class DoubleClickAnimationView extends RelativeLayout {
    public ImageView a;
    public ImageView b;
    public boolean c;

    public interface a {
        void a();
    }

    public DoubleClickAnimationView(Context context) {
        super(context);
        a(context);
    }

    public DoubleClickAnimationView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    public DoubleClickAnimationView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a(context);
    }

    private void a(Context context) {
        LayoutInflater.from(context).inflate(R.layout.double_click_like_view, this, true);
        setLayoutParams(new LayoutParams(-1, -1));
        this.a = (ImageView) findViewById(R.id.top_image_view);
        this.b = (ImageView) findViewById(R.id.bottom_image_view);
    }
}
