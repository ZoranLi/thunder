package com.xunlei.downloadprovider.publiser.campaign;

import android.content.Context;
import com.xunlei.common.commonview.dialog.XLAlertDialog;
import com.xunlei.downloadprovider.R;

/* compiled from: DownloadXLLiveDialog */
public final class a extends XLAlertDialog {
    private String a;

    /* compiled from: DownloadXLLiveDialog */
    public interface a {
    }

    public a(Context context, String str, a aVar) {
        super(context);
        this.a = str;
        setTitle((CharSequence) "迅雷直播");
        setMessage((CharSequence) "颜值与才艺俱佳的美女主播，就等你来撩！");
        setConfirmButtonText((int) R.string.download_youliao_dlg_btn_ok);
        setCancelButtonText((int) R.string.download_youliao_dlg_btn_cancel);
        setOnClickConfirmButtonListener(new b(this, aVar));
        setOnClickCancelButtonListener(new c(this, aVar));
    }

    static /* synthetic */ void a(com.xunlei.downloadprovider.publiser.campaign.a r3) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = "market://details?id=com.xunlei.tdlive";	 Catch:{ Exception -> 0x0018 }
        r0 = android.net.Uri.parse(r0);	 Catch:{ Exception -> 0x0018 }
        r1 = new com.xunlei.xllib.android.XLIntent;	 Catch:{ Exception -> 0x0018 }
        r2 = "android.intent.action.VIEW";	 Catch:{ Exception -> 0x0018 }
        r1.<init>(r2, r0);	 Catch:{ Exception -> 0x0018 }
        r0 = 268435456; // 0x10000000 float:2.5243549E-29 double:1.32624737E-315;	 Catch:{ Exception -> 0x0018 }
        r1.addFlags(r0);	 Catch:{ Exception -> 0x0018 }
        r0 = r3.mCtx;	 Catch:{ Exception -> 0x0018 }
        r0.startActivity(r1);	 Catch:{ Exception -> 0x0018 }
        return;
    L_0x0018:
        r3 = r3.mCtx;
        r0 = "您没有安装应用市场";
        com.xunlei.common.commonview.XLToast.showToast(r3, r0);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.downloadprovider.publiser.campaign.a.a(com.xunlei.downloadprovider.publiser.campaign.a):void");
    }
}
