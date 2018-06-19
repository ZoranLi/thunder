package com.xunlei.downloadprovider.pushmessage.c;

import android.content.Context;
import com.xunlei.downloadprovider.download.engine.task.n;
import com.xunlei.downloadprovider.pushmessage.biz.BasePushBiz;
import com.xunlei.downloadprovider.pushmessage.localpush.b;

/* compiled from: BusinessUtil */
public class a {
    private static final String a = "a";

    public static String a(int i) {
        switch (i) {
            case 1:
                return "mipush";
            case 2:
                return "upush";
            case 3:
                return "hwpush";
            case 4:
                return "gpush";
            default:
                return "upush";
        }
    }

    public static void a(Context context, BasePushBiz basePushBiz) {
        n.a();
        if (n.b()) {
            b.a().a(context);
        } else {
            n.a();
            n.a(new b(context));
        }
        basePushBiz.onReceive(context);
    }
}
