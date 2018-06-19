package com.xunlei.downloadprovider.download.center.widget;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager.LayoutParams;
import android.widget.TextView;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.download.create.CreateBtTaskActivity;
import com.xunlei.downloadprovider.download.create.CreateUrlTaskActivity;
import com.xunlei.thunder.commonui.dialog.XLBaseDialog;
import com.xunlei.xllib.android.XLIntent;
import com.xunlei.xllib.android.d;

/* compiled from: DownloadCreateMoreTaskDialog */
public final class p extends XLBaseDialog {
    private TextView a;
    private TextView b;
    private TextView c;

    public p(Context context) {
        this(context, (byte) 0);
    }

    private p(Context context, byte b) {
        super(context, (byte) 40);
        this.a = null;
        this.b = null;
        this.c = null;
    }

    protected final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.dialog_create_homepage);
        this.a = (TextView) findViewById(R.id.tv_create_homepage_qrcode);
        this.b = (TextView) findViewById(R.id.tv_create_homepage_link);
        this.c = (TextView) findViewById(R.id.tv_create_homepage_bt);
        ((TextView) findViewById(R.id.tv_cancel)).setOnClickListener(new q(this));
        this.a.setOnClickListener(new r(this));
        this.b.setOnClickListener(new s(this));
        this.c.setOnClickListener(new t(this));
        setCancelable(true);
        setCanceledOnTouchOutside(true);
        bundle = getWindow();
        LayoutParams attributes = bundle.getAttributes();
        attributes.gravity = 81;
        attributes.width = d.a(getContext().getApplicationContext());
        attributes.height = -2;
        attributes.flags &= -1025;
        attributes.flags |= 2048;
        attributes.windowAnimations = R.style.PopupBottomInAnim;
        bundle.setAttributes(attributes);
    }

    private static java.lang.String a() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = com.xunlei.common.businessutil.SettingStateController.getInstance();
        r0 = r0.getLastTorrentOpenPath();
        r1 = 0;
        if (r0 == 0) goto L_0x0017;
    L_0x000b:
        r2 = new java.io.File;	 Catch:{ Exception -> 0x0017 }
        r2.<init>(r0);	 Catch:{ Exception -> 0x0017 }
        r2 = r2.exists();	 Catch:{ Exception -> 0x0017 }
        if (r2 == 0) goto L_0x0017;
    L_0x0016:
        r1 = r0;
    L_0x0017:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.downloadprovider.download.center.widget.p.a():java.lang.String");
    }

    static /* synthetic */ void b(p pVar) {
        Intent xLIntent = new XLIntent();
        xLIntent.setClass(pVar.getContext(), CreateUrlTaskActivity.class);
        pVar.getContext().startActivity(xLIntent);
    }

    static /* synthetic */ void c(p pVar) {
        String a = a();
        Intent xLIntent = new XLIntent();
        xLIntent.setClass(pVar.getContext(), CreateBtTaskActivity.class);
        if (a != null) {
            xLIntent.putExtra("last_torrent_open_path", a);
        }
        pVar.getContext().startActivity(xLIntent);
    }
}
