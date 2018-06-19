package com.xunlei.downloadprovider.download.tasklist.list.banner.f;

import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.xiaomi.mipush.sdk.Constants;
import com.xunlei.downloadprovider.member.login.LoginHelper;
import com.xunlei.downloadprovider.personal.redenvelope.redenvelopelist.b.e;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/* compiled from: VoucherPacketHelper */
final class m implements Runnable {
    final /* synthetic */ List a;
    final /* synthetic */ f b;

    m(f fVar, List list) {
        this.b = fVar;
        this.a = list;
    }

    public final void run() {
        String format = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        Editor c = this.b.a;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(LoginHelper.a().g.c());
        stringBuilder.append("key:get_voucher_packet_list");
        c.putString(stringBuilder.toString(), format).commit();
        this.b.w();
        Collections.sort(this.a, new n(this));
        StringBuilder stringBuilder2 = new StringBuilder(64);
        String e = this.b.r.getString(f.y(), "");
        stringBuilder = new StringBuilder("mRecordAlarmCode=");
        stringBuilder.append(this.b.t);
        stringBuilder.append(" ,lastRecordAlarmCode=");
        stringBuilder.append(e);
        if (!TextUtils.isEmpty(e)) {
            this.b.t = e;
        }
        long j = -1;
        for (e eVar : this.a) {
            long min = Math.min(eVar.i - eVar.h, eVar.i - (System.currentTimeMillis() / 1000));
            if (eVar.e != 2 && min > 0) {
                this.b.s = this.b.s + 1;
                if (f.a(eVar.f) && !this.b.t.contains(eVar.j) && min < 259200) {
                    if (j < 0) {
                        stringBuilder = new StringBuilder("start alram expireTime=");
                        stringBuilder.append(min);
                        stringBuilder.append(" ,id=");
                        stringBuilder.append(eVar.a);
                        j = min;
                    }
                    stringBuilder2.append(eVar.j);
                    stringBuilder2.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                }
            } else if (this.b.t.contains(eVar.j)) {
                String e2 = this.b.r.getString(f.y(), "");
                StringBuilder stringBuilder3 = new StringBuilder();
                stringBuilder3.append(eVar.j);
                stringBuilder3.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                e2.replaceAll(stringBuilder3.toString(), "");
                this.b.a.putString(f.y(), e2).commit();
            }
        }
        this.b.x();
        if (j >= 0) {
            this.b.t = stringBuilder2.toString();
            f.h(this.b);
        }
    }
}
