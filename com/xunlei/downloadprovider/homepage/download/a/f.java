package com.xunlei.downloadprovider.homepage.download.a;

import android.view.View;
import android.view.ViewStub;
import android.view.ViewStub.OnInflateListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.xunlei.downloadprovider.R;

/* compiled from: DownloadTabEditToolBar */
public final class f implements OnInflateListener {
    protected final ViewStub a;
    protected View b;
    protected TextView c;
    protected ImageView d;
    public a e;
    private View f;

    /* compiled from: DownloadTabEditToolBar */
    public interface a {
        void a();
    }

    public f(ViewStub viewStub) {
        this.a = viewStub;
        this.a.setOnInflateListener(this);
    }

    public final void a(int i) {
        this.a.setVisibility(i);
    }

    public final void a(boolean z) {
        if (this.f != null) {
            if (z) {
                this.b.setClickable(true);
                this.d.setEnabled(true);
                this.c.setTextColor(this.f.getResources().getColor(R.color.download_tab_list_bottom_enable));
                return;
            }
            a();
        }
    }

    private void a() {
        this.b.setClickable(false);
        this.d.setEnabled(false);
        this.c.setTextColor(this.f.getResources().getColor(R.color.download_list_bottom_disable));
    }

    public final void onInflate(ViewStub viewStub, View view) {
        this.f = view;
        this.c = (TextView) view.findViewById(R.id.delete_tasks);
        this.d = (ImageView) view.findViewById(R.id.icon_delete);
        this.b = view.findViewById(R.id.delete_contain);
        this.b.setOnClickListener(new g(this));
        a();
    }
}
