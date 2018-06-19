package com.xunlei.downloadprovider.launch.guide.b;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.launch.guide.p.a;

/* compiled from: GuideNormalCommonItemView */
public final class h extends a {
    private ImageView d = null;

    public final View getView() {
        return this;
    }

    public h(Context context, a aVar) {
        super(context, aVar);
        LayoutInflater.from(this.a).inflate(R.layout.guide_normal_item_view, this);
        this.d = (ImageView) findViewById(R.id.iv_poster);
    }

    public final void setPosterImageResource(int i) {
        this.d.setImageResource(i);
    }

    public final void a(int i) {
        i = this.b.b(i);
        if (i != -1) {
            setPosterImageResource(i);
        }
    }
}
