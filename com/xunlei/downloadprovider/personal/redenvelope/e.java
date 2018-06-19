package com.xunlei.downloadprovider.personal.redenvelope;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.smtt.sdk.TbsDownloadConfig;
import com.umeng.message.MsgConstant;
import com.xunlei.common.androidutil.ClipboardUtil;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.regex.Pattern;

/* compiled from: RedEnvelopeHelper */
public final class e {
    public static String a = "还剩%s过期";
    public static String b = "获取时间：%s";

    public static String a(long j) {
        if (j >= 86400000) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append((j / 1000) / TbsDownloadConfig.DEFAULT_RETRY_INTERVAL_SEC);
            stringBuilder.append("天");
            return stringBuilder.toString();
        }
        long j2 = j / 1000;
        long j3 = (j2 / 60) % 60;
        j2 = (j2 / 3600) % 24;
        if (j >= 3600000) {
            j = new StringBuilder();
            j.append(j2);
            j.append("小时");
            j.append(j3);
            j.append("分钟");
            return j.toString();
        } else if (j < 60000) {
            return "1分钟";
        } else {
            j = new StringBuilder();
            j.append(j3);
            j.append("分钟");
            return j.toString();
        }
    }

    public static void a(Context context, String str) {
        if (str != null) {
            ClipboardUtil.copyToClipboard(context, str, MsgConstant.INAPP_LABEL);
        }
    }

    public static String b(long j) {
        return new SimpleDateFormat("yyyy年MM月dd日", Locale.CHINA).format(new Date(j * 1000));
    }

    public static int a(String str) {
        str = Pattern.compile("[^0-9]").matcher(str).replaceAll("").trim();
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return Integer.valueOf(str).intValue();
    }
}
