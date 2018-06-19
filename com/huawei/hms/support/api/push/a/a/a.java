package com.huawei.hms.support.api.push.a.a;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.support.api.push.a.a.a.c;
import com.huawei.hms.support.api.push.a.a.b.d;

/* compiled from: PushDataEncrypterManager */
public abstract class a {
    public static String a(Context context, String str, String str2) {
        String str3 = "";
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return str3;
        }
        StringBuilder stringBuilder;
        try {
            stringBuilder = new StringBuilder();
            stringBuilder.append(str2);
            stringBuilder.append("_v2");
            context = d.b(context, new c(context, str).b(stringBuilder.toString()));
        } catch (Context context2) {
            if (com.huawei.hms.support.log.a.d() != null) {
                stringBuilder = new StringBuilder("getSecureData");
                stringBuilder.append(context2.getMessage());
                com.huawei.hms.support.log.a.d("PushDataEncrypterManager", stringBuilder.toString());
            }
            context2 = str3;
        }
        if (!(TextUtils.isEmpty(context2) == null || com.huawei.hms.support.log.a.a() == null)) {
            StringBuilder stringBuilder2 = new StringBuilder("not exist for:");
            stringBuilder2.append(str2);
            com.huawei.hms.support.log.a.a("PushDataEncrypterManager", stringBuilder2.toString());
        }
        return context2;
    }

    public static void b(Context context, String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            try {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(str2);
                stringBuilder.append("_v2");
                new c(context, str).d(stringBuilder.toString());
            } catch (Context context2) {
                if (com.huawei.hms.support.log.a.d() != null) {
                    str2 = new StringBuilder("removeSecureData");
                    str2.append(context2.getMessage());
                    com.huawei.hms.support.log.a.d("PushDataEncrypterManager", str2.toString());
                }
            }
        }
    }

    public static boolean a(Context context, String str, String str2, String str3) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return false;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str2);
        stringBuilder.append("_v2");
        return new c(context, str).a(stringBuilder.toString(), d.a(context, str3));
    }
}
