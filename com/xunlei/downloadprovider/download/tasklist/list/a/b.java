package com.xunlei.downloadprovider.download.tasklist.list.a;

import android.view.View;
import android.widget.TextView;
import com.xunlei.downloadprovider.R;

/* compiled from: BasicCardBannerViewHolder */
public class b {
    public View f;
    public View g;
    public TextView h;
    public TextView i;

    public b(View view) {
        this.f = view;
        this.g = view.findViewById(R.id.closeButton);
        this.h = (TextView) view.findViewById(R.id.titleTextView);
        this.i = (TextView) view.findViewById(R.id.actionButton);
    }

    public final void a(CharSequence charSequence) {
        if (this.h != null) {
            this.h.setText(charSequence);
        }
    }

    public final void b(CharSequence charSequence) {
        if (this.i != null) {
            this.i.setText(charSequence);
        }
    }
}
