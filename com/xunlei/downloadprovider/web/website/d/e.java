package com.xunlei.downloadprovider.web.website.d;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.dialog.i;
import com.xunlei.downloadprovider.web.website.g.b$a;

/* compiled from: CollectionTipDialog */
public final class e extends i {
    private String a;
    private Context b;
    private View c;
    private TextView d;
    private TextView e;
    private TextView f;
    private String g;
    private String h;
    private String l;
    private b$a m;
    private OnClickListener n = new f(this);
    private OnClickListener o = new g(this);

    protected final int b() {
        return 8;
    }

    public e(Context context, String str, String str2, String str3, String str4, b$a com_xunlei_downloadprovider_web_website_g_b_a) {
        super(context);
        this.b = context;
        this.a = str4;
        this.g = str;
        this.h = str2;
        this.l = str3;
        this.m = com_xunlei_downloadprovider_web_website_g_b_a;
        this.c = LayoutInflater.from(this.b).inflate(R.layout.xl_collect_success_dialog, null);
        this.d = (TextView) this.c.findViewById(R.id.dlg_left_btn);
        this.e = (TextView) this.c.findViewById(R.id.dlg_right_btn);
        this.f = (TextView) this.c.findViewById(R.id.dlg_content);
        this.f.setText(R.string.collect_tip_content);
        setContentView(this.c);
        setCancelable(true);
        setCanceledOnTouchOutside(null);
        this.e.setOnClickListener(this.n);
        this.d.setOnClickListener(this.o);
    }

    protected final void a() {
        super.a();
    }
}
