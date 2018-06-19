package com.xunlei.downloadprovider.web.website.d;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.app.BrothersApplication;
import com.xunlei.downloadprovider.contentpublish.website.au;
import com.xunlei.downloadprovider.contentpublish.website.az;
import com.xunlei.downloadprovider.contentpublish.website.be;
import com.xunlei.downloadprovider.contentpublish.website.bf;
import com.xunlei.downloadprovider.dialog.i;
import com.xunlei.downloadprovider.member.login.authphone.p;
import com.xunlei.downloadprovider.member.login.authphone.r;
import com.xunlei.downloadprovider.member.login.ui.LoginFrom;
import com.xunlei.xllib.android.b;

/* compiled from: CollectSuccessDialog */
public class a extends i {
    private static final String a = "a";
    private Context b;
    private View c;
    private TextView d;
    private TextView e;
    private String f;
    private String g;
    private String h;
    private String l;
    private p m = new b(this);
    private OnClickListener n = new c(this);
    private OnClickListener o = new d(this);

    public a(Context context, String str, String str2, String str3, String str4) {
        super(context);
        this.b = context;
        this.f = str4;
        this.g = str;
        this.h = str2;
        this.l = str3;
        this.c = LayoutInflater.from(this.b).inflate(R.layout.xl_collect_success_dialog, null);
        this.d = (TextView) this.c.findViewById(R.id.dlg_left_btn);
        this.e = (TextView) this.c.findViewById(R.id.dlg_right_btn);
        setContentView(this.c);
        setCancelable(true);
        setCanceledOnTouchOutside(null);
        this.e.setOnClickListener(this.n);
        this.d.setOnClickListener(this.o);
    }

    private void c() {
        az a = az.a();
        String str = this.f;
        String str2 = this.g;
        Object obj = this.h;
        String str3 = this.l;
        StringBuilder stringBuilder = new StringBuilder("silencePublishWebsite--title=");
        stringBuilder.append(obj);
        stringBuilder.append("| url=");
        stringBuilder.append(str2);
        stringBuilder.append(" |picUrl=");
        stringBuilder.append(str3);
        if (!TextUtils.isEmpty(str2)) {
            if (!b.a(BrothersApplication.getApplicationInstance())) {
                bf.c(str, str2, "no_connect");
            } else if (TextUtils.isEmpty(obj)) {
                bf.c(str, str2, "fail");
            } else {
                bf.c(str, str2, "success");
                au auVar = new au();
                auVar.c = obj;
                auVar.a = str2;
                auVar.b = str3;
                a.a(auVar, new be(a, str, str2));
            }
        }
    }

    protected final void a() {
        super.a();
    }

    static /* synthetic */ void b(a aVar) {
        if (!r.a().a(aVar.b, LoginFrom.COLLECT_SUCCESS_PUBLIC, aVar.m)) {
            aVar.c();
        }
    }
}
