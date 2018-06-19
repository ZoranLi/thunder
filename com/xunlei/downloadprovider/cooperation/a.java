package com.xunlei.downloadprovider.cooperation;

import android.text.TextUtils;
import com.tencent.tinker.loader.shareutil.ShareConstants;
import com.xunlei.downloadprovider.cooperation.data.CooperationItem;
import com.xunlei.downloadprovider.cooperation.ui.b;
import com.xunlei.downloadprovider.download.engine.report.TaskStatInfo;
import com.xunlei.downloadprovider.download.engine.task.info.DownloadAdditionInfo;
import com.xunlei.downloadprovider.download.engine.task.m;
import com.xunlei.downloadprovider.download.engine.task.n;
import com.xunlei.downloadprovider.download.report.c;
import java.util.ArrayList;

/* compiled from: CooperationDownloader */
public final class a {
    private static final a c = new a();
    ArrayList<CooperationItem> a = new ArrayList();
    public ArrayList<CooperationItem> b;

    public static a a() {
        return c;
    }

    private a() {
    }

    static /* synthetic */ void a(CooperationItem cooperationItem) {
        String appDownloadUrl = cooperationItem.getAppDownloadUrl();
        TaskStatInfo taskStatInfo = new TaskStatInfo(c.a, appDownloadUrl, "");
        DownloadAdditionInfo downloadAdditionInfo = new DownloadAdditionInfo();
        downloadAdditionInfo.f = false;
        downloadAdditionInfo.a = cooperationItem.getAppName();
        downloadAdditionInfo.b = cooperationItem.getAppSelfIconUrl();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(cooperationItem.getAppName());
        stringBuilder.append(ShareConstants.PATCH_SUFFIX);
        String stringBuilder2 = stringBuilder.toString();
        b.a();
        if (TextUtils.isEmpty(b.c()) == null) {
            b.a();
            cooperationItem = b.c();
            String str = taskStatInfo.a;
            com.xunlei.downloadprovider.download.engine.report.a.a(str);
            m mVar = new m();
            mVar.a(appDownloadUrl, stringBuilder2, 0, "", str, downloadAdditionInfo);
            mVar.a(101);
            mVar.a(true);
            mVar.b = taskStatInfo;
            if (mVar.a != null) {
                mVar.a.mDownloadPath = cooperationItem;
            }
            n.a().a(mVar, null);
            com.xunlei.downloadprovider.download.util.c.a();
        }
    }
}
