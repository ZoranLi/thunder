package com.xunlei.downloadprovider.personal.message.a;

import android.view.View;
import android.widget.TextView;
import com.xunlei.downloadprovider.R;

/* compiled from: CommentViewHolder */
public final class r {
    public TextView a;
    public TextView b;

    public final void a(View view) {
        this.a = (TextView) view.findViewById(R.id.tv_content);
        this.b = (TextView) view.findViewById(R.id.tv_error_msg);
    }

    public final void a(int i) {
        if (i != 2) {
            this.a.setVisibility(0);
            this.b.setVisibility(8);
            return;
        }
        this.a.setVisibility(8);
        this.b.setVisibility(0);
    }
}
