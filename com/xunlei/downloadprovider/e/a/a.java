package com.xunlei.downloadprovider.e.a;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.widget.ImageView;
import android.widget.TextView;
import com.xunlei.common.commonutil.DateUtil;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.app.BrothersApplication;
import com.xunlei.downloadprovider.d.d;
import com.xunlei.downloadprovider.h.f;
import com.xunlei.downloadprovider.member.login.LoginHelper;
import com.xunlei.downloadprovider.member.login.b.l;
import com.xunlei.downloadprovider.personal.a.j;
import com.xunlei.thunder.commonui.dialog.XLBaseDialog;

/* compiled from: LikeGuideDlg */
public final class a extends XLBaseDialog {
    private TextView a;
    private ImageView b;
    private String c;
    private String d;
    private String e;
    private final Context f;

    private a(@NonNull Context context, String str, String str2, String str3) {
        super(context, R.style.ThunderTheme.Dialog);
        this.f = context;
        this.c = str;
        this.d = str2;
        this.e = str3;
    }

    protected final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.like_guide_dialog);
        this.a = (TextView) findViewById(R.id.tv_go_btn);
        this.b = (ImageView) findViewById(R.id.iv_close_dlg);
        this.a.setOnClickListener(new b(this));
        this.b.setOnClickListener(new c(this));
    }

    public final void show() {
        super.show();
        j.a(this.c, this.d, this.e);
    }

    public final void dismiss() {
        super.dismiss();
        j.a(this.c, this.d, this.e, "close");
    }

    public static void a(Context context, String str, String str2, String str3) {
        LoginHelper.a();
        if (l.c() && d.a().e.g()) {
            long b = f.b(BrothersApplication.getApplicationInstance(), "key_first_like_time_millis", 0);
            long currentTimeMillis = System.currentTimeMillis();
            int isTheSameDay = DateUtil.isTheSameDay(b, currentTimeMillis) ^ 1;
            if (isTheSameDay != 0) {
                f.a(BrothersApplication.getApplicationInstance(), "key_first_like_time_millis", currentTimeMillis);
            }
            if (isTheSameDay != 0) {
                new a(context, str, str2, str3).show();
            }
        }
    }
}
