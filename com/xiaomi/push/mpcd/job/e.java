package com.xiaomi.push.mpcd.job;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.mipush.sdk.Constants;
import com.xiaomi.push.mpcd.BroadcastActionsReceiver;
import com.xiaomi.xmpush.thrift.d;

public class e extends f {
    public static String a = "";
    public static String b = "";

    public e(Context context, int i) {
        super(context, i);
    }

    private String a(String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            if (!TextUtils.isEmpty(str2)) {
                String[] split = str2.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                if (split.length <= 10) {
                    return str2;
                }
                for (int length = split.length - 1; length >= split.length - 10; length--) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(str);
                    stringBuilder.append(split[length]);
                    str = stringBuilder.toString();
                }
                return str;
            }
        }
        return "";
    }

    public int a() {
        return 12;
    }

    public String b() {
        String str = "";
        if (!TextUtils.isEmpty(a)) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append(a(BroadcastActionsReceiver.a, a));
            str = stringBuilder.toString();
            a = "";
        }
        if (TextUtils.isEmpty(b)) {
            return str;
        }
        stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append(a(BroadcastActionsReceiver.b, b));
        str = stringBuilder.toString();
        b = "";
        return str;
    }

    public d d() {
        return d.BroadcastAction;
    }
}
