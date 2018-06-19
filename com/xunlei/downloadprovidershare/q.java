package com.xunlei.downloadprovidershare;

import android.text.TextUtils;
import com.xunlei.common.concurrent.XLThreadPool;

/* compiled from: ShareThunderCommandHelper */
public final class q {
    public static void a(String str, a aVar) {
        XLThreadPool.execute(new v(str, aVar));
    }

    public static boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        int indexOf = str.indexOf("【迅雷口令#X") + 7;
        str = str.indexOf("#】");
        if (indexOf == -1 || str == -1) {
            return false;
        }
        return true;
    }
}
