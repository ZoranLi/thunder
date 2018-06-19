package com.xunlei.downloadprovider.download.player.views.center;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import android.view.ViewStub.OnInflateListener;
import android.widget.TextView;
import com.xunlei.downloadprovider.R;

/* compiled from: VodPlayerErrorViewStub */
public final class e implements OnInflateListener {
    TextView a;
    OnClickListener b;
    private ViewStub c;
    private TextView d;

    public e(ViewStub viewStub) {
        this.c = viewStub;
        viewStub.setOnInflateListener(this);
    }

    public final void a(int i) {
        this.c.setVisibility(i);
    }

    public final void onInflate(ViewStub viewStub, View view) {
        this.a = (TextView) view.findViewById(R.id.errorTextView);
        this.d = (TextView) view.findViewById(R.id.errorRetryTextView);
        this.d.setOnClickListener(new f(this));
    }

    public final void a(boolean z) {
        if (this.d != null) {
            this.d.setVisibility(z ? false : true);
        }
    }
}
