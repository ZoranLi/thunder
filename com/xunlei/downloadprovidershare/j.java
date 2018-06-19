package com.xunlei.downloadprovidershare;

import android.support.annotation.DrawableRes;
import com.xunlei.common.businessutil.XLFileTypeUtil;
import java.util.HashMap;

/* compiled from: ShareFileIconTypeUtil */
public abstract class j {
    static final HashMap<String, Integer> a = new ShareFileIconTypeUtil$1();

    @DrawableRes
    public static int a(String str) {
        int i = R.drawable.share_ic_task_file_other;
        str = XLFileTypeUtil.extractFileExt(str, false).toLowerCase();
        return a.containsKey(str) ? ((Integer) a.get(str)).intValue() : i;
    }
}
