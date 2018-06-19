package com.xunlei.downloadprovider.launch.guide.b;

import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import android.widget.TextView;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.launch.guide.p.a;

/* compiled from: GuideBottomLoginView */
public final class c extends d implements OnClickListener {
    private TextView d;
    private TextView e;
    private TextView f;

    protected final int a() {
        return R.layout.guide_bottom_login_view;
    }

    public c(Activity activity, ViewStub viewStub, a aVar) {
        super(activity, viewStub, aVar);
        this.d = null;
        this.e = null;
        this.f = null;
        this.d = (TextView) this.a.findViewById(R.id.btn_wechat);
        this.e = (TextView) this.a.findViewById(R.id.btn_qq);
        this.f = (TextView) this.a.findViewById(R.id.btn_account);
        this.d.setOnClickListener(this);
        this.e.setOnClickListener(this);
        this.f.setOnClickListener(this);
    }

    public final void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_wechat:
                this.c.i();
                return;
            case R.id.btn_qq:
                this.c.j();
                return;
            case R.id.btn_account:
                this.c.k();
                break;
            default:
                break;
        }
    }
}
