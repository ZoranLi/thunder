package com.xunlei.downloadprovider.ad.home.ui;

import android.content.Context;
import android.text.TextUtils;
import com.xunlei.downloadprovider.ad.common.adget.l;
import com.xunlei.downloadprovider.ad.common.o;
import com.xunlei.downloadprovider.d.e;
import com.xunlei.downloadprovider.player.a.a;

/* compiled from: UIHelper */
public class u {
    public static int a = 0;
    private static final String b = "u";

    public static String a(l lVar) {
        return o.b(lVar);
    }

    public static String a() {
        return o.a();
    }

    public static a a(Context context, a aVar) {
        if (b() != 201) {
            return new h(context, aVar);
        }
        return new g(context, aVar);
    }

    public static ADImageItemviewBase a(Context context) {
        if (b() != 201) {
            return new ADImageItemViewTemplateUGCStyle2(context);
        }
        return new ADImageItemViewTemplateUGC(context);
    }

    public static l b(Context context, a aVar) {
        if (b() != 201) {
            return new r(context, aVar);
        }
        return new p(context, aVar);
    }

    public static String[] a(String str, String str2) {
        String[] strArr = new String[2];
        if ((TextUtils.isEmpty(str) ? 0 : str.length()) <= (TextUtils.isEmpty(str2) ? 0 : str2.length())) {
            strArr[0] = str;
            strArr[1] = str2;
        } else {
            strArr[0] = str2;
            strArr[1] = str;
        }
        return strArr;
    }

    private static int b() {
        if (a == 0) {
            e.a aVar = e.a().e;
            int i = 2;
            if (aVar.a != null) {
                i = aVar.a.optInt("home_ad_template_ugc_style", 2);
            }
            a = i;
        }
        return a == 1 ? 201 : 202;
    }
}
