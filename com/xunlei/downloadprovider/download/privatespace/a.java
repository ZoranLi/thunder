package com.xunlei.downloadprovider.download.privatespace;

import android.content.Context;
import android.view.View;
import com.xunlei.common.commonview.dialog.XLWaitingDialog;
import com.xunlei.downloadprovider.R;

/* compiled from: ClosePrivateSpaceTipDialog */
public final class a extends s {
    XLWaitingDialog a;

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

    public a(Context context) {
        super(context);
        super.c(context.getString(R.string.close_private_space));
        super.b(context.getString(R.string.tips_close_private_space));
        super.a(false);
        super.a(context.getString(R.string.private_space_close));
        super.a();
        setOnCancelListener(new b(this));
        super.a(new c(this));
        super.b(new d(this));
    }
}
