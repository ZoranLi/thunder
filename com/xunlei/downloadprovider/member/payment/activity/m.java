package com.xunlei.downloadprovider.member.payment.activity;

import android.support.annotation.NonNull;
import android.text.TextUtils;

/* compiled from: IActivityImpFactory */
public final class m {
    public static e a(@NonNull a aVar) {
        if (aVar == null) {
            return null;
        }
        e qVar;
        CharSequence charSequence = aVar.a;
        if (!TextUtils.equals(charSequence, "vip2017sl99")) {
            if (!TextUtils.equals(charSequence, "vip2017sl9901")) {
                if (TextUtils.equals(charSequence, "vip2017libao")) {
                    qVar = new q();
                } else {
                    qVar = new n();
                }
                qVar.a(aVar);
                if (qVar.a() != null) {
                    return null;
                }
                return qVar;
            }
        }
        qVar = new p();
        qVar.a(aVar);
        if (qVar.a() != null) {
            return qVar;
        }
        return null;
    }
}
