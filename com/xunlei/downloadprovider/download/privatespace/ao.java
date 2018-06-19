package com.xunlei.downloadprovider.download.privatespace;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.xunlei.common.commonview.dialog.XLWaitingDialog;
import com.xunlei.downloadprovider.R;

/* compiled from: VerifyPrivateSpaceDialog */
public final class ao extends s {
    XLWaitingDialog a;
    f c;

    public final /* bridge */ /* synthetic */ void a() {
        super.a();
    }

    public final /* bridge */ /* synthetic */ String b() {
        return super.b();
    }

    public final /* bridge */ /* synthetic */ String c() {
        return super.c();
    }

    public final /* bridge */ /* synthetic */ void c(String str) {
        super.c(str);
    }

    public final /* bridge */ /* synthetic */ void onClick(View view) {
        super.onClick(view);
    }

    public ao(Context context) {
        super(context);
        super.c(context.getString(R.string.look_hide_file));
        super.b(context.getString(R.string.tips_private_space_hide));
        super.a(false);
        super.a(context.getString(R.string.private_space_look));
        super.a();
        setOnCancelListener(new ap(this));
        super.a(new aq(this));
        super.b(new ar(this));
        TextView textView = (TextView) findViewById(R.id.private_space_find_pwd_tv);
        textView.setVisibility(0);
        textView.setOnClickListener(new at(this));
    }
}
