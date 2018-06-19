package com.xunlei.downloadprovider.ad.downloadlist;

import com.xiaomi.mipush.sdk.Constants;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.app.BrothersApplication;
import com.xunlei.downloadprovider.d.d;
import java.text.DecimalFormat;

/* compiled from: DownloadListADUtils */
public final class a {
    public static boolean[] a = new boolean[3];

    public static String a(int i) {
        String str = "total";
        switch (i) {
            case 0:
                return "total";
            case 1:
                return "downloading";
            case 2:
                return "finish";
            default:
                return str;
        }
    }

    public static boolean b(int i) {
        switch (i) {
            case 0:
                return d.a().p.e();
            case 1:
                return d.a().p.f();
            case 2:
                return d.a().p.g();
            default:
                return true;
        }
    }

    public static String a(long j) {
        if (j < 10000) {
            return "0";
        }
        if (j < 100000000) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(j / 10000);
            stringBuilder.append(BrothersApplication.getApplicationInstance().getString(R.string.choiceness_ad_download_count_min_unit));
            return stringBuilder.toString();
        }
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append(new DecimalFormat("#.0").format((((double) j) * 4607182418800017408L) / 4726483295884279808L));
        stringBuilder2.append(BrothersApplication.getApplicationInstance().getString(R.string.choiceness_ad_download_count_max_unit));
        return stringBuilder2.toString();
    }

    public static String a(com.xunlei.downloadprovider.ad.downloadlist.c.a aVar) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(aVar.b());
        stringBuilder.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
        stringBuilder.append(aVar.c());
        return stringBuilder.toString();
    }
}
