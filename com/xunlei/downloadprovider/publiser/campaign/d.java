package com.xunlei.downloadprovider.publiser.campaign;

import android.content.Context;
import com.tencent.tinker.loader.shareutil.ShareConstants;
import com.xunlei.common.commonview.dialog.XLAlertDialog;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.download.create.DownData;
import com.xunlei.downloadprovider.download.create.at;
import com.xunlei.downloadprovider.download.engine.report.TaskStatInfo;
import com.xunlei.downloadprovider.download.report.c;

/* compiled from: DownloadYouLiaoDialog */
public final class d extends XLAlertDialog {
    public static final String a = com.xunlei.downloadprovider.d.d.a().r.k();
    private String b;

    /* compiled from: DownloadYouLiaoDialog */
    public interface a {
        void a();
    }

    public d(Context context, String str, a aVar) {
        super(context);
        this.b = str;
        setTitle((int) R.string.download_youliao_dlg_title);
        setMessage((int) R.string.download_youliao_dlg_msg);
        setConfirmButtonText((int) R.string.download_youliao_dlg_btn_ok);
        setCancelButtonText((int) R.string.download_youliao_dlg_btn_cancel);
        setOnClickConfirmButtonListener(new e(this, aVar));
        setOnClickCancelButtonListener(new f(this, aVar));
    }

    private void a(String str, String str2, String str3) {
        DownData downData = new DownData();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str3);
        stringBuilder.append(ShareConstants.PATCH_SUFFIX);
        downData.a = stringBuilder.toString();
        downData.b = str;
        downData.a().b = str2;
        str2 = new TaskStatInfo(str, null);
        str2.a = c.a(this.b, "cn.kuaipan.android");
        at.a(downData, str2);
        com.xunlei.downloadprovider.download.util.c.a();
    }

    static /* synthetic */ void a(com.xunlei.downloadprovider.publiser.campaign.d r6, java.lang.String r7, java.lang.String r8, java.lang.String r9) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = "market://details?id=cn.kuaipan.android";	 Catch:{ Exception -> 0x0018 }
        r0 = android.net.Uri.parse(r0);	 Catch:{ Exception -> 0x0018 }
        r1 = new com.xunlei.xllib.android.XLIntent;	 Catch:{ Exception -> 0x0018 }
        r2 = "android.intent.action.VIEW";	 Catch:{ Exception -> 0x0018 }
        r1.<init>(r2, r0);	 Catch:{ Exception -> 0x0018 }
        r0 = 268435456; // 0x10000000 float:2.5243549E-29 double:1.32624737E-315;	 Catch:{ Exception -> 0x0018 }
        r1.addFlags(r0);	 Catch:{ Exception -> 0x0018 }
        r0 = r6.mCtx;	 Catch:{ Exception -> 0x0018 }
        r0.startActivity(r1);	 Catch:{ Exception -> 0x0018 }
        return;
    L_0x0018:
        com.xunlei.downloadprovider.download.engine.task.n.a();
        r0 = com.xunlei.downloadprovider.download.engine.task.n.e(r7);
        r2 = -1;
        r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1));
        if (r4 == 0) goto L_0x0055;
    L_0x0025:
        com.xunlei.downloadprovider.download.engine.task.n.a();
        r0 = com.xunlei.downloadprovider.download.engine.task.n.f(r0);
        if (r0 == 0) goto L_0x0051;
    L_0x002e:
        r1 = r0.mLocalFileName;
        if (r1 == 0) goto L_0x0051;
    L_0x0032:
        r1 = new java.io.File;
        r2 = r0.mLocalFileName;
        r1.<init>(r2);
        r1 = r1.exists();
        if (r1 == 0) goto L_0x0051;
    L_0x003f:
        r1 = r0.mDownloadedSize;
        r3 = r0.mFileSize;
        r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1));
        if (r5 != 0) goto L_0x0051;
    L_0x0047:
        r7 = r0.mLocalFileName;
        r6 = r6.getContext();
        com.xunlei.common.androidutil.ApkHelper.installApk(r6, r7);
        return;
    L_0x0051:
        r6.a(r7, r8, r9);
        return;
    L_0x0055:
        r6.a(r7, r8, r9);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.downloadprovider.publiser.campaign.d.a(com.xunlei.downloadprovider.publiser.campaign.d, java.lang.String, java.lang.String, java.lang.String):void");
    }
}
