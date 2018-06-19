package com.umeng.message.proguard;

import android.text.TextUtils;
import com.umeng.message.MsgConstant;
import java.io.File;
import java.io.FilenameFilter;

/* compiled from: MsgLogStore */
class l$1 implements FilenameFilter {
    final /* synthetic */ l a;

    l$1(l lVar) {
        this.a = lVar;
    }

    public boolean accept(File file, String str) {
        return (TextUtils.isEmpty(str) != null || str.startsWith(MsgConstant.CACHE_LOG_FILE_PREFIX) == null) ? null : true;
    }
}
