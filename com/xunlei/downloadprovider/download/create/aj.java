package com.xunlei.downloadprovider.download.create;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.text.TextUtils;
import com.xunlei.common.androidutil.ApkHelper;

/* compiled from: ThunderTaskActivity */
final class aj implements OnClickListener {
    final /* synthetic */ String a;
    final /* synthetic */ ThunderTaskActivity b;

    aj(ThunderTaskActivity thunderTaskActivity, String str) {
        this.b = thunderTaskActivity;
        this.a = str;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
        if (TextUtils.isEmpty(this.a) == null) {
            ApkHelper.launchAppByPackageName(this.b, this.a);
        }
    }
}
