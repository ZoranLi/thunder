package com.xiaomi.push.service;

import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.service.XMPushService.h;
import com.xiaomi.xmpush.thrift.af;
import com.xunlei.download.DownloadManager;

final class ad extends h {
    final /* synthetic */ XMPushService b;
    final /* synthetic */ af c;
    final /* synthetic */ String d;
    final /* synthetic */ String e;

    ad(int i, XMPushService xMPushService, af afVar, String str, String str2) {
        this.b = xMPushService;
        this.c = afVar;
        this.d = str;
        this.e = str2;
        super(i);
    }

    public final void a() {
        try {
            af a = x.a(this.b, this.c);
            a.h.a("error", this.d);
            a.h.a(DownloadManager.COLUMN_REASON, this.e);
            af.a(this.b, a);
        } catch (Exception e) {
            b.a(e);
            this.b.a(10, e);
        }
    }

    public final String b() {
        return "send wrong message ack for message.";
    }
}
