package com.xunlei.downloadprovider.publiser.per.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.homepage.choiceness.j;
import com.xunlei.downloadprovider.homepage.cinecism.data.CinecismInfo;

public class DynamicCinecismView extends LinearLayout {
    private ImageView a;
    private TextView b;
    private TextView c;
    private TextView d;

    public DynamicCinecismView(Context context) {
        super(context);
        a();
    }

    public DynamicCinecismView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    public DynamicCinecismView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a();
    }

    private void a() {
        LayoutInflater.from(getContext()).inflate(R.layout.cinecism_base_layout, this);
        setBackgroundColor(-526345);
        this.a = (ImageView) findViewById(R.id.iv_poster);
        this.b = (TextView) findViewById(R.id.tv_title);
        this.c = (TextView) findViewById(R.id.tv_good);
        this.d = (TextView) findViewById(R.id.tv_show);
    }

    public final void a(CinecismInfo cinecismInfo) {
        Object obj = cinecismInfo.d;
        if (TextUtils.isEmpty(obj)) {
            this.a.setImageResource(R.drawable.publisher_dynamic_video_not_found_poster);
        } else {
            Glide.with(this.a.getContext()).load(obj).asBitmap().diskCacheStrategy(DiskCacheStrategy.ALL).dontAnimate().fallback(R.drawable.choiceness_icon_default).error(R.drawable.choiceness_icon_default).placeholder(R.drawable.choiceness_icon_default).into(this.a);
        }
        this.d.setVisibility(8);
        this.c.setVisibility(8);
        if (cinecismInfo.l == 0) {
            this.b.setText("该影评已下线");
        } else if (TextUtils.isEmpty(cinecismInfo.b)) {
            this.b.setText("");
        } else {
            this.b.setText(cinecismInfo.b);
            if (cinecismInfo.j > 0) {
                this.d.setText(getResources().getString(R.string.cinecism_show_time, new Object[]{j.a((long) r0)}));
                this.d.setVisibility(0);
            } else {
                this.d.setVisibility(8);
            }
            cinecismInfo = cinecismInfo.g;
            if (cinecismInfo > null) {
                TextView textView = this.c;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(j.a((long) cinecismInfo));
                stringBuilder.append("人赞过");
                textView.setText(stringBuilder.toString());
                this.c.setVisibility(0);
                return;
            }
            this.c.setVisibility(8);
        }
    }
}
