package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.android.a;
import com.xiaomi.channel.commonutils.android.g;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.channel.commonutils.string.d;
import com.xiaomi.xmpush.thrift.ai;
import com.xiaomi.xmpush.thrift.r;
import java.util.HashMap;
import java.util.Map;

final class am implements Runnable {
    final /* synthetic */ Context a;
    final /* synthetic */ boolean b;

    am(Context context, boolean z) {
        this.a = context;
        this.b = z;
    }

    public final void run() {
        Map map;
        String a;
        b.a("do sync info");
        ai aiVar = new ai(MiPushClient.generatePacketID(), false);
        c a2 = c.a(this.a);
        aiVar.c(r.v.W);
        aiVar.b(a2.c());
        aiVar.d(this.a.getPackageName());
        aiVar.h = new HashMap();
        g.a(aiVar.h, "app_version", a.a(this.a, this.a.getPackageName()));
        g.a(aiVar.h, Constants.EXTRA_KEY_APP_VERSION_CODE, Integer.toString(a.b(this.a, this.a.getPackageName())));
        g.a(aiVar.h, "push_sdk_vn", "3_5_1");
        g.a(aiVar.h, "push_sdk_vc", Integer.toString(30501));
        g.a(aiVar.h, "token", a2.d());
        String a3 = d.a(com.xiaomi.channel.commonutils.android.d.c(this.a));
        Object e = com.xiaomi.channel.commonutils.android.d.e(this.a);
        if (!TextUtils.isEmpty(e)) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(a3);
            stringBuilder.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
            stringBuilder.append(e);
            a3 = stringBuilder.toString();
        }
        g.a(aiVar.h, Constants.EXTRA_KEY_IMEI_MD5, a3);
        g.a(aiVar.h, Constants.EXTRA_KEY_REG_ID, a2.e());
        g.a(aiVar.h, Constants.EXTRA_KEY_REG_SECRET, a2.f());
        g.a(aiVar.h, Constants.EXTRA_KEY_ACCEPT_TIME, MiPushClient.getAcceptTime(this.a).replace(Constants.ACCEPT_TIME_SEPARATOR_SP, "-"));
        if (this.b) {
            g.a(aiVar.h, Constants.EXTRA_KEY_ALIASES_MD5, al.a(MiPushClient.getAllAlias(this.a)));
            g.a(aiVar.h, Constants.EXTRA_KEY_TOPICS_MD5, al.a(MiPushClient.getAllTopic(this.a)));
            map = aiVar.h;
            a3 = Constants.EXTRA_KEY_ACCOUNTS_MD5;
            a = al.a(MiPushClient.getAllUserAccount(this.a));
        } else {
            g.a(aiVar.h, Constants.EXTRA_KEY_ALIASES, al.b(MiPushClient.getAllAlias(this.a)));
            g.a(aiVar.h, Constants.EXTRA_KEY_TOPICS, al.b(MiPushClient.getAllTopic(this.a)));
            map = aiVar.h;
            a3 = Constants.EXTRA_KEY_ACCOUNTS;
            a = al.b(MiPushClient.getAllUserAccount(this.a));
        }
        g.a(map, a3, a);
        ac.a(this.a).a(aiVar, com.xiaomi.xmpush.thrift.a.i, false, null);
    }
}
