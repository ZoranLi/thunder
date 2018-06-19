package com.xunlei.downloadprovider.app;

import com.tencent.tinker.lib.tinker.Tinker;
import com.tencent.tinker.loader.shareutil.ShareConstants;

/* compiled from: TinkerReportUtils */
public final class h {
    public static String a() {
        Tinker with = Tinker.with(BrothersApplication.getApplicationInstance());
        return (with.getTinkerLoadResultIfPresent() == null || with.getTinkerLoadResultIfPresent().packageConfig == null) ? null : (String) with.getTinkerLoadResultIfPresent().packageConfig.get(ShareConstants.NEW_TINKER_ID);
    }
}
