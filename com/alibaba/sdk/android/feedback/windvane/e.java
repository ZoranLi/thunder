package com.alibaba.sdk.android.feedback.windvane;

import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.alibaba.sdk.android.feedback.R;
import com.alibaba.sdk.android.feedback.xblink.webview.XBHybridViewController;
import com.alibaba.sdk.android.feedback.xblink.webview.XBHybridWebView;
import com.alibaba.sdk.android.feedback.xblink.webview.i;
import com.alibaba.sdk.android.feedback.xblink.webview.j;

public class e extends Fragment implements i {
    protected Handler a;
    protected XBHybridViewController b;
    protected XBHybridWebView c;
    protected byte[] d = null;
    protected String e;
    protected boolean f;
    protected boolean g;
    protected CustomHybirdWebViewClient h;
    protected l i;
    protected k j;
    private View k;
    private String l;
    private boolean m = false;
    private boolean n;
    private String o = "WXPageAction";
    private ProgressBar p;
    private TextView q;
    private Bundle r;

    private void a(LayoutInflater layoutInflater) {
        View inflate = layoutInflater.inflate(R.layout.ali_feedback_error, null);
        this.b.setErrorView(inflate);
        ((Button) inflate.findViewById(R.id.error_view_refresh_btn)).setOnClickListener(new f(this));
    }

    private void b() {
        this.f = this.r.getBoolean(WXBaseHybridActivity.NEED_LOGIN, false);
        this.g = this.r.getBoolean(WXBaseHybridActivity.NEED_SHOW_NAV, true);
    }

    private void c() {
        if (VERSION.SDK_INT < 18) {
            this.c.getSettings().setSavePassword(false);
        }
        this.h = new CustomHybirdWebViewClient(getActivity());
        this.c.setWebViewClient(this.h);
        this.p = new ProgressBar(getActivity(), null, 16842872);
        this.p.setMax(100);
        this.p.setProgressDrawable(getResources().getDrawable(R.drawable.ali_feedback_progress_bar_states));
        LayoutParams layoutParams = new LayoutParams(-1, 6);
        layoutParams.addRule(10, -1);
        this.c.getWvUIModel().a(this.p, layoutParams);
        String userAgentString = this.b.getWebview().getSettings().getUserAgentString();
        WebSettings settings = this.b.getWebview().getSettings();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(userAgentString);
        stringBuilder.append(" ");
        settings.setUserAgentString(stringBuilder.toString());
        this.h.setmUrl(this.e);
        this.h.setWebViewErrorListener(this);
    }

    private void d() {
        this.c.addJsObject(this.o, this.i);
        this.c.addJsObject("WXPage", this.j);
    }

    private void e() {
        this.k.findViewById(R.id.title_back).setOnClickListener(new h(this));
    }

    protected void a() {
        this.b.loadUrl(this.e, this.d);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (this.c != null) {
            this.c.onActivityResult(i, i2, intent);
        }
    }

    public void onCreate(Bundle bundle) {
        j jVar;
        this.r = getArguments();
        if (this.r != null) {
            jVar = (j) this.r.getParcelable("PARAMS");
            this.d = this.r.getByteArray("DATA");
            this.l = this.r.getString("APPKEY");
            this.e = this.r.getString("URL");
        } else {
            jVar = null;
        }
        this.a = new Handler(Looper.getMainLooper());
        this.b = new XBHybridViewController(getActivity());
        this.b.init(jVar);
        this.b.setUrlFilter(null);
        this.b.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        this.c = this.b.getWebview();
        this.c.setAppkey(this.l);
        this.c.setCurrentUrl(this.e);
        this.n = false;
        this.i = new l(getActivity(), getActivity().getWindow().getDecorView());
        this.j = new k(getActivity(), getActivity().getWindow().getDecorView());
        d();
        c();
        b();
        super.onCreate(bundle);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.k = layoutInflater.inflate(R.layout.ali_feedback_container_layout, viewGroup, false);
        ((ViewGroup) this.k.findViewById(R.id.hybird_container)).addView(this.b);
        e();
        a(layoutInflater);
        a();
        return this.k;
    }

    public void onDestroy() {
        this.b.destroy();
        this.b = null;
        super.onDestroy();
    }

    public void onReceivedError() {
        if (this.q == null) {
            this.q = (TextView) this.k.findViewById(R.id.webview_icon_back);
        }
        if (this.q != null) {
            this.q.setTextColor(getResources().getColor(R.color.ali_feedback_black));
            this.q.setCompoundDrawablesWithIntrinsicBounds(getResources().getDrawable(R.drawable.ali_feedback_common_back_btn_bg), null, null, null);
        }
        if (this.c.getWvUIModel() != null) {
            this.c.getWvUIModel().d();
        }
    }
}
