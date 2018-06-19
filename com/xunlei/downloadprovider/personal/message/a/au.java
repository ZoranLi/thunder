package com.xunlei.downloadprovider.personal.message.a;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.xunlei.downloadprovider.R;

/* compiled from: ResViewHolder */
public final class au {
    public ImageView a;
    public ImageView b;
    public TextView c;

    public final void a(View view) {
        this.a = (ImageView) view.findViewById(R.id.iv_poster);
        this.b = (ImageView) view.findViewById(R.id.iv_mark);
        this.c = (TextView) view.findViewById(R.id.tv_error_msg);
    }

    public final void a(int i) {
        if (i != 2) {
            this.a.setVisibility(0);
            this.b.setVisibility(0);
            this.c.setVisibility(8);
            return;
        }
        this.a.setVisibility(8);
        this.b.setVisibility(8);
        this.c.setVisibility(0);
    }
}
