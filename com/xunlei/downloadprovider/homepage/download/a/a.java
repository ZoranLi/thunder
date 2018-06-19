package com.xunlei.downloadprovider.homepage.download.a;

import android.view.View;
import android.view.ViewStub;
import android.view.ViewStub.OnInflateListener;
import android.view.animation.Animation;
import android.widget.TextView;
import com.xunlei.downloadprovider.R;

/* compiled from: DownloadTabEditTitleBar */
public final class a implements OnInflateListener {
    protected final ViewStub a;
    public View b;
    public TextView c;
    public a d;
    private TextView e;
    private TextView f;
    private TextView g;
    private boolean h = true;
    private Animation i = null;
    private Animation j = null;

    /* compiled from: DownloadTabEditTitleBar */
    public interface a {
        void a();

        void a(boolean z);
    }

    public a(ViewStub viewStub) {
        this.a = viewStub;
        this.a.setOnInflateListener(this);
    }

    public final void a(int i) {
        this.a.setVisibility(i);
    }

    public final void a() {
        if (this.c != null) {
            this.c.setText(R.string.download_list_select_title);
        }
    }

    public final void a(boolean z) {
        if (z) {
            this.f.setVisibility(0);
            this.g.setVisibility(8);
            return;
        }
        this.f.setVisibility(8);
        this.g.setVisibility(0);
    }

    public final void onInflate(ViewStub viewStub, View view) {
        this.b = view;
        this.c = (TextView) view.findViewById(R.id.title);
        this.e = (TextView) view.findViewById(R.id.cancel);
        this.e.setOnClickListener(new b(this));
        this.f = (TextView) view.findViewById(R.id.select_all);
        this.f.setOnClickListener(new c(this));
        this.g = (TextView) view.findViewById(R.id.un_select_all);
        this.g.setOnClickListener(new d(this));
        this.b.setOnClickListener(new e(this));
    }
}
