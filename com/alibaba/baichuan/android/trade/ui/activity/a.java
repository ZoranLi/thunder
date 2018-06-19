package com.alibaba.baichuan.android.trade.ui.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.alibaba.baichuan.android.trade.AlibcContext;
import com.alibaba.baichuan.android.trade.c.b.d;
import com.alibaba.baichuan.android.trade.utils.e;
import com.alibaba.baichuan.android.trade.utils.l;
import java.io.Serializable;
import java.util.Map;
import org.android.agoo.common.AgooConstants;

public class a extends Activity {
    public static int e = e.a("OPEN_H5_TRADE");
    private static final String h = "a";
    protected WebView a;
    protected d b;
    public TextView c;
    public boolean d;
    private View f;
    private View g;

    protected void onActivityResult(int i, int i2, Intent intent) {
        com.ali.auth.third.ui.a.a.a(i);
    }

    public void onBackPressed() {
        if (this.b.b()) {
            this.b.d();
        } else {
            finish();
        }
    }

    protected void onDestroy() {
        if (this.a != null) {
            ViewGroup viewGroup = (ViewGroup) this.a.getParent();
            if (viewGroup != null) {
                viewGroup.removeView(this.a);
            }
            this.a.removeAllViews();
            this.a.destroy();
        }
        super.onDestroy();
    }

    protected void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
    }

    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("url", this.a.getUrl());
        bundle.putString("title", this.c.getText().toString());
        bundle.putSerializable("ui_contextParams", (Serializable) this.b.c());
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (!AlibcContext.j) {
            requestWindowFeature(1);
        }
        CharSequence charSequence = null;
        LinearLayout linearLayout = (LinearLayout) getLayoutInflater().inflate(l.a(this, "layout", "com_taobao_nb_sdk_web_view_activity"), null);
        Serializable serializableExtra = getIntent() != null ? getIntent().getSerializableExtra("ui_contextParams") : bundle != null ? bundle.getSerializable("ui_contextParams") : null;
        com.alibaba.baichuan.android.trade.b.a aVar = com.alibaba.baichuan.android.trade.callback.a.a;
        com.alibaba.baichuan.android.trade.callback.a.a = null;
        if (aVar == null) {
            finish();
            return;
        }
        this.a = new WebView(this);
        this.b = new d(this, aVar, this.a, serializableExtra instanceof Map ? (Map) serializableExtra : null);
        linearLayout.addView(this.a, new LayoutParams(-1, -1));
        setContentView(linearLayout);
        this.c = (TextView) findViewById(l.a(this, AgooConstants.MESSAGE_ID, "com_taobao_nb_sdk_web_view_title_bar_title"));
        this.g = findViewById(l.a(this, AgooConstants.MESSAGE_ID, "com_taobao_nb_sdk_web_view_title_bar_close_button"));
        if (this.g != null) {
            this.g.setOnClickListener(new b(this));
        }
        View findViewById = findViewById(l.a(this, AgooConstants.MESSAGE_ID, "com_taobao_nb_sdk_web_view_title_bar_back_button"));
        if (findViewById != null) {
            findViewById.setOnClickListener(new c(this));
        }
        findViewById = findViewById(l.a(this, AgooConstants.MESSAGE_ID, "com_taobao_tae_sdk_web_view_title_bar_more_button"));
        if (findViewById != null) {
            findViewById.setOnClickListener(new d(this));
        }
        this.f = findViewById(l.a(this, AgooConstants.MESSAGE_ID, "com_taobao_tae_sdk_web_view_title_bar"));
        if (bundle != null) {
            charSequence = bundle.getString("title");
            bundle = bundle.getString("title");
        } else {
            bundle = null;
        }
        if (TextUtils.isEmpty(charSequence) && aVar != null) {
            charSequence = aVar.d;
        }
        if (TextUtils.isEmpty(charSequence)) {
            this.d = true;
        } else {
            this.d = false;
            this.c.setText(charSequence);
        }
        if (TextUtils.isEmpty(bundle)) {
            bundle = getIntent().getStringExtra("url");
        }
        AlibcContext.b();
        this.a.loadUrl(bundle);
    }
}
