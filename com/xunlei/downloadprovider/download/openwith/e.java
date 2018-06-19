package com.xunlei.downloadprovider.download.openwith;

import android.content.Context;
import com.xunlei.common.androidutil.OSUtil;
import com.xunlei.common.businessutil.XLFileTypeUtil;
import com.xunlei.downloadprovider.download.d.d.a;
import com.xunlei.downloadprovider.download.d.f;
import com.xunlei.downloadprovider.download.downloadvod.TaskPlayInfo;
import com.xunlei.downloadprovider.vodnew.VodPlayerActivityNew;

/* compiled from: LocalFileOpenHelper */
final class e implements a {
    final /* synthetic */ Context a;

    e(Context context) {
        this.a = context;
    }

    public final void a(f fVar, String str) {
        if (!(fVar == null || fVar.c == null)) {
            Context context = this.a;
            fVar = fVar.c;
            if (fVar == null || !fVar.activityInfo.packageName.equals(OSUtil.getCurProcessName(context))) {
                fVar = c.a().a(context, str, fVar);
                if (fVar != null) {
                    fVar.addFlags(67108864);
                    context.startActivity(fVar);
                }
            } else if (XLFileTypeUtil.isLocalVodSupport(str) != null) {
                fVar = str.contains("/") != null ? str.substring(str.lastIndexOf("/") + 1) : str;
                TaskPlayInfo taskPlayInfo = new TaskPlayInfo(str);
                taskPlayInfo.mTitle = fVar;
                VodPlayerActivityNew.a(context, taskPlayInfo, "app_other", null, true, 0, null);
            }
        }
        d.a();
    }

    public final void a() {
        d.a();
    }
}
