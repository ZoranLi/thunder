package com.hianalytics.android.v1;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.alipay.sdk.util.h;
import com.hianalytics.android.b.a.c;
import com.xiaomi.account.openauth.XiaomiOAuthConstants;
import com.xiaomi.mipush.sdk.Constants;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public final class a implements Runnable {
    private Context a;
    private String b;
    private String c;
    private long d;

    public a(Context context, String str, String str2, long j) {
        this.a = context;
        this.b = str.replace(Constants.ACCEPT_TIME_SEPARATOR_SP, "^");
        this.c = str2.replace(Constants.ACCEPT_TIME_SEPARATOR_SP, "^");
        this.d = j;
    }

    public final void run() {
        try {
            SharedPreferences a = c.a(this.a, XiaomiOAuthConstants.EXTRA_STATE_2);
            if (a == null) {
                com.hianalytics.android.b.a.a.h();
                return;
            }
            StringBuilder stringBuilder;
            Object string = a.getString("events", "");
            if (!"".equals(string)) {
                stringBuilder = new StringBuilder(String.valueOf(string));
                stringBuilder.append(h.b);
                string = stringBuilder.toString();
            }
            stringBuilder = new StringBuilder(String.valueOf(string));
            stringBuilder.append(this.b);
            stringBuilder.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
            stringBuilder.append(this.c);
            stringBuilder.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
            stringBuilder.append(new SimpleDateFormat("yyyyMMddHHmmssSSS", Locale.US).format(new Date(this.d)));
            String stringBuilder2 = stringBuilder.toString();
            if (stringBuilder2.split(h.b).length <= com.hianalytics.android.b.a.a.d()) {
                Editor edit = a.edit();
                edit.remove("events");
                edit.putString("events", stringBuilder2);
                edit.commit();
                com.hianalytics.android.b.a.a.h();
            }
            if (com.hianalytics.android.b.a.a.d(this.a)) {
                if (com.hianalytics.android.b.a.a.e()) {
                    com.hianalytics.android.b.a.a.h();
                    HiAnalytics.onReport(this.a);
                    return;
                }
                a.edit().remove("events").commit();
            }
        } catch (Exception e) {
            e.getMessage();
            com.hianalytics.android.b.a.a.h();
            e.printStackTrace();
        }
    }
}
