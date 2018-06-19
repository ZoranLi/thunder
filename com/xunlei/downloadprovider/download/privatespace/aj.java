package com.xunlei.downloadprovider.download.privatespace;

import android.content.Context;
import com.xunlei.common.accelerator.utils.LogcatUtil;
import com.xunlei.downloadprovider.member.login.b.c;

/* compiled from: PrivateSpaceMgr */
final class aj extends c {
    final /* synthetic */ Context a;
    final /* synthetic */ String b;
    final /* synthetic */ f c;

    aj(Context context, String str, f fVar) {
        this.a = context;
        this.b = str;
        this.c = fVar;
    }

    public final void onLoginCompleted(boolean z, int i, Object obj) {
        obj = new StringBuilder("errCode=");
        obj.append(i);
        LogcatUtil.i("PrivateSpaceMgr", obj.toString(), null);
        if (i == 0) {
            PrivateSpaceMgr.c(this.a, this.b, this.c);
        }
    }
}
